package com.fastcharging.csmsdbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcharging.csmsdbapi.model.OcppTag;

@Repository
public interface OcppTagRepository extends JpaRepository<OcppTag, Long> {
    public OcppTag findByidTag(String idTag);
}
