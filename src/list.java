

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class list
 */
@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","manager");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from doctor");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"  <title>Doctors List</title>\r\n" + 
					"  <meta charset=\"utf-8\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\r\n" + 
					"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
					"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" + 
					"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<div class=\"container\">\r\n" + 
					"  <h2>Doctors List</h2>\r\n" + 
					"  <p>List of doctors who are involved in this system</p>            \r\n" + 
					"  <table class=\"table table-striped\">\r\n" + 
					"    <thead>\r\n" + 
					"      <tr>\r\n" + 
					"        <th>Name</th>\r\n" + 
					"        <th>Mail</th>\r\n" + 
					"        <th>Phone</th>\r\n" + 
					"        <th>Hospital</th>\r\n" + 
					"      </tr>\r\n" + 
					"    </thead>\r\n" + 
					"    <tbody>\r\n" + 
					"      <tr>\r\n");
			
			String s="";
			while(rs.next()) {
				s=s+"<tr><td>"+rs.getString("name")+"</td><td>"+rs.getString("mail")+"</td><td>"+rs.getString("phone")+"</td><td>"+rs.getString("hospital")+"</td></tr>";
			}
			out.println(s+"</tbody>\r\n" + 
					"  </table>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
