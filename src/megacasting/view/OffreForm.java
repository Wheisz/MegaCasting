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
public class OffreForm extends javax.swing.JPanel {

    private MainJFrame mainJFrame;

    public OffreForm(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
        initComponents();
    }
    
    
    /**
     * Creates new form offreForm
     */
    public OffreForm() {
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
        accueilButton = new javax.swing.JButton();

        jLabel1.setText("Offre");

        accueilButton.setText("Accueil");
        accueilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accueilButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(accueilButton)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(116, 116, 116)
                .addComponent(accueilButton)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        accueilButton.getAccessibleContext().setAccessibleParent(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accueilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accueilButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) mainJFrame.mainPanel.getLayout();
        cl.show(mainJFrame.mainPanel, "accueilCard");
    }//GEN-LAST:event_accueilButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accueilButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
