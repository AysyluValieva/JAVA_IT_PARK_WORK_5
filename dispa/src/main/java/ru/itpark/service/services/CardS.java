package ru.itpark.service.services;

import ru.itpark.service.dto.CardDto;
import ru.itpark.service.dto.EventPatientDto;
import ru.itpark.service.dto.IndividualDto;


import java.util.List;

public interface CardS {

    List<IndividualDto> getIndividual(Integer indivId);
    List<CardDto> getCart(Integer eventPatientId);
    List<EventPatientDto> getEventPatient(Integer eventPatientId);

}
