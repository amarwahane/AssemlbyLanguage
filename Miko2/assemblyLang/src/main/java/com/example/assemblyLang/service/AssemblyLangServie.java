package com.example.assemblyLang.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assemblyLang.model.ProgramTest;
import com.example.assemblyLang.repo.ProgramTestRepo;

@Service
public class AssemblyLangServie {
	
	@Autowired
	private ProgramTestRepo programRepo;
	
	private Map<String, Integer> map = new HashMap<>();
	
	String lastShowCommandResult;

	public AssemblyLangServie() {
		this.map = new HashMap<>();
	}
	
	
	public void MV(String reg, int value) {
		
        map.put(reg, value);
    }
	
	public void ADD(String reg1, String operand) throws IllegalArgumentException{
		
		try {
			
		
        int value = map.containsKey(operand) ? map.get(operand) : Integer.parseInt(operand);
        map.put(reg1, map.get(reg1) + value);
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid value for ADD command: ");
			 throw new IllegalArgumentException("Invalid value for ADD command: " + operand);
		}
    }
	
	 public void executeSHOW(String reg) {
	        System.out.println(reg + ": " + map.get(reg));
	    }
	 
	 public String executeSHOW1(String reg) {
	        int value = map.getOrDefault(reg, 0);
	        lastShowCommandResult = reg + ": " + value;
	        System.out.println(lastShowCommandResult);
	        return lastShowCommandResult;
	    }
	
	 
	 public ProgramTest parseAndExecuteProgram(String command) {
		 
		
	        String[] lines = command.split("\\n");
	        for (String line : lines) {
	            String[] parts = line.trim().split(" ");
	            switch (parts[0]) {
	                case "MV":
	                    MV(parts[1].replace(",", ""), Integer.parseInt(parts[2].replace("#", "")));
	                    break;
	                case "ADD":
	                    ADD(parts[1].replace(",", ""), parts[2]);
	                    break;
	                case "SHOW":
	                    //SHOW(parts[1]);
	                	
	                	if (parts.length > 1) {
                            String regShow = parts[1].replace(",", "");
                            executeSHOW(regShow);
                            executeSHOW1(regShow);
                        } else {
                            throw new IllegalArgumentException("Invalid SHOW command: " + line);
                        }
	                    break;
	            }
	        }
	        
	        ProgramTest result = new ProgramTest();
	        result.setText(command);
	        result.setReg1Value(map.get("REG1"));
	        result.setReg2Value(map.get("REG2"));

	        programRepo.save(result);
	        return result;
	
	 }
	 
	 public String parseAndExecuteProgram1(String command) {
	        map.clear();
	        lastShowCommandResult = null;
	        String[] lines = command.split("\\n");
	        for (String line : lines) {
	            String[] parts = line.trim().split(" ");
	            switch (parts[0]) {
	                case "MV":
	                    MV(parts[1].replace(",", ""), Integer.parseInt(parts[2].replace("#", "")));
	                    break;
	                case "ADD":
	                    ADD(parts[1].replace(",", ""), parts[2]);
	                    break;
	                case "SHOW":
	                    if (parts.length > 1) {
	                        String regShow = parts[1].replace(",", "");
	                        executeSHOW(regShow);
	                        executeSHOW1(regShow);
	                    } else {
	                        throw new IllegalArgumentException("Invalid SHOW command: " + line);
	                    }
	                    break;
	            }
	        }
	        return lastShowCommandResult;
	    }

}
