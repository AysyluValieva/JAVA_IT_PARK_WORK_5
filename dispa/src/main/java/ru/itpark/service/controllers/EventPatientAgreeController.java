package ru.itpark.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itpark.service.dto.EventPatientDto;
import ru.itpark.service.forms.EventAgreementForm;
import ru.itpark.service.services.CardS;
import ru.itpark.service.services.EventAgreementS;

import java.util.List;

@Controller
public class EventPatientAgreeController {

    @Autowired
    private EventAgreementS eventAgreementS;

    @Autowired
    private CardS cardS;

    @GetMapping("/eventPatients/{eventPatients-id}/eventPatientsAgree")
    public String getEventPatientsAgreePage(@PathVariable("eventPatients-id") Integer eventPatientId, ModelMap model) {
        model.addAttribute("eventPatientsAgree", eventAgreementS.getOneEventAgreement(eventPatientId));



        List<EventPatientDto> eventPatient = cardS.getEventPatient(eventPatientId);
        model.addAttribute("eventPatient",eventPatient);


        return "EventPatientsAgree_page";
    }


    @PostMapping("/eventPatientsCard/{eventPatientsCard-id}/eventPatientsAgree")
    public String updateEventPatient(EventAgreementForm srvRendered) {

        eventAgreementS.addEventAgreement(srvRendered);
        eventAgreementS.addEventServicePatient(srvRendered.getEventPatientID());

        return "redirect:/eventPatients";
    }



}
