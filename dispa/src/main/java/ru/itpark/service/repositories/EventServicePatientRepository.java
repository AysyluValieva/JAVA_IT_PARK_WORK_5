package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.forms.EventServicePatientForm;
import ru.itpark.service.models.EventService;
import ru.itpark.service.models.EventServicePatient;

import java.util.List;
import java.util.Optional;
public interface EventServicePatientRepository extends JpaRepository<EventServicePatient, Integer> {

    @Query(nativeQuery = true, value = "select id as event_service_id, service_id, 1 as status from disp.md_event_service where event_id = ?1")
    List<EventServicePatient> findByEventId(Integer eventId);

    @Query(nativeQuery = true, value = "select es.id as id, mep.id as event_patient_id ,  es.id as service_id ,  1 as status " +
            "from disp.md_event_service es  " +
            "join disp.md_event_patient mep on mep.event_id = es.event_id " +
            "where mep.id = ?1")
    List<EventServicePatient> findEventId(Integer eventId);

}
