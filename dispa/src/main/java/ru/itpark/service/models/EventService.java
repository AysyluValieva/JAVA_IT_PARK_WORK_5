package ru.itpark.service.models;
import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "md_event_service", schema = "disp")
public class EventService {
    @Id
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "event_id", nullable = false)
    private Event eventID;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "org_id", nullable = false)
    private Clinic orgID;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "service_id", nullable = false)
    private Service serviceID;

}
