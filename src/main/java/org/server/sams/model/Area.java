package org.server.sams.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityScan("org.server.sams.model")
@Table(name = "areas", schema = "sams")
public class Area {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NonNull
    @OneToMany(mappedBy = "area")
    private Set<LocalArea> localAreas = new LinkedHashSet<>();


}