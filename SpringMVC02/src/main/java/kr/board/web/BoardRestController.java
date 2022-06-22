package kr.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.board.domain.Board;
import kr.board.service.BoardService;

//  @ResponseBody 안해도 됨
@RestController
public class BoardRestController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx){ // @RequestParam("idx") 변수 이름이 다를 때는 이 어노테이션을 써줘야 한다.
		service.boardDelete(idx);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value="/boardListAjax.do")
	public List<Board> boardListAjax() {
		List<Board> list = service.boardListAjax();
		// json data format으로 응답해야한다
		// List<Board> --> Gson API --> String(JSON)
		// 스프링은 Jackson사용
		return list; // List<Board> --> jackson --> String(JSON)
	}
	
	@RequestMapping(value="/boardInsertAjax.do")
	public void boardInsertAjax(Board vo) {
		service.boardInsertAjax(vo);
	}
	
	@RequestMapping(value="/boardContentUpdateAjax.do")
	public void boardContentUpdateAjax(Board vo) {
		service.boardContentUpdateAjax(vo);
	}
	
	@GetMapping(value="/boardDeleteAjax.do")
	public void boardDeleteAjax(int idx) {
		service.boardDelete(idx);
	}
	
	@PostMapping(value="/boardTWUpdateAjax.do")
	public void boardTWUpdateAjax(Board vo) {
		service.boardTWUpdateAjax(vo);
	}
}

