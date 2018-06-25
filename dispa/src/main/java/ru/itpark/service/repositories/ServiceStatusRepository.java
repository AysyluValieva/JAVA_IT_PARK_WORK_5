package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.ServiceStatus;
import java.util.List;
import java.util.Optional;
public interface ServiceStatusRepository extends JpaRepository<ServiceStatus, Integer> {

    @Query(nativeQuery = true, value = "SELECT id, name from disp.md_event_service_status WHERE UPPER (name) like '%'||upper(?1)||'%' limit 1")
    List<ServiceStatus> findOneStatus(String surname);

    @Query(nativeQuery = true, value = "SELECT id, name from disp.md_event_service_status WHERE UPPER (name) like '%'||upper(?1)||'%' limit 1")
    Optional<ServiceStatus> findOneStatusByName(String name);

    @Query(nativeQuery = true, value = "SELECT id, name from disp.md_event_service_status WHERE id = ?1 limit 1")
    Optional<ServiceStatus> findOneStatusById(Integer id);
}
