package org.zerock.persistence;

import org.zerock.domain.AdminVO;

public interface AdminDAO {

	void insertAdmin(AdminVO ab);

	AdminVO adminLogin(String admin_id);

}
