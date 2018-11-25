/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.treecode.MainEditor.exploter;

/**
 *
 * @author asar
 */
public class GameDB implements DBItem
{

    public GameDB()
    {
    }
    
    public String toString()
    {
        return "Game";
    }

    @Override
    public int getChildCount()
    {
        return 4;
    }

    @Override
    public int getIndexOfChild(Object child)
    {
        switch (child.toString())
        {
            case "Armie":
                return 0;
            case "Umiejętności":
                return 1;
            case "Broń":
                return 2;
            case "Czary":
                return 3;
            default:
                break;
        }
        return 0;
    }

    @Override
    public Object getChild(int index)
    {
//        switch(index)
//        {
//          case 0:
//            return _armyList;
//          case 1:
//            return _skillsList;
//          default:
//            return _weaponsList;
//        }
        return "Null Object";
    }

    @Override
    public boolean isLeaf()
    {
        return false;
    }

    @Override
    public void save()
    {
        
    }

    @Override
    public String getId()
    {
        return "GameDB";
    }
    
}
