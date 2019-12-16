package com.sa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="solarSystems")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class SolarSystem extends IdentifiableEntity{

    @Column(name = "name",length = 255, nullable = false)
    private String name;

    @OneToMany(mappedBy = "solarSystem")
    private List<Planet> planets;
}
