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
@Table (name = "md_event", schema = "disp")
public class Event {
    @Id
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "org_id", nullable = false)
    private Clinic orgID;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "event_type", nullable = false)
    private EventType eventType;

    private String name;


}
