package ru.itpark.service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import ru.itpark.service.models.EventServicePatient;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SrvRenderedDto {
    private Integer id;
    private String status;
    private String serviceName;

    public static SrvRenderedDto from(EventServicePatient model) {
        return SrvRenderedDto.builder()
                .id(model.getId())
                .status(model.getStatus().getName())
                .serviceName(model.getEventServiceID().getServiceID().getName())
                .build();
    }

    public static List<SrvRenderedDto> from(List<EventServicePatient> models) {
        return models.stream().map(SrvRenderedDto::from).collect(Collectors.toList());
    }

}
