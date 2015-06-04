/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.view;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import megacasting.dao.DomaineDAO;
import megacasting.dao.MetierDAO;
import megacasting.dao.OffreDAO;
import megacasting.dao.TypeContratDAO;
import megacasting.entite.Domaine;
import megacasting.entite.Metier;
import megacasting.entite.Offre;
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
        
        DefaultListModel<TypeContrat> modelListTypeContrat = new DefaultListModel<>();
        typeContratList.setModel(modelListTypeContrat);
        DefaultListModel<Domaine> modelListDomaine = new DefaultListModel<>();
        domaineList.setModel(modelListDomaine);
        DefaultListModel<Metier> modelListMetier = new DefaultListModel<>();
        metierList.setModel(modelListMetier);
        
        DefaultComboBoxModel<Domaine> modelComboBoxDomaine = new DefaultComboBoxModel<>();
        domaineCombobox.setModel(modelComboBoxDomaine);
        
        
        
        refreshListDomaine();
        refreshComboBoxDomaine();
        refreshListMetier();
        refreshListTypeContrat();
    }
    
    // List des types de contrats
    private void refreshListTypeContrat() {
        DefaultListModel model = (DefaultListModel)typeContratList.getModel();
        
        model.clear();
        
        // Liste de tous les types de contrat
        ArrayList<TypeContrat> typeContrats = TypeContratDAO.lister(mainJFrame.cnx);

        // Pour chaque type de contrat
        for (TypeContrat tc : typeContrats) {
            // On l'ajoute à la liste
            model.addElement(tc);
        }
        typeContratList.setModel(model);
    }
    
    // Liste des métiers d'un domaine d
    private void refreshListMetier(Domaine d) {
        DefaultListModel model = (DefaultListModel)metierList.getModel();
        
        model.clear();
        
        // Liste des métiers du domaine d
        ArrayList<Metier> metiers = MetierDAO.lister(mainJFrame.cnx, d);
        
        // Pour chaque métier du domaine d
        for (Metier m : metiers) {
            // On l'ajoute à la liste
            model.addElement(m);
        }
        metierList.setModel(model);
    }
    
    // Liste de tous les métiers
    private void refreshListMetier(){
        
        // Si la checkbox domaine est cochée
        if (domaineCheckBox.isSelected()) {
            // On récupère le domaine sélectionné
            Domaine d = (Domaine) domaineCombobox.getSelectedItem();
            
            // On refresh la liste des métiers du domaine sélectionné
            refreshListMetier(d);
        }
        else {
            // On vide la liste des métiers d'un domaine
            refreshListMetier(null);
        }
    }
    
    // Liste de tous les domaines
    private void refreshListDomaine() {
        DefaultListModel model = (DefaultListModel)domaineList.getModel();
        
        model.clear();
        
        // Liste de tous les domaines
        ArrayList<Domaine> domaines = DomaineDAO.lister(mainJFrame.cnx);

        // Pour chaque domaine
        for (Domaine d : domaines) {
            // On m'ajoute à la liste
            model.addElement(d);
        }
        domaineList.setModel(model);
    }
    
    // ComboBox de tous les domaines
    private void refreshComboBoxDomaine() {
        DefaultComboBoxModel model = (DefaultComboBoxModel)domaineCombobox.getModel();
        
        model.removeAllElements();
        
        // Liste de tous les domaines
        ArrayList<Domaine> domaines = DomaineDAO.lister(mainJFrame.cnx);
        
        // Pour chaque domaine
        for (Domaine d : domaines) {
            // On l'ajoute à la comboBox
            model.addElement(d);
        }
        domaineCombobox.setModel(model);
        
        // Selectionne vide
        domaineCombobox.setSelectedIndex(-1);
    }
    
    /**
     * Vide les labels et textField du panneau type de contrat
     */
    private void resetTypeContrat() {
        libelleTypeContratTextField.setText("");
        libelleTypeContratErreurLabel.setText("");
    }
    
    /**
     * Vide les labels et textField du panneau domaine
     */
    private void resetDomaine() {
        libelleDomaineTextField.setText("");
        libelleDomaineErreurLabel.setText("");
    }
    
    /**
     * Vide les labels et textField du panneau métier
     */
    private void resetMetier() {
        libelleMetierTextField.setText("");
        libelleMetierErreurLabel.setText("");
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
        jScrollPane4 = new javax.swing.JScrollPane();
        tabbedPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        typeContratLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        typeContratList = new javax.swing.JList();
        supprimerTypeContratButton = new javax.swing.JButton();
        buttonEffacerTypeContrat = new javax.swing.JButton();
        buttonValiderTypeContrat = new javax.swing.JButton();
        libelleTypeContratLabel = new javax.swing.JLabel();
        libelleTypeContratTextField = new javax.swing.JTextField();
        libelleTypeContratErreurLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        libelleDomaineLabel = new javax.swing.JLabel();
        libelleDomaineTextField = new javax.swing.JTextField();
        domaineLabel = new javax.swing.JLabel();
        validerDomaineButton = new javax.swing.JButton();
        supprimerDomaineButton = new javax.swing.JButton();
        effacerDomaineButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        domaineList = new javax.swing.JList();
        libelleDomaineErreurLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        effacerMetierButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        metierList = new javax.swing.JList();
        labelMetier = new javax.swing.JLabel();
        domaineCheckBox = new javax.swing.JCheckBox();
        supprimerMetierButton = new javax.swing.JButton();
        libelleMetierLabel = new javax.swing.JLabel();
        libelleMetierTextField = new javax.swing.JTextField();
        validerMetierButton = new javax.swing.JButton();
        domaineCombobox = new javax.swing.JComboBox();
        libelleMetierErreurLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        buttonRetour.setText("Accueil");
        buttonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetourActionPerformed(evt);
            }
        });

        typeContratLabel.setText("Type de contrat");

        typeContratList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        typeContratList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                typeContratListFocusGained(evt);
            }
        });
        typeContratList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                typeContratListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(typeContratList);

        supprimerTypeContratButton.setText("Supprimer");
        supprimerTypeContratButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerTypeContratButtonActionPerformed(evt);
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

        libelleTypeContratLabel.setText("Libelle :");

        libelleTypeContratErreurLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(357, Short.MAX_VALUE)
                .addComponent(libelleTypeContratErreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(supprimerTypeContratButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(typeContratLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonValiderTypeContrat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(libelleTypeContratLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(libelleTypeContratTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(buttonEffacerTypeContrat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(488, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(libelleTypeContratErreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(libelleTypeContratLabel)
                                .addComponent(libelleTypeContratTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonValiderTypeContrat)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonEffacerTypeContrat))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(typeContratLabel)
                            .addGap(11, 11, 11)
                            .addComponent(jScrollPane1)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(supprimerTypeContratButton)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );

        tabbedPanel.addTab("Type de contrat", jPanel1);

        libelleDomaineLabel.setText("Libelle :");

        domaineLabel.setText("Domaine");

        validerDomaineButton.setText("Valider");
        validerDomaineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerDomaineButtonActionPerformed(evt);
            }
        });

        supprimerDomaineButton.setText("Supprimer");
        supprimerDomaineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerDomaineButtonActionPerformed(evt);
            }
        });

        effacerDomaineButton.setText("Effacer");
        effacerDomaineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacerDomaineButtonActionPerformed(evt);
            }
        });

        domaineList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        domaineList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                domaineListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(domaineList);

        libelleDomaineErreurLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 345, Short.MAX_VALUE)
                .addComponent(libelleDomaineErreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(supprimerDomaineButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addComponent(domaineLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(libelleDomaineLabel)
                            .addGap(18, 18, 18)
                            .addComponent(libelleDomaineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(effacerDomaineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(validerDomaineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(504, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(libelleDomaineErreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(domaineLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(libelleDomaineLabel)
                                .addComponent(libelleDomaineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(validerDomaineButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(effacerDomaineButton)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(supprimerDomaineButton)
                    .addContainerGap(164, Short.MAX_VALUE)))
        );

        tabbedPanel.addTab("Domaine", jPanel2);

        effacerMetierButton.setText("Effacer");
        effacerMetierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacerMetierButtonActionPerformed(evt);
            }
        });

        metierList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        metierList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                metierListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(metierList);

        labelMetier.setText("Métier");

        domaineCheckBox.setSelected(true);
        domaineCheckBox.setText("Domaine :");
        domaineCheckBox.setEnabled(false);
        domaineCheckBox.setFocusable(false);
        domaineCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                domaineCheckBoxStateChanged(evt);
            }
        });

        supprimerMetierButton.setText("Supprimer");
        supprimerMetierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerMetierButtonActionPerformed(evt);
            }
        });

        libelleMetierLabel.setText("Libelle : ");

        validerMetierButton.setText("Valider");
        validerMetierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerMetierButtonActionPerformed(evt);
            }
        });

        domaineCombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                domaineComboboxItemStateChanged(evt);
            }
        });

        libelleMetierErreurLabel.setForeground(new java.awt.Color(255, 0, 0));

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
                                .addComponent(domaineCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(domaineCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(effacerMetierButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(validerMetierButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(libelleMetierLabel)
                                .addGap(18, 18, 18)
                                .addComponent(libelleMetierTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(libelleMetierErreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelMetier, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addComponent(supprimerMetierButton, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelMetier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(domaineCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(domaineCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(libelleMetierLabel)
                                .addComponent(libelleMetierTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(libelleMetierErreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(validerMetierButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(effacerMetierButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supprimerMetierButton)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Métier", jPanel3);

        jScrollPane4.setViewportView(tabbedPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonRetour)
                .addGap(0, 387, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Click boutton Retour
    private void buttonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetourActionPerformed

        // On affiche l'accueil
        CardLayout cl = (CardLayout) mainJFrame.mainPanel.getLayout();
        cl.show(mainJFrame.mainPanel, "accueilCard");
    }//GEN-LAST:event_buttonRetourActionPerformed

    private void typeContratListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_typeContratListFocusGained
        // TODO add your handling code here:
        // On récupère le type de contrat sélectionné
        TypeContrat tc = (TypeContrat) typeContratList.getSelectedValue();
        
        // Si la sélection n'est pas nulle
        if (tc != null) {
            // On rempli le textField libelle
            libelleTypeContratTextField.setText(tc.getLibelle());
        }
    }//GEN-LAST:event_typeContratListFocusGained

    /**
     * Changement de valeur dans la liste type de contrat
     * @param evt 
     */
    private void typeContratListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_typeContratListValueChanged
        // TODO add your handling code here:
        // On récupère le type de contrat sélectionné
        TypeContrat tc = (TypeContrat) typeContratList.getSelectedValue();
        
        // Si la sélection n'est pas nulle
        if (tc != null) {
            // On rempli le textField type contrat
            libelleTypeContratTextField.setText(tc.getLibelle());
        }  
    }//GEN-LAST:event_typeContratListValueChanged

    // Click boutton Supprimer de type contrat
    private void supprimerTypeContratButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerTypeContratButtonActionPerformed
        // TODO add your handling code here:
        // On récupère le type de contrat sélectionné
        TypeContrat tc = (TypeContrat) typeContratList.getSelectedValue();
        
        // Liste des offres ayant ce type de contrat
        ArrayList<Offre> offres = OffreDAO.lister(mainJFrame.cnx, tc);
        
        // Si la liste est vide (pas d'offres pour ce type de contrat)
        if (offres.isEmpty()) {
            // On supprime le type de contrat de la bdd
            TypeContratDAO.supprimer(mainJFrame.cnx, tc);
            
            // Actualise la liste
            refreshListTypeContrat();
        }
        // Si liste pas vide = reste des offres pour ce type de contrats
        else {
            // Affiche l'erreur
            mainJFrame.affichagePopUpInfo("Suppression impossible, des offres correspondent au type de contrat","Erreur");
        } 
    }//GEN-LAST:event_supprimerTypeContratButtonActionPerformed

    // Click boutton effacer panneau type de contrat
    private void buttonEffacerTypeContratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEffacerTypeContratActionPerformed
        // TODO add your handling code here:
        // On vide les champs
        resetTypeContrat();
    }//GEN-LAST:event_buttonEffacerTypeContratActionPerformed

    // Click boutton valider du panneau type de contrat
    private void buttonValiderTypeContratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderTypeContratActionPerformed
        // TODO add your handling code here:
        // Liste de tous les types de contrat
        ArrayList<TypeContrat> typeContrats = TypeContratDAO.lister(mainJFrame.cnx);
        
        // On récupère le libelle du type de contrat
        String libelle = libelleTypeContratTextField.getText();
        
        // Si le libelle est vide
        if (libelle.equals("")) {
            // Affiche l'erreur
            libelleTypeContratErreurLabel.setText("Veuillez saisir un libelle !");
        }
        else {
            libelleTypeContratErreurLabel.setText("");
            boolean exist = false;

            // Pour chaque type de contrat
            for(TypeContrat tc : typeContrats) {
                // Si ce libelle existe déjà
                if (tc.getLibelle().equalsIgnoreCase(libelle)) {
                    // Il y a erreur
                    exist = true;
                }
            }

            if (exist) {
                // Afficher erreur
                mainJFrame.affichagePopUpInfo("Ce type de contrat existe déjà !","Information");
            }
            // Pas d'erreur -> ajout à la bdd
            else {
                TypeContrat typeC = new TypeContrat(libelle);
                try {
                    TypeContratDAO.creer(mainJFrame.cnx, typeC);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // Actualise la liste
                refreshListTypeContrat();
                // On vide les champs
                resetTypeContrat();
            }
        }
    }//GEN-LAST:event_buttonValiderTypeContratActionPerformed

    // Click boutton valider du panneau domaine
    private void validerDomaineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerDomaineButtonActionPerformed
        // TODO add your handling code here:
        // Lisye de tous les domaines
        ArrayList<Domaine> domaines = DomaineDAO.lister(mainJFrame.cnx);
        
        // On récupère le libelle du domaine
        String libelle = libelleDomaineTextField.getText();
        
        // Si le libelle est vide -> on affiche l'erreur
        if (libelle.equals("")) {
            libelleDomaineErreurLabel.setText("Veuillez saisir un libelle !");
        }
        // Si pas vide
        else {
            libelleDomaineErreurLabel.setText("");
            boolean exist = false;

            // pour chaque domaine on regarde si il existe déjà
            for (Domaine d : domaines) {
                if (d.getLibelle().equalsIgnoreCase(libelle)) {
                    // Domaine existant
                    exist = true;
                }
            }

            Domaine domaine = null;
            
            // Si il existe pas -> on le crée
            if (!exist) {
                domaine = new Domaine(libelle);
                try {
                    DomaineDAO.creer(mainJFrame.cnx, domaine);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // Actualise la liste et la comboBox
                refreshListDomaine();
                refreshComboBoxDomaine();
                // Vide les champs
                resetDomaine();
            }
            // Si il existe on affiche l'erreur
            else {
                mainJFrame.affichagePopUpInfo("Ce domaine existe déjà !", "information");
            }
        }
        
    }//GEN-LAST:event_validerDomaineButtonActionPerformed

    // Click boutton supprimer du panneau domaine
    private void supprimerDomaineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerDomaineButtonActionPerformed
        // TODO add your handling code here:
        // On récupère le domaine sélectionné
        Domaine d = (Domaine) domaineList.getSelectedValue();
        
        // Liste des offres du domaine
        ArrayList<Offre> offres = OffreDAO.lister(mainJFrame.cnx, d);
        
        // Liste des métiers du domaine
        ArrayList<Metier> metiers = MetierDAO.lister(mainJFrame.cnx, d);
        
        // Pas d'offres ni de metiers pour ce domaine
        if (offres.isEmpty() && metiers.isEmpty()) {
            // On le supprime de la bdd
            DomaineDAO.supprimer(mainJFrame.cnx, d);
            // Actualise l liste et la comboBox
            refreshListDomaine();
            refreshComboBoxDomaine();
        }
        // Pas d'offres mais des métiers pour ce domaine
        if (offres.isEmpty() && !metiers.isEmpty()) {
            mainJFrame.affichagePopUpInfo("Suppression impossible, des métiers correspondent au domaine","Erreur");
        }
        // Des offres mais pas de métiers pour ce domaine
        if (!offres.isEmpty() && metiers.isEmpty()) {
            mainJFrame.affichagePopUpInfo("Suppression impossible, des offres correspondent au domaine","Erreur");
        }
        // Des offres et des métiers pour ce domaine
        if (!offres.isEmpty() && !metiers.isEmpty()) {
            mainJFrame.affichagePopUpInfo("Suppression impossible,  des offres et des métiers correspondent au domaine","Erreur");
        }
    }//GEN-LAST:event_supprimerDomaineButtonActionPerformed

    // Click boutton effacer du panneua domaine
    private void effacerDomaineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacerDomaineButtonActionPerformed
        // TODO add your handling code here:
        // Vide les champs
        resetDomaine();
    }//GEN-LAST:event_effacerDomaineButtonActionPerformed

    // Changement de valeur liste domaine
    private void domaineListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_domaineListValueChanged
        // TODO add your handling code here:
        // Actualise la liste métier
        refreshListMetier();
        
        // Domaine sélectionné
        Domaine d = (Domaine) domaineList.getSelectedValue();
        if (d != null) {
            // On rempli le textField libelle du domaine
            libelleDomaineTextField.setText(d.getLibelle());
        }
        
    }//GEN-LAST:event_domaineListValueChanged

    // Click boutton effacer du panneau métier
    private void effacerMetierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacerMetierButtonActionPerformed
        // TODO add your handling code here:
        // Actualise la liste
        resetMetier();
        
        // Sélectionne rien
        domaineCombobox.setSelectedIndex(-1);
    }//GEN-LAST:event_effacerMetierButtonActionPerformed

    // Changement de valeure de la liste métier
    private void metierListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_metierListValueChanged
        // TODO add your handling code here:
        // Métier selectionné
        Metier m = (Metier) metierList.getSelectedValue();
        
        // Si selection non nulle
        if (m != null) {
            // Rempli le textField libelle du métier
            libelleMetierTextField.setText(m.getLibelle());
        } 
    }//GEN-LAST:event_metierListValueChanged

    // Check box domaine changement d'état
    private void domaineCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_domaineCheckBoxStateChanged
        // TODO add your handling code here:
        // Si checkbox selectionné
        if (domaineCheckBox.isSelected()) {
            // on affiche la comboBox
            domaineCombobox.setVisible(true);
        }
        // Pas selectionné
        else {
            // On cache la comboBox
            domaineCombobox.setVisible(false);
        }
        refreshListMetier();
    }//GEN-LAST:event_domaineCheckBoxStateChanged

    // CLick boutton supprimer du panneau métier
    private void supprimerMetierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerMetierButtonActionPerformed
        // TODO add your handling code here:
        // Métier selectionné
        Metier m = (Metier) metierList.getSelectedValue();
        
        // Liste des offres du métier selctionné
        ArrayList<Offre> offres = OffreDAO.lister(mainJFrame.cnx, m);
        
        // Pas d'offres associées au métier selectionné
        if (offres.isEmpty()) {
            // On supprime le métier selectionné
            MetierDAO.supprimer(mainJFrame.cnx, m);
            
            // Actualise la liste
            refreshListMetier();
        }
        // Offres associées au métier -> Erreur
        else {
            mainJFrame.affichagePopUpInfo("Suppression impossible, des offres correspondent au métier","Erreur");
        }  
    }//GEN-LAST:event_supprimerMetierButtonActionPerformed

    // CLick bouton valider du panneau métier
    private void validerMetierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerMetierButtonActionPerformed
        // TODO add your handling code here:
        // Liste de tous les métiers
        ArrayList<Metier> metiers = MetierDAO.lister(mainJFrame.cnx);
        
        // On récupère le libelle du métier
        String libelle = libelleMetierTextField.getText();
        Domaine d = null;
        boolean exist = false;

        // Si libelle vide -> erreur
        if (libelle.equals("")) {
            libelleMetierErreurLabel.setText("Veuillez saisir un libelle !");
        }
        // Non vide
        else {
            libelleMetierErreurLabel.setText("");
            
            // On regarde si le métier existe déjà
            for (Metier m : metiers) {
                if (m.getLibelle().equalsIgnoreCase(libelle)) {
                    exist = true;
                }
            }
            
            // Si checkBox domaine sélectionné
            if (domaineCheckBox.isSelected()) {
                // On récupère le domaine sélectionné dans la comboBox
                d = (Domaine) domaineCombobox.getSelectedItem();
            }

            // Métier existe déjà
            if (exist) {
                mainJFrame.affichagePopUpInfo("Ce métier existe déjà !","Information");
            }
            // Existe pas -> on l'ajoute à la bdd
            else {
                if(d!= null)
                {
                    Metier metier = new Metier(libelle, d);
                    MetierDAO.creer(mainJFrame.cnx, metier);

                    // Actualise la liste
                    refreshListMetier();
                    // Vide les champs
                    resetMetier(); 
                }

            } 
        }
    }//GEN-LAST:event_validerMetierButtonActionPerformed

    // Permet le refresh de la List de metiers
    private void domaineComboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_domaineComboboxItemStateChanged
        // TODO add your handling code here:
        refreshListMetier();
    }//GEN-LAST:event_domaineComboboxItemStateChanged

    // Refresh des List et de la ComboBox de la page
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        refreshListDomaine();
        refreshComboBoxDomaine();
        refreshListMetier();
        refreshListTypeContrat();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEffacerTypeContrat;
    private javax.swing.JButton buttonRetour;
    private javax.swing.JButton buttonValiderTypeContrat;
    private javax.swing.JCheckBox domaineCheckBox;
    private javax.swing.JComboBox domaineCombobox;
    private javax.swing.JLabel domaineLabel;
    private javax.swing.JList domaineList;
    private javax.swing.JButton effacerDomaineButton;
    private javax.swing.JButton effacerMetierButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelMetier;
    private javax.swing.JLabel libelleDomaineErreurLabel;
    private javax.swing.JLabel libelleDomaineLabel;
    private javax.swing.JTextField libelleDomaineTextField;
    private javax.swing.JLabel libelleMetierErreurLabel;
    private javax.swing.JLabel libelleMetierLabel;
    private javax.swing.JTextField libelleMetierTextField;
    private javax.swing.JLabel libelleTypeContratErreurLabel;
    private javax.swing.JLabel libelleTypeContratLabel;
    private javax.swing.JTextField libelleTypeContratTextField;
    private javax.swing.JList metierList;
    private javax.swing.JButton supprimerDomaineButton;
    private javax.swing.JButton supprimerMetierButton;
    private javax.swing.JButton supprimerTypeContratButton;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JLabel typeContratLabel;
    private javax.swing.JList typeContratList;
    private javax.swing.JButton validerDomaineButton;
    private javax.swing.JButton validerMetierButton;
    // End of variables declaration//GEN-END:variables
}
