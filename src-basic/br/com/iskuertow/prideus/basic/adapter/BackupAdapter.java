/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic.adapter;

import br.com.iskuertow.prideus.basic.BasicBackup;

/**
 *
 * @author Thiago Dias Gomes
 */
public class BackupAdapter implements BasicBackup{

    @Override
    public boolean newBackup(String path, String host, String port, String user, String password, String bd, String destiny) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean restore(String path, String host, String port, String user, String password, String bd, String dumpToRestore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
