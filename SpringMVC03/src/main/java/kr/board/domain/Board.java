package kr.board.domain;

import lombok.Data;

@Data
public class Board { // lombok(롬복) --> setter, getter 안 써도 됨
	// property(프로퍼티, 속성)
	private int idx; // 번호
	private String memId; // 아이디
	private String title; // 제목
	private String contents; // 내용
	private String writer; // 작성자
	private String indate; // 작성일
	private int count; // 조회수
		
}
