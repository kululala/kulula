package s121022021036.controller;

import s121022021036.service.WordsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WordsDeleteServlet", urlPatterns = "/s121022021036/words_del")
public class WordsDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WordsService wordsService = new WordsService();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            wordsService.deleteWord(id) ;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//重定向请求到用户信息分页列表
        response.sendRedirect(request.getContextPath() + "/s121022021036/words_list" + "?pageNo=" + request.getParameter("pageNo"));
    }
}