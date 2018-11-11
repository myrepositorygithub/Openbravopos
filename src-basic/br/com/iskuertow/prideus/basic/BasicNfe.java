/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

/**
 *
 * @author Thiago Dias Gomes
 */
public interface BasicNfe {

    public abstract boolean generateXML();

    public abstract boolean validationXML();

    public abstract boolean signatureXML();

    public abstract boolean sendNfe();

    public abstract boolean searchResultProcess();

    public abstract boolean generateXMLtoDistribution();

    public abstract boolean cancelNfe();

    public abstract boolean disruption();

    public abstract boolean protocolQuery();

    public abstract boolean queryServiceStatus();
}
