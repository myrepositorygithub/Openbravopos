/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.model;

import br.com.iskuertow.prideus.basic.BasicBean;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author Thiago Dias Gomes
 */
public class PeopleBean implements BasicBean, Serializable {

    private Long id;
    private String name;
    private Long card;
    private RoleBean roleInfo;
    private boolean visible;
    private BufferedImage image;

    public PeopleBean() {
    }

    public PeopleBean(Long id, String name, Long card, RoleBean roleInfo, boolean visible, BufferedImage image) {
        this.id = id;
        this.name = name;
        this.card = card;
        this.roleInfo = roleInfo;
        this.visible = visible;
        this.image = image;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCard() {
        return card;
    }

    public void setCard(Long card) {
        this.card = card;
    }

    public RoleBean getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleBean roleBean) {
        this.roleInfo = roleBean;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    

}
