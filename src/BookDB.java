
public class BookDB {
	public Book getBook(String title){
		Book b = new Book();
		if(title.equalsIgnoreCase("Harry Potter")){
			b.setTitle(title);
			b.setPrice(45);
			b.setAuthor("J.K.Rowling");
			b.setIsInStock(true);			
			b.setDescription("Fiction");
			b.setTotal(45);
		}
		if(title.equalsIgnoreCase("Java Basics")){
			b.setTitle(title);
			b.setPrice(55);
			b.setAuthor("Russel Adams");
			b.setIsInStock(true);			
			b.setDescription("Educational");	
			b.setTotal(55);
		}
		if(title.equalsIgnoreCase("PHP Basics")){
			b.setTitle(title);
			b.setPrice(85);
			b.setAuthor("Dave Fulcher");
			b.setIsInStock(true);			
			b.setDescription("Educational");	
			b.setTotal(85);
		}
		if(title.equalsIgnoreCase("HTML Basics")){
			b.setTitle(title);
			b.setPrice(75);
			b.setAuthor("Steve Skyy");
			b.setIsInStock(true);			
			b.setDescription("Educational");	
			b.setTotal(75);
		}
		if(title.equalsIgnoreCase("JS Basics")){
			b.setTitle(title);
			b.setPrice(65);
			b.setAuthor("Powell Cow");
			b.setIsInStock(true);			
			b.setDescription("Educational");	
			b.setTotal(65);
		}
		if(title.equalsIgnoreCase("Python Basics")){
			b.setTitle(title);
			b.setPrice(105);
			b.setAuthor("King Drew");
			b.setIsInStock(true);			
			b.setDescription("Educational");	
			b.setTotal(105);
		}
		return b;		
	}
}
