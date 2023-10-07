

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class healthh
 */
@WebServlet("/healthh")
public class healthh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public healthh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				"<script>\r\n" +  
				"    var k=Math.floor(Math.random()*11+70);\r\n" + 
				"    var kk=Math.floor(Math.random()*2+36);\r\n" + 
				"    var kkk=Math.floor(Math.random()*21+80);\r\n" + 
				"    document.getElementById(\"hh\").innerHTML=k+\"bpm\";\r\n" + 
				"    document.getElementById(\"hhh\").innerHTML=kk+\"\\u00B0\"+\"C\";\r\n" + 
				"    document.getElementById(\"h\").innerHTML=kkk+\"mg\";\r\n" + 
				"</script>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
