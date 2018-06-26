package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.EventPatient;

import java.util.List;
import java.util.Optional;

public interface EventPatientsRepository extends JpaRepository<EventPatient, Integer>{


    @Query(nativeQuery = true, value = "SELECT mep.id, mep.event_id, mep.indiv_id,  i.surname, i.name, i.patr_name, g.code, i.birth_dt, e.name as eventName " +
            "from disp.md_event_patient mep " +
            "join public.pim_individual i on i.id = mep.indiv_id " +
            "join public.pim_gender g on g.id = i.gender_id " +
            "join disp.md_event e on e.id = mep.event_id " +
            "where mep.event_id = ?1")
    List<EventPatient> findByEventId(Integer eventId);

    @Query(nativeQuery = true, value = "select id from disp.md_event_patient where id = ?1")
    Optional<EventPatient> findOneEventPatient(Integer Id);
}
