package com.banshee.infoclients.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"code"})
@Getter
@NoArgsConstructor
@Setter
@ToString
public class StateDto implements Serializable {

    private static final long serialVersionUID = -4647872406894338483L;

    private Long code;

    private String name;

    private CountryDto country;
}
