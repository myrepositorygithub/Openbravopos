/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.view.domain;

import br.com.iskuertow.prideus.basic.BasicAppMessage;
import br.com.iskuertow.prideus.basic.BasicFrame;
import br.com.iskuertow.prideus.basic.BasicProperties;
import br.com.iskuertow.prideus.basic.task.InstanceManager;
import com.openbravo.pos.forms.AppLocal;
import java.awt.BorderLayout;
import java.io.IOException;
import java.rmi.RemoteException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Thiago
 */
public class JRootFrame extends javax.swing.JFrame implements BasicAppMessage, BasicFrame {

    private InstanceManager m_instmanager = null;
    private JRootApp m_rootapp;
    private BasicProperties m_props;

    public JRootFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
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
    public void initFrame(BasicProperties basicProperties) {
        m_props = basicProperties;
        m_rootapp = new JRootApp();
        if (m_rootapp.initApp(m_props)) {
            if ("true".equals(basicProperties.getProperty("machine.uniqueinstance"))) {
                try {
                    m_instmanager = new InstanceManager(this);
                } catch (Exception e) {
                    //TODO
                }
            }
            add(m_rootapp, BorderLayout.CENTER);
            try {
                this.setIconImage(ImageIO.read(JRootFrame.class.getResourceAsStream("/com/openbravo/images/favicon.png")));
            } catch (IOException e) {
                //TODO
            }
            setTitle(AppLocal.APP_NAME + " - " + AppLocal.APP_VERSION);
            pack();
            setLocationRelativeTo(null);
            setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
        }else{
            //TODO
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
