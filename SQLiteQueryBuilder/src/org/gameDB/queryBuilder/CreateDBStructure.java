/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gameDB.queryBuilder;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.treecode.GRW.DatabaseManager.DBConnection;

/**
 *
 * @author asar
 */
public class CreateDBStructure
{
    public static void initDBStructure() throws SQLException
    {
        DBConnection.getInstance().exequteUpdate(_skilsTableCreateQuery);
        DBConnection.getInstance().exequteUpdate(_spellsTableCreateQuery);
        DBConnection.getInstance().exequteUpdate(_dbVersion);
        String version = getVersion();
        DBConnection.getInstance().exequteUpdate("INSERT INTO version (version) VALUES('"+version+"');");
    }

    private static String getVersion()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd.HHmmss");
        Date date = new Date();
        String version = dateFormat.format(date);
        return version;
    }
    
    private static final String _dbVersion = "CREATE TABLE IF NOT EXISTS version(id INTEGER PRIMARY KEY AUTOINCREMENT, version TEXT, note TEXT);";
    private static final String _skilsTableCreateQuery = "CREATE TABLE IF NOT EXISTS skills(id INTEGER PRIMARY KEY AUTOINCREMENT, cost INTEGER, name VARCHAR, requirements TEXT, effects TEXT, description TEXT);";
    private static final String _spellsTableCreateQuery = "CREATE TABLE IF NOT EXISTS spells(id INTEGER PRIMARY KEY AUTOINCREMENT, cost INTEGER, difficulty_level INTEGER, name VARCHAR, description TEXT);";
}
