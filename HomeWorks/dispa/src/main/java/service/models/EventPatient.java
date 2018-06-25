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

public class EventPatient {
    private int eventPatientId;
    private int eventId;
    private int patientId;
    private String sex;
    private String surname;
    private String givenName;
    private String middleName;
    private Date birthDate;
}
