package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.DayDescriptionDto;
import com.example.demo.facades.DayDescriptionFacade;
import com.example.demo.models.ApiResponseError;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/day-description")
public class DayDescriptionController {

    @Autowired
    DayDescriptionFacade dayDescriptionFacade;
    
    @GetMapping("/getForEvent/{id}")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode="200",
            content = @Content(
                mediaType="application/json",
                schema = @Schema(implementation= DayDescriptionDto.class)
            )
        ),
        @ApiResponse(
            responseCode="404",
            content = @Content(
                mediaType="application/json",
                schema = @Schema(implementation= ApiResponseError.class)
            )
        )
    })
    public ResponseEntity<?> getDayDescriptionForEvent(
        @PathVariable("id") Long id
    ){
        try {
            Optional<DayDescriptionDto> dayDescription = dayDescriptionFacade.getDescriptionForEvent(id);
            
            if(dayDescription.isPresent()){
                return ResponseEntity.ok(dayDescription.get());
            }
            else{
                return ResponseEntity.ok(new ApiResponseError(002, "No content", "No results found", "dayDescription"));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
