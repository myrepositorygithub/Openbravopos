/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.model;

import br.com.iskuertow.prideus.basic.BasicBean;
import java.io.Serializable;

/**
 *
 * @author Thiago
 */
public class ProductBean implements BasicBean, Serializable {

    private Long id;

    public ProductBean() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
