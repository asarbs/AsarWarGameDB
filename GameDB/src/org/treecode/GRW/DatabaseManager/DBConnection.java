package org.treecode.GRW.DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author skorupa
 */
public class DBConnection {

    private static DBConnection _dbConnection = null;
    Connection _connection = null;

    private DBConnection() {
        try {
            _connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBConnection getInstance() {
        if (_dbConnection == null) {
            _dbConnection = new DBConnection();
        }
        return _dbConnection;
    }

    public void clearDB() 
    {
        List<String> tables = new ArrayList<String>();
        try 
        {
            PreparedStatement statement = _connection.prepareStatement("select name from sqlite_master where type is 'table'");
            statement.execute();
            ResultSet results = statement.getResultSet();
            List<String> tableNames = new ArrayList<>();
            while(results.next())
            {
                String s = results.getString("name");
                tableNames.add(s);
            }
            results.close();
            for(String tableName : tableNames)
            {
                this.exequte("DROP TABLE '"+ tableName + "';");
                Logger.getLogger(DBConnection.class.getName()).log(Level.INFO, tableName + " droped");
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exequte(String result) {
        try 
        {
            PreparedStatement statement = _connection.prepareStatement(result);
            statement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<String> getColumnsNames(ResultSet results) throws SQLException
    {
        List<String> columnsNames = new ArrayList<>();
        for(int i = 1 ; i <= results.getMetaData().getColumnCount(); i++)
        {
            columnsNames.add(results.getMetaData().getColumnName(i));
        }
        return columnsNames;
    }
    
    public List<Map<String, String >> getResults(String result) throws SQLException
    {
        PreparedStatement statement = _connection.prepareStatement(result);
        statement.execute();
        ResultSet results = statement.getResultSet();
        
        List<String> columnNames = getColumnsNames(results);
        
        List<Map<String, String >> res = new ArrayList<Map<String, String>>();          
        while(results.next())
            {
                Map<String, String> row = new HashMap<String, String>();
                for(String colName : columnNames)
                {
                    row.put(colName, results.getString(colName));
                }
                res.add(row);
            }
        return res;
    }
    
}
