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
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 7048083123424844642L;

    private Long id;

    private String nit;

    private String fullName;

    private String address;

    private String phone;

    private Integer creditLimit;

    private String username;

    private String password;

    private double visitsPercentage;

    private double availableCredit;

}
