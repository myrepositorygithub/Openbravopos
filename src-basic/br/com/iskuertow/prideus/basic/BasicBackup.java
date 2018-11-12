/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

/**
 *
 * @author Thiago Dias Gomes
 */
public interface BasicBackup {

    public abstract boolean newBackup(String path, String host, String port, String user, String password, String bd, String destiny);

    public abstract boolean restore(String path, String host, String port, String user, String password, String bd, String dumpToRestore);
}
