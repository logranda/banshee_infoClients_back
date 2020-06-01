package com.banshee.infoclients.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"code"})
@Getter
@NoArgsConstructor
@Setter
@ToString
public class CountryDto implements Serializable {

    private static final long serialVersionUID = 6649539708483284899L;

    private Long code;

    private String name;
}
