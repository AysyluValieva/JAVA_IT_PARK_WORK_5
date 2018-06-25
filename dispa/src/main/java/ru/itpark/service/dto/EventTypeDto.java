package ru.itpark.service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.EventType;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EventTypeDto {
    private Integer id;
    private String  name;
    private String  code;


    public static EventTypeDto from(EventType model) {
        return EventTypeDto.builder()
                .id(model.getId())
                .name(model.getName())
                .code(model.getCode())
                .build();
    }

    public static List<EventTypeDto> from(List<EventType> models) {
        return models.stream().map(EventTypeDto::from).collect(Collectors.toList());
    }
}
