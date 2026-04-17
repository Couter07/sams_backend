package org.server.sams.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CountryDto {

    @NotNull
    @Min(value = 0)
    private Integer id;

    @NotNull(message = "Khong duoc null")
    @NotBlank(message = "Khong duoc de trong ten tinh thanh")
    private String name;
}
