package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.OrganizerDto;
import com.example.demo.dtos.ProgrammedEventDto;
import com.example.demo.dtos.ProgrammedEventOrganizerDto;
import com.example.demo.entities.ProgrammedEventEntity;
import com.example.demo.repositories.ProgrammedEventRepository;

@Service
public class ProgrammedEventService extends  BasicServiceImpl<ProgrammedEventEntity, ProgrammedEventDto, Long>{

    @Autowired
    private ProgrammedEventRepository programmedEventRepository;

    public ProgrammedEventService(
        ProgrammedEventRepository repository
    ) 
    {
        super(repository, 
        ProgrammedEventEntity.class, 
        ProgrammedEventDto.class);
    }

    @Autowired
    private OrganizerService organizerService;

    public List<ProgrammedEventOrganizerDto> getProgrammedEventsForDate(String dateTimeString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime dateTimeStart = LocalDate.parse(dateTimeString, formatter).atStartOfDay();
    LocalDateTime dateTimeEnd = dateTimeStart.plusDays(1);

    List<ProgrammedEventEntity> eventList = programmedEventRepository.getProgrammedEventsForDate(dateTimeStart, dateTimeEnd);

    return eventList.stream().map(entity -> {
        ProgrammedEventOrganizerDto dto = modelMapper.map(entity, ProgrammedEventOrganizerDto.class);

        // Formatear fecha
        dto.setDateTime(entity.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // Buscar el OrganizerDto llamando al service con el organizerId de la entidad
        if(entity.getOrganizerId() != null){
            OrganizerDto organizerDto = organizerService.findById(entity.getOrganizerId()).get();
            dto.setOrganizer(organizerDto);
        }

        return dto;
    }).collect(Collectors.toList());
}

    public List<ProgrammedEventDto> getProgrammedEventsForDateTime(String dateTimeString) {
        // Define el formato esperado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Convierte el String a LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        List<ProgrammedEventEntity> eventList = programmedEventRepository.getProgrammedEventsForDateTime(dateTime);

        return eventList.stream()
                .map(entity -> {
                    // Mapeo del entity al DTO usando ModelMapper
                    ProgrammedEventDto dto = modelMapper.map(entity, ProgrammedEventDto.class);

                    // Formatea el LocalDateTime a String
                    LocalDateTime entityDateTime = entity.getDateTime(); // Suponiendo que es LocalDateTime
                    String formattedDateTime = entityDateTime
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    // Establece el valor formateado en el DTO
                    dto.setDateTime(formattedDateTime); // Asegúrate de que este campo sea String en el DTO

                    return dto;
                })
                .collect(Collectors.toList());

    }

}
