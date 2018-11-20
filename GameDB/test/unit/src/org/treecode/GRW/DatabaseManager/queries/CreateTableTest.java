/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.treecode.GRW.DatabaseManager.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.treecode.GRW.DatabaseManager.DBConnection;
import org.treecode.GRW.DatabaseManager.DBConnectionTest;
import org.treecode.GRW.DatabaseManager.Field;

/**
 *
 * @author skorupa
 */
public class CreateTableTest {
    
    public CreateTableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class CreateTable.
     */
    @Test
    public void testGetCreateTableQuery() {
        CreateTable instance = new CreateTable();
        String result = instance.get("sampleTestName", new Field("aaaa", "BBBBB", true), new Field("ccc", "DDD"));
        
        String expResult = "CREATE TABLE IF NOT EXISTS 'sampleTestName' (aaaa BBBBB PRIMARY KEY, ccc DDD);";
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTable() throws SQLException
    {
        DBConnection dBConnection = DBConnection.getInstance();
        dBConnection.clearDB();
        CreateTable createTableQuery = new CreateTable();
        createTableQuery.get("sampleTestName", new Field("aaaa", "BBBBB", true), new Field("ccc", "DDD"));
        List<Map<String, String>> results = dBConnection.getResults("select name from sqlite_master where type is 'table'");
        assertEquals(1,results.size());
        assertEquals("sampleTestName", results.get(0).get("name"));
    }
    
}
