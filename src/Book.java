public class Book {

	private String title;
	private String author;
	private String description;
	private int price;
	private int totalPrice;
	private boolean isInStock;
		
	public void setTitle( String bookTitle ) {
		title = bookTitle;
	} 
	public void setAuthor( String bookAuthor ) {
		author = bookAuthor;
	} 
	public void setDescription( String bookDescription ) {
		description = bookDescription;
	} 
	public void setPrice( int bookPrice ) {
		price = bookPrice;
	} 
	public void setIsInStock( boolean bookIsInStock ) {
		isInStock = bookIsInStock;
	} 
	public void setTotal( int bookPrice ) {
		totalPrice = bookPrice;
	} 
	public String getTitle() {
		return title;
	} 
	public String getAuthor() {
		return author;
	} 
	public String getDescription() {
		return description;
	} 
	public int getPrice() {
		return price;
	} 
	public boolean getIsInStock() {
		return isInStock;
	} 
	public int getTotal() {
		return totalPrice;
	} 
	
	public Book(){
		//System.out.println("A new book has been created");
	}
	public Book(String title){
		//System.out.println("A new book " + title + " has been requested");
	}
	public String getDisplayText(){
		return "Author: " + author + "\nTitle: " + title + "\nDescription:" + description;
	}
}
