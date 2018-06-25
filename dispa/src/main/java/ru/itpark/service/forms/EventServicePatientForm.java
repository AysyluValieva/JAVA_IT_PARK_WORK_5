package ru.itpark.service.forms;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventServicePatientForm {

    private Integer eventServiceID;
    private Integer eventPatientID;
    private Integer status;

}
