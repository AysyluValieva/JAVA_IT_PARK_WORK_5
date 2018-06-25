package ru.itpark.service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.EventPatient;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EventPatientDto {
    private Integer id;
    private Integer eventID;
    private Integer indivID;


    public static EventPatientDto from(EventPatient model ) {
        return EventPatientDto.builder()
                .id(model.getId())
                .eventID(model.getEventID().getId())
                .indivID(model.getIndivID().getId())
                .build();
    }

    public static List<EventPatientDto> from(List<EventPatient> models) {
        return models.stream().map(EventPatientDto::from).collect(Collectors.toList());
    }
}
