package ru.itpark.service.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "md_event_service_patient", schema = "disp")
public class EventServicePatient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disp.md_event_service_patient_id_gen")
    @SequenceGenerator(name = "disp.md_event_service_patient_id_gen", sequenceName = "disp.md_event_service_patient_id_seq",
            allocationSize = 1)
    @Access(AccessType.PROPERTY)
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "service_id", nullable = false)
    private EventService eventServiceID;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "event_patient_id", nullable = false)
    private EventPatient eventPatientID;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "status", nullable = false)
    private ServiceStatus status;
}
