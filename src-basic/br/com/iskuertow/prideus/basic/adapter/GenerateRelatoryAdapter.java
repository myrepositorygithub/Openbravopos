/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic.adapter;

import br.com.iskuertow.prideus.basic.BasicGenerateRelatory;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Thiago Dias Gomes
 */
public class GenerateRelatoryAdapter implements BasicGenerateRelatory {

    @Override
    public boolean generateRelatory(String arquivo, Collection<?> itens, Map<String, Object> parametros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean generateRelatory(InputStream arquivo, Collection<?> itens, Map<String, Object> parametros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean generateRelatory(JasperReport arquivo, Collection<?> itens, Map<String, Object> parametros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
