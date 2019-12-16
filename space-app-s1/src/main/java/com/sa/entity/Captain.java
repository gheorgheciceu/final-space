package com.sa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "captains")
@Data
public class Captain extends IdentifiableEntity {

    @Column(name = "firstName", length = 255)
    private String firstName;

    @Column(name = "lastName", length = 255)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "crewId")
    private Crew crew;
}
