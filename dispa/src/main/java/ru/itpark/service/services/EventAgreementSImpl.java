package ru.itpark.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.service.dto.EventAgreementDto;
import ru.itpark.service.forms.EventAgreementForm;
import ru.itpark.service.forms.EventServicePatientForm;
import ru.itpark.service.models.*;
import ru.itpark.service.repositories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class EventAgreementSImpl  implements EventAgreementS {

    @Autowired
    private EventAgreementRepository eventAgreementRepository;
    public List<EventAgreementDto> getOneEventAgreement(Integer eventPatientId) {
        List<EventAgreement> eventAgreements = eventAgreementRepository.findByEventPatientId(eventPatientId);

        List<EventAgreementDto> eventAgreementDtos = new ArrayList<>();
        for (EventAgreement eventAgreement : eventAgreements) {
            eventAgreementDtos.add(EventAgreementDto.builder()
                    .id(eventAgreement.getId())
                    .eventPatientID(eventAgreement.getEventPatientID().getId())
                    .build());
        }
        return eventAgreementDtos;
    }

    @Autowired
    private EventPatientsRepository eventPatientsRepository;

    @Override
    public void addEventAgreement(EventAgreementForm eventAgreement) {

        EventPatient eventPatient = eventPatientsRepository.findOneEventPatient(eventAgreement.getEventPatientID()).get();

        EventAgreement newEventAgreement = EventAgreement.builder()
                .eventPatientID(eventPatient)
                .build();
        eventAgreementRepository.save(newEventAgreement);

    }


    @Autowired
    private EventServiceRepository eventServiceRepository;

    @Autowired
    private ServiceStatusRepository serviceStatusRepository;

    @Autowired
    private SrvRenderedRepository srvRenderedRepository;

    @Autowired
    private EventServicePatientRepository eventServicePatientRepository;

    @Override
    public void addEventServicePatient(Integer eventId ){

        List<EventServicePatient> list = eventServicePatientRepository.findEventId(eventId);

        if (list != null) {
            for (EventServicePatient eventService : list) {

                EventService eServ = eventServiceRepository.findOneId(eventService.getEventServiceID().getId()).get();
                EventPatient ePat = eventPatientsRepository.findOneEventPatient(eventService.getEventPatientID().getId()).get();
                ServiceStatus sStat = serviceStatusRepository.findOneStatusById(eventService.getStatus().getId()).get();

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
