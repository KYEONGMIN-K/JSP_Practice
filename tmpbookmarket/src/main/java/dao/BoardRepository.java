package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Board;
import logTime.timeReturn;

public class BoardRepository {
	//싱글톤
	private static BoardRepository br = new BoardRepository();
	private BoardRepository() {}
	
	public static BoardRepository getInstance() {
		return br;
	}

	/*
	 * Function Name : dbconn()
	 * Parameter : none
	 * Return Type : Connection 
	 * DB에 연결하는 작업(드라이버)을 하는 함수 
	 */
	private Connection dbconn() {
		Connection conn = null;
		//연결 시 반드시 DB가 생성되어 있는지, WEB-INF/lib에 .jar가 있는지 확인 
		System.out.println(timeReturn.getTime()+" #rp_Conn dbconn in");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bookmarketdb";
			String id = "root";
			String pw = "1234";
			conn = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//행의 갯수를 리턴함
	public int getTotalCount() {
		int count = 0;
		try {
			//DB 연결
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			//count(*) 는 테이블 행의 갯수를 새어 return한다.
			String sql ="select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);	//첫번째 컬럼이라는 뜻
				System.out.println("count : "+count);
			}
		}catch(Exception e) {}
		
		return count;
	}
	
	
	//create
	public void create(Board bd) {
		try {
			//DB연결
			Connection conn = dbconn();
			//쿼리 전송
			PreparedStatement pstmt = null;
			String sql ="insert into board(id,name,subject,content,regist_day,hit,ip) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bd.getId());
			pstmt.setString(2, bd.getName());
			pstmt.setString(3, bd.getSubject());
			pstmt.setString(4, bd.getContent());
			pstmt.setTimestamp(5, bd.getRegist_day());
			pstmt.setInt(6,bd.getHit());
			pstmt.setString(7, bd.getIp());
			pstmt.executeUpdate();
			//ResultSet()
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//read All
	public ArrayList<Board> getAllBoard() {
		ArrayList<Board> arr = new ArrayList<Board>();
		
		try {
			//DB 연결
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegist_day(rs.getTimestamp("regist_day"));
				board.setHit(rs.getInt("hit"));
				board.setIp(rs.getString("ip"));
				
				arr.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return arr;
	}
	//read One
	
	//update
	
	//delete
	

}
