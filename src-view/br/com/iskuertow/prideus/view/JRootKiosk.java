/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.view;

import br.com.iskuertow.prideus.basic.BasicAppMessage;
import br.com.iskuertow.prideus.basic.BasicFrame;
import br.com.iskuertow.prideus.basic.BasicProperties;
import br.com.iskuertow.prideus.basic.task.InstanceManager;
import com.openbravo.pos.forms.AppLocal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import javax.swing.JFrame;

/**
 *
 * @author Thiago
 */
public class JRootKiosk extends javax.swing.JFrame implements BasicAppMessage, BasicFrame {

    private InstanceManager m_instmanager = null;
    private JRootApp m_rootapp;
    private BasicProperties basicProperties;

    public JRootKiosk() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void restoreWindow() throws RemoteException {
        java.awt.EventQueue.invokeLater(() -> {
            if (getExtendedState() == JFrame.ICONIFIED) {
                setExtendedState(JFrame.NORMAL);
            }
            requestFocus();
        });
    }

    @Override
    public void initFrame(BasicProperties m_basicProperties) {
        basicProperties = m_basicProperties;
        m_rootapp = new JRootApp();
        if (m_rootapp.initApp(basicProperties)) {
            if ("true".equals(basicProperties.getProperty("machine.uniqueinstance"))) {
                try {
                    m_instmanager = new InstanceManager(this);
                } catch (Exception e) {
                    //TODO
                }
            }
            add(m_rootapp, BorderLayout.CENTER);
            setTitle(AppLocal.APP_NAME + " - " + AppLocal.APP_VERSION);
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            setBounds(0, 0, d.width, d.height);
            setVisible(true);
        } else {
            //TODO
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
