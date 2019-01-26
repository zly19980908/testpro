package com.wxggt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxggt.dao.ConsumeDAO;
import com.wxggt.dao.CourseDAO;
import com.wxggt.dao.StucouDAO;
import com.wxggt.dao.TeacherIncomeDAO;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String uid = "2016010901";
        String cid = "126263347";
        String tid = "2016010901";
        int price = 50;
        String type = "购买";
        StucouDAO stucoudao = new StucouDAO();
        ConsumeDAO consumedao = new ConsumeDAO();
        CourseDAO coursedao = new CourseDAO();
        TeacherIncomeDAO teacherincomedao = new TeacherIncomeDAO();
        //学生购买课程则选课一门
        boolean result = stucoudao.insertStucou(uid, cid);
        //学生购买课程添加一条消费记录
        boolean result1 = consumedao.insertConsume(uid, price, type, 126263347);
        //学生购买课程课程购买次数加一
        boolean result2 = coursedao.addStudyquantity(cid);
        //学生购买课程老师加入一笔收益;
        boolean result3 = teacherincomedao.insertIncome(cid, tid, price, type);
        System.out.println(result+" "+result1+" "+result2+" "+result3);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
