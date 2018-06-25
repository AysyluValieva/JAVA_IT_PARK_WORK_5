package ru.itpark.service.services;

import ru.itpark.service.dto.EventAgreementDto;
import ru.itpark.service.forms.EventAgreementForm;

import ru.itpark.service.forms.EventServicePatientForm;
import ru.itpark.service.models.EventServicePatient;


import java.util.List;

public interface EventAgreementS {

    List<EventAgreementDto> getOneEventAgreement(Integer eventPatientServiceId);

    void addEventAgreement(EventAgreementForm eventAgreement);
    void addEventServicePatient(List<EventServicePatientForm> list);


}
