/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic.adapter;

import br.com.iskuertow.prideus.basic.BasicInit;
import java.rmi.RemoteException;

/**
 *
 * @author Thiago Dias Gomes
 */
public class InitAdapter implements BasicInit{

    @Override
    public boolean loadConfig(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void instanceCheck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void restoreWindow() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
