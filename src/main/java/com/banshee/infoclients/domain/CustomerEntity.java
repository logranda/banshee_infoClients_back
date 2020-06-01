package com.banshee.infoclients.domain;


import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@ToString
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = 7048083123424844642L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nit;

    @NotEmpty
    @Column(name = "full_name")
    private String fullName;

    @NotEmpty
    private String address;

    @NotEmpty
    private String phone;

    @NotEmpty
    @Column(name = "credit_limit")
    private Integer creditLimit;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Transient
    private double visitsPercentage;

    @Transient
    private double availableCredit;

}
