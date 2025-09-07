package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProgrammedEventDto;
import com.example.demo.dtos.OrganizerDto;
import com.example.demo.facades.OrganizerFacade;
import com.example.demo.facades.ProgrammedEventFacade;
import com.example.demo.models.BasicResponse;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/organizer")
public class OrganizerController {

    @Autowired
    private OrganizerFacade facade;

    @GetMapping("/getOrganizers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrganizerDto.class)))),
            @ApiResponse(responseCode = "400", content = {
                    @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
    })
    public ResponseEntity<?> getProgrammedEventForDate(
            @RequestParam String dateTime // 2025-06-01
    ) {

        try {
            // List<OrganizerDto> events = facade.

            return ResponseEntity.ok(events);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    
    @GetMapping("/getOrganizer/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrganizerDto.class)))),
            @ApiResponse(responseCode = "400", content = {
                    @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
    })
    public ResponseEntity<?> getOrganizer(
            @RequestParam Long id
    ) {

        try {
            Optional<OrganizerDto> organizer = facade.getOrganizerById(id);

            if(organizer.isPresent()){
                return ResponseEntity.ok(organizer.get());
            }
            else{
                return ResponseEntity.internalServerError().body(BasicResponse.error("No hemos encontrado un organizador con este identificador", 404));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PostMapping("/createProgrammedEvent")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode="200", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProgrammedEventDto.class))
            }
        ),
        @ApiResponse(
            responseCode="200", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BasicResponse.class))
            }
        )
    })
    public ResponseEntity createEvent(
        ProgrammedEventDto event
    ){
        try {
            ProgrammedEventDto createdEvent = facade.

            return ResponseEntity.status(200).body(BasicResponse.success("Evento creado", createdEvent));
            
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BasicResponse.error(e.getMessage(), 500));
        }
    }
}
