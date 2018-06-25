package service.repositories;

import service.models.EventPatient;

public interface EventPatientRepository extends CrudRepository<EventPatient> {
    EventPatient findAllByEvent(Integer eventId);
}
