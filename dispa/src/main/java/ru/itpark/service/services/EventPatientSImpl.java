package ru.itpark.service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import ru.itpark.service.forms.EventPatientForm;
import ru.itpark.service.dto.ClinicDto;
import ru.itpark.service.dto.EventDto;
import ru.itpark.service.dto.EventPatientsDto;
import ru.itpark.service.dto.IndividualDto;
import ru.itpark.service.models.Clinic;
import ru.itpark.service.models.Event;
import ru.itpark.service.models.EventPatient;
import ru.itpark.service.models.Individual;
import ru.itpark.service.repositories.ClinicRepository;
import ru.itpark.service.repositories.EventPatientsRepository;
import ru.itpark.service.repositories.EventRepository;
import ru.itpark.service.repositories.IndividualRepository;


@Component
public class EventPatientSImpl implements EventPatientS{

    @Autowired
    private ClinicRepository clinicsRepository;

    public List<ClinicDto> getClinics() {
        List<Clinic> clinics = clinicsRepository.findOneClinic();

        List<ClinicDto> clinicDtos = new ArrayList<>();
        for (Clinic clinic : clinics) {
            clinicDtos.add(ClinicDto.builder()
                      .id(clinic.getId())
                      .shortName(clinic.getShortName())
                    .build());
        }
        return clinicDtos;
    }

    @Autowired
    private EventRepository eventsRepository;

    public List<EventDto> getEvents() {
        List<Event> events = eventsRepository.findOneEvent();

        List<EventDto> eventDtos = new ArrayList<>();
        for (Event event : events) {
            eventDtos.add(EventDto.builder()
                    .id(event.getId())
                    .name(event.getName())
                    .build());
        }
        return eventDtos;
    }

    @Autowired
    private IndividualRepository individualRepository;

    public List<IndividualDto> getIndividual() {
        List<Individual> individuals = individualRepository.findBySurname();

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
    private EventPatientsRepository eventPatientsRepository;

    public List<EventPatientsDto> getAllEventPatient(Integer eventId) {
        List<EventPatient> eventParients = eventPatientsRepository.findByEventId(eventId);

        List<EventPatientsDto> eventPatientsDtos = new ArrayList<>();
        for (EventPatient eventPatient : eventParients) {
            eventPatientsDtos.add(EventPatientsDto.builder()
                    .id(eventPatient.getId())
                    .eventID(eventPatient.getEventID().getId())
                    .indivID(eventPatient.getIndivID().getId())
                    .name(eventPatient.getIndivID().getName())
                    .surname(eventPatient.getIndivID().getSurname())
                    .patrName(eventPatient.getIndivID().getPatrName())
                    .gender(eventPatient.getIndivID().getGenderID().getCode())
                    .birthDt(eventPatient.getIndivID().getBirthDt())
                    .eventName(eventPatient.getEventID().getName())
                    .build());
        }
        return eventPatientsDtos;
    }



    @Override
    public void addEventPatient(EventPatientForm eventPatient) {

        Event event = eventsRepository.findOneEventID().get();
        Individual indiv = individualRepository.findOneIndividualID(eventPatient.getIndivID()).get();

        EventPatient newEventPatient = EventPatient.builder()
                .eventID(event)
                .indivID(indiv)
                .build();
        eventPatientsRepository.save(newEventPatient);

    }
}
