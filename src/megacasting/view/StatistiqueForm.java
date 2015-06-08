/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.view;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import megacasting.dao.AnnonceurDAO;
import megacasting.dao.DomaineDAO;
import megacasting.dao.MetierDAO;
import megacasting.dao.OffreDAO;
import megacasting.dao.TypeContratDAO;
import megacasting.entite.Annonceur;
import megacasting.entite.Domaine;
import megacasting.entite.Metier;
import megacasting.entite.Offre;
import megacasting.entite.TypeContrat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author theodore
 */
public class StatistiqueForm extends javax.swing.JPanel {

    private MainJFrame mainJFrame;
    private JFrame graphJFrame;
    
    /**
     * Charge les lignes du tableau domaine
     * Nom du domaine X, Nb de métiers du domaine X, Nb d'offres du domaine X, Nb de postes du domaine X
     */
    private void refreshTableDomaine() {
        // On récupère le model
        DefaultTableModel model = (DefaultTableModel) tableDomaine.getModel();
        
        // Liste de tous les domaines
        ArrayList<Domaine> domaines = DomaineDAO.lister(mainJFrame.cnx);
        
        ArrayList<Metier> metiers = new ArrayList<>();      
    
        // Vide les lignes
        model.setRowCount(0);
        
        // Pour chaque domaine
        for (Domaine d : domaines) {
            // Liste des métiers du domaine
            metiers = MetierDAO.lister(mainJFrame.cnx, d);
            
            // Creation tableau d'offres
            ArrayList<Offre> offresFinal = new ArrayList<>();
            
            // On initialise le nb de postes à 0
            int nbPostes = 0;
            
            // Pour chaque métier
            for (Metier m : metiers) {
                // Liste des offres du métier (et donc du domaine)
                ArrayList<Offre> offresTemp = OffreDAO.lister(mainJFrame.cnx, m);
                // Pour chaque offre du métier
                for (Offre o : offresTemp) {
                    // On l'ajoute à la liste des offres du domaine
                    offresFinal.add(o);
                }
            }
            
            // Pour chaque offre du domaine
            for (Offre of : offresFinal) {
                // On compte le nombre de postes
                nbPostes += of.getNbPoste();
            }
            
            // On ajoute la ligne dans le model
            model.addRow(new Object[] {
                // Libelle du domaine
                d.getLibelle(),
                // Nombre de métiers dans ce domaine
                metiers.size(),
                // Nombre d'offres pour ce domaine
                offresFinal.size(),
                // Nombre de postes pour ce domaine
                nbPostes
            });
        }
    }
    
    /**
     * Charge les lignes du tableau métier
     * Nom du métier X, Nb d'offres du métier X, Nb de postes du métier X
     */
    private void refreshTableMetier() {
        // On récupère le model
        DefaultTableModel model = (DefaultTableModel) tableMetier.getModel();
        
        // Liste de tous les métiers
        ArrayList<Metier> metiers = MetierDAO.lister(mainJFrame.cnx);
    
        // Vide les lignes du tableau
        model.setRowCount(0);
        
        // Pour chaque métier
        for (Metier m : metiers) {
            // On récupère les offres du métier
            ArrayList<Offre> offresFinal = OffreDAO.lister(mainJFrame.cnx, m);
            
            // Initialisation du nb de postes à 0
            int nbPostes = 0;
            
            // Pour chaque offre du métier
            for (Offre of : offresFinal) {
                // On compte le nb de postes
                nbPostes += of.getNbPoste();
            }
            
            // On ajoute la ligne au tableau
            model.addRow(new Object[] {
                // Libelle du métier
                m.getLibelle(),
                // Nombre d'offres pour ce métier
                offresFinal.size(),
                // Nombre de postes offert pour ce métier
                nbPostes
            });
        }
    }
    
    /**
     * Chargement des lignes du tableau annonceur
     * Nom de l'annonceur X, Nb d'offres de l'annonceur X, Nb de postes de l'annonceur X
     */
    private void refreshTableAnnonceur() {
        // On récupère le modèle du tableau
        DefaultTableModel model = (DefaultTableModel) tableSociete.getModel();
        
        // Liste de tous les annonceurs
        ArrayList<Annonceur> annonceurs = AnnonceurDAO.lister(mainJFrame.cnx);
    
        // On vide les lignes du tableau
        model.setRowCount(0);
        
        // Pour chaque annonceur
        for (Annonceur a : annonceurs) {
            // On récupère les offres de l'annonceur
            ArrayList<Offre> offresFinal = OffreDAO.lister(mainJFrame.cnx, a);
            
            // Nb de postes à 0
            int nbPostes = 0;
            
            // Pour chaque offre de l'annonceur
            for (Offre of : offresFinal) {
                // On compte le nb de postes
                nbPostes += of.getNbPoste();
            }
            
            // On ajoute la ligne au tableau
            model.addRow(new Object[] {
                // Raison sociale de l'annonceur
                a.getRaisonSociale(),
                // Nombre d'offres proposées par l'annonceur
                offresFinal.size(),
                // Nombre de postes offert grâce à l'annonceur
                nbPostes
            });
        }
    }
    
    
    /**
     * Charge les lignes du tableau type contrat
     * Nom du type de contrat X, Nb d'offres du type de contrat X, Nb de postes du type de contrat X
     */
    private void refreshTableTypeContrat() {
        // On recupère le model
        DefaultTableModel model = (DefaultTableModel) tableTypeContrat.getModel();
        
        // Liste de tous les type de contrats
        ArrayList<TypeContrat> typeContrats = TypeContratDAO.lister(mainJFrame.cnx);
    
        // On vide les lignes 
        model.setRowCount(0);
        
        // Pour chaque type de contrat
        for (TypeContrat tc : typeContrats) {
            // Liste des offres du type de contrat
            ArrayList<Offre> offresFinal = OffreDAO.lister(mainJFrame.cnx, tc);
            
            // Initialisation du nb de postes à 0
            int nbPostes = 0;
            
            // Pour chaque offre du type de contrat
            for (Offre of : offresFinal) {
                // On compte le nb de potes
                nbPostes += of.getNbPoste();
            }
            
            // On ajoute la ligne au model
            model.addRow(new Object[] {
                // Libelle du type de contrat
                tc.getLibelle(),
                // Nombre d'offres ayant ce type de contrat
                offresFinal.size(),
                // Nombre de postes ayant ce type de contrat
                nbPostes
            });
        }
    }
    
    public StatistiqueForm(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
        initComponents();
    }
    
    /**
     * Creates new form StatistiqueForm
     */
    public StatistiqueForm() {
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

        buttonAccueil = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSociete = new javax.swing.JTable();
        graphAnnonceurButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDomaine = new javax.swing.JTable();
        graphDomaineButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMetier = new javax.swing.JTable();
        graphMetierButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTypeContrat = new javax.swing.JTable();
        graphTcButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        buttonAccueil.setText("Accueil");
        buttonAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAccueilActionPerformed(evt);
            }
        });

        tableSociete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Société", "Nombre d'offres", "Nombre de postes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableSociete);

        graphAnnonceurButton.setText("Graphique");
        graphAnnonceurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphAnnonceurButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(393, 393, 393)
                .addComponent(graphAnnonceurButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(graphAnnonceurButton)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Annonceur", jPanel1);

        tableDomaine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Domaine", "Nombre de métiers", "Nombre d'offres", "Nombre de postes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDomaine);

        graphDomaineButton.setText("Graphique");
        graphDomaineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphDomaineButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(graphDomaineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(graphDomaineButton)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Domaine", jPanel2);

        tableMetier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Métier", "Nombre d'offres", "Nombre de postes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableMetier);

        graphMetierButton.setText("Graphique");
        graphMetierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphMetierButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(graphMetierButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(graphMetierButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Métier", jPanel3);

        tableTypeContrat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type de contrat", "Nombre d'offres", "Nombre de postes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableTypeContrat);

        graphTcButton.setText("Graphique");
        graphTcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphTcButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(graphTcButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(graphTcButton)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Type de contrat", jPanel4);

        jScrollPane5.setViewportView(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonAccueil)
                .addGap(0, 973, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAccueil)
                .addContainerGap(491, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Clic boutton accueil
    private void buttonAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAccueilActionPerformed
        // TODO add your handling code here:
        // On renvoi sur l'accueil
        CardLayout cl = (CardLayout) mainJFrame.mainPanel.getLayout();
        cl.show(mainJFrame.mainPanel, "accueilCard");
    }//GEN-LAST:event_buttonAccueilActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        // On charge les lignes des tableaux
        refreshTableDomaine();
        refreshTableMetier();
        refreshTableAnnonceur();
        refreshTableTypeContrat();
    }//GEN-LAST:event_formComponentShown

    private void graphDomaineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphDomaineButtonActionPerformed
        // TODO add your handling code here:
        
        // Liste de tous les domaines
        ArrayList<Domaine> domaines = DomaineDAO.lister(mainJFrame.cnx);
        
        ArrayList<Metier> metiers = new ArrayList<>();      
    
        final DefaultPieDataset pieDataSet = new DefaultPieDataset();
        
        // Pour chaque domaine
        for (Domaine d : domaines) {
            // Liste des métiers du domaine
            metiers = MetierDAO.lister(mainJFrame.cnx, d);
            
            // Liste des offres du domaine (celles qui n'ont pas de métier)
            ArrayList<Offre> offresFinal = OffreDAO.lister(mainJFrame.cnx, d , null);
            
            
            // Pour chaque métier
            for (Metier m : metiers) {
                // Liste des offres du métier (et donc du domaine)
                ArrayList<Offre> offresTemp = OffreDAO.lister(mainJFrame.cnx, m);
                // Pour chaque offre du métier
                for (Offre o : offresTemp) {
                    // On l'ajoute à la liste des offres du domaine
                    offresFinal.add(o);
                }
            }
            if(!offresFinal.isEmpty()){
            pieDataSet.setValue(d.getLibelle() + " = " + offresFinal.size(), offresFinal.size());
            }
            
        }
        
        graphOpen(pieDataSet, "Nombre d'offres par Domaine");
        
    }//GEN-LAST:event_graphDomaineButtonActionPerformed

    private void graphMetierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphMetierButtonActionPerformed
        // TODO add your handling code here:
        
        
        // Liste de tous les métiers
        ArrayList<Metier> metiers = MetierDAO.lister(mainJFrame.cnx);
        
        final DefaultPieDataset pieDataSet = new DefaultPieDataset();
    

        // Pour chaque métier
        for (Metier m : metiers) {
            // On récupère les offres du métier
            ArrayList<Offre> offresFinal = OffreDAO.lister(mainJFrame.cnx, m);
            
            if(!offresFinal.isEmpty()){
            pieDataSet.setValue(m.getLibelle() + " = " + offresFinal.size(), offresFinal.size());
            }
        }
        
        graphOpen(pieDataSet, "Nombre d'offres par métiers");
    }//GEN-LAST:event_graphMetierButtonActionPerformed

    private void graphOpen(DefaultPieDataset pieDataSet, String titre){
        
        graphJFrame = new JFrame();
        graphJFrame.setTitle("Graphique");
        
        
        final JFreeChart pieChart = ChartFactory.createPieChart(titre, pieDataSet, true, true, false);
        final ChartPanel cPanel = new ChartPanel(pieChart);

        graphJFrame.add(cPanel);

        graphJFrame.pack();
        graphJFrame.setVisible(true);
        
    }
    
    
    private void graphTcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphTcButtonActionPerformed
        // TODO add your handling code here:
        
        // Liste de tous les type de contrats
        ArrayList<TypeContrat> typeContrats = TypeContratDAO.lister(mainJFrame.cnx);
        
        final DefaultPieDataset pieDataSet = new DefaultPieDataset();
        
        // Pour chaque type de contrat
        for (TypeContrat tc : typeContrats) {
            // Liste des offres du type de contrat
            ArrayList<Offre> offresFinal = OffreDAO.lister(mainJFrame.cnx, tc);
       
            if(!offresFinal.isEmpty()){
            pieDataSet.setValue(tc.getLibelle() + " = " + offresFinal.size(), offresFinal.size());
            }
        }
        
        graphOpen(pieDataSet, "Nombre d'offres par type de contrat");
    }//GEN-LAST:event_graphTcButtonActionPerformed

    private void graphAnnonceurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphAnnonceurButtonActionPerformed
        // TODO add your handling code here:
        
        // Liste de tous les type de contrats
        ArrayList<Annonceur> annconceurs = AnnonceurDAO.lister(mainJFrame.cnx);
        
        final DefaultPieDataset pieDataSet = new DefaultPieDataset();
        
        // Pour chaque type de contrat
        for (Annonceur a : annconceurs) {
            // Liste des offres du type de contrat
            ArrayList<Offre> offresFinal = OffreDAO.lister(mainJFrame.cnx, a);
       
            if(!offresFinal.isEmpty()){
            pieDataSet.setValue(a.getRaisonSociale() + " = " + offresFinal.size(), offresFinal.size());
            }
        }
        
        graphOpen(pieDataSet, "Nombre d'offres par annonceur");
    }//GEN-LAST:event_graphAnnonceurButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccueil;
    private javax.swing.JButton graphAnnonceurButton;
    private javax.swing.JButton graphDomaineButton;
    private javax.swing.JButton graphMetierButton;
    private javax.swing.JButton graphTcButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableDomaine;
    private javax.swing.JTable tableMetier;
    private javax.swing.JTable tableSociete;
    private javax.swing.JTable tableTypeContrat;
    // End of variables declaration//GEN-END:variables
}
