package com.example.mys.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.mys.dto.EmergencyContactDTO;
import com.example.mys.repository.EmergencyContactRepositoryCustom;

@Repository
public class EmergencyContactRepositoryImpl implements EmergencyContactRepositoryCustom{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<EmergencyContactDTO> listEmergencyContact(Long accountId) {
		// TODO Auto-generated method stub
		
		TypedQuery<EmergencyContactDTO> query = this.entityManager
				.createNamedQuery("emergencyContact.listByAccountId", EmergencyContactDTO.class)
				.setParameter("accountId", accountId);
		return query.getResultList();
	}
	

}
