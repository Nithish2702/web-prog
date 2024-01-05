import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
// Extend HttpServlet class
public class GetData extends HttpServlet
{
public void service(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException 
{
try
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();
Class.forName("com.mysql.jdbc.Driver");
//Open a connection
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
out.println("connection success");
//build a query
String sql = "select * from register";
//create a statemment
Statement stmt = conn.createStatement();
//Execute a query
ResultSet rs=stmt.executeQuery(sql);
out.println("Query executed...");
while(rs.next())
{
  out.println("ht no="+rs.getString(1)+" name="+rs.getString(2)+" gender="+rs.getString(3)+" branch="+rs.getString(4));
}
}
catch(Exception e)
{
}
}
}




 
