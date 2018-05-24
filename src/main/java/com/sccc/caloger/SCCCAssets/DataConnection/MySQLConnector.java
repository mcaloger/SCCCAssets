package com.sccc.caloger.SCCCAssets.DataConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnector {

    public Connection getSQLConnection () throws SQLException {
        String url = DataConfiguration.url;
        String user = DataConfiguration.user;
        String password = DataConfiguration.password;
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
