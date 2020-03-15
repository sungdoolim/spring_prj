package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.AdminVO;
import org.zerock.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO adminDAO;
	
	@Override
	public void insertAdmin(AdminVO ab) {
	  this.adminDAO.insertAdmin(ab);  			
	}

	@Override
	public AdminVO adminLogin(String admin_id) {
		return this.adminDAO.adminLogin(admin_id);
	}
}






