package org.server.sams.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@EntityScan("org.server.sams.model")
@Table(name = "country", schema = "sams")
public class Country {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @NonNull
    @OneToMany(mappedBy = "country")
    private Set<User> users = new LinkedHashSet<>();


}