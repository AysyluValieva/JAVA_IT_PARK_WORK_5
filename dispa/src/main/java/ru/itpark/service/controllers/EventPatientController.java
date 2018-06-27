package ru.itpark.service.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.service.dto.EventDto;
import ru.itpark.service.dto.EventPatientsDto;
import ru.itpark.service.dto.IndividualDto;
import ru.itpark.service.forms.EventPatientForm;
import ru.itpark.service.services.EventPatientS;


import java.util.List;

@Controller
public class EventPatientController {

    @Autowired
    private EventPatientS eventPatientS;

  /*  @GetMapping("/events/{event-id}/eventPatients")
    @ResponseBody
    public ResponseEntity<List<EventPatientsDto>>
    getUsersOfGroup(@PathVariable("event-id") Integer eventId) {
        return ResponseEntity.ok(eventPatientS.getAllEventPatient(eventId));
    }
*/

    @GetMapping("/events/{event-id}/eventPatients")
    public String EventPatientsInEventPage(ModelMap model) {
        model.addAttribute("eventPatients", eventPatientS.getAllEventPatient(2501));
        return "EventPatientsInEvent_page";
    }

    @GetMapping("/eventPatients")
    public String getEventPatientsPage(ModelMap model) {
        model.addAttribute("eventPatients", eventPatientS.getAllEventPatient(2501));

        List<IndividualDto> individuals = eventPatientS.getIndividual();
        model.addAttribute("individuals",individuals);

        List<EventDto> event = eventPatientS.getEvents();
        model.addAttribute("events",event);

        return "EventPatients_page";
    }

    @PostMapping("/eventPatients")
    public String addUser(EventPatientForm eventPatient) {

        eventPatientS.addEventPatient(eventPatient);
        return "redirect:/eventPatients";
    }

}
