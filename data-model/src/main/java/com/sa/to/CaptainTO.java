package com.sa.to;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CaptainTO extends IdentifiableTO{
    public String firstName;
    public String lastName;
}
