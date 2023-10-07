

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
 * Servlet implementation class otp1
 */
@WebServlet("/otp1")
public class otp1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public otp1() {
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
		String s=request.getParameter("otp");
		HttpSession session=request.getSession();
		String k=(String) session.getAttribute("otp");
		PrintWriter out=response.getWriter();
		if(s.equals(k)) {
			response.sendRedirect("susuccess.html");
		}
		else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","manager");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from register");
				String m=(String) session.getAttribute("mail");
				String ss="";
				while(rs.next()) {
					if(rs.getString("mail").equals(m)){
						ss=rs.getString("doctor");
						break;
					}
				}
				int k1=1;
				Statement st1=con.createStatement();
				ResultSet rs1=st1.executeQuery("select * from doctor");
				while(rs1.next()){
					if(rs1.getString("mail").equals(ss)) {
						k1=rs1.getInt("patno");
						break;
					}
				}
				PreparedStatement ps1=con.prepareStatement("update doctor set patno=? where mail=?");
				ps1.setInt(1, k1-1);
				ps1.setString(2, ss);
				ps1.execute();
				PreparedStatement ps=con.prepareStatement("delete from register where mail=?");
				ps.setString(1, m);
				ps.execute();
				PreparedStatement ps2=con.prepareStatement("delete from date where mail=?");
				ps2.setString(1, m);
				ps2.execute();
				response.sendRedirect("otpwrong.html");
				session.invalidate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
