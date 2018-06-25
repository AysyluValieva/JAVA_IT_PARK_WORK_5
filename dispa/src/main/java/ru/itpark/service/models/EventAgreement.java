package ru.itpark.service.models;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "md_event_agreement", schema = "disp")

public class EventAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disp.md_event_agreement_id_gen")
    @SequenceGenerator(name = "disp.md_event_agreement_id_gen", sequenceName = "disp.md_event_agreement_id_seq",
            allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "event_patient_id", nullable = false)
    private EventPatient eventPatientID;

    private Date adate;
}
