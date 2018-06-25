package service.services;

import service.forms.EventPatientForm;
import service.models.EventPatient;
import java.util.List;

public interface EventPatientService {
    List<EventPatient> getAllEventPatient();
}