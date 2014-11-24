/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.view;

import java.awt.CardLayout;

/**
 *
 * @author theodore
 */
public class AccueilForm extends javax.swing.JPanel {

    private MainJFrame mainJFrame;

    public AccueilForm(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
        this.mainJFrame.setExtendedState(this.mainJFrame.MAXIMIZED_BOTH);
        initComponents();
    }

    /**
     * Creates new form AccueilForm
     */
    public AccueilForm() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        offreButton = new javax.swing.JButton();
        typeContratButton = new javax.swing.JButton();
        societeButton = new javax.swing.JButton();
        buttonParams = new javax.swing.JButton();

        jLabel1.setText("Accueil");

        offreButton.setText("Offre");
        offreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offreButtonActionPerformed(evt);
            }
        });

        typeContratButton.setText("Type Contrat");
        typeContratButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeContratButtonActionPerformed(evt);
            }
        });

        societeButton.setText("Societe");
        societeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                societeButtonActionPerformed(evt);
            }
        });

        buttonParams.setText("Paramètres");
        buttonParams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonParamsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeContratButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(offreButton)
                            .addComponent(societeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonParams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(buttonParams)
                .addGap(18, 18, 18)
                .addComponent(offreButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeContratButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(societeButton)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void offreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offreButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) mainJFrame.mainPanel.getLayout();
        cl.show(mainJFrame.mainPanel, "offreCard");
    }//GEN-LAST:event_offreButtonActionPerformed

    private void typeContratButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeContratButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) mainJFrame.mainPanel.getLayout();
        cl.show(mainJFrame.mainPanel, "typeContratCard");
    }//GEN-LAST:event_typeContratButtonActionPerformed

    private void societeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_societeButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) mainJFrame.mainPanel.getLayout();
        cl.show(mainJFrame.mainPanel, "societeCard");
    }//GEN-LAST:event_societeButtonActionPerformed

    private void buttonParamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonParamsActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) mainJFrame.mainPanel.getLayout();
        cl.show(mainJFrame.mainPanel, "paramsCard");
    }//GEN-LAST:event_buttonParamsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonParams;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton offreButton;
    private javax.swing.JButton societeButton;
    private javax.swing.JButton typeContratButton;
    // End of variables declaration//GEN-END:variables
}
