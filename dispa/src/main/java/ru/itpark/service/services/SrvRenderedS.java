package ru.itpark.service.services;

import ru.itpark.service.dto.SrvRenderedDto;
import ru.itpark.service.forms.SrvRenderedForm;


import java.util.List;

public interface SrvRenderedS {

    List<SrvRenderedDto> getSrvRendered(Integer srvId);

    SrvRenderedDto updateSrvRendered(SrvRenderedForm srvRenderedId);

}
