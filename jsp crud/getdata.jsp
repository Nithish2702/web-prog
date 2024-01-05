<%@ page import="java.sql.*"%>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
out.println("connection success");

String sql = "select * from register";

Statement stmt = conn.createStatement();

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
%>
