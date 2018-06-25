package ru.itpark.service.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;



import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "md_event_type", schema = "disp")
public class EventType {
    @Id
    private Integer id;
    private String name;
    private String code;

}
