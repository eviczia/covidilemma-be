package com.hackathon.covidilemma.repositories;

import com.hackathon.covidilemma.models.entities.LedConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedConfigRepository extends CrudRepository <LedConfig, Integer>{
}
