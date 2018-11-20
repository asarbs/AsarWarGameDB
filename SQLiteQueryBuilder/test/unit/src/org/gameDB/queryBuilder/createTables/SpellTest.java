/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gameDB.queryBuilder.createTables;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skorupa
 */
public class SpellTest {
    
    public SpellTest() {
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
     * Test of query method, of class Spell.
     */
    @Test
    public void testQuery() {
        String[] s = null;
        Spell instance = new Spell();
        String expResult = "CREATE TABLE IF NOT EXISTS 'spell' (id INTEGER PRIMARY KEY, cost INTEGER, difficulty_level INTEGER, name TEXT NOT NULL, description TEXT NOT NULL);";
        String result = instance.query(s);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, result);
        assertEquals(expResult, result);
    }
    
}
