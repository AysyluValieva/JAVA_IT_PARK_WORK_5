package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.Individual;

import java.util.List;
import java.util.Optional;

public interface IndividualRepository extends JpaRepository<Individual, Integer>{

    @Query(nativeQuery = true, value = "SELECT * from pim_individual WHERE UPPER (surname) like '%'||upper(?1)||'%'")
    List<Individual> findBySurname(String surname);

    @Query(nativeQuery = true, value = "SELECT id, name from pim_individual WHERE UPPER (surname) like '%'||upper(?1)||'%' limit 1")
    List<Individual> findOneIndividual(String surname);

    @Query(nativeQuery = true, value = "SELECT id, name from pim_individual WHERE UPPER (surname) like '%'||upper(?1)||'%' limit 1")
    Optional<Individual> findOneIndividualID(String surname);


    @Query(nativeQuery = true, value = "SELECT id, name from pim_individual WHERE id = ?1 limit 1")
    List<Individual> findOneIndividualById(Integer indivId);



}
