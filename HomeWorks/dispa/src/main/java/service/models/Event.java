package service.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Event {
    private Integer id;
    private Integer organization;
    private Integer eventType;
    private String name;
    private Integer standard;
    private Date startDate;
    private Date endDate;
    private Integer payType;
}