package com.example.assemblyLang.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assemblyLang.model.ProgramTest;


@Repository	
public interface ProgramTestRepo extends JpaRepository<ProgramTest, Long> {

}
