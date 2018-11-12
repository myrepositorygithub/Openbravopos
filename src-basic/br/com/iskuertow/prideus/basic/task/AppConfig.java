/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic.task;

import br.com.iskuertow.prideus.basic.BasicProperties;
import br.com.iskuertow.prideus.basic.adapter.ConfigAdapter;
import com.openbravo.pos.forms.AppLocal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Properties;

/**
 *
 * @author Thiago Dias Gomes
 */
public final class AppConfig extends ConfigAdapter implements BasicProperties{

    private Properties m_propsconfig;
    private File configfile;

    public AppConfig(String[] args) {
        if (args.length == 0) {
            init(getDefaultConfig());
        } else {
            init(new File(args[0]));
        }
    }

    public AppConfig(File configfile) {
        init(configfile);
    }

    @Override
    public void init(File configfile) {
        this.configfile = configfile;
        m_propsconfig = new Properties();
    }

    @Override
    public File getDefaultConfig() {
        return new File(new File(System.getProperty("user.home")), AppLocal.APP_ID + ".properties");
    }

    @Override
    public String getProperty(String sKey) {
        return m_propsconfig.getProperty(sKey);
    }

    @Override
    public String getHost() {
        return getProperty("machine.hostname");
    }

    @Override
    public File getConfigFile() {
        return configfile;
    }

    @Override
    public void setProperty(String sKey, String sValue) {
        if (sValue == null) {
            m_propsconfig.remove(sKey);
        } else {
            m_propsconfig.setProperty(sKey, sValue);
        }
    }

    @Override
    public String getLocalHostName() {
        try {
            return java.net.InetAddress.getLocalHost().getHostName();
        } catch (java.net.UnknownHostException eUH) {
            return "localhost";
        }
    }

    @Override
    public boolean delete() {
        loadDefault();
        return configfile.delete();
    }

    @Override
    public void load() {
        loadDefault();
        try {
            InputStream in = new FileInputStream(configfile);
            if (in != null) {
                m_propsconfig.load(in);
                in.close();
            }
        } catch (IOException e) {
            loadDefault();
        }
    }

    @Override
    public void save() throws IOException {
        OutputStream out = new FileOutputStream(configfile);
        if (out != null) {
            m_propsconfig.store(out, AppLocal.APP_NAME + ". Configuration file.");
            out.close();
        }
    }

    @Override
    public void loadDefault() {

        m_propsconfig = new Properties();
        String dirname = System.getProperty("dirname.path");
        dirname = dirname == null ? "./" : dirname;
        m_propsconfig.setProperty("db.driverlib", new File(new File(dirname), "lib/derby.jar").getAbsolutePath());
        m_propsconfig.setProperty("db.driver", "org.apache.derby.jdbc.EmbeddedDriver");
        m_propsconfig.setProperty("db.URL", "jdbc:derby:" + new File(new File(System.getProperty("user.home")), AppLocal.APP_ID + "-database").getAbsolutePath() + ";create=true");
        m_propsconfig.setProperty("db.user", "");
        m_propsconfig.setProperty("db.password", "");

//        m_propsconfig.setProperty("db.driverlib", new File(new File(dirname), "lib/hsqldb.jar").getAbsolutePath());
//        m_propsconfig.setProperty("db.driver", "org.hsqldb.jdbcDriver");
//        m_propsconfig.setProperty("db.URL", "jdbc:hsqldb:file:" + new File(new File(System.getProperty("user.home")), AppLocal.APP_ID + "-db").getAbsolutePath() + ";shutdown=true");
//        m_propsconfig.setProperty("db.user", "sa");
//        m_propsconfig.setProperty("db.password", "");
//        m_propsconfig.setProperty("db.driver", "com.mysql.jdbc.Driver");
//        m_propsconfig.setProperty("db.URL", "jdbc:mysql://localhost:3306/database");
//        m_propsconfig.setProperty("db.user", "user");         
//        m_propsconfig.setProperty("db.password", "password");
//        m_propsconfig.setProperty("db.driver", "org.postgresql.Driver");
//        m_propsconfig.setProperty("db.URL", "jdbc:postgresql://localhost:5432/database");
//        m_propsconfig.setProperty("db.user", "user");         
//        m_propsconfig.setProperty("db.password", "password");        
//        m_propsconfig.setProperty("machine.hostname", getLocalHostName());

        Locale l = Locale.getDefault();
        m_propsconfig.setProperty("user.language", l.getLanguage());
        m_propsconfig.setProperty("user.country", l.getCountry());
        m_propsconfig.setProperty("user.variant", l.getVariant());

        m_propsconfig.setProperty("swing.defaultlaf", System.getProperty("swing.defaultlaf", "javax.swing.plaf.metal.MetalLookAndFeel"));

        m_propsconfig.setProperty("machine.printer", "screen");
        m_propsconfig.setProperty("machine.printer.2", "Not defined");
        m_propsconfig.setProperty("machine.printer.3", "Not defined");
        m_propsconfig.setProperty("machine.display", "screen");
        m_propsconfig.setProperty("machine.scale", "Not defined");
        m_propsconfig.setProperty("machine.screenmode", "window"); // fullscreen / window
        m_propsconfig.setProperty("machine.ticketsbag", "standard");
        m_propsconfig.setProperty("machine.scanner", "Not defined");

        m_propsconfig.setProperty("payment.gateway", "external");
        m_propsconfig.setProperty("payment.magcardreader", "Not defined");
        m_propsconfig.setProperty("payment.testmode", "false");
        m_propsconfig.setProperty("payment.commerceid", "");
        m_propsconfig.setProperty("payment.commercepassword", "password");

        m_propsconfig.setProperty("machine.printername", "(Default)");

        // Receipt printer paper set to 72mmx200mm
        m_propsconfig.setProperty("paper.receipt.x", "10");
        m_propsconfig.setProperty("paper.receipt.y", "287");
        m_propsconfig.setProperty("paper.receipt.width", "190");
        m_propsconfig.setProperty("paper.receipt.height", "546");
        m_propsconfig.setProperty("paper.receipt.mediasizename", "A4");

        // Normal printer paper for A4
        m_propsconfig.setProperty("paper.standard.x", "72");
        m_propsconfig.setProperty("paper.standard.y", "72");
        m_propsconfig.setProperty("paper.standard.width", "451");
        m_propsconfig.setProperty("paper.standard.height", "698");
        m_propsconfig.setProperty("paper.standard.mediasizename", "A4");

        m_propsconfig.setProperty("machine.uniqueinstance", "false");
    }
}
