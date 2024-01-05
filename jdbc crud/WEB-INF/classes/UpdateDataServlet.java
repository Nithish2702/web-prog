import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateDataServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";
        // Get values from the request parameter
        String htno = request.getParameter("htno");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String branch = request.getParameter("branch");
        try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            // Create an SQL update statement
            String query = "UPDATE register SET name=?,gender=? ,branch=? WHERE hnto=?;";
            PreparedStatement pst = con.prepareStatement(query);
            // Set values to the statement
                       pst.setString(1, name);
            pst.setString(2, gender);
            pst.setString(3, branch);
pst.setString(4, htno);
            // Execute the SQL update statement
            int rowsUpdated = pst.executeUpdate();

            if(rowsUpdated > 0) {
                out.println("<script>alert('Data updated successfully!'); window.location.href='index.html';</script>");
            } else {
                out.println("<script>alert('Failed to update data!'); window.location.href='index.html';</script>");
            }
            // Close database resources
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e.getMessage());
        } finally {
            out.close();
        }
    }
}
