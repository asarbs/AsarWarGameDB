/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.treecode.GRW.DatabaseManager.queries;

import java.util.ArrayList;
import org.treecode.GRW.DatabaseManager.Field;

/**
 *
 * @author skorupa
 */
public class CreateTable implements Query {

    public String get(String tableName, Field... fields) {

        ArrayList<String> list = new ArrayList<String>();
        
        for(Field f : fields)
        {
            list.add(f.getDefinition());
        }
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS '");
        sb.append(tableName);
        sb.append("' (");
        sb.append(String.join(", ", list));
        sb.append(");");                
        return sb.toString();
    }
}
