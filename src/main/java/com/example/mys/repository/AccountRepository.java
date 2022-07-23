package com.example.mys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mys.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
