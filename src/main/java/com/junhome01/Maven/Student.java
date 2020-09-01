package com.junhome01.Maven;

import com.junhome.Maven.App;

import java.sql.SQLException;
import java.util.List;

public interface Student {

    public List<App> getinfo() throws SQLException, ClassNotFoundException;
}


