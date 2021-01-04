package com.example.core.repository;

import com.example.core.model.ModuleTest;

import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo {

  public ModuleTest helloWorld();

}
