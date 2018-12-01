package com.gateranker.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.model.Address;

@Repository
public interface AddresRepository extends JpaRepository<Address, Integer> {

}
