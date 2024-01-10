package s121022021036.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import s121022021036.model.Words;
import s121022021036.utils.DataSourceUtils;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public class WordsDao {
    public int addWord(Words w) throws SQLException { //增加单词
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into words(word, mark, intro, derivative) " + "values(?, ?, ?, ?)";
        int id = runner.insert(sql, new ScalarHandler<BigInteger>(), w.getWord(), w.getMark(), w.getIntro(), w.getDerivative()).intValue();
        w.setId(id);
        return id;
    }
    public static Words selectById(int id) throws SQLException { //查找单词
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from words where id = ?";
        return runner.query(sql, new BeanHandler<>(Words.class), id);
    }

    public static int selectWordsCount() throws SQLException { //统计单词
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from words";
        return runner.query(sql, new ScalarHandler<Long>()).intValue();
    }

    public static List<Words> selectWordsList(int pageNo, int pageSize) throws SQLException { //查看单词列表
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from words limit ?, ?";
        return runner.query(sql, new BeanListHandler<>(Words.class), (pageNo - 1) * pageSize, pageSize);
    }

    public int updateWords(Words w) throws SQLException { //更新单词
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update words set word = ?, mark = ?, intro = ?, derivative = ? where id = ?";
        return runner.update(sql, w.getWord(), w.getMark(), w.getIntro(), w.getDerivative(), w.getId());
    }

    public int deleteWord(int id) throws SQLException { //删除单词
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from words where id = ?";
        return runner.execute(sql, id);
    }
}