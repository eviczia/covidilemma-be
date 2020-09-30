package com.hackathon.covidilemma.repositories;

import com.hackathon.covidilemma.models.dtos.LedConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedConfigRepository extends CrudRepository <LedConfig, Integer>{
}
