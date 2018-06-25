package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.EventServicePatient;

import java.util.List;
import java.util.Optional;

public interface SrvRenderedRepository extends JpaRepository<EventServicePatient, Integer> {

    @Query(nativeQuery = true, value = "SELECT ssr.id, sts.name as status, ss.name " +
            "from disp.md_event_service_patient ssr " +
            "join disp.md_event_service mes on mes.id = ssr.service_id " +
            "join sr_service s on s.id = mes.service_id " +
            "join disp.md_md_event_service_status sts on sts.id = ssr.status" +
            "WHERE ssr.id = ?1")
    List<EventServicePatient> findOneById(Integer srvId);

    @Query(nativeQuery = true, value = "SELECT ssr.id, sts.name as status, ss.name " +
            "from disp.md_event_service_patient ssr " +
            "join disp.md_event_service mes on mes.id = ssr.service_id " +
            "join sr_service s on s.id = mes.service_id " +
            "join disp.md_md_event_service_status sts on sts.id = ssr.status" +
            "WHERE ssr.id = ?1")
    Optional<EventServicePatient> findOneByIdOpt(Integer srvId);
}
