package kr.board.mapper;
// 비지니스 로직
// JDBC -> CRUD
// 1. Java + SQL 혼합된 형태 : 유지보수가 어렵다
// 2. 개발생산성이 떨어진다 : 어렵고, 개발속도가 느리다.
// Java와 SQL 분리 -> MyBatis Framework(DB Framework)
// MyBatis란? SQL Mapping Framework for Java : http://mybatis.org
// -> Spring JPA로 변화하는 추세임

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kr.board.domain.Board;

public interface BoardMapper {
	// 1. 데이터베이스 접속 기능(X) -> Spring
	// 2. 게시판리스트 가져오는 기능
	public List<Board> boardList(); 
	// 추상메서드 : 리턴타입은 Array보다 높은  List로 한다 
	//--> Why? 부모타입으로 리턴을 받아야 범용성 O
	// --> SQL(Select ~ )와 연결해야함
	
		// 1. 연결
		// 2. SQL
		// 3. 전송
		// 4. 반복문
		// 5. Board
		// 6. ArrayList
		// 1-6은 이미 다 되어있음. 안해도 됨.
	
	public void boardInsert(Board vo);
	public Board boardContent(int idx);
	
	// 쿼리 쓰는 법 2가지
	// 1. 어노테이션
	// 2. xml파일 이용 --> 복잡할 땐 xml이 좋다
	// 혼용도 되지만 두개 동시 사용은 XXXX
	@Delete("delete from board where idx=#{idx}")
	public void boardDelete(int idx);
	
	public void boardUpdate(Board vo);
	
	@Update("update set board contents=#{contents} where idx=#{idx}")
	public void boardContentUpdateAjax(Board vo);
}
