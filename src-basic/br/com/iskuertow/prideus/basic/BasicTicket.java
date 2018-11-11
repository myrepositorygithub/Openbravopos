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
public interface BasicTicket<E> {

    public abstract boolean add(E e);

    public abstract boolean remove(E e);

    public abstract E update(E e);

    public abstract boolean reflesh();

    public abstract boolean back();

    public abstract boolean open(E e);
    
    public abstract boolean export();
    
    public abstract boolean calc(E e);
}
