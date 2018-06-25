package ru.itpark.service.models;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "md_event_patient", schema = "disp")
public class EventPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disp.md_event_patient_id_gen")
    @SequenceGenerator(name = "disp.md_event_patient_id_gen", sequenceName = "disp.md_event_patient_id_seq",
            allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "event_id", nullable = false)
    private Event eventID;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "indiv_id", nullable = false)
    private Individual indivID;


}