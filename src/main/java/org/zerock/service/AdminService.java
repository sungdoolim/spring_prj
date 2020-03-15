package org.zerock.service;

import org.zerock.domain.AdminVO;

public interface AdminService {

	void insertAdmin(AdminVO ab);

	AdminVO adminLogin(String admin_id);

}
