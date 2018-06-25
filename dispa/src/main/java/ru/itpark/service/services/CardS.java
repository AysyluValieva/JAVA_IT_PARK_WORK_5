package ru.itpark.service.services;

import ru.itpark.service.dto.CartDto;
import ru.itpark.service.dto.IndividualDto;


import java.util.List;

public interface CardS {

    List<IndividualDto> getIndividual(Integer indivId);
    List<CartDto> getCart(Integer eventPatientId);
}
