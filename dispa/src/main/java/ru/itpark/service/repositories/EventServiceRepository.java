package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.EventService;

import java.util.List;
import java.util.Optional;

public interface EventServiceRepository  extends JpaRepository<EventService, Integer>{



    @Query(nativeQuery = true, value = "select id from disp.md_event_service where event_id = ?1")
    Optional<EventService> findOneId(Integer Id);
}
