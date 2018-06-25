package ru.itpark.service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import ru.itpark.service.dto.CartDto;
import ru.itpark.service.models.*;
import ru.itpark.service.repositories.*;
import ru.itpark.service.dto.*;
import ru.itpark.service.dto.IndividualDto;
import ru.itpark.service.models.EventServicePatient;
import ru.itpark.service.models.Individual;
import ru.itpark.service.repositories.CardRepository;
import ru.itpark.service.repositories.IndividualRepository;


@Component
public class CardSImpl implements CardS{

    @Autowired
    private IndividualRepository individualRepository;

    public List<IndividualDto> getIndividual(Integer indivId) {
        List<Individual> individuals = individualRepository.findOneIndividualById(indivId);

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

    public List<CartDto> getCart(Integer eventPatientId) {
        List<EventServicePatient> eventServicePatients = cardRepository.findByEventPatientId(eventPatientId);

        List<CartDto> cartDtos = new ArrayList<>();
        for (EventServicePatient eventServicePatient : eventServicePatients) {
            cartDtos.add(CartDto.builder()
                    .id(eventServicePatient.getId())
                    .serviceName(eventServicePatient.getEventServiceID().getServiceID().getName())
                    .status(eventServicePatient.getStatus().getName())
                    .build());
        }
        return cartDtos;
    }
}
