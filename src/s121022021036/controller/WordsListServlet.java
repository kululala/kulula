package s121022021036.controller;

import s121022021036.model.Words;
import s121022021036.model.Page;
import s121022021036.service.WordsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WordsListServlet", urlPatterns = "/s121022021036/words_list")
public class WordsListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
//获取分页参数
        int pageNo, pageSize;
        try {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        } catch (NumberFormatException e) {
            pageNo = 1;
        }
        try {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } catch (NumberFormatException e) {
            pageSize = 7;
        }
        WordsService wordsService = new WordsService();
        Page<Words> page = wordsService.getWordsPage(pageNo, pageSize);
        request.setAttribute("p", page);
//转发请求到用户信息列表JSP页面
        request.getRequestDispatcher("/w121022021036/words_list.jsp").forward(request, response);
    }
}