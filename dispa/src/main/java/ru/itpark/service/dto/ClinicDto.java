package ru.itpark.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.Clinic;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClinicDto {
    private Integer id;
    private String  shortName;

    public static ClinicDto from(Clinic model) {
        return ClinicDto.builder()
                .id(model.getId())
                .shortName(model.getShortName())
                .build();
    }

    public static List<ClinicDto> from(List<Clinic> models) {
        return models.stream().map(ClinicDto::from).collect(Collectors.toList());
    }
}
