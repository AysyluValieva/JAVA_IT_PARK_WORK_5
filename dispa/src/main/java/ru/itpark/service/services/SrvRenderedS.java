package ru.itpark.service.services;

import ru.itpark.service.dto.ServiceStatusDto;
import ru.itpark.service.dto.SrvRenderedDto;
import ru.itpark.service.forms.SrvRenderedForm;


import java.util.List;

public interface SrvRenderedS {

    List<SrvRenderedDto> getSrvRendered(Integer srvId);

    List<ServiceStatusDto> getSrvStatus();


    SrvRenderedDto updateSrvRendered(SrvRenderedForm srvRenderedId);

}
