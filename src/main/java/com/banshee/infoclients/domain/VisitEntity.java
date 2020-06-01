package com.banshee.infoclients.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "visit")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@ToString
public class VisitEntity implements Serializable {

    private static final long serialVersionUID = -5559272256101521188L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_visit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVisit;

    @NotEmpty
    private double net;

    private double total;

    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_sale_representative")
    private SaleRepresentativeEntity saleRepresentative;

    @ManyToOne
    @JoinColumn(name = "id_city")
    private CityEntity city;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customer;

}
