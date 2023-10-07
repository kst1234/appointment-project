

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String m=request.getParameter("mail");
		String p=request.getParameter("pass");
		String cp=request.getParameter("cpass");
		String f=request.getParameter("fn");
		String l=request.getParameter("ln");
		String k=request.getParameter("otp");
		String d=request.getParameter("date");
		String tt=request.getParameter("time");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		session.setAttribute("mail", m);
		session.setAttribute("otp", k);
		if(p.equals(cp)) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","manager");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register");
			boolean b=true;
			while(rs.next()) {
				if(rs.getString("mail").equals(m) && rs.getString("pw").equals(cp)) {
					b=false;
					break;
				}
			}
			if(b) {
				int i=0;
				ResultSet rs1=st.executeQuery("select * from doctor");
				String s="",ss="";
				while(rs1.next()) {
					if(rs1.getInt("patno")<3) {
						s=rs1.getString("mail");
						ss=rs1.getString("name");
						i=rs1.getInt("patno");
						break;
					}
				}
				PreparedStatement ps1=con.prepareStatement("update doctor set patno=? where mail=?");
				ps1.setInt(1, i+1);
				ps1.setString(2, s);
				ps1.execute();
				PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?)");
				
			ps.setString(1, m);
			ps.setString(2, p);
			ps.setString(3, f);
			ps.setString(4, l);
			ps.setString(5, s);
			ps.setString(6, ss);
			ps.execute();
			PreparedStatement ps2=con.prepareStatement("delete from deletepat where mail=?");
			ps2.setString(1,m);
			ps2.execute();
			PreparedStatement ps3=con.prepareStatement("insert into date values(?,?,?)");
			ps3.setString(1, m);
			ps3.setString(2, d);
			ps3.setString(3, tt);
			ps3.execute();
			System.out.println(d);
			response.sendRedirect("otp.html");
			}
			else {
				out.println("<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"<head>\r\n" + 
						"<meta charset=\"ISO-8859-1\">\r\n" + 
						"<title>Registration UnSuccessful</title>\r\n" + 
						"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\r\n" + 
						"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
						"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" + 
						"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\r\n" + 
						"  <script src=\"https://use.fontawesome.com/e4aacdd27c.js\"></script>\r\n" + 
						"</head>\r\n" + 
						"</head>\r\n" + 
						"<body>\r\n" + 
						"<nav class=\"navbar navbar-expand-sm navbar-dark bg-dark fixed-top\">\r\n" + 
						"        <a href=\"#\" class=\"navbar-brand\">Registration Unsuccessful</a>\r\n" + 
						"        <button class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#menu\">\r\n" + 
						"            <span class=\"navbar-toggler-icon\"></span>\r\n" + 
						"        </button>\r\n" + 
						"\r\n" + 
						"        <div class=\"collapse navbar-collapse\" id=\"menu\">\r\n" + 
						"            <span class=\"mr-auto\"></span>\r\n" + 
						"            <ul class=\"navbar-nav\">\r\n" + 
						"                <li class=\"nav-item\">\r\n" + 
						"                    <a href=\"index.html\" class=\"nav-link active\">\r\n" + 
						"                        <i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i> Login\r\n" + 
						"                    </a>\r\n" + 
						"                </li>\r\n" + 
						"                <li class=\"nav-item\">\r\n" + 
						"                    <a href=\"index.html\" class=\"nav-link\">\r\n" + 
						"                        <i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>\r\n" + 
						"                        Register\r\n" + 
						"                    </a>\r\n" + 
						"                </li>\r\n" + 
						"                \r\n" + 
						"            </ul>\r\n" + 
						"        </div>\r\n" + 
						"    </nav>\r\n" + 
						"    <br>\r\n" + 
						"    <br>\r\n" + 
						"    <br>\r\n" + 
						"    <div class=\"container bg-dark\">\r\n" + 
						"<h5 class=\"jumbotron text-important\">User already exists.... Try Again</h5><br>\r\n" + 
						"</div>\r\n" + 
						"<br>\r\n" + 
						"<br>\r\n" + 
						"<br>\r\n" + 
						"<div class=\"jumbotron bg-important\">\r\n" + 
						"<p>Go to</p>\r\n" + 
						"<a href=\"index.html\">Login Page</a>\r\n" + 
						"</div>\r\n" + 
						"</body>\r\n" + 
						"</html>");
			}
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
