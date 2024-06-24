package com.example.assemblyLang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assemblyLang.model.ProgramTest;
import com.example.assemblyLang.service.AssemblyLangServie;

@RestController
@RequestMapping("/assembly")
public class AssemblyLangController {

	
	@Autowired
	private AssemblyLangServie assemblyLangServie;

	
	@PostMapping("/execute")
    public ResponseEntity<String> executeProgram(@RequestBody String command) {
        String result = assemblyLangServie.parseAndExecuteProgram1(command);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body("No SHOW command found in the input.");
        }
    }
	
	
	
	
	
}
