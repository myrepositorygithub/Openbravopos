/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

import java.io.InputStream;
import org.w3c.dom.Document;

/**
 *
 * @author Thiago Dias Gomes
 */
public interface BasicJasperLegacyInputStream {

    public abstract InputStream convertToLegacyFormat(InputStream is);

    public abstract String removeDataTag(String source, String tag, String attr);

    public abstract String replaceTagTitle(String source, String tag, String oldAttr, String newAttr);

    public abstract String addAttributeInTag(String source, String tag, String attr);

    public abstract Document convertInputStreamToDOM(InputStream is);

    public abstract String addDocTypeAndConvertDOMToString(Document document);

    public abstract InputStream convertStringToInputStream(String template);
}
