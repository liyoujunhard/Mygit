package com.junhome02.Maven;

import com.junhome.Maven.App;
import com.junhome01.Maven.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//实现类
public class StudentTest implements Student {

    static final String URL =  "jdbc:mysql://localhost:3306/java";
    static final String USER =  "root";
    static final String PWD =  "123456";
    Connection conn = null;  //连接对象
    Statement statement = null; //sql执行对象

    @Override
    public List<App> getinfo() throws SQLException, ClassNotFoundException {

        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接数据库对象  DriverManager.getConnection(URL,USER,PWD);
        conn = DriverManager.getConnection(URL,USER,PWD);

        //获取执行sql的对象
        statement = conn.createStatement();

        //结果集
        ResultSet rs = statement.executeQuery("select * from student");

        System.out.println("合并分支");
        System.out.println("主分支提交");
        List<App> list = new ArrayList<>();

        try {
            while(rs.next()){

                int id = rs.getInt("id");
                String name = rs.getString("name");

                App app = new App();

                //赋值给对象
                app.setId(id);
                app.setName(name);

                //将对象放进集合
                list.add(app);
            }

        }catch(Exception e){
           e.printStackTrace();
        }finally {
            //关闭资源
            conn.close();
            rs.close();
            statement.close();
        }

        return list;
    }
}
