/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import com.sun.glass.events.KeyEvent;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Hyrex
 */
public class Login extends javax.swing.JFrame {
Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
         conn=db.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
        currentDate();
    }
 public void currentDate (){
        
        Calendar cal =new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        txt_date.setText((month+1)+"/"+day+"/"+year);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_combo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        txt_date = new javax.swing.JMenu();
        txt_time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel2.setText("Username :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 280, 70, 14);

        jLabel3.setText("Password :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 320, 70, 14);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(180, 390, 70, 30);
        jPanel1.add(txt_username);
        txt_username.setBounds(90, 270, 160, 30);
        jPanel1.add(txt_password);
        txt_password.setBounds(90, 310, 160, 30);

        txt_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin" }));
        jPanel1.add(txt_combo);
        txt_combo.setBounds(90, 350, 160, 30);

        jLabel4.setText("Division :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 360, 50, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/bk4.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 660, 430);

        txt_date.setText("Date");
        jMenuBar1.add(txt_date);

        txt_time.setText("Time");
        jMenuBar1.add(txt_time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          String sql = "select id,username,password,division from Users Where (username =? and password =? and division =?)";
                
               
        try{
           int count =0;
         
           pst=conn.prepareStatement(sql);
           
           
           pst.setString(1,txt_username.getText());
           pst.setString(2,txt_password.getText());
           pst.setString(3, txt_combo.getSelectedItem().toString());

           rs=pst.executeQuery();
           
           {
           }
           while(rs.next()){
               int id = rs.getInt(1);
               Emp.empId = id;
               count =count+1;
           }
          String access=(txt_combo.getSelectedItem().toString());
            
          
           
           if(access=="Admin") {
           
               if(count==1){
                   JOptionPane.showMessageDialog(null,"Sucess" );
                   MainMenu j = new MainMenu();
                   j.setVisible(true);
                   this.dispose();
                   
                   
                    Date currentDate = GregorianCalendar.getInstance().getTime();
                  DateFormat df = DateFormat.getDateInstance();
                  String dateString = df.format(currentDate);

                  Date d = new Date();
                  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                  String timeString = sdf.format(d);

                  String value0 = timeString;
                  String values = dateString;
                   
                   
                   int value = Emp.empId;
                   String reg = "insert into Audit (emp_id,date,status) values ('"+value+"','"+value0+" / "+values+"','Logged in')";
                   pst=conn.prepareStatement(reg);
                   pst.execute();
                   this.dispose();
                   
           
           }
               
           
           
           else if(count>1){
                   JOptionPane.showMessageDialog(null,"Duplicate Username or Password Access denied");
                   }
           else{
               JOptionPane.showMessageDialog(null,"Username and Password is not correct");
           }   
           }
                
        } catch(Exception e)

        {
             JOptionPane.showMessageDialog(null, e);

        }
        finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
                
            }
        
        }
    
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> txt_combo;
    private javax.swing.JMenu txt_date;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JMenu txt_time;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}