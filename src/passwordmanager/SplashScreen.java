package passwordmanager;



import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author sahilchalke
 */
public class SplashScreen extends javax.swing.JFrame {

//    private static void DISPOSE_ON_CLOSE(boolean b) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        initComponents();
    }

   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoadingBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Loadingbar = new javax.swing.JProgressBar();
        LoadingLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Loadingvalue = new javax.swing.JLabel();

        LoadingBar.setBackground(new java.awt.Color(51, 153, 255));
        LoadingBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/password.png"))); // NOI18N
        LoadingBar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 98, -1, -1));
        LoadingBar.add(Loadingbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 495, 850, -1));

        LoadingLabel.setBackground(new java.awt.Color(255, 255, 255));
        LoadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoadingLabel.setText("Loding...");
        LoadingBar.add(LoadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 472, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password Manager");
        LoadingBar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 360, 443, -1));

        Loadingvalue.setForeground(new java.awt.Color(255, 255, 255));
        Loadingvalue.setText("0%");
        LoadingBar.add(Loadingvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 472, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       
        SplashScreen sp=new SplashScreen();
        sp.setVisible(true);
        
        try {
            for (int i = 0; i <101; i++) {
                Thread.sleep(40);
                sp.Loadingvalue.setText(i+"%");
                
                if(i==10)
                {
                    sp.LoadingLabel.setText("Turning On Moduels...");
                }
                if(i==20)
                {
                    sp.LoadingLabel.setText("Loading Modules....");
                }
                if(i==50)
                {
                    sp.LoadingLabel.setText("Connecting to the Database");
                }
                if(i==70)
                {
                    sp.LoadingLabel.setText("Connection SuccessFull");
                }
                if(i==80)
                {
                    sp.LoadingLabel.setText("Application Launching");
                }
                sp.Loadingbar.setValue(i);
                
                if(i==100)
                {
                    
                 new passwordmanager.Login().setVisible(true);
                 sp.dispose();
                
                }
         
            }
          
            
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, e);
                    
        }
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JProgressBar Loadingbar;
    private javax.swing.JLabel Loadingvalue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
