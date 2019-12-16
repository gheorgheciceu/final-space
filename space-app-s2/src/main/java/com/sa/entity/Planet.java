package com.sa.entity;


import com.sa.enums.PlanetStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Planet extends IdentifiableEntity {

    @Column(name = "name", length = 255)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PlanetStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solarSystemId")
    private SolarSystem solarSystem;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "visitedBy")
    private Integer visitedBy;

    @Column(name = "description", length = 1000)
    private String description;


}
