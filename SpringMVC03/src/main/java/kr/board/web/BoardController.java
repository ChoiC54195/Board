package kr.board.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.domain.Member;
import kr.board.service.BoardService;

@Controller // POJO
public class BoardController {

	@Autowired
	private BoardService service;
	// 멤버 변수로 선언 --> import해줘야함
	
	@RequestMapping("/")
	public String main() {
		return "basic";
	}
	
	@RequestMapping("login.do")
	public String login(Member vo, HttpSession session) {
		Member mvo = service.login(vo);
		if(mvo != null) { // 성공 --> 객체바인딩(HttpSession) why using session? request는 특정 jsp에만 객체바인딩되므로
			session.setAttribute("mvo", mvo);
			
		}
		return "redirect:/";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}