//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2009 Openbravo, S.L.
//    http://www.openbravo.com/product/pos
//
//    This file is part of Openbravo POS.
//
//    Openbravo POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Openbravo POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.
package br.com.iskuertow.prideus.view.domain;

import com.openbravo.pos.config.JFrmConfig;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppProperties;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import com.openbravo.pos.instance.AppMessage;
import com.openbravo.pos.instance.InstanceManager;
import java.awt.BorderLayout;
import java.rmi.AlreadyBoundException;

/**
 *
 * @author adrianromero
 */
public class JRootKiosk extends javax.swing.JFrame implements AppMessage {

    private InstanceManager m_instmanager = null;
    private JRootApp m_rootapp;
    private AppProperties m_props;

    public JRootKiosk() {
        initComponents();
    }

    @Override
    public void initFrame(AppProperties props) {
        m_props = props;
        m_rootapp = new JRootApp();
        if (m_rootapp.initApp(m_props)) {
            if ("true".equals(props.getProperty("machine.uniqueinstance"))) {
                try {
                    m_instmanager = new InstanceManager(this);
                } catch (AlreadyBoundException | RemoteException e) {
                    //TODO
                }
            }

            // Show the application
            add(m_rootapp, BorderLayout.CENTER);
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            setBounds(0, 0, d.width, d.height);
        } else {
            new JFrmConfig(props).setVisible(true); // Show the configuration window.
        }
    }

    @Override
    public void restoreWindow() throws RemoteException {
        java.awt.EventQueue.invokeLater(() -> {
            if (getExtendedState() == JFrame.ICONIFIED) {
                setExtendedState(JFrame.NORMAL);
            }
            requestFocus();
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(AppLocal.APP_NAME + " - " + AppLocal.APP_VERSION);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        m_rootapp.tryToClose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
