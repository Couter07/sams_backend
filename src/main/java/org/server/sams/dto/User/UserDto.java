package org.server.sams.dto.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 255, message = "Giới hạn độ dài tên 255 kí tự")
    private String name;



}
