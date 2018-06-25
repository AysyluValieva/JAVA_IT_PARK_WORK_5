package ru.itpark.service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.Event;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {
    private Integer id;
    private String  name;


    public static EventDto from(Event model) {
        return EventDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    public static List<EventDto> from(List<Event> models) {
        return models.stream().map(EventDto::from).collect(Collectors.toList());
    }
}
