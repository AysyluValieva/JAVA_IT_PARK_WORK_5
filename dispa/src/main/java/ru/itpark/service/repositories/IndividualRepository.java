package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.Individual;

import java.util.List;
import java.util.Optional;

public interface IndividualRepository extends JpaRepository<Individual, Integer>{

    @Query(nativeQuery = true, value = "SELECT id, concat(surname, ' '||name, ' '||patr_name,' '||to_char(birth_dt,'dd.mm.yyyy')) as name, birth_dt, surname, patr_name, gender_id from pim_individual limit 100")
    List<Individual> findBySurname();

    @Query(nativeQuery = true, value = "SELECT id, name from pim_individual WHERE UPPER (surname) like '%'||upper(?1)||'%' limit 100")
    List<Individual> findOneIndividual(String surname);

    @Query(nativeQuery = true, value = "SELECT * from pim_individual WHERE id = ?1 limit 1")
    Optional<Individual> findOneIndividualID(Integer indivId);


    @Query(nativeQuery = true, value = "SELECT * from pim_individual i where id = ?1 limit 1")
    List<Individual> findOneIndividualById(Integer indivId);

    @Query(nativeQuery = true, value = "SELECT i.id, concat(surname, ' '||name, ' '||patr_name, ' '||to_char(birth_dt,'dd.mm.yyyy'), ' '||(case when gender_id = 1 then 'Мужской' else 'Женский' end )) as name, birth_dt, surname, patr_name, gender_id from pim_individual i join disp.md_event_patient mep on mep.indiv_id = i.id where mep.id = ?1 limit 1")
    List<Individual> findOneIndividualByIdEvent(Integer indivId);



}
