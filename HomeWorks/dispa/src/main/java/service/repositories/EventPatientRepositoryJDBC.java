package service.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import service.models.EventPatient;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Component
public class EventPatientRepositoryJDBC implements EventPatientRepository {

    private static final String SQL_INSERT_EVENT_PATIENT =
            "INSERT INTO disp.md_event_patient(event_id, patient_id) VALUES (?,?)";

    private static final String SQL_FIND_ALL =
            "SELECT mep.id, mep.event_id,mep.indiv_id, case when i.gender_id = 1 then 'Man' else 'Woman' end gender, i.surname, i.name, i.patr_name, i.birth_dt " +
                    "FROM disp.md_event_patient mep JOIN pim_individual i on i.id = mep.indiv_id JOIN disp.md_event e on e.id = mep.event_id limit 10";

    //language=SQL
    private static final String SQL_FIND_ALL_BY_EVENT =
            "SELECT mep.id, mep.event_id,mep.indiv_id,case when i.gender_id = 1 then 'М' else 'Ж' end gender, i.surname, i.name, i.patr_name, i.birth_dt " +
                    "FROM disp.md_event_patient mep JOIN pim_individual i on i.id = mep.indiv_id JOIN disp.md_event e on e.id = mep.event_id WHERE mep.event_id = ? limit 10";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EventPatientRepositoryJDBC(@Qualifier("dataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<EventPatient> EventPatientRowMapper = new RowMapper<EventPatient>() {
        @Override
        public EventPatient mapRow(ResultSet row, int i) throws SQLException {
            return EventPatient.builder()

            .eventPatientId(row.getInt("id"))
            .eventId(row.getInt("event_id"))
            .patientId(row.getInt("indiv_id"))
            .sex(row.getString("gender"))
            .surname(row.getString("surname"))
            .givenName(row.getString("name"))
            .middleName(row.getString("patr_name"))
            .birthDate(row.getDate("birth_dt"))
                    .build();
        }
    };

    @Override
    public EventPatient find(int id) {
        return null;
    }

    @Override
    public List<EventPatient> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, EventPatientRowMapper);
    }


    @Override
    public EventPatient findAllByEvent(Integer eventId) {
        List<EventPatient> users = jdbcTemplate.query(SQL_FIND_ALL_BY_EVENT, EventPatientRowMapper, eventId);
        if (users.size() == 0) {
            return null;
        } else {
            return users.get(0);
        }
    }
}
