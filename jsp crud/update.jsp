<%@ page import="java.sql.*"%>
<%
try {
	String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";
            
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        
        String htno=request.getParameter("htno");
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String branch=request.getParameter("branch");
        
        String query = "UPDATE register SET name=?,gender=? ,branch=? WHERE htno=?;";
        PreparedStatement pst = con.prepareStatement(query);
            
        pst.setString(1, name);
        pst.setString(2, gender);
        pst.setString(3, branch);
	pst.setString(4, htno);
            
        int rowsUpdated = pst.executeUpdate();

        if(rowsUpdated > 0) {
              out.println("<script>alert('Data updated successfully!'); window.location.href='index.html';</script>");
        }
        else {
             out.println("<script>alert('Failed to update data!'); window.location.href='index.html';</script>");
        }
            
        pst.close();
        con.close();
}
catch(Exception e)
{
}
%>
