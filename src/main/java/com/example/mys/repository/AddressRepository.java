package com.example.mys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mys.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
