package org.server.sams.service.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.server.sams.dto.Student.StudentSaveDto;
import org.server.sams.enums.Gender;
import org.server.sams.enums.StudentState;
import org.server.sams.exception.InternalServerErrorException;
import org.server.sams.exception.ResourceNotFoundException;
import org.server.sams.model.Address;
import org.server.sams.model.Country;
import org.server.sams.model.Student;
import org.server.sams.model.User;
import org.server.sams.repository.*;
import org.server.sams.utils.UIDGenerated;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDate;
import java.util.Objects;


/**
 * Các logic liên quan tới quản lí học sinh
 * @author Hoàng Phúc
 * @since 1.0
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AdminStudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;
    private final AddressRepository addressRepository;
    private final LocalAreaRepository localAreaRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * <p>
     *     <b>Cung cấp tài khoản và lưu thông tin của học sinh</b><br>
     *     1. Tìm kiếm quê quán của học sinh <br>
     *     2. Tìm kiếm LocalArea và lưu địa chỉ của học sinh <br>
     *     3. Tự sinh email, id, student_code, code được sinh bằng phương thức {@link UIDGenerated}
     *     4. Password được mã hóa bằng bcrypt {@link PasswordEncoder}
     *     5. Lưu User và Student
     * </p>
     * @param studentSaveDto thông tin học sinh nhập học
     * @see UIDGenerated
     * @see PasswordEncoder
     * @throws ResourceNotFoundException không tìm thấy tài nguyên, trong logic này không tìm thấy tên country và localArea
     * @throws InternalServerErrorException logic toàn cục
     */
    public void saveStudent(StudentSaveDto studentSaveDto) {
        try {
            Country country = countryRepository
                    .findCountryByName(studentSaveDto.getCountry())
                    .orElseThrow(() -> new ResourceNotFoundException("Country not found with name " + studentSaveDto.getCountry()));

            Integer addressId = addressRepository.findMaxId();
            if (Objects.isNull(addressId)) addressId = 1;
            else addressId += 1;

            Address address = Address.builder()
                    .id(addressId)
                    .houseNumber(studentSaveDto.getHouseNumber())
                    .localArea(localAreaRepository
                            .findLocalAreaByName(studentSaveDto.getLocalArea())
                            .orElseThrow(() -> new ResourceNotFoundException("Local area not found with name " + studentSaveDto.getLocalArea())))
                    .build();

            addressRepository.save(address);

            Integer enrollYear = studentSaveDto.getEnrollAt().getYear();
            Integer studentId = userRepository.findMaxId();
            if (Objects.isNull(studentId)) studentId = 1;
            else studentId += 1;
            StringBuilder email = new StringBuilder();
            String code = UIDGenerated.generate(studentId);
            email.append("HS")
                    .append(enrollYear)
                    .append(code)
                    .append("@sams.edu.vn");
            String studentCode = "HS" + code;

            StringBuilder password = new StringBuilder();
            LocalDate birthday = studentSaveDto.getBirthday();
            password.append(birthday.getDayOfMonth())
                    .append(birthday.getMonth())
                    .append(birthday.getYear())
                    .append("@sams");
            String passwordHashed = passwordEncoder.encode(password.toString());


            User user = User.builder()
                    .id(studentId)
                    .fullName(studentSaveDto.getFullName())
                    .email(email.toString())
                    .birthday(studentSaveDto.getBirthday())
                    .address(address)
                    .gender(studentSaveDto.getGender().toString())
                    .personalPhone(studentSaveDto.getPersonalPhone())
                    .country(country)
                    .passwordHashed(passwordHashed)
                    .build();

            userRepository.save(user);

            Student student = Student.builder()
                    .user(user)
                    .studentCode(studentCode)
                    .classroom(null)
                    .state(StudentState.STUDYING.toString())
                    .enrollAt(studentSaveDto.getEnrollAt())
                    .parentPhone(studentSaveDto.getParentPhone())
                    .graduateAt(studentSaveDto.getGraduateAt())
                    .build();
            studentRepository.save(student);
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to save student " + e);
        }
    }

}
