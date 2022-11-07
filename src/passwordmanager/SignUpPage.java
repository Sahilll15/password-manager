/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passwordmanager;





import java.sql.*;
import java.awt.Color;
import java.awt.Container;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;



/**
 *
 * @author sahilchalke
 */
public class SignUpPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUpPage
     * @throws java.sql.SQLException
     */
    public SignUpPage() throws SQLException {
        Container c=getContentPane();
        c.setBackground( new Color(0,153,204));
        initComponents();
    }
    
    int id=0;
    public int getId()
    {
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
               String dburl="jdbc:mysql://localhost:3306/passwordManager";
             String username="root";
             String password="Chiki@1015";
             
        Connection con=  DriverManager.getConnection(dburl, username,password);
         
         String sql="select mac(id) from signup ";
         Statement st=con.createStatement();
          rs=st.executeQuery(sql);
         while(rs.next())
         {
          
             id=rs.getInt(1);
             id++;
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    
   public static boolean checkpass(String password)
   {
       
       boolean hasNum=false;
       boolean hasCap=false;
       boolean hasLow=false;
       char c;
       for(int i=0;i<password.length();i++)
       {
           c=password.charAt(i);
           if(Character.isDigit(c))
           /**/          {
               hasNum=true;
           
           }
           
           else if(Character.isUpperCase(c))
                   {
                       hasCap=true;
                   }
           else if(Character.isLowerCase(c))
           {
               hasLow=true;
           }
           if(hasNum &&hasLow &&hasCap)
           {
               return true;
           }
           
       }
       return false;
       
   }
    
   public static boolean hasSpecialChar(String password)
   {
       Pattern sPattern= Pattern.compile("[a-zA-Z0-9]*");
       
       Matcher sMatcher=sPattern.matcher(password);
       
       if(!sMatcher.matches())
       {
           return true;
       }
       
        return false;
       
   }
    
    public boolean validation()
    {
        String firstname,lastname,username,password,confrimpassword;
        firstname=txtfirstname.getText();
        lastname=txtlastname.getText();
        username=txtusername.getText();
        password=txtpassword.getText();
        confrimpassword=txtconfrimpassword.getText();
        
        if(firstname.equals(""))
        {
            JOptionPane.showMessageDialog(this, "please Enter the First name");
            return false;
        }
         if(lastname.equals(""))
        {
            JOptionPane.showMessageDialog(this, "please Enter the Last name");
            return false;
        }
          if(username.equals(""))
        {
            JOptionPane.showMessageDialog(this, "please Enter the username");
            return false;
        } if(password.equals(""))
        {
            JOptionPane.showMessageDialog(this, "please Enter the password");
            return false;
        }
         if(password.length()>8)
         {
             
         }
         else
         {
             JOptionPane.showMessageDialog(this, "Toosmall");
             
             return false;
         } 
         if(checkpass(password)==false)
         {
             JOptionPane.showMessageDialog(null, "Password must contain number,Uppercase and Lower case");
             return false;
         }
         if(hasSpecialChar(password)==false)
         {
             JOptionPane.showMessageDialog(null, "Password must Contain an Special character");
             return false;
         }
         
         
         if(confrimpassword.equals(""))
        {
            JOptionPane.showMessageDialog(this, "please Enter the First name");
            return false;
        }
         if(!password.equals(confrimpassword))
         {
              JOptionPane.showMessageDialog(this, "password not matched");
              return false;
             
         }
        
         return true;    
    }
    
    public void insertDetails() throws SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
               String dburl="jdbc:mysql://localhost:3306/passwordManager";
             String username="root";
             String password="Chiki@1015";
             
        Connection con=  DriverManager.getConnection(dburl, username,password);
         
         String sql="insert into signup(ID,firstname,lastname,username,password,contact_no) values(?,?,?,?,?,?)";
//         String sql="insert into signup (firstname,lastname,username,password,contact_no) values ('?','?','?',aes_encrypt(\"?\",'key1234'),?);";
         
         PreparedStatement pst=con.prepareStatement(sql);
         
          pst.setInt(1, getId());
          pst.setString(2, txtfirstname.getText());
          pst.setString(3, txtlastname.getText());
          pst.setString(4, txtusername.getText());
          pst.setString(5, txtpassword.getText());
          pst.setString(6, txtcontactno.getText());
          
       
          int rows=pst.executeUpdate();
          if(rows>0)
          {
              JOptionPane.showMessageDialog(this, "Congratulation,Registration complete!!");
          }else
          {
              JOptionPane.showMessageDialog(this, "Registration failed!!");
          }
          
    
    
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtfirstname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcontactno = new javax.swing.JTextField();
        txtlastname = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        btnSIgnUp = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtconfrimpassword = new javax.swing.JPasswordField();
        txtpassword = new javax.swing.JPasswordField();
        checkbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Sign Up");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 660, 3));

        txtfirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfirstnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtfirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 250, 30));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("First Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Mobile No:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 160, 80));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Last Name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 90));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Username:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 120, 90));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("password:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, 90));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Confirm password:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 160, 90));

        txtcontactno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontactnoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcontactno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 250, 30));

        txtlastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlastnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtlastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 250, 30));

        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 250, 30));

        btnSIgnUp.setText("Sign Up");
        btnSIgnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIgnUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnSIgnUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 110, 30));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 100, 30));
        jPanel1.add(txtconfrimpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 250, 30));

        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 250, 30));

        checkbox.setForeground(new java.awt.Color(255, 255, 255));
        checkbox.setText("View password");
        checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxActionPerformed(evt);
            }
        });
        jPanel1.add(checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 660, 420));

        setSize(new java.awt.Dimension(783, 492));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtfirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfirstnameActionPerformed

    private void txtcontactnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontactnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactnoActionPerformed

    private void txtlastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlastnameActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void btnSIgnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIgnUpActionPerformed
        // TODO add your handling code here:
       if( validation())
       {
           try {
               insertDetails();
           } catch (SQLException ex) {
               Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_btnSIgnUpActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxActionPerformed
        // TODO add your handling code here:
        
        
        if(checkbox.isSelected())
        {
            txtpassword.setEchoChar((char)0);
        }
        else
        {
             txtpassword.setEchoChar('*');
           
        }
        
        
        
    }//GEN-LAST:event_checkboxActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    new SignUpPage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSIgnUp;
    private javax.swing.JCheckBox checkbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtconfrimpassword;
    private javax.swing.JTextField txtcontactno;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
