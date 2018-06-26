package ru.itpark.service.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.service.dto.CardDto;
import ru.itpark.service.dto.EventPatientsDto;
import ru.itpark.service.forms.EventPatientForm;
import ru.itpark.service.services.CardS;


import java.util.List;

@Controller
public class CardController {

    @Autowired
    private CardS cardS;

    @GetMapping("/eventPatients/{eventPatients-id}/eventPatientsCard")
    public String getEventPatientsPage(@PathVariable("eventPatients-id") Integer eventPatientId, ModelMap model) {
        model.addAttribute("eventPatientsCard", cardS.getCart(eventPatientId));
        return "Card_page";
    }


}
