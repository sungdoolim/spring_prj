package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.GongjiVO;

public interface GongjiDAO {

	List<GongjiVO> getList();
	void updateHit(int gongji_no);
	GongjiVO getGCont(int gongji_no);

}
