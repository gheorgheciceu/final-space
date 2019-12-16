package com.sa.to;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CrewTO extends IdentifiableTO{
    public String shuttleName;
    public CaptainTO captain;
    public List<RobotTO> robots;
}
