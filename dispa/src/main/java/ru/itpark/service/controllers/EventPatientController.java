package ru.itpark.service.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.service.dto.EventPatientsDto;
import ru.itpark.service.forms.EventPatientForm;
import ru.itpark.service.services.EventPatientS;


import java.util.List;

@Controller
public class EventPatientController {

    @Autowired
    private EventPatientS service;

    @GetMapping("/events/{event-id}/eventPatients")
    @ResponseBody
    public ResponseEntity<List<EventPatientsDto>>
    getUsersOfGroup(@PathVariable("event-id") Integer eventId) {
        return ResponseEntity.ok(service.getAllEventPatient(eventId));
    }

    @GetMapping("/eventPatients")
    public String getEventPatientsPage(ModelMap model) {
        model.addAttribute("eventPatients", service.getAllEventPatient(2501));
        return "EventPatients_page";
    }

    @PostMapping("/eventPatients")
    public String addUser(EventPatientForm eventPatient) {
        service.addEventPatient(eventPatient);
        return "redirect:/eventPatients";
    }
}
