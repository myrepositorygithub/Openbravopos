/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Thiago Dias Gomes
 */
public interface BasicGenerateRelatory {

    public abstract boolean generateRelatory(String arquivo, Collection<?> itens, Map<String, Object> parametros);

    public abstract boolean generateRelatory(InputStream arquivo, Collection<?> itens, Map<String, Object> parametros);

    public abstract boolean generateRelatory(JasperReport arquivo, Collection<?> itens, Map<String, Object> parametros);
}
