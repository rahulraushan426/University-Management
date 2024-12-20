package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.userDAO;
import com.user.model.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new userDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "getById":
                    getUserById(request, response);
                    break;
                case "getByRollno":
                    getUserByRollno(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    response.getWriter().write("Invalid action");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "create":
                    createUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                default:
                    response.getWriter().write("Invalid action");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int rollno = Integer.parseInt(request.getParameter("rollno"));

        User user = new User(0, name, email, password, rollno);
        boolean success = userDAO.createUser(user);

        if (success) {
            response.getWriter().write("User created successfully");
        } else {
            response.getWriter().write("Failed to create user");
        }
    }

    private void getUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(id);

        if (user != null) {
            response.getWriter().write(user.toString());
        } else {
            response.getWriter().write("User not found");
        }
    }

    private void getUserByRollno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        User user = userDAO.getUserByRollno(rollno);

        if (user != null) {
            response.getWriter().write(user.toString());
        } else {
            response.getWriter().write("User not found");
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int rollno = Integer.parseInt(request.getParameter("rollno"));

        User user = new User(id, name, email, password, rollno);
        boolean success = userDAO.updateUser(user);

        if (success) {
            response.getWriter().write("User updated successfully");
        } else {
            response.getWriter().write("Failed to update user");
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean success = userDAO.deleteUser(id);

        if (success) {
            response.getWriter().write("User deleted successfully");
        } else {
            response.getWriter().write("Failed to delete user");
        }
    }

    @Override
    public void destroy() {
        userDAO.close();
    }
}
