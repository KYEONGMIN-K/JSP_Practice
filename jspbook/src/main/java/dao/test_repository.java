package dao;

import java.sql.*;
import java.util.ArrayList;

import dto.test_dto;

public class test_repository {
	//싱글턴 구현
	private static test_repository rep= new test_repository();
	public static test_repository getInstance() {
		return rep;
	}
	
	//db connect module
	private Connection dbconn() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jspbook";
			String uid = "root";
			String upw = "1234";
			conn = DriverManager.getConnection(url, uid, upw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//db insert data
	public void test_insert(test_dto dto) {
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String psql = "insert into exam values(?,?,?)";
			pstmt = conn.prepareStatement(psql);
			String id = dto.getId();
			String pw = dto.getPw();
			String name = dto.getName();
			System.out.println("삽입 데이터 : "+id + " "+pw+ " "+name);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
			System.out.println("삽입성공!");
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//db read all the data
	public ArrayList<test_dto> test_read() {
		ArrayList<test_dto> arr = new ArrayList<test_dto>();
		try {
			System.out.println("read() 진입");
			Connection conn = dbconn();
			//preparedstmt 선언
			PreparedStatement pstmt = null;
			String sql ="select * from exam";
			//sql 먼저 작성 후 생성 시 파라미터로 넣어줘야한다.
			pstmt = conn.prepareStatement(sql);
			//실행
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				test_dto dto = new test_dto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				
				arr.add(dto);
				System.out.println("read() : "+dto.getId());
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return arr;		
	}
	//db read one data
	public test_dto test_readone(String id) {
		test_dto dto = new test_dto();
		System.out.println("update id : "+ id);
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String sql = "select * from exam where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("resultset name : "+rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
			}
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	//db delete data
	public void test_deletd(String id) {
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String sql="delete from exam where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//db update data
	public void test_update(test_dto dto) {
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String sql="update exam set pw=?, name=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getId());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
