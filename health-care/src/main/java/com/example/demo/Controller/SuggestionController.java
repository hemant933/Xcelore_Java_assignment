package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Services.SuggestionService;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
    @Autowired private SuggestionService suggestionService;

    @GetMapping("/{patientId}")
    public ResponseEntity<?> getSuggestions(@PathVariable Long patientId) {
        return ResponseEntity.ok(suggestionService.suggestDoctors(patientId));
    }
}
