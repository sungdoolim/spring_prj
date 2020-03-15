package org.zerock.service;

import java.util.List;

import org.zerock.domain.GongjiVO;

public interface GongjiService {

	List<GongjiVO> getList();
	GongjiVO getGCont(int gongji_no);

}
