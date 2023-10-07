

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class health
 */
@WebServlet("/health")
public class health extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public health() {
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
			ResultSet rs=st.executeQuery("select * from register");
			String s="";
			HttpSession session=request.getSession();
			if(session.getAttribute("user")!=null) {
			String l=(String) session.getAttribute("user");
			while(rs.next()) {
				if(rs.getString("mail").equals(l)) {
					s=rs.getString("doctor");
					break;
				}
			}
			//s=s.substring(0, s.length()-1);
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Home</title>\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\r\n" + 
					"  <link rel=\"stylesheet\" type=\"text/css\"\r\n" + 
					"href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.2/semantic.min.css\">\r\n" + 
					"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
					"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" + 
					"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\r\n" + 
					"  <script src=\"https://use.fontawesome.com/e4aacdd27c.js\"></script>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"    <nav class=\"navbar navbar-expand-sm navbar-dark bg-dark fixed-top\">\r\n" + 
					"        <a href=\"#\" class=\"navbar-brand\">Monitoring System</a>\r\n" + 
					"        <button class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#menu\">\r\n" + 
					"            <span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"        </button>\r\n" + 
					"\r\n" + 
					"        <div class=\"collapse navbar-collapse\" id=\"menu\">\r\n" + 
					"            <span class=\"mr-auto\"></span>\r\n" + 
					"            <ul class=\"navbar-nav\">\r\n" + 
					"            <li class=\"nav-item\">\r\n" + 
					"                    <a href=\"health\" class=\"nav-link active\">\r\n" + 
					"                        <i class=\"fa fa-medkit\" aria-hidden=\"true\"></i>Your Health\r\n" + 
					"                    </a>\r\n" + 
					"                </li>\r\n" + 
					"                <li class=\"nav-item\">\r\n" + 
					"                    <a href=\"https://kst1234.github.io/covidtracker/\" class=\"nav-link active\">\r\n" + 
					"                        <i class=\"fa fa-line-chart\" aria-hidden=\"true\"></i>Covid-19 Tracker\r\n" + 
					"                    </a>\r\n" + 
					"                </li>\r\n" + 
					"                <li class=\"nav-item\">\r\n" + 
					"                    <a href=\"profile\" class=\"nav-link active\">\r\n" + 
					"                        <i class=\"fa fa-user\" aria-hidden=\"true\"></i>\r\n" + 
					"                        Profile\r\n" + 
					"                    </a>\r\n" + 
					"                </li>\r\n" + 
					"            </ul>\r\n" + 
					"        </div>\r\n" + 
					"    </nav>\r\n" + 
					"<div class=\"jumbotron\">\r\n" + 
					"  <h1>Welcome to Covid-19 Monitoring System</h1>\r\n" + 
					"  <p>In the service of Covid-19 affected patients</p>\r\n" + 
					"</div>\r\n" + 
					"<div class=\"row\">\r\n" + 
					"    <div class=\"card col p-3 m-3\">\r\n" + 
					"        <div class=\"ui statistic\">\r\n" + 
					"            <div class=\"label\">\r\n" + 
					"                Heart Beat\r\n" + 
					"              </div>\r\n" + 
					"            <div class=\"value\">\r\n" + 
					"              <p id=\"hh\"></p>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"card col p-3 m-3\">\r\n" + 
					"        <div class=\"ui statistic\">\r\n" + 
					"            <div class=\"label\">\r\n" + 
					"                Body Temperature\r\n" + 
					"              </div>\r\n" + 
					"            <div class=\"value\">\r\n" + 
					"              <p id=\"hhh\"></p>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"card col p-3 m-3\">\r\n" + 
					"        <div class=\"ui statistic\">\r\n" + 
					"            <div class=\"label\">\r\n" + 
					"                Blood Pressure\r\n" + 
					"              </div>\r\n" + 
					"            <div class=\"value\">\r\n" + 
					"              <p id=\"h\"></p>\r\n" + 
					"            </div>\r\n" + 
					"          </div>\r\n" + 
					"    </div>\r\n" + 
					"</div>\r\n" + 
					"<script src=\"https://smtpjs.com/v3/smtp.js\"></script>\r\n" + 
					"<script>\r\n" + 
					"    var k=Math.floor(Math.random()*41+70);\r\n" + 
					"    var kk=Math.floor(Math.random()*3+36);\r\n" + 
					"    var kkk=Math.floor(Math.random()*61+70);\r\n" + 
					"    document.getElementById(\"hh\").innerHTML=k+\"bpm\";\r\n" + 
					"    document.getElementById(\"hhh\").innerHTML=kk+\"\\u00B0\"+\"C\";\r\n" + 
					"    document.getElementById(\"h\").innerHTML=kkk+\"mg\";\r\n" + 
					"    if((k>80 && kk>=38 && kkk>120) || (kk<60 && kk<=35 && kkk<75)){\r\n" + 
					"        Email.send({\r\n" + 
					"	Host: \"smtp.gmail.com\",\r\n" + 
					"	Username : \"projectvir2@gmail.com\",\r\n" + 
					"	Password : \"Projectvir1@\",\r\n" + 
					"	To : '"+s+"',\r\n" + 
					"	From : 'projectvir2@gmail.com',\r\n" + 
					"	Subject : \"Urgent\",\r\n" + 
					"	Body : \"Heart beat,Body Temperature,BP not in-line for "+l+"\",\r\n" +
					"	}).then(\r\n" + 
					"		message => console.log(\"mail sent successfully\")\r\n" + 
					"	);\r\n" + 
					"    }\r\n" + 
					"    else if(k>80 || k<60){\r\n" + 
					"        Email.send({\r\n" + 
					"	Host: \"smtp.gmail.com\",\r\n" + 
					"	Username : \"projectvir2@gmail.com\",\r\n" + 
					"	Password : \"Projectvir1@\",\r\n" + 
					"	To : '"+s+"',\r\n" + 
					"	From : 'projectvir2@gmail.com',\r\n" + 
					"	Subject : \"Urgent\",\r\n" + 
					"	Body : \"Heart beat not in-line for "+l+",\"\r\n" + 
					"	}).then(\r\n" + 
					"		message => console.log(\"mail1 sent successfully\")\r\n" + 
					"	);\r\n" + 
					"    }\r\n" + 
					"    else if(kk>=38 || kk<=35){\r\n" + 
					"        Email.send({\r\n" + 
					"	Host: \"smtp.gmail.com\",\r\n" + 
					"	Username : \"projectvir2@gmail.com\",\r\n" + 
					"	Password : \"Projectvir1@\",\r\n" + 
					"	To : '"+s+"',\r\n" + 
					"	From : 'projectvir2@gmail.com',\r\n" + 
					"	Subject : \"Urgent\",\r\n" + 
					"	Body : \"Body Temperature not in-line for "+l+"\",\r\n" +
					"	}).then(\r\n" + 
					"		message => console.log(\"mail2 sent successfully\")\r\n" + 
					"	);\r\n" + 
					"    }\r\n" + 
					"    else if(kkk>120 || kkk<75){\r\n" + 
					"        Email.send({\r\n" + 
					"	Host: \"smtp.gmail.com\",\r\n" + 
					"	Username : \"projectvir2@gmail.com\",\r\n" + 
					"	Password : \"Projectvir1@\",\r\n" + 
					"	To : '"+s+"',\r\n" + 
					"	From : 'projectvir2@gmail.com',\r\n" + 
					"	Subject : \"Urgent\",\r\n" + 
					"	Body : \"BP not in-line for "+l+"\",\r\n" +
					"	}).then(\r\n" + 
					"		message => console.log(\"mail3 sent successfully\")\r\n" + 
					"	);\r\n" + 
					"    }\r\n" + 
					"</script>\r\n" + 
					"</body>\r\n" + 
					"</html>");
			}
			else {
				response.sendRedirect("index.html");
			}
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
