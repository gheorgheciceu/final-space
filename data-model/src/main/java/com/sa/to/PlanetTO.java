package com.sa.to;

import com.sa.enums.PlanetStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PlanetTO extends IdentifiableTO {

    private String name;
    private String description;
    private String picture; //base64 encoded image
    private PlanetStatus status;
    private Integer visitedBy;
    private Integer solarSystemId;

}
