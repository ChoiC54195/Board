package kr.board.domain;

public class Board {
	// property(프로퍼티, 속성)
	private int idx; // 번호
	private String title; // 제목
	private String contents; // 내용
	private String writer; // 작성자
	private String indate; // 작성일
	private int count; // 조회수
	
	public Board() {} 
	// 생성자를 쓰려면 디폴트 생성자를 무조건 해줘야 함
	// 제일 최악은 디폴트 생성자를 쓰지 않아놓고 다른 생성자를 만들어놓는 것 --> 에러 생김
	// 디폴트 생성자는 생성자가 아예 없으면 자동으로 만들어지기 때문에 아예 생성자를 하나도 안 적는 것도 방법이다
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
