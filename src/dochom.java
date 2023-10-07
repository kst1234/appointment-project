

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class dochom
 */
@WebServlet("/dochom")
public class dochom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dochom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static String dat(String d) {
    	Date d1=new Date();
    	long k=d1.getTime();
    	long kk=Long.parseLong(d);
    	long kkk=(k-kk)/(1000*3600*24);
    	return Long.toString(kkk);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("mail");
		PrintWriter out=response.getWriter();
		//out.println("hello");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","manager");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register");
			//PrintWriter out=response.getWriter();
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery("select * from date");
			out.println("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"  <title>Patients List</title>\r\n" + 
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
					"  <h2>Patients List</h2>\r\n" + 
					"  <p>List of patients who are alloted</p>\r\n" + 
					"  <table class=\"table table-striped\">\r\n" + 
					"    <thead>\r\n" + 
					"      <tr>\r\n" + 
					"        <th>Patient Name</th>\r\n" + 
					"        <th>Mail</th>\r\n" + 
					"        <th>His Health</th>\r\n" +  
					"		 <th>Number of days under observation</th>\r\n"+	
					"      </tr>\r\n" + 
					"    </thead>\r\n" + 
					"    <tbody>\r\n" + 
					"      <tr>\r\n");
			String s="";
			while(rs.next()) {
				if(rs.getString("doctor").equals(user)) {
					String q=rs.getString("mail");
					s=s+"<tr><td>"+rs.getString("fn")+" "+rs.getString("ln")+"</td><td>"+rs.getString("mail")+"</td><td>"+"<a href=\"healthh\">See Health</a>"+"</td>";
					while(rs1.next()) {
						if(rs1.getString("mail").equals(q)) {
							s=s+"<td>"+dat(rs1.getString("time"))+"</td></tr>";
							break;
						}
					}
				}
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
		
	}

}
