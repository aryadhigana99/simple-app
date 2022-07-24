package com.example.mys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.mys.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>, LoanRepositoryCustom, JpaSpecificationExecutor<Loan>{

}
