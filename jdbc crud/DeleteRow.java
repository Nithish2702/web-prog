import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteRow extends HttpServlet
{
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws IOException, ServletException
{
res.setContentType("text/html");
PrintWriter pw = res.getWriter();
  String htno = req.getParameter("htno");
String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
        String password = "";
Connection con;
PreparedStatement pst;
//ResultSet rs;
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url, username, password);

pst= con.prepareStatement("delete from register where hnto=?;");
pst.setString(1, htno);

int i = pst.executeUpdate();
if(i!=0)
pw.println("Deleting row...");
else if (i==0)
{
pw.println("<br>Row has been deleted successfully.");
}
}
catch(SQLException sx)
{
pw.println(sx);
}
catch(ClassNotFoundException cx)
{
pw.println(cx);
} 
}
}
