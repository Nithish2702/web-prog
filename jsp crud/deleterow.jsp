<%@ page import="java.sql.*"%>
<%
String htno = request.getParameter("htno");
String url = "jdbc:mysql://localhost:3306/test";
String username = "root";
String password = "";
Connection con;
PreparedStatement pst;

try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url, username, password);

pst= con.prepareStatement("delete from register where htno=?;");
pst.setString(1, htno);

int i = pst.executeUpdate();
if(i!=0)
out.println("Deleting row...");
else if (i==0)
{
out.println("<br>Row has been deleted successfully.");
}
}
catch(SQLException sx)
{
out.println(sx);
}
catch(ClassNotFoundException cx)
{
out.println(cx);
} 
%>
