package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.EventAgreement;

import java.util.List;

public interface EventAgreementRepository  extends JpaRepository<EventAgreement, Integer> {

    @Query(nativeQuery = true, value = " select id, event_patient_id, adate from disp.md_event_agreement where event_patient_id = ?1 ")
    List<EventAgreement> findByEventPatientId(Integer eventPatientId);

}
