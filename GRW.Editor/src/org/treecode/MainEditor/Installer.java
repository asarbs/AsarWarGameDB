/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.treecode.MainEditor;

import java.sql.SQLException;
import org.gameDB.queryBuilder.CreateDBStructure;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;

public class Installer extends ModuleInstall
{

    @Override
    public void restored()
    {     
        try
        {
          CreateDBStructure.initDBStructure();
        }
        catch(SQLException ex)
        {
          Exceptions.printStackTrace(ex);
        }
    }

}
