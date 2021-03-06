package ru.itpark.service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import ru.itpark.service.dto.CardDto;
import ru.itpark.service.dto.EventPatientDto;
import ru.itpark.service.dto.IndividualDto;
import ru.itpark.service.models.EventPatient;
import ru.itpark.service.models.EventServicePatient;
import ru.itpark.service.models.Individual;
import ru.itpark.service.repositories.CardRepository;
import ru.itpark.service.repositories.EventPatientsRepository;
import ru.itpark.service.repositories.IndividualRepository;


@Component
public class CardSImpl implements CardS{

    @Autowired
    private IndividualRepository individualRepository;

    public List<IndividualDto> getIndividual(Integer indivId) {
        List<Individual> individuals = individualRepository.findOneIndividualByIdEvent(indivId);

        List<IndividualDto> individualDtos = new ArrayList<>();
        for (Individual individual : individuals) {
            individualDtos.add(IndividualDto.builder()
                    .id(individual.getId())
                    .name(individual.getName())
                    .patrName(individual.getPatrName())
                    .surname(individual.getSurname())
                    .genderID(individual.getGenderID().getCode())
                    .birthDt(individual.getBirthDt())
                    .build());
        }
        return individualDtos;
    }


    @Autowired
    private CardRepository cardRepository;

    public List<CardDto> getCart(Integer eventPatientId) {
        List<EventServicePatient> eventServicePatients = cardRepository.findByEventPatientId(eventPatientId);

        List<CardDto> cartDtos = new ArrayList<>();
        for (EventServicePatient eventServicePatient : eventServicePatients) {
            cartDtos.add(CardDto.builder()
                    .id(eventServicePatient.getId())
                    .serviceName(eventServicePatient.getEventServiceID().getServiceID().getName())
                    .status(eventServicePatient.getStatus().getName())
                    .build());
        }
        return cartDtos;
    }

    @Autowired
    private EventPatientsRepository eventPatientsRepository;

    public List<EventPatientDto> getEventPatient(Integer eventPatientId) {
        List<EventPatient> eventPatients = eventPatientsRepository.findOneEventPatientID(eventPatientId);

        List<EventPatientDto> eventPatientDtos = new ArrayList<>();
        for (EventPatient eventPatient : eventPatients) {
            eventPatientDtos.add(EventPatientDto.builder()
                    .id(eventPatient.getId())
                    .eventID(eventPatient.getEventID().getId())
                    .indivID(eventPatient.getIndivID().getId())
                    .build());
        }
        return eventPatientDtos;
    }
}