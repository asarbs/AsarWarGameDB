/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gameDB.queryBuilder.createTables;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.treecode.GRW.DatabaseManager.DBQueryBuilder;
import org.treecode.GRW.DatabaseManager.DatabaseTable;
import org.treecode.GRW.DatabaseManager.Field;

/**
 *
 * @author skorupa
 */
@ServiceProvider(service=DatabaseTable.class)
public class Spell implements DBQueryBuilder, DatabaseTable {

    private ArrayList<Field> fields = new ArrayList<>();
    
    public Spell()
    {
        fields.add(new Field("id", "INTEGER", true));
        fields.add(new Field("difficulty_level", "INTEGER"));
        fields.add(new Field("name", "TEXT NOT NULL"));
        fields.add(new Field("description", "TEXT NOT NULL"));
    }
    
    @Override
    public String query(String... s) {
        /*
        CREATE TABLE [IF NOT EXISTS] [schema_name].table_name (
         column_1 data_type PRIMARY KEY,
           column_2 data_type NOT NULL,
         column_3 data_type DEFAULT 0,
         table_constraint
        ) [WITHOUT ROWID];
        */
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS 'spell' (id INTEGER PRIMARY KEY, cost INTEGER, difficulty_level INTEGER, name TEXT NOT NULL, description TEXT NOT NULL);");
        return sb.toString();
    }

    @Override
    public List<Field> getFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
