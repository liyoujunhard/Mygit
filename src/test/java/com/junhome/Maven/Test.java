package com.junhome.Maven;

import com.junhome02.Maven.StudentTest;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getinfos();
    }
     public static void getinfos() throws SQLException, ClassNotFoundException {

         StudentTest s = new StudentTest();

         List<App> list = s.getinfo();

         for(App value:list){
             System.out.println(value.getName());
         }
     }
}
