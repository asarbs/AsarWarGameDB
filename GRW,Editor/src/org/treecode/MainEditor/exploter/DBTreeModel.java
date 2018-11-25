/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.treecode.MainEditor.exploter;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author asar
 */
public class DBTreeModel implements TreeModel
{

    private final GameDB _root;

    public DBTreeModel()
    {
        _root = new GameDB();
    }

    @Override
    public Object getRoot()
    {
        return _root;
    }

    @Override
    public Object getChild(Object parent, int index)
    {
        DBItem gItem = (DBItem) parent;
        return gItem.getChild(index);
    }

    @Override
    public int getChildCount(Object parent)
    {
        DBItem gItem = (DBItem) parent;
        return gItem.getChildCount();
    }

    @Override
    public boolean isLeaf(Object node)
    {
        return ((DBItem) node).isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue)
    {
        
    }

    @Override
    public int getIndexOfChild(Object parent, Object child)
    {
        if(parent instanceof DBItem)
        {
          DBItem g = (DBItem) parent;
          return g.getIndexOfChild(child);
        }
        return 1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l)
    {
        
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l)
    {
        
    }
    
}
