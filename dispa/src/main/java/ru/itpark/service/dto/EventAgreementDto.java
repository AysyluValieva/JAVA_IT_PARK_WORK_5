package ru.itpark.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.EventAgreement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EventAgreementDto {
    private Integer id;
    private Integer eventPatientID;

    public static EventAgreementDto from(EventAgreement model) {
        return EventAgreementDto.builder()
                .id(model.getId())
                .eventPatientID(model.getEventPatientID().getId())
                .build();
    }

    public static List<EventAgreementDto> from(List<EventAgreement> models) {
        return models.stream().map(EventAgreementDto::from).collect(Collectors.toList());
    }



}
