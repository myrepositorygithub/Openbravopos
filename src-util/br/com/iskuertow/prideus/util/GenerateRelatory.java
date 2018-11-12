/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.util;

import br.com.iskuertow.prideus.basic.adapter.GenerateRelatoryAdapter;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Thiago Dias Gomes
 */
public class GenerateRelatory extends GenerateRelatoryAdapter {

    @Override
    public boolean generateRelatory(InputStream arquivo, Collection<?> itens, Map<String, Object> parametros) {
        try {
            JasperPrint print = JasperFillManager.fillReport(arquivo, parametros,
                    new JRBeanCollectionDataSource(itens));
            JasperViewer.viewReport(print, false);
            return true;
        } catch (Exception e) {
            //TODO
        }
        return false;
    }

    @Override
    public boolean generateRelatory(JasperReport arquivo, Collection<?> itens, Map<String, Object> parametros) {
        try {
            JasperPrint print = JasperFillManager.fillReport(arquivo, parametros,
                    new JRBeanCollectionDataSource(itens));
            JasperViewer.viewReport(print, false);
            return true;
        } catch (Exception e) {
            //TODO
        }
        return false;
    }

    @Override
    public boolean generateRelatory(String arquivo, Collection<?> itens, Map<String, Object> parametros) {
        try {
            JasperPrint print = JasperFillManager.fillReport(arquivo, parametros,
                    new JRBeanCollectionDataSource(itens));
            JasperViewer.viewReport(print, false);
            return false;
        } catch (Exception e) {
            //TODO
        }
        return false;
    }

}
