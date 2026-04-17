package org.server.sams.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students", schema = "sams", uniqueConstraints = {@UniqueConstraint(name = "student_code",
        columnNames = {"student_code"})})
public class Student {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @Size(max = 50)
    @NotNull
    @Column(name = "student_code", nullable = false, length = 50)
    private String studentCode;

    @NotNull
    @Column(name = "enroll_at", nullable = false)
    private LocalDate enrollAt;

    @NotNull
    @Column(name = "graduate_at", nullable = false)
    private LocalDate graduateAt;

    @NotNull
    @ColumnDefault("'STUDYING'")
    @Column(name = "state", nullable = false)
    private String state;

    @Size(max = 10)
    @NotNull
    @Column(name = "parent_phone", nullable = false, length = 10)
    private String parentPhone;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Classroom classroom;


}