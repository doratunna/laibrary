/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DatabaseConnection;

/**
 *
 * @author Sith7
 */
public class View_Books extends javax.swing.JFrame {

    /**
     * Creates new form View_Books
     */
    public View_Books() {
        initComponents();
        SearchBooks();
    }
    
    
    
     public void SearchBooks(){
  
                String[] columnNames={"id","Refno","name","author","publisher","quantity","issued","added_date"};
                DefaultTableModel tm=new DefaultTableModel();
                tm.setColumnIdentifiers(columnNames);
                table.setModel(tm);
                
                String id="";
                String Refno="";
                String name="";
                String author="";
                String publisher="";
                String quantity="";
                String issued="";
                String added_date="";
                
                
                try
                {   
                    DatabaseConnection ob = new DatabaseConnection();
                    Connection con = ob.getConnection();
                     String sql = "select * from Books"; 
                     PreparedStatement ps = con.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery() ;
                     int i=0 ;
                      
                     if(rs.next())
                     {
                         id = rs.getString("id");
                         Refno =rs.getString("Refno");
                         name =rs.getString("name");
                         author =rs.getString("author");
                          publisher =rs.getString("publisher");
                           quantity =rs.getString("quantity");
                            issued =rs.getString("issued");
                             added_date =rs.getString("added_date");
                         
                         
                         tm.addRow(new Object[]{id, Refno ,name , author,publisher,quantity,issued,added_date});
                         i++;
                     }
                     if(i<1)
                     {
                         JOptionPane.showMessageDialog(null, "No records ","Error",JOptionPane.ERROR_MESSAGE);
                     }
                     if(i==1)
                     {
                         System.out.println("Found 1");
                     }
                     else
                     {System.out.println("Found 2");
                     }
                }
                catch(Exception e)
                {System.out.println("Error "+e);
                }
                
                
                }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollpane.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(View_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}