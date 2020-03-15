package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BbsVO;

public interface AdminBbsDAO {

	int getListCount(BbsVO b);
	List<BbsVO> getBbsList(BbsVO b);
	void isnertBbs(BbsVO b);
	BbsVO getBbsCont(int no);
	void editBbs(BbsVO b);
	void delBbs(int no);

}
