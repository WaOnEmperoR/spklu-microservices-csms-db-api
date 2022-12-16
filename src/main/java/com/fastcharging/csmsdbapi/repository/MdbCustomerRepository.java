package com.fastcharging.csmsdbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcharging.csmsdbapi.model.MdbCustomer;

@Repository
public interface MdbCustomerRepository extends JpaRepository<MdbCustomer, Long> {
    public MdbCustomer findByidTag(Long mdbCustomerId);

}
