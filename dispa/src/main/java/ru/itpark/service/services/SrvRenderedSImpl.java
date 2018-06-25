package ru.itpark.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import ru.itpark.service.forms.SrvRenderedForm;
import ru.itpark.service.models.*;
import ru.itpark.service.repositories.*;
import ru.itpark.service.dto.SrvRenderedDto;
import ru.itpark.service.models.EventServicePatient;
import ru.itpark.service.models.ServiceStatus;
import ru.itpark.service.repositories.ServiceStatusRepository;
import ru.itpark.service.repositories.SrvRenderedRepository;

@Component

public class SrvRenderedSImpl implements SrvRenderedS{

    @Autowired
    private SrvRenderedRepository srvRenderedRepository;

    public List<SrvRenderedDto> getSrvRendered(Integer srvId) {
        List<EventServicePatient> srvRendereds = srvRenderedRepository.findOneById(srvId);

        List<SrvRenderedDto> srvRenderedDtos = new ArrayList<>();
        for (EventServicePatient srvRendered : srvRendereds) {
            srvRenderedDtos.add(SrvRenderedDto.builder()
                    .id(srvRendered.getId())
                    .status(srvRendered.getStatus().getName())
                    .serviceName(srvRendered.getEventServiceID().getServiceID().getName())
                    .build());
        }
        return srvRenderedDtos;
    }

    @Autowired
    private ServiceStatusRepository serviceStatusRepository;

    @Override
    public SrvRenderedDto updateSrvRendered(SrvRenderedForm srv) {
        EventServicePatient srvRendered = srvRenderedRepository.findOneByIdOpt(srv.getId()).get();
        ServiceStatus sStatus = serviceStatusRepository.findOneStatusByName(srv.getStatus()).get();
        srvRendered.setStatus(sStatus);
        srvRenderedRepository.save(srvRendered);
        return new SrvRenderedDto();
    }
}
