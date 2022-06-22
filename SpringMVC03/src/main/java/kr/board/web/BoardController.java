package kr.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;

@Controller // POJO
public class BoardController {

	@Autowired
	private BoardMapper mapper;
	// 멤버 변수로 선언 --> import해줘야함
	
	@RequestMapping("/")
	public String main() {
		return "basic";
	}
	
}