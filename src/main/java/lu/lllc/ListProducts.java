package lu.lllc;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Book> bookList = new ArrayList<Book>();
		// Adding the (at this moment empty) bookList to the session
		request.setAttribute("bookList", bookList);

//		Connection connection;
//		Statement statement;
//		ResultSet result = null;

		String dbURL = DBInfo.getDBURL();
		String user = DBInfo.getUser();
		String password = DBInfo.getPassword();

//		try {
//			Class.forName(DBInfo.getDriver());
//		} catch (ClassNotFoundException e) {
//			System.out.println("Error. Driver class not found: " + e);
//		}

//		try {
//			connection = DriverManager.getConnection(dbURL, user, password);
//		} catch (SQLException e) {
//			System.out.println("Error. Connection problem: " + e);
//			return;
//		}

//		try {
//			statement = connection.createStatement();
//		} catch (SQLException e) {
//			System.out.println("Error. Can not create the statement: " + e);
//			return;
//		}

		String searchString = "SELECT * FROM products";
//		try {
//			result = statement.executeQuery(searchString);
//		} catch (SQLException e) {
//			System.out.println("Error. Problem with executeUpdate: " + e);
//			return;
//		}

		// Now we collect the data from the result in order to display them in
		// JSP

//		try {
//			while (result.next()) {
//				Book book = new Book();
//				String title = result.getString("title");
//				book.setTitle(title);
//
//				String description = result.getString("description");
//				book.setDescription(description);
//
//				float price = result.getFloat("price");
//				book.setPrice(price);
//				bookList.add(book);
//			}
//		} catch (SQLException e) {
//			System.out.println("Error. Problem reading data: " + e);
//			return;
//		}

		Book book1 = new Book();
		book1.setTitle("Genesis");
		book1.setDescription("First book");
		book1.setPrice(1);
		bookList.add(book1);
		Book book2 = new Book();
		book2.setTitle("Exodus");
		book2.setDescription("Second book");
		book2.setPrice(2);
		bookList.add(book2);
		Book book3 = new Book();
		book3.setTitle("Leviticus");
		book3.setDescription("Third book");
		book3.setPrice(3);
		bookList.add(book3);
		Book book4 = new Book();
		book4.setTitle("Numbers");
		book4.setDescription("Fourth book");
		book4.setPrice(4);
		bookList.add(book4);
		Book book5 = new Book();
		book5.setTitle("Deuteronomy");
		book5.setDescription("Fifth book");
		book5.setPrice(5);
		bookList.add(book5);

//		try {
//			connection.close();
//		} catch (SQLException e) {
//			System.out.println("Error. Problem with closing connection: " + e);
//			return;
//		}

		RequestDispatcher disp = request
				.getRequestDispatcher("/WEB-INF/showBookList.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
