

import java.io.IOException;
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

/**
 * Servlet implementation class patdel
 */
@WebServlet("/patdel")
public class patdel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patdel() {
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
		String mail=request.getParameter("usern");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","manager");
			Statement st1=con.createStatement();
			int a=0;
			ResultSet rs=st1.executeQuery("select * from register");
			String s="",ss="";
			while(rs.next()) {
				if(rs.getString("mail").equals(mail)) {
					s=rs.getString("doctor");
					ss=rs.getString("docname");
					break;
				}
			}
			ResultSet rs1=st1.executeQuery("select * from doctor");
			while(rs1.next()) {
				if(rs1.getString("mail").equals(s)) {
					a=rs1.getInt("patno");
					break;
				}
			}
			Statement st=con.createStatement();
			st.executeUpdate("delete from register where mail='"+mail+"'");
			PreparedStatement ps=con.prepareStatement("insert into deletepat values(?,?,?)");
			ps.setString(1, mail);
			ps.setString(2, s);
			ps.setString(3, ss);
			ps.execute();
			PreparedStatement ps1=con.prepareStatement("update doctor set patno=? where mail=?");
			ps1.setInt(1, a-1);
			ps1.setString(2,s);
			ps1.execute();
			PreparedStatement ps2=con.prepareStatement("delete from date where mail=?");
			ps2.setString(1, mail);
			ps2.execute();
			response.sendRedirect("adminhome.html");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
