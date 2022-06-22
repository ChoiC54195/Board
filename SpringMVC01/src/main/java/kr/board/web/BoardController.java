package kr.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;

@Controller // POJO
public class BoardController {

	@Autowired
	private BoardMapper mapper;
	// 멤버 변수로 선언 --> import해줘야함

	@RequestMapping("/boardList.do") // URL에서 요청을 받는 부분(요청이름)
	public String boardList(Model model) {
		// HttpServletRequest 대신 Model(객체바인딩을 위한 스프링클래스)
		List<Board> list = mapper.boardList();
		model.addAttribute("list", list);
		// request.getAttribute 대신 model.addAttriute
		return "boardList";
	}

	@RequestMapping(value="/boardInsert.do", method=RequestMethod.GET)
	public String boardInsertGet(Model model) {
		return "boardInsertForm";
	}

	@RequestMapping(value="/boardInsert.do", method=RequestMethod.POST) // form의 파라미터 3개가 넘어온다.
	public String boardInsertPost(Board vo) {
		// 글쓰기 요청을 처리
		// getParameter --> vo || dto => 파라미터 수집
		// 스프링을 자동으로 해준다
		mapper.boardInsert(vo);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("/boardContent.do/{idx}")
	public String boardContent(@PathVariable("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo",vo);
		return "boardContent";
	}
	
	@RequestMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx){ // @RequestParam("idx") 변수 이름이 다를 때는 이 어노테이션을 써줘야 한다.
		mapper.boardDelete(idx);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value="/boardUpdate.do/{idx}", method=RequestMethod.GET)
	public String boardUpdateGet(@PathVariable("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo",vo);
		return "boardUpdateForm";
	}
	@RequestMapping(value="/boardUpdate.do", method=RequestMethod.POST)
	public String boardUpdatePost(Board vo) {
		mapper.boardUpdate(vo);
		return "redirect:/boardList.do";
	}
	
}
