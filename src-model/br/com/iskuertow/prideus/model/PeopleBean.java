/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.model;

import br.com.iskuertow.prideus.basic.adapter.BeanAdapter;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author Thiago Dias Gomes
 */
@Entity(name = "people_tb")
public class PeopleBean extends BeanAdapter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "card")
    private Long card;
    @Column(name = "role")
    private RoleBean roleInfo;
    @Column(name = "visible")
    private boolean visible;
    @Lob
    @Column(name = "image")
    private byte[] image;

    public PeopleBean() {
    }

    public PeopleBean(Long id, String name, Long card, RoleBean roleInfo, boolean visible, byte[] image) {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
