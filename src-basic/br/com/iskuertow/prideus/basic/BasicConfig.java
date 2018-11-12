/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Thiago Dias Gomes
 */
public interface BasicConfig{

    public abstract void init(File configfile);

    public abstract File getDefaultConfig();

    public abstract void setProperty(String sKey, String sValue);

    public abstract String getLocalHostName();

    public abstract void save()throws IOException;

    public abstract void load();

    public abstract void loadDefault();

    public abstract boolean delete();

}
