/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.treecode.GRW.DatabaseManager;

/**
 *
 * @author skorupa
 */
public class Field {
    private final String _name;
    private final String _type;
    private Boolean _is_primary_key = false;
    
    public Field(String name, String type, boolean is_primary_key )
    {
        _name = name;
        _type = type;
        _is_primary_key = is_primary_key;
    }

    public Field(String name, String type)
    {
        _name = name;
        _type = type;
    }
    
    public String getDefinition()
    {
        if(_is_primary_key)
            return String.join(" ", _name, _type, "PRIMARY KEY");
        return String.join(" ", _name, _type);
    }

}
