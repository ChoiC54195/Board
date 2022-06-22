package kr.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper mapper;

	public String boardDelete(@PathVariable("idx") int idx) { // @RequestParam("idx") 변수 이름이 다를 때는 이 어노테이션을 써줘야 한다.
		mapper.boardDelete(idx);
		return "redirect:/boardList.do";
	}

	public List<Board> boardListAjax() {
		List<Board> list = mapper.boardList();
		// json data format으로 응답해야한다
		// List<Board> --> Gson API --> String(JSON)
		// 스프링은 Jackson사용
		return list; // List<Board> --> jackson --> String(JSON)
	}

	public void boardInsertAjax(Board vo) {
		mapper.boardInsert(vo);
	}

	public void boardContentUpdateAjax(Board vo) {
		mapper.boardContentUpdateAjax(vo);
	}

	public void boardDeleteAjax(int idx) {
		mapper.boardDelete(idx);
	}

	public void boardTWUpdateAjax(Board vo) {
		mapper.boardTWUpdateAjax(vo);
	}
}
