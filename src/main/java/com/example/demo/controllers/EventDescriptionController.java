package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EventDescriptionDto;
import com.example.demo.facades.EventDescriptionFacade;
import com.example.demo.models.ApiResponseError;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/event-description")
public class EventDescriptionController {

    @Autowired
    private EventDescriptionFacade eventDescriptionFacade;
    
    @GetMapping("/getForEvent/{id}")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = EventDescriptionDto.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ApiResponseError.class)
            )
        )
    })
    public ResponseEntity<?> findByEventId(@PathVariable("id") Long id) {
        try {
            Optional<EventDescriptionDto> eventDescription = eventDescriptionFacade.findByEventId(id);
            
            if (eventDescription.isPresent()) {
                return ResponseEntity.ok(eventDescription.get());
            } else {
                ApiResponseError error = new ApiResponseError(404, "Not Found", "No results found", "EventDescription");
                return ResponseEntity.status(404).body(error);
            }
        } catch (Exception e) {
            ApiResponseError error = new ApiResponseError(500, "Internal Server Error", e.getMessage(), "EventDescription");
            return ResponseEntity.status(500).body(error);
        }
    }
}

