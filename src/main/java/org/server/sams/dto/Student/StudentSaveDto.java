package org.server.sams.dto.Student;

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
    private String fullName;
    private LocalDate birthday;
    private String houseNumber;
    private String localArea;
    private String area;
    private String personalPhone;
    private Gender gender;
    private String country;
    private LocalDate enrollAt;
    private LocalDate graduateAt;
    private StudentState state;
    private String parentPhone;
}
