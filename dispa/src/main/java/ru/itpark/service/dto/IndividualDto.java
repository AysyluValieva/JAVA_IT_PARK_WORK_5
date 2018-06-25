package ru.itpark.service.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.Individual;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualDto {
    private Integer id;
    private String  name;
    private String  patrName;
    private String  surname;
    private String  genderID;
    private Date    birthDt;


    public static IndividualDto from(Individual model) {
        return IndividualDto.builder()
                .id(model.getId())
                .name(model.getName())
                .patrName(model.getPatrName())
                .surname(model.getSurname())
                .genderID(model.getGenderID().getCode())
                .birthDt(model.getBirthDt())
                .build();
    }

    public static List<IndividualDto> from(List<Individual> models) {
        return models.stream().map(IndividualDto::from).collect(Collectors.toList());
    }
}

