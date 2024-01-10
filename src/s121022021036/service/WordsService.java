package s121022021036.service;

import s121022021036.dao.WordsDao;
import s121022021036.model.Words;
import s121022021036.model.Page;

import java.sql.SQLException;

public class WordsService {
    private WordsDao wordsDao = new WordsDao();

    public boolean addWord(Words w) {
        try {
            wordsDao.addWord(w);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateWords(Words w) {
        try {
            wordsDao.updateWords(w);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteWord(int id) {
        try {
            wordsDao.deleteWord(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Page<Words> getWordsPage(int pageNo, int pageSize) { //获取词汇列表
        int totalCount = 0;
        Page<Words> page = new Page<>();
        try {
            totalCount = WordsDao.selectWordsCount();
            page.setPage(pageNo, pageSize, totalCount);
            page.setList(WordsDao.selectWordsList(page.getPageNo(), page.getPageSize()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    public static Words selectById(int id) {
        Words w = null;
        try {
            w = WordsDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return w;
    }
}