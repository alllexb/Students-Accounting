package ua.kiev.allexb.servlet;

import ua.kiev.allexb.bean.StudentBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {

    @EJB
    private StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") != null && !req.getParameter("id").equals("")) {
            long id = Long.valueOf(req.getParameter("id"));
            studentBean.delete(id);
        }
        resp.sendRedirect("list");
    }

}
