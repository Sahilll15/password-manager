    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passwordmanager;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sahilchalke
 */
public class storepassword extends javax.swing.JFrame {
    
               String dburl="jdbc:mysql://localhost:3306/passwordManager";
             String username="root";
             String password="Chiki@1015";
             
             
             Connection con=null;
             PreparedStatement pst=null;
             ResultSet rs=null;
             int q,i,id,deleteItem;
             
     
   
    public storepassword() {
        initComponents();
    }

    
    
    
    //==================================Function=================
    
    public void upDateDB()
    {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
              con=  DriverManager.getConnection(dburl, username,password);
             String  sql="select* from StorePassword ";
//              String  sql="select ID,AccountID,Name,Username,Url,password from Storepassword";
             pst=con.prepareStatement(sql);
              rs=pst.executeQuery();
              ResultSetMetaData stData=rs.getMetaData();
               q=stData.getColumnCount();
              DefaultTableModel RecordModel=(DefaultTableModel)Tabel.getModel();
              RecordModel.setRowCount(0);
              while(rs.next())
              {
                  Vector columnData= new Vector();
                    for(i=1;i<=200;i++)
                 {
                      columnData.add(rs.getString("ID"));
                      columnData.add(rs.getString("AccountID"));
                      columnData.add(rs.getString("Name"));
                      columnData.add(rs.getString("Username"));
                      columnData.add(rs.getString("Url"));
                      columnData.add(rs.getString("Password"));
                 
                  }
                  RecordModel.addRow(columnData);
              }
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,e );
               
        }
    }
     public void upwsingleDateDB()
    {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
              con=  DriverManager.getConnection(dburl, username,password);
             String  sql="select* from StorePassword where AccountId=?"; 
//             String  sql="select (ID,AccountID,Name,Username,Url,aes_decrypt(password,'key1234')) from Storepassword";
             
pst=con.prepareStatement(sql);
              pst.setString(1, txtAcc_Id.getText()); 
              rs=pst.executeQuery();
              ResultSetMetaData stData=rs.getMetaData();
              
              q=stData.getColumnCount();
               
              DefaultTableModel RecordModel=(DefaultTableModel)Tabel.getModel();
              RecordModel.setRowCount(0);
            
         
               
              while(rs.next())
              {
                  Vector columnData= new Vector();
                  
                  for(i=1;i<=200;i++)
                 
                  {
                      columnData.add(rs.getString("ID"));
                      columnData.add(rs.getString("AccountID"));
                      columnData.add(rs.getString("Name"));
                      columnData.add(rs.getString("Username"));
                      columnData.add(rs.getString("Url"));
                      columnData.add(rs.getString("Password"));
                  }
                  RecordModel.addRow(columnData);
              }
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,e );
           
        }
    }
    
     
    
    
    
    
    //=============================End function===============
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAcc_name = new javax.swing.JTextField();
        txtAcc_Username = new javax.swing.JTextField();
        txtAcc_Url = new javax.swing.JTextField();
        txtAcc_Password = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtAcc_Id = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 7));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 7));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passwordmanager/edit.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passwordmanager/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passwordmanager/reset (1).png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passwordmanager/delete (1).png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passwordmanager/logout.png"))); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passwordmanager/eye.png"))); // NOI18N
        jButton1.setText("show");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 7));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setText("Account Username:");

        jLabel3.setText("Account name*:");

        jLabel4.setText("Account Password*:");

        jLabel5.setText("website Url:");

        txtAcc_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAcc_UsernameActionPerformed(evt);
            }
        });

        txtAcc_Url.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAcc_UrlActionPerformed(evt);
            }
        });

        txtAcc_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAcc_PasswordActionPerformed(evt);
            }
        });

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Account ID", "Account name", "Account Username", "Website Url", "Account Password"
            }
        ));
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        jLabel6.setText("Account ID*:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAcc_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtAcc_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAcc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAcc_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAcc_Url, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAcc_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAcc_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAcc_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAcc_Url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAcc_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passwordmanager/exit.png"))); // NOI18N
        jMenu1.setText("Main");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAcc_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAcc_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAcc_UsernameActionPerformed

    private void txtAcc_UrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAcc_UrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAcc_UrlActionPerformed
   
    private JFrame frame;
    
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        frame =new JFrame("Exit");

        if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to Exit","Password Manager",
                JOptionPane.YES_NO_OPTION)!=JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        else {
            
        }
       
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        
        txtAcc_Id.setText("");
        txtAcc_name.setText("");
        txtAcc_Username.setText("");
        txtAcc_Url.setText("");
        txtAcc_Password.setText("");
        
        
    }//GEN-LAST:event_btnResetActionPerformed

    public boolean addvalidate()
    {
     
        
        String Acc_id=txtAcc_Id.getText();
        String Acc_name=txtAcc_name.getText();
        String Acc_username=txtAcc_Username.getText();
//         String Acc_url=txtAcc_Url.getText();
        String Acc_password=txtAcc_Password.getText();
       
        
        
        if(Acc_id.equals(""))
        {
            JOptionPane.showMessageDialog(this, "please Enter the Acc_id name");
           return false;
        }
        
         if(Acc_name.equals("") )
        {
            JOptionPane.showMessageDialog(this, "please Enter the  Account name");
            return false;
        }
         if(username.equals(""))
         {
            JOptionPane.showMessageDialog(this, "please Enter the username");
            return false;
        }  
//        {
//            JOptionPane.showMessageDialog(this, "please Enter the username");
//            return false;
//        }
          if(Acc_password.equals(""))
        {
            JOptionPane.showMessageDialog(this, "please Enter the password");
            return false;
        }
          
          
     return true;
    }
    
    
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
     
                
        if(addvalidate())
        {
        
        
        
           try {
             Class.forName("com.mysql.cj.jdbc.Driver");
              con=  DriverManager.getConnection(dburl, username,password);
              String sql ="insert into StorePassword(AccountId,Name,Username,Url,password)values(?,?,?,?,?)";
//             String  sql="insert into StorePassword(AccountId,Name,Username,Url,password)values(?,?,?,?,aes_encrypt(?,'key1234'))";
             pst=con.prepareStatement(sql);
             pst.setString(1,txtAcc_Id.getText());
             pst.setString(2, txtAcc_name.getText());
             pst.setString(3, txtAcc_Username.getText());
             pst.setString(4, txtAcc_Url.getText());
             pst.setString(5, txtAcc_Password.getText());
             pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"RECORD INSERTED");
             upwsingleDateDB();
             }
           catch(HeadlessException | ClassNotFoundException | SQLException e)
             {
                 JOptionPane.showMessageDialog(null, e);
                   }
        }
           
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel RecordTableModel  =(DefaultTableModel)Tabel.getModel();
             int SelectedRows=Tabel.getSelectedRow();
        try {
            id = Integer.parseInt(RecordTableModel.getValueAt(SelectedRows, 0).toString());
             Class.forName("com.mysql.cj.jdbc.Driver");
              con=  DriverManager.getConnection(dburl, username,password);
             String  sql="update StorePassword set Name=?,Username=?,Url=?,Password=?,AccountID=? where ID=?";
              pst=con.prepareStatement(sql);
             pst.setString(1, txtAcc_name.getText());
             pst.setString(2, txtAcc_Username.getText());
             pst.setString(3, txtAcc_Url.getText());
             pst.setString(4, txtAcc_Password.getText());
             pst.setString(5,txtAcc_Id.getText());
//           pst.setString(6,txtAcc_Id.getText());
             pst.setInt(6, id);
             pst.executeUpdate();
              JOptionPane.showMessageDialog(this,"RECORD UPDATED");
              upDateDB();
              
              
             }
           catch(HeadlessException | ClassNotFoundException | SQLException e)
             {
                 JOptionPane.showMessageDialog(null, e);
                      
                       
                   }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordModel=(DefaultTableModel)Tabel.getModel();
             int SelectedRows=Tabel.getSelectedRow();
             
             
             txtAcc_Id.setText((String) RecordModel.getValueAt(SelectedRows, 1));
           
             txtAcc_name.setText((String) RecordModel.getValueAt(SelectedRows, 2));
             txtAcc_Username.setText((String) RecordModel.getValueAt(SelectedRows, 3));
             txtAcc_Url.setText((String) RecordModel.getValueAt(SelectedRows, 4));
             txtAcc_Password.setText((String) RecordModel.getValueAt(SelectedRows, 5));
             
    }//GEN-LAST:event_TabelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        try {
               Class.forName("com.mysql.cj.jdbc.Driver");
              con=  DriverManager.getConnection(dburl, username,password);
              Statement st=con.createStatement();
             String  query="select* from StorePassword";
//             String  query="select ID,AccountID,Name,Username,Url,cast(aes_decrypt(password,'key1234')as char(100)) from Storepassword";
             ResultSet rs=st.executeQuery(query);
          
              ResultSetMetaData rsmd=rs.getMetaData();
              
              DefaultTableModel model=(DefaultTableModel) Tabel.getModel();
              
              int cols=rsmd.getColumnCount();
              String[] colName=new String[cols];
              
              for(int i=0;i<cols;i++)
              
                colName[i]=rsmd.getColumnName(i+1);
                
                model.setColumnIdentifiers(colName);
                  
              String Acc_no,Acc_name,Acc_username,Acc_url,Acc_password;
              while(rs.next())
              {
                  Acc_no=rs.getString(1);
                   Acc_name=rs.getString(2);
                    Acc_username=rs.getString(3);
                     Acc_url=rs.getString(4);
                     Acc_password=rs.getString(5);
                     String[]row={Acc_no,Acc_name,Acc_username,Acc_url,Acc_password};
                     model.addRow(row); 
              }
              upDateDB();
              st.close();
              con.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
          DefaultTableModel RecordModel=(DefaultTableModel)Tabel.getModel();
             int SelectedRows=Tabel.getSelectedRow();
             
             
             txtAcc_Id.setText((String) RecordModel.getValueAt(SelectedRows, 1));
           
             txtAcc_name.setText((String) RecordModel.getValueAt(SelectedRows, 2));
             txtAcc_Username.setText((String) RecordModel.getValueAt(SelectedRows, 3));
             txtAcc_Url.setText((String) RecordModel.getValueAt(SelectedRows, 4));
             txtAcc_Password.setText((String) RecordModel.getValueAt(SelectedRows, 5));
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
            DefaultTableModel RecordTableModel  =(DefaultTableModel)Tabel.getModel();
            int SelectedRows=Tabel.getSelectedRow();
             
             try {
            
             id = Integer.parseInt(RecordTableModel.getValueAt(SelectedRows, 0).toString());
               
            deleteItem=JOptionPane.showConfirmDialog(null,"Confirm if you want to delete","Warning",JOptionPane.YES_NO_OPTION);
            
            if(deleteItem==JOptionPane.YES_OPTION)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
              con=  DriverManager.getConnection(dburl, username,password);
             String  sql="delete from StorePassword where ID=?";
                 pst=con.prepareStatement(sql);
                 
                 pst.setInt(1, id);
                 pst.executeUpdate();
                 
                 JOptionPane.showMessageDialog(this,"Record Deleted");
                 upDateDB();
                 
                 txtAcc_Id.setText("");
//               txtAcc_Id.requestFocus();
                 txtAcc_name.setText("");
                 txtAcc_Username.setText("");
                 txtAcc_Url.setText("");
                 txtAcc_Password.setText("");
            }
            
               
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
                 System.err.println(e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
          new Main().setVisible(true);
          this.dispose();
         
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
         // TODO add your handling code here:
         
         
       
        
        
        
        
    }//GEN-LAST:event_jMenu1MousePressed

    private void txtAcc_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAcc_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAcc_PasswordActionPerformed

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
            java.util.logging.Logger.getLogger(storepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(storepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(storepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(storepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new storepassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAcc_Id;
    private javax.swing.JTextField txtAcc_Password;
    private javax.swing.JTextField txtAcc_Url;
    private javax.swing.JTextField txtAcc_Username;
    private javax.swing.JTextField txtAcc_name;
    // End of variables declaration//GEN-END:variables
}
