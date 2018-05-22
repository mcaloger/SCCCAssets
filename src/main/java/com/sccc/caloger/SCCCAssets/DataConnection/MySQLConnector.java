package com.sccc.caloger.SCCCAssets.DataConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class MySQLConnector {

    private String url = "jdbc:mysql://localhost:32768/SCCCAssets";
    private String user = "root";
    private String password = "password1";

    public Connection getSQLConnection () throws SQLException {
        // Exposing database secrets only for testing, will pull out into env variables later.

        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
