/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

import java.io.File;

/**
 *
 * @author Thiago Dias Gomes
 */
public interface BasicBackup {

    public abstract boolean newBackup();

    public abstract boolean restore(final File file);

    public abstract boolean checkBackup(final File backup);

    public abstract boolean toCleanDataBase();

}
