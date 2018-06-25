package ru.itpark.service.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.Clinic;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Integer>{

    @Query(nativeQuery = true, value = "SELECT id, short_name from md_clinic WHERE UPPER (short_name) like '%'||upper(?1)||'%' or UPPER (full_name) like '%'||upper(?1)||'%'")
    List<Clinic> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT id, short_name from md_clinic WHERE id = 490")
    List<Clinic> findOneClinic();

}
