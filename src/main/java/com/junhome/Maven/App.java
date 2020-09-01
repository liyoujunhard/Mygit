package com.junhome.Maven;


import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;
import java.net.URL;

public class App
{
    private int id;
    private String name;

    public static void main( String[] args ) {

        /*
        *   jdbc 连接数据库操作
        *
        *   方式1:
        *
        *   1. 第一步 注册驱动
        *    Driver driver = new com.mysql.jdbc.Driver();
        *
        *    jdbc:mysql 协议
        *    localhost:IP地址
        *    test: 数据库名
        *    String Url = "jdbc:mysql://localhost:3306/test";
        *
        *    2.将用户名和密码封装在Properties里面
        *    Properties info = new Properties();
        *    info.setProperty("user","root");
        *    info.setProperty("password","");
        *
        *    3. 创建mysql 连接
        *    Connection conn = driver.connect(url,info);
        *   ======================
        *   方法2:
        *
        *   1.获取driver 实现类对象 使用反射
        *   Class class = Class.forName("com.mysql.jdbc.Driver");
        *   Driver driver = class.newInstance();
        *
        *   //下面一样与上面一样
        *   ======================
        *   方法3 使用DriverManger替换Driver
        *
        *    1. 获取Driver实现类对象
        *
        *    Class class = Class.forName("com.mysql.jdbc.Driver");
        *    Driver driver = class.newInstance();
        *
        *    2. 提供三个信息 url user password
        *    String url = "jdbc:mysql://localhost:3306/test";
        *    String user = "root";
        *    String pwd = "123456";
        *
        *    3.注册驱动
        *    DriverManger.registerDriver(driver);
        *
        *    4.获取连接
        *    Connection conn = DriverManager.getConnection(URL,USER,PWD);
        *
        *    ======================
        *    方法4:(方法3简写)
        *
        *     Class.forName("com.mysql.jdbc.Driver");
        *
        *     2. 提供三个信息 url user password
         *    String url = "jdbc:mysql://localhost:3306/test";
         *    String user = "root";
         *    String pwd = "123456";
         *
        *     3.获取连接
         *    Connection conn = DriverManager.getConnection(URL,USER,PWD);
        *
        *     方法5: 最终方法  将基本信息放在配置文件
        *
        *
        * */

          //读取配置文件信息
        ClassLoader clazz = App.class.getClassLoader();

        URL res = clazz.getResource("jdbc.properties");

        //url统一资源定位符
        String path = res.getPath();

        Properties ps = new Properties();


        try {
           ps.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String user = ps.getProperty("user");

        System.out.println(user);


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



