package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface AdminBoardDAO {

	int getListCount(BoardVO b);
	List<BoardVO> getBoardList(BoardVO b);
	void insertBoard(BoardVO b);
	BoardVO getAdminBoardCont(int board_no);
	void editBoard(BoardVO eb);
	void deleteBoard(int no);

}
