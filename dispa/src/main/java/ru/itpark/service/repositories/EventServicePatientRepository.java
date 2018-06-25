package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.EventService;
import ru.itpark.service.models.EventServicePatient;

import java.util.List;
import java.util.Optional;
public interface EventServicePatientRepository extends JpaRepository<EventServicePatient, Integer> {
}
