package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.Book;

public class BookRepository {
	//싱글턴 형식으로 생성
	private static BookRepository repository = new BookRepository();	
	//싱글턴 형식으로 생성
	private BookRepository() {};
	
	/*
	 * Function Name : dbconn()
	 * Parameter : none
	 * Return Type : Connection 
	 * DB에 연결하는 작업(드라이버)을 하는 함수 
	 */
	private Connection dbconn() {
		Connection conn = null;
		//연결 시 반드시 DB가 생성되어 있는지, WEB-INF/lib에 .jar가 있는지 확인 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bookmarketdb";
			String id = "root";
			String pw = "1234";
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB 연결 성공!");
		}catch(Exception e) {
			System.out.println("DB 연결 실패..");
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	 * Function Name : getRepository()
	 * Parameter : none
	 * Return Type : BookRepository
	 * 싱글턴으로 생성되어 있는 BookRepository 객체의 주소를 반환하는 함수
	 */
	public static BookRepository getRepository() {
		return repository;
	}
	
	/*
	 * Function Name : readAllbook()
	 * Parameter : none
	 * Return Type : ArrayList<Book>
	 * DB에 저장된 책 전체를 읽어와 ArrayList<Book> 객체에 담아 주소를 반환하는 함수
	 */
	public ArrayList<Book> readAllbook(){
		//반환할 변수 준비
		ArrayList<Book> arr = new ArrayList<Book>();
		
		try {
			//DB 연결
			Connection conn = dbconn();
			//SQL 작성 준비 : PreparedStatement 객체 생성
			PreparedStatement pstmt = null;
			String sql = "select * from book";
			pstmt = conn.prepareStatement(sql); //PreparedStatement 객체 생성, 파라미터 : sql
			
			//SQL문 DB로 전달 , return : ResultSet 객체
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				// 테이블 전체를 가져와 저장해야하고 row 하나 당 dto 하나가 매핑된다.
				// 변수 > dto > ArrayList<Book>
				
				//== 선생님은 변수에 담아서 해당 변수를 set()의 파라미터로 전달.
				//== DTO의 변수이름, Repository 변수이름, Database 컬럼 이름 
				//== 위 3가지를 다 같이 쓰는 것이 편하다.
				Book book = new Book();
				book.setBookId(rs.getString("b_id")); 
				book.setAuthor(rs.getString("b_author"));
				book.setCategory(rs.getString("b_category"));
				book.setCondition(rs.getString("b_condition"));
				book.setDescription(rs.getString("b_description"));
				book.setName(rs.getString("b_name"));
				book.setPublisher(rs.getString("b_publisher"));
				book.setUnitPrice(rs.getInt("b_unitPrice"));
				book.setUnitsInStock(rs.getLong("b_unitsInStock"));
				book.setReleaseDate(rs.getString("b_releaseDate"));
				book.setFilename(rs.getString("b_fileName"));
				//한 row를 다 book에 담았으면 해당 dto를 ArrayList에 추가
				arr.add(book);
			}
			//왜 .equals()를 사용하지 않고 비교 연산자를 사용할까?
			/*
			 * String 클래스는 우리가 편하게 = "문자열";로 넣어도 일반적인 데이터 타입처럼 사용할 수 있게 해주는데
			 * 이걸 잘 생각해보면, .은 객체의 멤버 메소드를 사용하겠다는 것인데 주소값 자체가 없는 NULL상태라면
			 * 접근 자체가 NullPointerException을 일으킬 수 있기 때문에 비교연산자를 사용하여 
			 * 참조변수 자체가 NULL인지 아닌지를 비교하는 것이 맞다.
			 * 10.29 BookMarket 작성 중 궁금증으로 찾아봄.
			 */
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return arr;
	}

	/*
	 * Function Name : readOneBook()
	 * Parameter : String id
	 * Return Type : Book
	 * 선택된 책 하나만 DB로부터 가져와 DTO(Book)로 반환하는 함수
	 * SQL 작성 시 옵션으로 함수의 파라미터로 넘어온 ID를 가지고 찾는다.
	 */
	public Book readOneBook(String id) {
		Book book = null;
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String sql ="select * from book where b_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setBookId(rs.getString("b_id")); 
				book.setAuthor(rs.getString("b_author"));
				book.setCategory(rs.getString("b_category"));
				book.setCondition(rs.getString("b_condition"));
				book.setDescription(rs.getString("b_description"));
				book.setName(rs.getString("b_name"));
				book.setPublisher(rs.getString("b_publisher"));
				book.setUnitPrice(rs.getInt("b_unitPrice"));
				book.setUnitsInStock(rs.getLong("b_unitsInStock"));
				book.setReleaseDate(rs.getString("b_releaseDate"));
				book.setFilename(rs.getString("b_fileName"));				
			}
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	
	/*
	 * Function Name : addBook()
	 * Parameter : Book book
	 * Return Type : void
	 * 새로운 책을 DB로 저장하는 함수
	 * 저장 시 DB에 생성된 필드의 순서에 맞게 넣어야한다.
	 */
	public void addBook(Book book) {
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
			pstmt.setString(2, book.getName());
			pstmt.setInt(3, book.getUnitPrice());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, book.getDescription());
			pstmt.setString(6, book.getPublisher());
			pstmt.setString(7, book.getCategory());
			pstmt.setLong(8, book.getUnitsInStock());
			pstmt.setString(9, book.getReleaseDate());
			pstmt.setString(10, book.getCondition());
			pstmt.setString(11, book.getFilename());
			// execute 자꾸 까먹지마라
			pstmt.executeUpdate();
			
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Function Name : updateBook()
	 * Parameter : Book book
	 * Return Type : void
	 * 새로운 책을 DB로 저장하는 함수
	 * 저장 시 DB에 생성된 필드의 순서에 맞게 넣어야한다.
	 */
	public void updateBook(Book book) {
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			if(book.getFilename() != null) {	//file이 있을 때
				String sql = "update book set b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=?, b_fileName=? where b_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getName());
				pstmt.setInt(2, book.getUnitPrice());
				pstmt.setString(3, book.getAuthor());
				pstmt.setString(4, book.getDescription());
				pstmt.setString(5, book.getPublisher());
				pstmt.setString(6, book.getCategory());
				pstmt.setLong(7, book.getUnitsInStock());
				pstmt.setString(8, book.getReleaseDate());
				pstmt.setString(9, book.getCondition());
				pstmt.setString(10, book.getFilename());
				pstmt.setString(11, book.getBookId());
				pstmt.executeUpdate();
			}else { //file이 없을 때
				String sql = "update book set b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=? where b_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getName());
				pstmt.setInt(2, book.getUnitPrice());
				pstmt.setString(3, book.getAuthor());
				pstmt.setString(4, book.getDescription());
				pstmt.setString(5, book.getPublisher());
				pstmt.setString(6, book.getCategory());
				pstmt.setLong(7, book.getUnitsInStock());
				pstmt.setString(8, book.getReleaseDate());
				pstmt.setString(9, book.getCondition());
				pstmt.setString(10, book.getBookId());
				pstmt.executeUpdate();
			}
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Function Name : deleteBook()
	 * Parameter : String id
	 * Return Type : void
	 * 선택한 책을 DB에서 삭제하는 함수
	 * 삭제 시 필요한 ID를 파라미터로 받아 SQL의 옵션으로 넣어 삭제한다.
	 */
	public void deleteBook(String id) {
		try {
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			String sql = "delete from book where b_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
