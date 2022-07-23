package com.example.mys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mys.model.Account;
import com.example.mys.other.AccountRequest;
import com.example.mys.other.RequestResponse;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	

}
