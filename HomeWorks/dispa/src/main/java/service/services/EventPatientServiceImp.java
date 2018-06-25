package service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.forms.EventPatientForm;
import service. models.EventPatient;
import service.repositories.EventPatientRepository;

import java.util.List;
@Component
public class EventPatientServiceImp implements EventPatientService {

    private EventPatientRepository eventpatientRepository;

    @Autowired
    public EventPatientServiceImp(EventPatientRepository eventpatientRepository) {
        this.eventpatientRepository = eventpatientRepository;
    }

    @Override
    public List<EventPatient> getAllEventPatient() {
        return eventpatientRepository.findAll();
    }


}
