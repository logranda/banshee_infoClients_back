package com.banshee.infoclients.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class CityByVisitDto implements Serializable {
    private List<CityDto> city;
    private List<Long> visitNumber;
}
