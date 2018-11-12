/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Thiago Dias Gomes
 */
public interface BasicInit extends Remote {

    public abstract boolean loadConfig(String[] args);

    public abstract void instanceCheck();

    public void restoreWindow() throws RemoteException;
}
