/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

/**
 *
 * @author Thiago
 */
public interface BasicUpdate {

    public abstract boolean checkVesion(final String key);

    public abstract String checkVesion();

    public abstract boolean update();

    public abstract boolean rollback();

    public abstract boolean createTask();

}
