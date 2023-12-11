package com.example.demo13;

import manageStudent.service.ManageStudent;
import manageStudent.student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/student")
public class HelloServlet extends HttpServlet {
    ManageStudent manageStudent = new ManageStudent();
    Student student;
    List<Student> list = manageStudent.showAll();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
        }
        String name = req.getParameter("key");
        if (name != null) {
            List<Student> productListSearch = new ArrayList<>();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("web/list.jsp");
            for (int i = 0; i < manageStudent.getListStudentList().size(); i++) {
                if (manageStudent.getListStudentList().get(i).getName().contains(name)) {
                    productListSearch.add(manageStudent.getListStudentList().get(i));
                }
            }
            req.setAttribute("danhsach", productListSearch);
            student = manageStudent.findByName(name);
            requestDispatcher.forward(req, resp);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "sortUp":
                sortUp(request, response);
                break;
            case "sortDown":
                sortDown(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void sortDown(HttpServletRequest request, HttpServletResponse response) throws IOException {
        manageStudent.sortDown();
        response.sendRedirect("/student");
    }

    private void sortUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        manageStudent.sortUp();
        response.sendRedirect("/student");
    }


    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        manageStudent.remove(id);
        resp.sendRedirect("/student");
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        int averageScore = Integer.parseInt(req.getParameter("averageScore"));
        manageStudent.edit(id, new Student(id, name, age, gender, address, averageScore));
        resp.sendRedirect("/student");
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("web/create.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        student = manageStudent.findById(id);
        request.setAttribute("edit", student);
        requestDispatcher.forward(request, response);
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id;
        id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        int averageScore = Integer.parseInt(req.getParameter("averageScore"));
        manageStudent.addStudent(new Student(id, name, age, gender, address, averageScore));
        resp.sendRedirect("/student");
    }

    public void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("web/list.jsp");
        String name = req.getParameter("key");
        if (name != null) {
            req.setAttribute("danhsach", manageStudent.findByName(name));
        } else {
            req.setAttribute("danhsach", list);
        }
        requestDispatcher.forward(req, resp);
    }

    public void createForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("web/create.jsp");
        requestDispatcher.forward(req, resp);
    }
}