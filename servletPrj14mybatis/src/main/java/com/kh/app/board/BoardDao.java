package com.kh.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {
	
	//mybatis와 SqlSession으로 연습
	public int insert(SqlSession ss, BoardVo vo) throws Exception{
		//sql
		//close
		return ss.insert("BoardMapper.write", vo);
		//어떤파일의 어떤 쿼리를 실행해라!
	}

//	public int insert(Connection conn, BoardVo vo) throws Exception {
//		//쿼리 준비
//		String sql="""
//				INSERT INTO BOARD
//				(
//				    NO
//				    ,TITLE
//				    ,CONTENT
//				    ,WRITER_NO
//				)
//				VALUES
//				(
//				    SEQ_BOARD.NEXTVAL
//				    , ?
//				    , ?
//				    , 1
//				)
//				""";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getTitle());
//		pstmt.setString(2, vo.getContent());
//		
//		//쿼리 실행
//		int result = pstmt.executeUpdate();
//		
//		//자원 반납
//		pstmt.close();
//		return result;
//	}

	//mybatis와 SqlSession으로 연습
	public List<BoardVo> selectList(SqlSession ss) throws Exception {
		//sql
		//close
		return ss.selectList("BoardMapper.getBoardList");
	}
	
//	public List<BoardVo> selectList(SqlSession ss) throws Exception {
//		String sql = """
//				SELECT *
//				FROM BOARD
//				WHERE DEL_YN = 'N'
//				ORDER BY NO DESC
//				""";
//		PreparedStatement pstmt = ss.prepareStatement(sql);
//		
//		ResultSet rs = pstmt.executeQuery();
//		
//		//rs -> List<BoardVo>
//		List<BoardVo> voList = new ArrayList<BoardVo>();
//		
//		while(rs.next()) {
//			String no = rs.getString("NO");
//			String title = rs.getString("TITLE");
//			String content = rs.getString("CONTENT");
//			String writerNo = rs.getString("WRITER_NO");
//			String createdDate = rs.getString("CREATED_DATE");
//			String hit = rs.getString("HIT");
//			String delYn = rs.getString("DEL_YN");
//			
//			BoardVo vo = new BoardVo(no, title, content, writerNo, createdDate, hit, delYn);
//			
//			voList.add(vo);
//		}
//		
//		pstmt.close();
//		rs.close();
//		
//		return voList;
//	}

}
