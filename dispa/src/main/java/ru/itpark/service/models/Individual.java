package ru.itpark.service.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "pim_individual", schema = "public")
public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pim_party_id_gen")
    @SequenceGenerator(name = "pim_party_id_gen", sequenceName = "disp.pim_party_id_seq",
            allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    private String name;
    private String patrName;
    private String surname;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "gender_id", nullable = false)
    private Gender genderID;

    private Date birthDt;
}
