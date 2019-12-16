package com.sa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "crews")
@Data
public class Crew extends IdentifiableEntity {

    @Column(name = "shuttleName", length = 255)
    private String shuttleName;

    @OneToOne(mappedBy = "crew")
    private Captain captain;

    @OneToMany(mappedBy = "crew")
    private List<Robot> robots;
}
