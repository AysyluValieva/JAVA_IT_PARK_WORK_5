package ru.itpark.service.services;

import ru.itpark.service.dto.ClinicDto;
import ru.itpark.service.dto.EventDto;
import ru.itpark.service.dto.EventPatientsDto;
import ru.itpark.service.dto.IndividualDto;
import ru.itpark.service.forms.EventPatientForm;


import java.util.List;

public interface EventPatientS {

    List<ClinicDto> getClinics();
    List<EventDto> getEvents();
    List<IndividualDto> getIndividual(String surname);

    List<EventPatientsDto> getAllEventPatient(Integer eventId);

    void addEventPatient(EventPatientForm eventPatient);
}
