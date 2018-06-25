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
@Table (name = "sr_service", schema = "public")
public class Service {
    @Id
    private Integer id;
    private String name;
    private String code;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "org_id", nullable = false)
    private Clinic orgID;
}
