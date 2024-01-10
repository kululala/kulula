package s121022021036.controller;

import s121022021036.model.Words;
import s121022021036.service.WordsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WordsEditServlet", urlPatterns = "/s121022021036/words_edit")
public class WordsEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        WordsService wordsService = new WordsService();
        Words words = new Words();
        try {
//接收参数
            int id = Integer.parseInt(request.getParameter("id"));
            String word = new String(request.getParameter("word").getBytes("ISO-8859-1"), "UTF-8");
            String mark = new String(request.getParameter("mark").getBytes("ISO-8859-1"), "UTF-8");
            String intro = new String(request.getParameter("intro").getBytes("ISO-8859-1"), "UTF-8");
            String derivative = new String(request.getParameter("derivative").getBytes("ISO-8859-1"), "UTF-8");
            words.setId(id);
            words.setWord(word);
            words.setMark(mark);
            words.setIntro(intro);
            words.setDerivative(derivative);
            wordsService.updateWords(words);
        } catch (Exception e) {
            e.printStackTrace();
        }
//重定向到用户信息分页列表
        response.sendRedirect(request.getContextPath() + "/s121022021036/words_list" + "?pageNo=" + request.getParameter("pageNo"));
    }
}