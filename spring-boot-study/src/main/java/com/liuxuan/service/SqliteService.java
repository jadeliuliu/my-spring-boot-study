package com.liuxuan.service;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

/**
 * @author: liuxuan
 * @date: 2023-01-20 09:41
 **/
@Service
public class SqliteService {

    public static void main(String[] args) {
        String filePath = "/Users/liuxuan/Downloads/test.db";
        Connection conn = createConnection(filePath);
        // 创建表
        String query = "create table if not exists table_test (\n" +
                "id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "num INTEGER(11),\n" +
                "`desc` varchar(10) not null);";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
//            conn.commit();
//            conn.close();
        } catch (SQLException e){
            System.out.println("建立表存在异常！" + e);
        }

        // 插入数据
        String sql = "insert into table_test (num, desc) " +
                "values(1, 'one');";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e){
            System.out.println("插入数据存在异常！" + e);
        }

        // 查询数据
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM table_test;" );
            while (rs.next() ) {
                int id = rs.getInt("id");
                int num = rs.getInt("num");
                String desc = rs.getString("desc");
                System.out.println(id + "," + num + "," + desc);
            }
            rs.close();
        } catch (SQLException e){
            System.out.println("查询数据存在异常！" + e);
        }

        // 分页查询 用commons-dbutils包下的QueryRunner
        String selectSql = "select * from table_test";
        try {
            List<SqliteDO> list = selectList(selectSql, conn, SqliteDO.class, 1, 10);
            System.out.println(list);
        } catch (SQLException e) {
            System.out.println("查询数据list存在异常！" + e);
        }
    }


    /**
     * 获取数据库连接
     **/
    public static Connection createConnection(String filePath) {
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(String.format("jdbc:sqlite:%s", filePath));
        }catch(ClassNotFoundException e){
            System.out.println("不存在sqlite驱动包！");
        }catch (SQLException e){
            System.out.println("与sqlite数据库连接失败！");
        }
        return conn;
    }

    public static <T> List<T> selectList(String sql, Connection connection, Class<T>objType, int currentPage, int pageSize) throws SQLException {
        sql = sql + " limit ?,?";
        QueryRunner queryRunner = new QueryRunner();
        List<T> dataList = queryRunner.query(connection, sql, new BeanListHandler<>(objType), pageSize * (currentPage - 1), pageSize);
        return dataList;
    }

    @ToString
    @Getter
    @Setter
    public static class SqliteDO {
        private Integer id;
        private Integer num;
        private String desc;
    }

}