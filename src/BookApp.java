import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookApp {
	static Scanner sc = new Scanner(System.in);
	static int totalPrice;
	static int status;
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		status = 0;
		while (status == 0) {
			System.out.println("Welcome to your personal Book Library!");
			System.out.println("(1) Add a book\n(2) Update a book\n(3) Delete a book\n(4) Find a book\n(5) Quit");
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("1")) {
				System.out.println("Adding a new record");
				System.out.println("Enter book SKU: ");
				String sku = sc.nextLine();
				System.out.println("Enter book Title: ");
				String title = sc.nextLine();
				System.out.println("Enter book Author: ");
				String author = sc.nextLine();
				System.out.println("Enter book Description: ");
				String description = sc.nextLine();
				System.out.println("Enter book Price: ");
				double price = sc.nextDouble();
				sc.nextLine();
				System.out.println(insertBook(sku, title, author, description, price) + "\n\n");
			} else if (input.equalsIgnoreCase("2")) {
				System.out.println("Updating an existing record");
				System.out.println("Enter book SKU to update: ");
				String sku = sc.nextLine();
				System.out.println("Enter book Title: ");
				String title = sc.nextLine();
				System.out.println("Enter book Author: ");
				String author = sc.nextLine();
				System.out.println("Enter book Description: ");
				String description = sc.nextLine();
				System.out.println("Enter book Price: ");
				double price = sc.nextDouble();
				sc.nextLine();
				System.out.println(updateBook(sku, title, author, description, price) + "\n\n");
			} else if (input.equalsIgnoreCase("3")) {
				System.out.println("Deleteing a record");
				System.out.println("Enter book SKU to delete: ");
				String sku = sc.nextLine();
				System.out.println(deleteBook(sku) + "\n\n");
			} else if (input.equalsIgnoreCase("4")) {
				System.out.println("Find a book");
				System.out.println("Enter book SKU to find: ");
				String sku = sc.nextLine();
				System.out.println(findBook(sku) + "\n\n");
			} else if (input.equalsIgnoreCase("5")) {
				System.out.println("Thank you. Have a good day.");
				status = 1;
			} else {
				System.out.println("Wrong input. Please try again.");
			}
		}
	}

	public static String insertBook(String sku, String title, String author, String description, double price) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO Book VALUES (?,?,?,?,?)");
			pstmt.setString(1, sku);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, description);
			pstmt.setDouble(5, price);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Book inserted.";
	}

	public static String updateBook(String sku, String title, String author, String description, double price) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement(
					"update Book set title=?, author=?, description=?, price=? where lower(trim(SKU)) = ?");
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setString(3, description);
			pstmt.setDouble(4, price);
			pstmt.setString(5, sku);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Book updated.";
	}

	public static String deleteBook(String sku) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("delete from book where lower(trim(SKU)) = ?");
			pstmt.setString(1, sku);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Book deleted.";
	}

	public static String findBook(String sku) {
		String returnString = "No such book found";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("select * from book where lower(trim(SKU)) = ?");
			pstmt.setString(1, sku);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				returnString = "SKU: " + rs.getString("SKU") + "\n";
				returnString += "Title: " + rs.getString("Title") + "\n";
				returnString += "Author: " + rs.getString("Author") + "\n";
				returnString += "Description: " + rs.getString("Description") + "\n";
				returnString += "Price: " + rs.getString("Price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnString;
	}
}
