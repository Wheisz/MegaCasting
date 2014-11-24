/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.view;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import megacasting.MegaCasting;
import megacasting.dao.DomaineDAO;
import megacasting.dao.MetierDAO;
import megacasting.dao.TypeContratDAO;
import megacasting.entite.Domaine;
import megacasting.entite.Metier;
import megacasting.entite.TypeContrat;

/**
 *
 * @author theodore
 */
public class ParamsForm extends javax.swing.JPanel {

    private MainJFrame mainJFrame;

    public ParamsForm(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
        initComponents();        
        
        refreshListDomaine();
        refreshComboBoxDomaine();
        refreshListMetier();
        refreshListTypeContrat();
    }
    
    private void refreshListTypeContrat() {
        DefaultListModel<TypeContrat> modelListTypeContrat = new DefaultListModel<>();
        ArrayList<TypeContrat> typeContrats = TypeContratDAO.lister(mainJFrame.cnx);

        for (TypeContrat tc : typeContrats) {
            modelListTypeContrat.addElement(tc);
        }
        listTypeContrat.setModel(modelListTypeContrat);
    }
    
    private void refreshListMetier(Domaine d) {
        DefaultListModel<Metier> modelListMetier = new DefaultListModel<>();
        ArrayList<Metier> metiers = MetierDAO.lister(mainJFrame.cnx, d);
        for (Metier m : metiers) {
            modelListMetier.addElement(m);
        }
        listMetier.setModel(modelListMetier);
    }
    
    private void refreshListDomaine() {
        DefaultListModel<Domaine> modelListDomaine = new DefaultListModel<>();
        ArrayList<Domaine> domaines = DomaineDAO.lister(mainJFrame.cnx);

        for (Domaine d : domaines) {
            modelListDomaine.addElement(d);
        }
        listDomaine.setModel(modelListDomaine);
    }
    
    private void refreshComboBoxDomaine() {
        DefaultComboBoxModel<Domaine> modelComboBoxDomaine = new DefaultComboBoxModel<>();
        ArrayList<Domaine> domaines = DomaineDAO.lister(mainJFrame.cnx);
        for (Domaine d : domaines) {
            modelComboBoxDomaine.addElement(d);
        }
        comboBoxDomaine.setModel(modelComboBoxDomaine);
        comboBoxDomaine.setSelectedIndex(-1);
    }
    
    private void refreshListMetier(){
        
        if (checkBoxDomaine.isSelected()) {
            Domaine d = (Domaine) comboBoxDomaine.getSelectedItem();
            refreshListMetier(d);
        }
        else {
            refreshListMetier(null);
        }
    }
    
    /**
     * Creates new form ParamsForm
     */
    public ParamsForm() {
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

        buttonRetour = new javax.swing.JButton();
        tabbedPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        typeContratLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTypeContrat = new javax.swing.JList();
        buttonSupprimerTypeContrat = new javax.swing.JButton();
        buttonEffacerTypeContrat = new javax.swing.JButton();
        buttonValiderTypeContrat = new javax.swing.JButton();
        labelLibelleTypeContrat = new javax.swing.JLabel();
        textFieldLibelleTypeContrat = new javax.swing.JTextField();
        labelErrorTypeContrat = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelLibelleDomaine = new javax.swing.JLabel();
        textFieldLibelleDomaine = new javax.swing.JTextField();
        labelDomaine = new javax.swing.JLabel();
        buttonValiderDomaine = new javax.swing.JButton();
        buttonSupprimerDomaine = new javax.swing.JButton();
        buttonEffacerDomaine = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listDomaine = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        buttonEffacerMetier = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMetier = new javax.swing.JList();
        labelMetier = new javax.swing.JLabel();
        checkBoxDomaine = new javax.swing.JCheckBox();
        buttonSupprimerMetier = new javax.swing.JButton();
        labelLibelleMetier = new javax.swing.JLabel();
        textFieldLibelleMetier = new javax.swing.JTextField();
        buttonValiderMetier = new javax.swing.JButton();
        comboBoxDomaine = new javax.swing.JComboBox();

        buttonRetour.setText("Retour");
        buttonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetourActionPerformed(evt);
            }
        });

        typeContratLabel.setText("Type de contrat");

        listTypeContrat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listTypeContrat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listTypeContratFocusGained(evt);
            }
        });
        listTypeContrat.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listTypeContratValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listTypeContrat);

        buttonSupprimerTypeContrat.setText("Supprimer");
        buttonSupprimerTypeContrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupprimerTypeContratActionPerformed(evt);
            }
        });

        buttonEffacerTypeContrat.setText("Effacer");
        buttonEffacerTypeContrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEffacerTypeContratActionPerformed(evt);
            }
        });

        buttonValiderTypeContrat.setText("Valider");
        buttonValiderTypeContrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderTypeContratActionPerformed(evt);
            }
        });

        labelLibelleTypeContrat.setText("Libelle :");

        labelErrorTypeContrat.setForeground(new java.awt.Color(255, 0, 0));
        labelErrorTypeContrat.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonSupprimerTypeContrat, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(typeContratLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonValiderTypeContrat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelLibelleTypeContrat)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelErrorTypeContrat)
                                        .addComponent(textFieldLibelleTypeContrat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(buttonEffacerTypeContrat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(192, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(labelErrorTypeContrat)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelLibelleTypeContrat)
                                .addComponent(textFieldLibelleTypeContrat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonValiderTypeContrat)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonEffacerTypeContrat))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(typeContratLabel)
                            .addGap(11, 11, 11)
                            .addComponent(jScrollPane1)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(buttonSupprimerTypeContrat)
                    .addContainerGap(112, Short.MAX_VALUE)))
        );

        tabbedPanel.addTab("Type de contrat", jPanel1);

        labelLibelleDomaine.setText("Libelle :");

        labelDomaine.setText("Domaine");

        buttonValiderDomaine.setText("Valider");
        buttonValiderDomaine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderDomaineActionPerformed(evt);
            }
        });

        buttonSupprimerDomaine.setText("Supprimer");
        buttonSupprimerDomaine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupprimerDomaineActionPerformed(evt);
            }
        });

        buttonEffacerDomaine.setText("Effacer");
        buttonEffacerDomaine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEffacerDomaineActionPerformed(evt);
            }
        });

        listDomaine.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listDomaine.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDomaineValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listDomaine);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(buttonSupprimerDomaine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addComponent(labelDomaine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(labelLibelleDomaine)
                            .addGap(18, 18, 18)
                            .addComponent(textFieldLibelleDomaine, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(buttonEffacerDomaine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonValiderDomaine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(208, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(labelDomaine)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelLibelleDomaine)
                                .addComponent(textFieldLibelleDomaine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonValiderDomaine)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonEffacerDomaine)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(buttonSupprimerDomaine)
                    .addContainerGap(91, Short.MAX_VALUE)))
        );

        tabbedPanel.addTab("Domaine", jPanel2);

        buttonEffacerMetier.setText("Effacer");
        buttonEffacerMetier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEffacerMetierActionPerformed(evt);
            }
        });

        listMetier.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listMetier.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listMetierValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listMetier);

        labelMetier.setText("Métier");

        checkBoxDomaine.setText("Domaine :");
        checkBoxDomaine.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkBoxDomaineStateChanged(evt);
            }
        });

        buttonSupprimerMetier.setText("Supprimer");
        buttonSupprimerMetier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupprimerMetierActionPerformed(evt);
            }
        });

        labelLibelleMetier.setText("Libelle : ");

        buttonValiderMetier.setText("Valider");
        buttonValiderMetier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderMetierActionPerformed(evt);
            }
        });

        comboBoxDomaine.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxDomaineItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(comboBoxDomaine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(checkBoxDomaine))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonEffacerMetier, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonValiderMetier, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelLibelleMetier)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldLibelleMetier, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(labelMetier, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSupprimerMetier, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelMetier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxDomaine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxDomaine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelLibelleMetier)
                            .addComponent(textFieldLibelleMetier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonValiderMetier))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSupprimerMetier)
                    .addComponent(buttonEffacerMetier))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Métier", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabbedPanel))
                .addGap(205, 205, 205))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRetour)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetourActionPerformed
        // TODO add your handling code here:
        labelErrorTypeContrat.setVisible(false);
        CardLayout cl = (CardLayout) mainJFrame.mainPanel.getLayout();
        cl.show(mainJFrame.mainPanel, "accueilCard");
    }//GEN-LAST:event_buttonRetourActionPerformed

    private void listTypeContratFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listTypeContratFocusGained
        // TODO add your handling code here:
        TypeContrat tc = (TypeContrat) listTypeContrat.getSelectedValue();
        textFieldLibelleTypeContrat.setText(tc.getLibelle());
    }//GEN-LAST:event_listTypeContratFocusGained

    private void listTypeContratValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listTypeContratValueChanged
        // TODO add your handling code here:
        TypeContrat tc = (TypeContrat) listTypeContrat.getSelectedValue();
        textFieldLibelleTypeContrat.setText(tc.getLibelle());
    }//GEN-LAST:event_listTypeContratValueChanged

    private void buttonSupprimerTypeContratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerTypeContratActionPerformed
        // TODO add your handling code here:
        TypeContrat tc = (TypeContrat) listTypeContrat.getSelectedValue();
        TypeContratDAO.supprimer(mainJFrame.cnx, tc);
        refreshListTypeContrat();
    }//GEN-LAST:event_buttonSupprimerTypeContratActionPerformed

    private void buttonEffacerTypeContratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEffacerTypeContratActionPerformed
        // TODO add your handling code here:
        textFieldLibelleTypeContrat.setText("");
    }//GEN-LAST:event_buttonEffacerTypeContratActionPerformed

    private void buttonValiderTypeContratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderTypeContratActionPerformed
        // TODO add your handling code here:
        ArrayList<TypeContrat> typeContrats = TypeContratDAO.lister(mainJFrame.cnx);
        String libelle = textFieldLibelleTypeContrat.getText();
        boolean exist = false;

        for(TypeContrat tc : typeContrats) {
            // Si ce libelle existe déjà
            if (tc.getLibelle().equalsIgnoreCase(libelle)) {
                // Il y a erreur
                exist = true;
            }
            // Sinon pas d'erreur
            else {
                exist = false;
            }
        }

        if (exist) {
            // Afficher erreur
            labelErrorTypeContrat.setText("Ce type de contrat existe déjà !");
        }
        else {
            TypeContrat typeC = new TypeContrat(libelle);
            try {
                TypeContratDAO.creer(mainJFrame.cnx, typeC);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            refreshListTypeContrat();
        }
    }//GEN-LAST:event_buttonValiderTypeContratActionPerformed

    private void buttonValiderDomaineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderDomaineActionPerformed
        // TODO add your handling code here:
        ArrayList<Domaine> domaines = DomaineDAO.lister(mainJFrame.cnx);
        String libelle = textFieldLibelleDomaine.getText();
        boolean exist = false;

        for (Domaine d : domaines) {
            if (d.getLibelle().equalsIgnoreCase(libelle)) {
                // Domaine existant
                exist = true;
            }
            else {
                exist = false;
            }
        }

        Domaine domaine = null;
        if (!exist) {
            domaine = new Domaine(libelle);
            try {
                DomaineDAO.creer(mainJFrame.cnx, domaine);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            refreshListDomaine();
            refreshComboBoxDomaine();
        }
    }//GEN-LAST:event_buttonValiderDomaineActionPerformed

    private void buttonSupprimerDomaineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerDomaineActionPerformed
        // TODO add your handling code here:
        Domaine d = (Domaine) listDomaine.getSelectedValue();
        DomaineDAO.supprimer(mainJFrame.cnx, d);
        refreshListDomaine();
        
    }//GEN-LAST:event_buttonSupprimerDomaineActionPerformed

    private void buttonEffacerDomaineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEffacerDomaineActionPerformed
        // TODO add your handling code here:
        textFieldLibelleDomaine.setText("");
    }//GEN-LAST:event_buttonEffacerDomaineActionPerformed

    private void listDomaineValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDomaineValueChanged
        // TODO add your handling code here:
        refreshListMetier();
        Domaine d = (Domaine) listDomaine.getSelectedValue();
        textFieldLibelleDomaine.setText(d.getLibelle());
    }//GEN-LAST:event_listDomaineValueChanged

    private void buttonEffacerMetierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEffacerMetierActionPerformed
        // TODO add your handling code here:
        textFieldLibelleMetier.setText("");
        comboBoxDomaine.setSelectedIndex(-1);
    }//GEN-LAST:event_buttonEffacerMetierActionPerformed

    private void listMetierValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listMetierValueChanged
        // TODO add your handling code here:
        Metier m = (Metier) listMetier.getSelectedValue();
        textFieldLibelleMetier.setText(m.getLibelle());
    }//GEN-LAST:event_listMetierValueChanged

    private void checkBoxDomaineStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkBoxDomaineStateChanged
        // TODO add your handling code here:
        if (checkBoxDomaine.isSelected()) {
            comboBoxDomaine.setVisible(true);
        }
        else {
            comboBoxDomaine.setVisible(false);
        }
        refreshListMetier();
    }//GEN-LAST:event_checkBoxDomaineStateChanged

    private void buttonSupprimerMetierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupprimerMetierActionPerformed
        // TODO add your handling code here:
        Metier m = (Metier) listMetier.getSelectedValue();
        MetierDAO.supprimer(mainJFrame.cnx, m);
        refreshListMetier();
    }//GEN-LAST:event_buttonSupprimerMetierActionPerformed

    private void buttonValiderMetierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderMetierActionPerformed
        // TODO add your handling code here:
        ArrayList<Metier> metiers = MetierDAO.lister(mainJFrame.cnx);
        String libelle = textFieldLibelleMetier.getText();
        Domaine d = null;
        boolean exist = false;

        for (Metier m : metiers) {
            if (m.getLibelle().equalsIgnoreCase(libelle)) {
                exist = true;
            }
            else {
                exist = false;
            }
        }
        if (checkBoxDomaine.isSelected()) {
            d = (Domaine) comboBoxDomaine.getSelectedItem();
        }

        Metier metier = new Metier(libelle, d);

        MetierDAO.creer(mainJFrame.cnx, metier);

        refreshListMetier();
    }//GEN-LAST:event_buttonValiderMetierActionPerformed

    private void comboBoxDomaineItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxDomaineItemStateChanged
        // TODO add your handling code here:
        refreshListMetier();
    }//GEN-LAST:event_comboBoxDomaineItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEffacerDomaine;
    private javax.swing.JButton buttonEffacerMetier;
    private javax.swing.JButton buttonEffacerTypeContrat;
    private javax.swing.JButton buttonRetour;
    private javax.swing.JButton buttonSupprimerDomaine;
    private javax.swing.JButton buttonSupprimerMetier;
    private javax.swing.JButton buttonSupprimerTypeContrat;
    private javax.swing.JButton buttonValiderDomaine;
    private javax.swing.JButton buttonValiderMetier;
    private javax.swing.JButton buttonValiderTypeContrat;
    private javax.swing.JCheckBox checkBoxDomaine;
    private javax.swing.JComboBox comboBoxDomaine;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelDomaine;
    private javax.swing.JLabel labelErrorTypeContrat;
    private javax.swing.JLabel labelLibelleDomaine;
    private javax.swing.JLabel labelLibelleMetier;
    private javax.swing.JLabel labelLibelleTypeContrat;
    private javax.swing.JLabel labelMetier;
    private javax.swing.JList listDomaine;
    private javax.swing.JList listMetier;
    private javax.swing.JList listTypeContrat;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JTextField textFieldLibelleDomaine;
    private javax.swing.JTextField textFieldLibelleMetier;
    private javax.swing.JTextField textFieldLibelleTypeContrat;
    private javax.swing.JLabel typeContratLabel;
    // End of variables declaration//GEN-END:variables
}