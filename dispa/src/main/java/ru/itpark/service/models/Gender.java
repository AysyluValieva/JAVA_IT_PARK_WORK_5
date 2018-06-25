package ru.itpark.service.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;



import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "pim_gender", schema = "public")

public class Gender {
    @Id
    private Integer id;
    private String name;
    private String code;
}
