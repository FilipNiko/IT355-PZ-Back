package com.metropolitan.it355pzback.data.entities;

import com.metropolitan.it355pzback.data.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "naziv", nullable = false, length = 20)
    private RoleType name;

}