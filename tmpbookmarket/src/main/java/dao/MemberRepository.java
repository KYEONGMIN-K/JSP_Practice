package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import dto.Member;
import logTime.timeReturn;

public class MemberRepository {
	private static MemberRepository mr = new MemberRepository();
	private MemberRepository() {}
	public static MemberRepository getMr() {
		return mr;
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
	
	//create
	public void create(Member mb) {
		try {
			//DB연결
			Connection conn = dbconn();
			//SQL 전송
			PreparedStatement pstmt = null;
			String sql ="INSERT INTO member VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPassword());
			pstmt.setString(3, mb.getName());
			pstmt.setString(4, mb.getGender());
			pstmt.setString(5, mb.getBirth());
			pstmt.setString(6, mb.getMail());
			pstmt.setString(7, mb.getPhone());
			pstmt.setString(8, mb.getAddress());
			pstmt.setTimestamp(9, mb.getRegist_day());
			pstmt.executeUpdate();	
			//ResultSet 처리
			
			if(pstmt!=null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//delete
	
	//update

	//read
	
	//login info
	public Member getUser(String id, String pw){
		Member mb = null;
//		System.out.println("getUser id, pw : "+ id+"|"+pw);
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String sql = "select * from member where id=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb = new Member();
//				System.out.println("getUser id, pw : "+ id+"|"+pw);
				System.out.println(timeReturn.getTime()+" #getUser in");
				mb.setId(rs.getString("id"));
//				System.out.println(mb.getId());
				mb.setPassword(rs.getString("password"));
				mb.setName(rs.getString("name"));
				mb.setAddress(rs.getString("address"));
				mb.setBirth(rs.getString("birth"));
				mb.setGender(rs.getString("gender"));
				mb.setMail(rs.getString("mail"));
				mb.setPhone(rs.getString("phone"));
				mb.setRegist_day(rs.getTimestamp("regist_day"));
			}
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mb;
	}
}
