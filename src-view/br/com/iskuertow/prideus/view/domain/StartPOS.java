/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.view.domain;

import br.com.iskuertow.prideus.basic.BasicScreenModeEnum;
import static br.com.iskuertow.prideus.basic.BasicScreenModeEnum.FULL_SCREEN;
import static br.com.iskuertow.prideus.basic.BasicScreenModeEnum.getScreenMode;
import br.com.iskuertow.prideus.basic.adapter.InitAdapter;
import br.com.iskuertow.prideus.basic.task.AppConfig;

/**
 *
 * @author Thiago Dias Gomes
 */
public class StartPOS extends InitAdapter {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartPOS oS = new StartPOS();
                oS.loadConfig(args);
            }
        });
    }

    @Override
    public void loadConfig(String[] args) {
        AppConfig config = new AppConfig(args);
        config.load();
        
        switch (getScreenMode(config.getProperty("machine.screenmode"))) {
            case FULL_SCREEN:
                JRootKiosk rootkiosk = new JRootKiosk();
                rootkiosk.initFrame(config);
                break;
            case WINDOW:
                JRootFrame rootframe = new JRootFrame();
                rootframe.initFrame(config);
                break;
            default:
                //TODO
        }

    }

}
