package com.banshee.infoclients.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"code"})
@Getter
@NoArgsConstructor
@Setter
@ToString
public class CityDto implements Serializable {

    private static final long serialVersionUID = 1271737855761710375L;

    private Long code;

    private String name;

    private StateDto state;
}
