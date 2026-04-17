package org.server.sams.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "teachers", schema = "sams", uniqueConstraints = {@UniqueConstraint(name = "teacher_code",
        columnNames = {"teacher_code"})})
public class Teacher {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @Size(max = 50)
    @NotNull
    @Column(name = "teacher_code", nullable = false, length = 50)
    private String teacherCode;

    @NotNull
    @Column(name = "start_at", nullable = false)
    private Instant startAt;

    @NotNull
    @Column(name = "end_at", nullable = false)
    private Instant endAt;

    @NotNull
    @Lob
    @Column(name = "degree", nullable = false)
    private String degree;

    @NotNull
    @ColumnDefault("'TEACHING'")
    @Column(name = "state", nullable = false)
    private String state;

}