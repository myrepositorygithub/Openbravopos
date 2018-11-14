/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

import com.openbravo.pos.forms.AppConfig;

/**
 *
 * @author Thiago Dias Gomes
 */
public interface BasicInit {

    public abstract void loadConfig(String[] args,AppConfig config);

    public abstract boolean registerApp();

    public abstract void display(AppConfig appConfig);
}
