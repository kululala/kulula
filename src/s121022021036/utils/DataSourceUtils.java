package s121022021036.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
    private static DataSource ds;

    static { //初始化C3P0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try { //设置连接数据库需要的配置信息
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/worddb?serverTimezone=GMT%2B8&useSSL=false&useUnicode=true&characterEncoding=utf-8");
            cpds.setUser("root");
            cpds.setPassword("123456");
            //设置连接池的参数
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(15);
            ds = cpds;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ds.getConnection(); //获取数据库连接对象
            System.out.println(conn);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close(); //关闭数据库连接
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}