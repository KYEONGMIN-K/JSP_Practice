package dao;

import dto.member_dto;
import java.sql.*;
import java.util.ArrayList;

public class member_repository {
	//싱글턴
	private static member_repository mr = new member_repository();
	//DB 연결 메서드
	private Connection DBconn() throws Exception{
		//Step 1. JDBC 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		//Step 2. Connection 객체 생성 
		//	* 확인사항 
		//		1. 데이터베이스 생성여부
		//		2. WEB-INF/lib 폴더 내 라이브러리 확인
		String database ="jdbc:mysql://localhost:3306/login_crud";
		String id ="root";
		String password="1234";
		conn = DriverManager.getConnection(database, id, password);
		System.out.println("데이터 베이스 연결완료");
		return conn;
	}
	
	public static member_repository getInstance() {
		return mr;
	}	
	
	//Create
	public void member_create(member_dto dto) {
		//데이터베이스에 넣기
		System.out.println("member_create 함수 진입");
		Connection conn = null;
		try {
			conn = DBconn();
			//Step 3. SQL 전송객체 생성 및 전송 : DB에 데이터를 삽입하는 절차
			Statement stmt = conn.createStatement();
			String userid = dto.getId();
			String userpw = dto.getPw();
			int userage = dto.getAge();
			// insert into member values ('admin', '1234', 7) : 워크벤치에서 테스트 실행
			// "insert into member values ('userid', 'userpw', userage)"
			// "insert into member values ('" + userid
			//  userid + "', '" + userpw
			//  userpw + "'," + age
			//  age + ")";
			//  ';' 은 사람을 기준으로 문자열의 끝을 알리는 표시. 보낼때는 .class로 변환되어 사라지게 되기때문에 기계는 표시 하지 않아도 된다. (애초에 한줄씩 밖에 보내지 못한다.)
			String sql = "INSERT INTO member values('"+userid+"','"+userpw+"',"+userage+")";
			//Step 4. 리턴이 있다면 ResultSet 객체에 담기 - CUD는 해당없음
			stmt.executeUpdate(sql);
			System.out.println("member_create DB 데이터 삽입 완료");			
			
		} catch (Exception e) {
			System.out.println("member_create DB 연결오류");
		}
	}
	//Read
	public ArrayList<member_dto> getAllmember() {
		ArrayList<member_dto> arr = new ArrayList<member_dto>();
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBconn();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM member";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//한 행을 가져오기
				//getString("컬럼명");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				
				member_dto dto = new member_dto();
				dto.setAge(age);
				dto.setId(id);
				dto.setPw(pw);
				/*
					member_dto dto = new member_dto();
					dto.setAge(rs.getInt("age"));
					dto.setId(rs.getString("id"));
					dto.setPw(rs.getString("pw"));
				 */
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("DB 읽어오기 오류");			
		}
		return arr;
	}
	public member_dto getOnemember(String userid) {
		System.out.println("getOnemember 함수 진입");
		ResultSet rs = null;
		member_dto dto = new member_dto();
		Connection conn= null;
		try {
			//1. DB연결
			conn = DBconn();
			//2. Query 전송 및 실행
			Statement stmt = conn.createStatement(); 
			String sql = "select * from member where id='"+userid+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				System.out.println(id+pw+age);
				dto.setAge(age);
				dto.setId(id);
				dto.setPw(pw);
			}
		}catch(Exception e) {
			System.out.println("getOnemember 함수 오류");
		}
		return dto;
	}
	
	//Update
	public void update_member(member_dto dto) {
		Connection conn = null;
		try {
			conn = DBconn();
			Statement stmt = conn.createStatement();
			String sql = "update member set pw='"+dto.getPw()+"', age="+dto.getAge()+" where id='"+dto.getId()+"' ";
			stmt.executeUpdate(sql);
			System.out.println("DB 데이터 수정 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Delete
	public void deleteuser(String id) {
		Connection conn = null;
		try {
			conn = DBconn();
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM member where id='"+id+"'";
			stmt.executeUpdate(sql);
			System.out.println("DB 데이터 삭제 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
