/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author theodore
 */
public class MainJFrame extends javax.swing.JFrame {

    private AccueilForm accueilForm;
    private OffreForm offreForm;
    private SocieteForm societeForm;
    private ParamsForm paramsForm;
    private StatistiqueForm statistiqueForm;
    
    protected Connection cnx;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();      
        loadDriver();
        String url = "jdbc:jtds:sqlserver://172.16.2.66:1433/MegaCasting;integratedSecurity=true;";
        
        try {
            
            cnx = DriverManager.getConnection(url, "sa", "Rr7u82vT");
           
            loadCardLayout();
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "accueilCard");      
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    private void loadDriver() {
        try {
             //Chargement du driver MSSQL Server
             Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException ex) { 
             ex.printStackTrace();
            } 
        }
    
    private void loadCardLayout()
    {
        // Accueil
        accueilForm = new AccueilForm(this);
        mainPanel.add(accueilForm, "accueilCard");
        // Offre
        offreForm = new OffreForm(this);
        mainPanel.add(offreForm, "offreCard");
        // Paramètres
        paramsForm = new ParamsForm(this);
        mainPanel.add(paramsForm, "paramsCard");
        // Societe
        societeForm = new SocieteForm(this);
        mainPanel.add(societeForm, "societeCard");
        // Statistique
        statistiqueForm = new StatistiqueForm(this);
        mainPanel.add(statistiqueForm, "statistiqueCard");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1020, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setAlignmentX(0.0F);
        mainPanel.setAlignmentY(0.0F);
        mainPanel.setAutoscrolls(true);
        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        mainPanel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (cnx != null) {
            try {
                cnx.close();
            } catch (SQLException ex){

            }
        }
    }//GEN-LAST:event_formWindowClosing

    protected int affichagePopUpValidation (String contenu, String titre){
        JOptionPane option = new JOptionPane();
        int retour = JOptionPane.showConfirmDialog(this,
                     contenu, 
                     titre,
                     JOptionPane.OK_CANCEL_OPTION);
        return retour;
    }
    
    protected void affichagePopUpInfo (String contenu,String titre){
        JOptionPane option = new JOptionPane();
        JOptionPane.showMessageDialog(this,
                     contenu,
                     titre,
                     JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected Boolean regexCoordonnees(String coordonnée) {
        Pattern p = Pattern.compile("^[0-9]{2}° [0-9]{2}' [N-S-E-O]{1}$");
        Matcher m = p.matcher(coordonnée);
        Boolean b = m.matches();

        return b;
    }

    protected Boolean regexReference(String reference) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_-]+$");
        Matcher m = p.matcher(reference);
        Boolean b = m.matches();

        return b;
    }

    protected Boolean regexTelephone(String telephone) {
        Pattern p = Pattern.compile("^0[1-68]([.-]?[0-9]{2}){4}$");
        Matcher m = p.matcher(telephone);
        Boolean b = m.matches();

        return b;
    }

    protected Boolean regexEmail(String email) {
        Pattern p = Pattern.compile("^[a-z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$");
        Matcher m = p.matcher(email);
        Boolean b = m.matches();

        return b;
    }
    
    protected Boolean regexNumeroSiret(String numeroSiret) {
        Pattern p = Pattern.compile("^[0-9]{14}$");
        Matcher m = p.matcher(numeroSiret);
        Boolean b = m.matches();

        return b;
    }

    protected Boolean regexRue(String rue) {
        Pattern p = Pattern.compile("^[a-zA-Z-éèëäâàüûïîöô ]*$");
        Matcher m = p.matcher(rue);
        Boolean b = m.matches();

        return b;
    }

    protected Boolean regexCodePostal(String codePostal) {
        Pattern p = Pattern.compile("^[0-9]{5}$");
        Matcher m = p.matcher(codePostal);
        Boolean b = m.matches();

        return b;
    }

    protected Boolean regexVille(String ville) {
        Pattern p = Pattern.compile("^[a-zA-Z-éèëäâàüûïîöô ]*$");
        Matcher m = p.matcher(ville);
        Boolean b = m.matches();

        return b;
    }
    
    public static String remplacementCaractere (String chaine){
        String newChaine = chaine.replaceAll("'", "''");
 
        return newChaine;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
