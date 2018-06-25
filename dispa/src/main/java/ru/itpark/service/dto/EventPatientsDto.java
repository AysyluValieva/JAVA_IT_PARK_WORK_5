package ru.itpark.service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.EventPatient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EventPatientsDto {
    private Integer id;
    private Integer eventID;
    private Integer indivID;
    private String name;
    private String surname;
    private String patrName;
    private String gender;
    private Date birthDt;
    private String eventName;



    public static EventPatientsDto from(EventPatient model ) {
        return EventPatientsDto.builder()
                .id(model.getId())
                .eventID(model.getEventID().getId())
                .indivID(model.getIndivID().getId())
                .name(model.getIndivID().getName())
                .surname(model.getIndivID().getSurname())
                .patrName(model.getIndivID().getPatrName())
                .gender(model.getIndivID().getGenderID().getCode())
                .birthDt(model.getIndivID().getBirthDt())
                .eventName(model.getEventID().getName())
                .build();
    }

    public static List<EventPatientsDto> from(List<EventPatient> models) {
        return models.stream().map(EventPatientsDto::from).collect(Collectors.toList());
    }

}
