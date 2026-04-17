package org.server.sams.dto.User;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.server.sams.enums.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class UserSaveDto {

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 255, message = "Quá 255 kí tự cho tên")
    private String fullName;

    @Past(message = "Ngày sinh là ngày trong quá khứ")
    private LocalDate birthday;

    @NotNull(message = "Giới tính không được null")
    private Gender gender;

    @NotBlank(message = "Sđt không được để trống")
    private String personalPhone;


}
