package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.EventServicePatient;

import java.util.List;

public interface CardRepository extends JpaRepository<EventServicePatient, Integer>{

    @Query(nativeQuery = true, value = "select mesp.id, s.name, sts.id as status, mesp.event_patient_id, mesp.service_id " +
            "from disp.md_event_patient mep " +
            "join disp.md_event_service_patient mesp on mesp.event_patient_id = mep.id " +
            "join disp.md_event_service mes on mes.id = mesp.service_id " +
            "join sr_service s on s.id = mes.service_id " +
            "join disp.md_event_service_status sts on sts.id = mesp.status " +
            "WHERE mep.id = ?1")
    List<EventServicePatient> findByEventPatientId(Integer eventPatientId);
}
