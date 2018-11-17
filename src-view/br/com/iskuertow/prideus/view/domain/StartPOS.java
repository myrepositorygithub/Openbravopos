/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.view.domain;

import static br.com.iskuertow.prideus.basic.BasicScreenModeEnum.FULL_SCREEN;
import static br.com.iskuertow.prideus.basic.BasicScreenModeEnum.getScreenMode;
import br.com.iskuertow.prideus.basic.adapter.InitAdapter;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.instance.InstanceQuery;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Locale;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceSkin;

/**
 *
 * @author Thiago Dias Gomes
 */
public class StartPOS extends InitAdapter {

    private static final Logger LOGGER = Logger.getLogger("com.openbravo.pos.forms.StartPOS");

    private InstanceQuery instanceQuery = null;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            StartPOS oS = new StartPOS();
            if (!oS.registerApp()) {
                System.exit(0);
            }
            AppConfig config = new AppConfig(args);
            config.load();
            oS.loadConfig(args, config);
        });
    }

    @Override
    public boolean registerApp() {
        try {
            instanceQuery = new InstanceQuery();
            instanceQuery.getAppMessage().restoreWindow();
            return false;
        } catch (NotBoundException | RemoteException e) {
            return true;
        }
    }

    @Override
    public void loadConfig(String[] args, AppConfig config) {

        // set Locale.
        String slang = config.getProperty("user.language");
        String scountry = config.getProperty("user.country");
        String svariant = config.getProperty("user.variant");
        if (slang != null && !slang.equals("") && scountry != null && svariant != null) {
            Locale.setDefault(new Locale(slang, scountry, svariant));
        }

        // Set the format patterns
        Formats.setIntegerPattern(config.getProperty("format.integer"));
        Formats.setDoublePattern(config.getProperty("format.double"));
        Formats.setCurrencyPattern(config.getProperty("format.currency"));
        Formats.setPercentPattern(config.getProperty("format.percent"));
        Formats.setDatePattern(config.getProperty("format.date"));
        Formats.setTimePattern(config.getProperty("format.time"));
        Formats.setDateTimePattern(config.getProperty("format.datetime"));

        display(config);
        setSkin(config);
    }

    @Override
    public void display(AppConfig appConfig) {
        switch (getScreenMode(appConfig.getProperty("machine.screenmode"))) {
            case FULL_SCREEN:
                JRootKiosk rootkiosk = new JRootKiosk();
                rootkiosk.initFrame(appConfig);
                rootkiosk.setVisible(true);
                break;
            case WINDOW:
                JRootFrame rootframe = new JRootFrame();
                rootframe.initFrame(appConfig);
                rootframe.setVisible(true);
                break;
            default:
            //TODO
        }
    }

    @Override
    public void setSkin(AppConfig appConfig) {
        try {
            Object laf = Class.forName(appConfig.getProperty("swing.defaultlaf")).newInstance();
            if (laf instanceof LookAndFeel) {
                UIManager.setLookAndFeel((LookAndFeel) laf);
            } else if (laf instanceof SubstanceSkin) {
                SubstanceLookAndFeel.setSkin((SubstanceSkin) laf);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
