package ru.itpark.service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.EventServicePatient;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto {
    private Integer id;
    private String serviceName;
    private String status;



    public static CardDto from(EventServicePatient model ) {
        return CardDto.builder()
                .id(model.getId())
                .serviceName(model.getEventServiceID().getServiceID().getName())
                .status(model.getStatus().getName())
                .build();
    }

    public static List<CardDto> from(List<EventServicePatient> models) {
        return models.stream().map(CardDto::from).collect(Collectors.toList());
    }
}
