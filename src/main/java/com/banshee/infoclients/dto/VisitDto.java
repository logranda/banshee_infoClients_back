package com.banshee.infoclients.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Getter
@NoArgsConstructor
@Setter
@ToString
public class VisitDto implements Serializable {

    private static final long serialVersionUID = -5559272256101521188L;

    private Long id;

    private Date dateVisit;

    private double net;

    private double total;

    private String description;

    private SaleRepresentativeDto saleRepresentative;

    private CityDto city;

    private CustomerDto customer;

}
