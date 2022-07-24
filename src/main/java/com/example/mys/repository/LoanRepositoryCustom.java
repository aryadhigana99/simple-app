package com.example.mys.repository;

import java.util.Date;
import java.util.List;

import com.example.mys.dto.LoanDTO;

public interface LoanRepositoryCustom {
	
	public List<LoanDTO> loanList(Date today,String status);

}
