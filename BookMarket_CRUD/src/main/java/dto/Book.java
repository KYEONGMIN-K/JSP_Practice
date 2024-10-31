package dto;

import java.io.Serializable;

/*
 * Book class 정의
 * 변수 10개, 함수 : 생성자 2개 , get()/set() 20개 
 * 
 */
public class Book implements Serializable{
	private static final long serialVersionUID = -4274700572038677000L;
	
	private String bookId;			//책 번호 (고유값)
	private String name;			//책 이름
	private int unitPrice;			//책 가격
	private String author;			//저자
	private String description;		//설명
	private String publisher;		//출판사
	private String category;		//분류
	private long unitsInStock;		//재고 수
	private String releaseDate;		//출판일
	private String condition;		//상태 (새도서, 중고도서, E-Book)
	private String filename;		//책 이미지파일
	private int quantity;			//구매하려는 책 개수
	
	//======= 함수 ========
	//생성자
	public Book() {
		super();
	}
	public Book(String bookId, String name, Integer unitPrice) {
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	//모든 변수들에 대한 get,set 함수들 
	// private 멤버에 대한 접근은 직접적으로 이루어져서는 안된다. 모든 것은 함수를 통해.
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
