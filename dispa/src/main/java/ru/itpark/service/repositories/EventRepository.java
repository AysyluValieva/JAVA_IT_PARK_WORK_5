package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer>{

    @Query(nativeQuery = true, value = "SELECT * from disp.md_event WHERE org_id = 27 and trim(name) like '%'||trim(?1)||'%'")
    List<Event> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT id, name from disp.md_event WHERE id = 2501 limit 1")
    List<Event> findOneEvent();

    @Query(nativeQuery = true, value = "SELECT id, name, event_type, org_id from disp.md_event WHERE id = 2501 limit 1")
    Optional<Event> findOneEventID();
}
