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
interface DBItem
{
  int getChildCount();

  public int getIndexOfChild(Object child);

  public Object getChild(int index);

  public boolean isLeaf();

  public void save();

  public String getId();

}