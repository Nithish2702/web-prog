<%@ page import="java.sql.*"%>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
out.println("Connection success");
String htno=request.getParameter("htno");
String name=request.getParameter("name");
String gender=request.getParameter("gender");
String branch=request.getParameter("branch");

String sql="insert into register values('"+htno+"','"+name+"','"+gender+"','"+branch+"')";

Statement stmt=conn.createStatement();

stmt.executeUpdate(sql);
out.println("Query executed....");
out.println("<html><h1>Record inserted sussessfuly</h1></html>"+htno+name);
}
catch(Exception e)
{
}
%>
