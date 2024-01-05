import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
// Extend HetpServlet class
public class Appform extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException
{
//get responses from HTML
try
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();
Class.forName("com.mysql.jdbc.Driver");
//Open a connection
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
out.println("connection success");
String htno=request. getParameter("htno");
String name=request.getParameter("name");
String gender=request.getParameter("gender");
String branch=request.getParameter("branch");
//build a query
String sql = "insert into register values( '"+htno+"','"+name+"', '"+gender+"','"+branch+"')";
//create a statemment
Statement stmt = conn.createStatement();
//Execute a query
stmt.executeUpdate(sql);
out.println("Query executed...");
out.println("<html><h1>Record inserted sucessfully</h1></html>" +htno+name);
}
catch(Exception e)
{
}
}
}

