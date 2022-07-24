package com.example.mys.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.mys.dto.LoanDTO;
import com.example.mys.repository.LoanRepositoryCustom;

@Repository
public class LoanRepositoryImpl implements LoanRepositoryCustom{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<LoanDTO> loanList(Date today,String status) {
		
		TypedQuery<LoanDTO> query = this.entityManager
				.createNamedQuery("loan.listDate", LoanDTO.class)
				.setParameter("today", today)
				.setParameter("status", status);
		return query.getResultList();
	}

}
