package com.banshee.infoclients.domain;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "city")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@EqualsAndHashCode(of = {"code"})
@NoArgsConstructor
@ToString
public class CityEntity implements Serializable {

    private static final long serialVersionUID = 1271737855761710375L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name = "code_state")
    private StateEntity state;
}
