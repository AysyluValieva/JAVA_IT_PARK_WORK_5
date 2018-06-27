package ru.itpark.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.ServiceStatus;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ServiceStatusDto {
    private Integer id;
    private String  name;

    public static ServiceStatusDto from(ServiceStatus model) {
        return ServiceStatusDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    public static List<ServiceStatusDto> from(List<ServiceStatus> models) {
        return models.stream().map(ServiceStatusDto::from).collect(Collectors.toList());
    }
}