package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.DayDescriptionDto;
import com.example.demo.dtos.ProgrammedEventDto;
import com.example.demo.dtos.ProgrammedEventOrganizerDto;
import com.example.demo.facades.ProgrammedEventFacade;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/programmed-event")
public class ProgrammedEventController {

    @Autowired
    private ProgrammedEventFacade facade;

    @GetMapping("/getProgrammedEventsForDate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProgrammedEventOrganizerDto.class)))),
            @ApiResponse(responseCode = "400", content = {
                    @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
    })
    public ResponseEntity<?> getProgrammedEventForDate(
            @RequestParam String dateTime // 2025-06-01
    ) {

        try {
            List<ProgrammedEventOrganizerDto> events = facade.getAllEventsForDate(dateTime);

            return ResponseEntity.ok(events);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @GetMapping("/getProgrammedEventsForDateTime")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProgrammedEventDto.class))) }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(mediaType = "string", schema = @Schema(implementation = String.class)) })
    })
    public ResponseEntity<?> getProgrammedEventForDateTime(
            @RequestParam String dateTime // 2025-06-01
    ) {

        try {
            List<ProgrammedEventDto> events = facade.getAllEventsForDateTime(dateTime);
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

}
