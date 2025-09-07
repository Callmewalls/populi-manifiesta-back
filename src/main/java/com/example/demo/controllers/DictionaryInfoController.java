package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.BasicResponse;
import com.example.demo.services.CatalogService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController("/DictionaryInfo")
public class DictionaryInfoController {
    
    @Autowired
    CatalogService catalogService;

    @GetMapping("/getInfo")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            content = @Content(
                mediaType="application/json",
                schema = @Schema(implementation = BasicResponse.class)
            ))
    })
    public ResponseEntity getInfo(){

        try {
            return ResponseEntity.status(200).body(BasicResponse.success("Catalogos obtenidos", this.catalogService.getCatalogs()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(BasicResponse.error(e.getMessage(), 500));
        }
    }
    
}
