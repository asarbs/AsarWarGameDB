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
public class NullObject implements DBItem
{

    public NullObject()
    {
    }

    @Override
    public int getChildCount()
    {
        return 0;
    }

    @Override
    public int getIndexOfChild(Object child)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getChild(int index)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLeaf()
    {
        return true;
    }

    @Override
    public void save()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString()
    {
        return "Null Object";
    }
}
