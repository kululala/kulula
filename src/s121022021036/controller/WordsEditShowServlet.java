package s121022021036.controller;

import s121022021036.model.Words;
import s121022021036.service.WordsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WordsEditShowServlet", urlPatterns = "/s121022021036/words_editShow")
public class WordsEditShowServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        WordsService wordsService = new WordsService();
        int id = Integer.parseInt(request.getParameter("id"));
//提取用户信息
        Words words = wordsService.selectById(id);
//为request对象添加words属性
        request.setAttribute("w", words);
//请求转发到用户信息修改JSP
        request.getRequestDispatcher("/w121022021036/words_edit.jsp").forward(request, response);
    }
}