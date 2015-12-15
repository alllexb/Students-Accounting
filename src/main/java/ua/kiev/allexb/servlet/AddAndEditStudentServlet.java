package ua.kiev.allexb.servlet;

import ua.kiev.allexb.bean.StudentBean;
import ua.kiev.allexb.entity.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddAndEditStudentServlet extends HttpServlet {

    @EJB
    private StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/http");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("edit") != null) {
            long id = Long.valueOf(req.getParameter("edit"));
            Student student = studentBean.get(id);

            req.setAttribute("student", student);
        }
        req.getRequestDispatcher("/add.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/http");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        int age = Integer.valueOf(req.getParameter("age"));

        System.out.println(name + " : " + lastName + " : " + age);

        if(req.getParameter("id") != null && !req.getParameter("id").equals("")) {
            long id = Long.valueOf(req.getParameter("id"));
            Student student = studentBean.get(id);
            student.setName(name);
            student.setLastName(lastName);
            student.setAge(age);

            studentBean.update(student);
        } else {
            studentBean.add(new Student(name, lastName, age));
        }

        resp.sendRedirect("list");
    }
}
