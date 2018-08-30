package ua.training.model.dao.implement;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null){
                    BasicDataSource ds = new BasicDataSource();
                    ds.setDriverClassName("com.mysql.jdbc.Driver");
                    ds.setUrl("jdbc:mysql://localhost:3306/food_db?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
                    //ds.setUrl("jdbc:mysql://localhost:3306/food_db?autoReconnect=true&useSSL=false");
                    ds.setUsername("root");
                    ds.setPassword("");
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }
}
