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
@EqualsAndHashCode(of = {"id"})
@Getter
@NoArgsConstructor
@Setter
@ToString
public class SaleRepresentativeDto implements Serializable {

    private static final long serialVersionUID = -5497930183024311040L;

    private Long id;

    private String name;
}
