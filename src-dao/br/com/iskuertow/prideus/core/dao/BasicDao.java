/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.core.dao;

import java.util.List;

/**
 *
 * @author Thiago Dias Gomes
 * @param <E>
 */
public interface BasicDao<E> {

    public abstract boolean save(E e);

    public abstract boolean remove(E e);

    public abstract List<E> findAll();

    public abstract E find(Object key);

    public abstract E find(Object... key);

}
