package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.models.EventPatient;
import service.services.EventPatientService;

import java.util.List;

@Controller
public class EventPatientController {

    @Autowired
    private EventPatientService service;


    @GetMapping("/eventpatient")
    public ModelAndView getEventPatientPage(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("eventpatient");
        List<EventPatient> eventpatient = service.getAllEventPatient();
        model.addAttribute("eventpatient", eventpatient);
        return modelAndView;
    }
}
