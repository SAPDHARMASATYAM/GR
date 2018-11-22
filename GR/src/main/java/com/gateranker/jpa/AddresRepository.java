package com.gateranker.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateranker.entity.Address;

@Repository
public interface AddresRepository extends JpaRepository<Address, Integer> {

}
