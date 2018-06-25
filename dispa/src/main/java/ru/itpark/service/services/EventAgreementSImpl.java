package ru.itpark.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.service.dto.EventAgreementDto;
import ru.itpark.service.forms.EventAgreementForm;
import ru.itpark.service.forms.EventServicePatientForm;
import ru.itpark.service.models.*;
import ru.itpark.service.repositories.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventAgreementSImpl  implements EventAgreementS{

    @Autowired
    private EventAgreementRepository eventAgreementRepository;

    public List<EventAgreementDto> getOneEventAgreement(Integer eventPatientServiceId) {
        List<EventAgreement> eventAgreements = eventAgreementRepository.findByEventPatientId(eventPatientServiceId);

        List<EventAgreementDto> eventAgreementDtos = new ArrayList<>();
        for (EventAgreement eventAgreement : eventAgreements) {
            eventAgreementDtos.add(EventAgreementDto.builder()
                    .id(eventAgreement.getId())
                    .eventPatientID(eventAgreement.getEventPatientID().getId())
                    .adate(eventAgreement.getAdate())
                    .build());
        }
        return eventAgreementDtos;
    }

    @Autowired
    private EventPatientsRepository eventPatientsRepository;

    @Override
    public void addEventAgreement(EventAgreementForm eventAgreement) {

        EventPatient eventPatient = eventPatientsRepository.findOneEventPatient(eventAgreement.getEventPatientID()).get();
        Date adate = eventAgreement.getAdate();

        EventAgreement newEventAgreement = EventAgreement.builder()
                .eventPatientID(eventPatient)
                .adate(adate)
                .build();
        eventAgreementRepository.save(newEventAgreement);

    }


    @Autowired
    private EventServiceRepository eventServiceRepository;

    @Autowired
    private ServiceStatusRepository serviceStatusRepository;

    @Autowired
    private EventServicePatientRepository eventServicePatientRepository;

    @Override
    public void addEventServicePatient(List<EventServicePatientForm> list){

        if (list != null) {
            for (EventServicePatientForm eventService : list) {

                EventService eServ = eventServiceRepository.findOneId(eventService.getEventServiceID()).get();
                EventPatient ePat = eventPatientsRepository.findOneEventPatient(eventService.getEventPatientID()).get();
                ServiceStatus sStat = serviceStatusRepository.findOneStatusById(eventService.getStatus()).get();

                EventServicePatient newEventServicePatient = EventServicePatient.builder()
                        .eventServiceID(eServ)
                        .eventPatientID(ePat)
                        .status(sStat)
                        .build();


                eventServicePatientRepository.save(newEventServicePatient);


            }


        }

    }


}
