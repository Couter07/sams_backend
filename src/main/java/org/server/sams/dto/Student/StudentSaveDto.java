package org.server.sams.dto.Student;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.server.sams.enums.Gender;
import org.server.sams.enums.StudentState;

import java.time.LocalDate;


/**
 *
 * @author hoangphuc
 */

@Builder
@Data
public class StudentSaveDto {
    @NotBlank(message = "Không được để trống")
    private String fullName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past(message = "Phải là thời gian trong quá khứ")
    @NotNull(message = "Không được rỗng")
    private LocalDate birthday;

    @NotBlank(message = "Không được để trống")
    private String houseNumber;

    @NotBlank(message = "Không được để trống")
    private String localArea;

    @NotBlank(message = "Không được để trống")
    private String area;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^\\d{10}$", message = "Số điện thoại phải có 10 chữ số")
    private String personalPhone;

    @NotNull(message = "Bổ sung giới tính")
    private Gender gender;

    @NotBlank(message = "Không được để trống")
    private String country;

    @FutureOrPresent(message = "Phải là hiện tại hoặc tương lai")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotBlank(message = "Không được để trống")
    private LocalDate enrollAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Future(message = "Phải là thời gian tương lai")
    @NotBlank(message = "Không được để trống")
    private LocalDate graduateAt;

    @NotNull(message = "Bổ sung trạng thái hồ sơ")
    private StudentState state;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^\\d{10}$", message = "Số điện thoại phải có 10 chữ số")
    private String parentPhone;
}
