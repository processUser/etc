package org.iptime.mypj;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sel", value = "/sel")
public class SelStudtGroupInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String val = request.getParameter("val");
        Gson gson = new Gson();
        String json = null;
        if("학생".equals(val)){
            json = gson.toJson(StudyGroupDAO.selStudentGroupList(val));
        } else if("그룹".equals(val)) {
            json = gson.toJson(StudyGroupDAO.selStudentGroupList(val));

        } else if("학생그룹".equals(val)){
            json = gson.toJson(StudyGroupDAO.selStudentGroupList(val));
        }
        PrintWriter out = response.getWriter();
        out.println(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
