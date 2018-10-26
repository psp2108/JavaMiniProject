/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayconcession;
import dbInterface.*;
import java.awt.Color;
import javax.swing.JOptionPane;

public class ViewApplicationStatus extends javax.swing.JFrame {

    static RequestApplicationForm Request = null;

    /**
     * Creates new form ViewApplicationStatus
     */
    public ViewApplicationStatus() {
        initComponents();
        if (RequestApplicationForm.Status == null) {
            RequestApplicationForm.Status = this;
        }
        if (ViewApplicationStatusClass.fetchStatus()) {
            NameIP.setText(ViewApplicationStatusClass.Name);
            SapIP.setText(CommonDataSet.SapId);
            StationToIP.setText(ViewApplicationStatusClass.StationTo);
            StationFromIP.setText(ViewApplicationStatusClass.StationFrom);
            EmailIP.setText(ViewApplicationStatusClass.Email);
            DepartmentIP.setText(ViewApplicationStatusClass.Department);
            if (ViewApplicationStatusClass.Class == 1) {
                ClassIP.setText("First Class");
            } else {
                ClassIP.setText("Second Class");
            }
            
            switch (ViewApplicationStatusClass.Status){
                case -1:
                    AcceptanceStatusLabel.setText("Rejected");
                    AcceptanceStatusLabel.setBackground(Color.red);
                    AcceptanceStatusLabel.setForeground(Color.white);
                    break;
                case 0:
                    AcceptanceStatusLabel.setText("Pending");
                    AcceptanceStatusLabel.setBackground(Color.blue);
                    AcceptanceStatusLabel.setForeground(Color.white);
                    break;
                case 1:
                    AcceptanceStatusLabel.setText("Accepted");
                    AcceptanceStatusLabel.setBackground(Color.green);
                    AcceptanceStatusLabel.setForeground(Color.black);
                    break;
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Databse Connectivity Error");
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        NameLabel = new javax.swing.JLabel();
        SapLabel = new javax.swing.JLabel();
        StationToLabel = new javax.swing.JLabel();
        StationFromLabel = new javax.swing.JLabel();
        DepartmentLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        ClassLabel = new javax.swing.JLabel();
        SapIP = new javax.swing.JTextField();
        StationToIP = new javax.swing.JTextField();
        StationFromIP = new javax.swing.JTextField();
        EmailIP = new javax.swing.JTextField();
        DepartmentIP = new javax.swing.JTextField();
        NameIP = new javax.swing.JTextField();
        ClassIP = new javax.swing.JTextField();
        AcceptanceStatusLabel = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("APPLICATION REQUEST STATUS");
        jLabel1.setName(""); // NOI18N

        NameLabel.setText("Name");

        SapLabel.setText("SAP");

        StationToLabel.setText("Station To");

        StationFromLabel.setText("Station From");

        DepartmentLabel.setText("Department");

        EmailLabel.setText("Email");

        ClassLabel.setText("Class");

        SapIP.setEditable(false);
        SapIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SapIPActionPerformed(evt);
            }
        });

        StationToIP.setEditable(false);
        StationToIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StationToIPActionPerformed(evt);
            }
        });

        StationFromIP.setEditable(false);
        StationFromIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StationFromIPActionPerformed(evt);
            }
        });

        EmailIP.setEditable(false);
        EmailIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailIPActionPerformed(evt);
            }
        });

        DepartmentIP.setEditable(false);
        DepartmentIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentIPActionPerformed(evt);
            }
        });

        NameIP.setEditable(false);
        NameIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameIPActionPerformed(evt);
            }
        });

        ClassIP.setEditable(false);
        ClassIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassIPActionPerformed(evt);
            }
        });

        AcceptanceStatusLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        AcceptanceStatusLabel.setText("Not Appled");

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClassLabel)
                            .addComponent(NameLabel)
                            .addComponent(SapLabel)
                            .addComponent(StationToLabel)
                            .addComponent(StationFromLabel)
                            .addComponent(EmailLabel)
                            .addComponent(DepartmentLabel))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DepartmentIP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailIP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StationFromIP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SapIP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StationToIP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NameIP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClassIP, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BackBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AcceptanceStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(NameIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SapLabel)
                    .addComponent(SapIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StationToLabel)
                    .addComponent(StationToIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StationFromLabel)
                    .addComponent(StationFromIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepartmentLabel)
                    .addComponent(DepartmentIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClassLabel)
                    .addComponent(ClassIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AcceptanceStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SapIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SapIPActionPerformed

    private void StationToIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StationToIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StationToIPActionPerformed

    private void StationFromIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StationFromIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StationFromIPActionPerformed

    private void EmailIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailIPActionPerformed

    private void DepartmentIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepartmentIPActionPerformed

    private void NameIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameIPActionPerformed

    private void ClassIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClassIPActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        if (Request == null) {
            Request = new RequestApplicationForm();

        }
        Request.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewApplicationStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewApplicationStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewApplicationStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewApplicationStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewApplicationStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AcceptanceStatusLabel;
    private javax.swing.JButton BackBtn;
    private javax.swing.JTextField ClassIP;
    private javax.swing.JLabel ClassLabel;
    private javax.swing.JTextField DepartmentIP;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JTextField EmailIP;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField NameIP;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField SapIP;
    private javax.swing.JLabel SapLabel;
    private javax.swing.JTextField StationFromIP;
    private javax.swing.JLabel StationFromLabel;
    private javax.swing.JTextField StationToIP;
    private javax.swing.JLabel StationToLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
