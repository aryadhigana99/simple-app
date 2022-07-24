package com.example.mys.repository;

import java.util.List;

import com.example.mys.dto.EmergencyContactDTO;

public interface EmergencyContactRepositoryCustom {

	public List<EmergencyContactDTO> listEmergencyContact(Long accountId);
}
