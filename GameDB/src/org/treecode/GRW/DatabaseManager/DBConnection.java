package org.treecode.GRW.DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
public class DBConnection 
{

    private static DBConnection _dbConnection = null;
    Connection _connection = null;

    private DBConnection() {
        try {
            _connection = DriverManager.getConnection("jdbc:sqlite:/home/asar/Dokumenty/projekty/GameDataBase/game.db");
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

    public void exequteUpdate(String sql) throws SQLException
    {
        _connection.createStatement().execute(sql);
    }

    public ArrayList<HashMap<String, String>> executeQuery(String query) throws SQLException
    {
        Statement statement = _connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<String> colNames = getColumnNames(rs);
        
        ArrayList<HashMap<String, String>> out = new ArrayList<HashMap<String, String>>();
        while(rs.next())
        {
            final HashMap<String, String> row = new HashMap<String, String>();
            for(String col : colNames)
            {
                row.put(col, rs.getString(col));
            }
            out.add(row);
        }
        rs.close();
        return out;
    }
    
    public List<String> getColumnNames(ResultSet rs) throws SQLException
    {
        final ResultSetMetaData metaData = rs.getMetaData();
        final int columnCount = metaData.getColumnCount();
        ArrayList<String> out = new ArrayList<String>();
        for(int i = 1 ; i <= columnCount; ++i)
        {
            out.add(metaData.getColumnName(i));
        }
        return out;
    }
}
