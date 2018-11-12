/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.util;

import br.com.iskuertow.prideus.basic.adapter.JasperLegacyInputStreamAdapter;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *
 * @author Thiago Dias Gomes
 */
public final class JasperLegacyInputStream extends JasperLegacyInputStreamAdapter {

    public JasperLegacyInputStream(final InputStream is) {
        convertInputStreamToDOM(is);
    }

    @Override
    public InputStream convertToLegacyFormat(InputStream is) {
        Document document = convertInputStreamToDOM(is);
        document.getDocumentElement().removeAttribute("xmlns");
        document.getDocumentElement().removeAttribute("xmlns:xsi");
        document.getDocumentElement().removeAttribute("xsi:schemaLocation");
        document.getDocumentElement().removeAttribute("uuid");
        String source = addDocTypeAndConvertDOMToString(document);
        source = replaceTagTitle(source, "band", "splitType", "isSplitAllowed=\"true\"");
        source = removeDataTag(source, "reportElement", "uuid");
        source = addAttributeInTag(source, "imageExpression", "class=\"java.awt.Image\"");
        return convertStringToInputStream(source);
    }

    @Override
    public String removeDataTag(String source, String tag, String attr) {
        return source.replaceAll("(<" + tag + " .*)(" + attr + "=\"[^\"]*\")", "$1");
    }

    @Override
    public String replaceTagTitle(String source, String tag, String oldAttr, String newAttr) {
        return source.replaceAll("(<" + tag + " .*)(" + oldAttr + "=\"[^\"]*\")", "$1" + newAttr);
    }

    @Override
    public String addAttributeInTag(String source, String tag, String attr) {
        return source.replaceAll("(<" + tag + ")", "$1 " + attr);
    }

    @Override
    public Document convertInputStreamToDOM(InputStream is) {
        Document document = null;
        BufferedInputStream bis = new BufferedInputStream(is);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(bis);
        } catch (Exception ex) {
//            LoggerFactory.getLogger(LegacyJasperInputStream.class).error(ex.getMessage(), ex);
        }
        return document;
    }

    @Override
    public String addDocTypeAndConvertDOMToString(Document document) {
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = null;
        try {
            trans = transfac.newTransformer();
        } catch (TransformerConfigurationException ex) {
//            LoggerFactory.getLogger(LegacyJasperInputStream.class).error(ex.getMessage(), ex);
        }
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        trans.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "//JasperReports//DTD Report Design//EN");
        trans.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://jasperreports.sourceforge.net/dtds/jasperreport.dtd");

        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(document);
        try {
            trans.transform(source, result);
        } catch (TransformerException ex) {
//            LoggerFactory.getLogger(LegacyJasperInputStream.class).error(ex.getMessage(), ex);
        }
        return sw.toString();
    }

    @Override
    public InputStream convertStringToInputStream(String template) {
        return new ByteArrayInputStream(template.getBytes());
    }

}
