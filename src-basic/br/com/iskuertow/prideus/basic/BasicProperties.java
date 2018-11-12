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
public interface BasicProperties {

    public File getConfigFile();

    public String getHost();

    public String getProperty(String key);
}
