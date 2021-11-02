package org.iptime.mypj;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ins")
public class InsStudentGroupInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String json= req.getParameter("jsonData");
        Gson gson = new Gson();
        StudentGroupInfoVO vo= gson.fromJson(json, StudentGroupInfoVO.class);
        System.out.println(json);
        StudyGroupDAO.insStudyGroup(vo);
//        StudentGroupInfoVO vo = new StudentGroupInfoVO();


//        String json = gson.toJson(StudyGroupDAO.selStudentGroupList(vo));
//        res.setContentType("text/plain;charset=UTF-8");
//        res.setCharacterEncoding("UTF-8");
//
//        PrintWriter out = res.getWriter();
//        out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
