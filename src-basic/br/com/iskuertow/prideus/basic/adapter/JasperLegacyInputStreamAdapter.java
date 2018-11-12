/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic.adapter;

import br.com.iskuertow.prideus.basic.BasicJasperLegacyInputStream;
import java.io.InputStream;
import org.w3c.dom.Document;

/**
 *
 * @author Thiago Dias Gomes
 */
public class JasperLegacyInputStreamAdapter implements BasicJasperLegacyInputStream{

    @Override
    public InputStream convertToLegacyFormat(InputStream is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeDataTag(String source, String tag, String attr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String replaceTagTitle(String source, String tag, String oldAttr, String newAttr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addAttributeInTag(String source, String tag, String attr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Document convertInputStreamToDOM(InputStream is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addDocTypeAndConvertDOMToString(Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InputStream convertStringToInputStream(String template) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
