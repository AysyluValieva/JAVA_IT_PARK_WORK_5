package ru.itpark.service.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.service.dto.*;
import ru.itpark.service.forms.EventPatientForm;
import ru.itpark.service.forms.SrvRenderedForm;
import ru.itpark.service.services.CardS;
import ru.itpark.service.services.SrvRenderedS;


import java.util.List;
import java.util.Optional;

@Controller
public class CardController {

    @Autowired
    private CardS cardS;

    @GetMapping("/eventPatients/{eventPatients-id}/eventPatientsCard")
    public String getEventPatientsPage(@PathVariable("eventPatients-id") Integer eventPatientId, ModelMap model) {
        model.addAttribute("eventPatientsCard", cardS.getCart(eventPatientId));


        List<IndividualDto> individuals = cardS.getIndividual(eventPatientId);
        model.addAttribute("individuals",individuals);
        return "Card_page";
    }

    @Autowired
    private SrvRenderedS srvRenderedS;

    @GetMapping("/eventPatientsCard/{eventPatientsCard-id}/eventPatientsCardAgree")
    public String getEventPatientsAgreePage(@PathVariable("eventPatientsCard-id") Integer eventPatientsCardId, ModelMap model) {
        model.addAttribute("eventPatientsCardAgree", srvRenderedS.getSrvRendered(eventPatientsCardId));

        List<ServiceStatusDto> serviceStatus = srvRenderedS.getSrvStatus();
        model.addAttribute("serviceStatus",serviceStatus);

        List<SrvRenderedDto> srvRendered = srvRenderedS.getSrvRendered(eventPatientsCardId);
        model.addAttribute("srvRendered",srvRendered);

        return "CardAgree_page";
    }


    @PostMapping("/eventPatientsCard/{eventPatientsCard-id}/eventPatientsCardAgree")
    public String updateSrvRendered(SrvRenderedForm srvRendered) {

        srvRenderedS.updateSrvRendered(srvRendered);
        return "redirect:/eventPatients";
    }

}
