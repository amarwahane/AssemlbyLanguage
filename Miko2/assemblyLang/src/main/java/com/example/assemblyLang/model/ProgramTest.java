package com.example.assemblyLang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProgramTest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String text;

    private int reg1Value;

    private int reg2Value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getReg1Value() {
		return reg1Value;
	}

	public void setReg1Value(int reg1Value) {
		this.reg1Value = reg1Value;
	}

	public int getReg2Value() {
		return reg2Value;
	}

	public void setReg2Value(int reg2Value) {
		this.reg2Value = reg2Value;
	}
    
    
    
    

    
}
