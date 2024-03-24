/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dsd.socket.client.view.register;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;
import dsd.socket.client.view.base.BaseRegisterView;
import java.awt.event.ActionListener;

/**
 *
 * @author Matheus
 */
public final class CompanyRegisterView extends BaseRegisterView {

    public CompanyRegisterView() {
        initLayout();
    }

    @Override
    public void initLayout() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(880, 300);
    }
    
    public void addActionBtnRegister(ActionListener action) {
        btnRegister.addActionListener(action);
    }
    
    public void addActionBtnUpdate(ActionListener action) {
        btnUpdate.addActionListener(action);
    }
    
    public void addActionBtnCancel(ActionListener action) {
        btnCancel.addActionListener(action);
    }
    
    public void initializeRegister() {
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
    }
    
    public void initializeUpdate() {
        btnRegister.setEnabled(false);
        btnRegister.setVisible(false);
    }
    
    @Override
    public void showFrame() {
        super.showFrame();
    }
    
    public String getId() {
        return this.txtId.getText();
    }
    
    public void setId(String id) {
        this.txtId.setText(id);
    }
    
    public String getCnpj() {
        return this.txtCnpj.getText();
    }
    
    public void setCnpj(String cnpj) {
        this.txtCnpj.setText(cnpj);
    }
    
    public String getSocialReason() {
        return this.txtSocialReason.getText();
    }
    
    public void setSocialReason(String socialReason) {
        this.txtSocialReason.setText(socialReason);
    }
    
    public String getFoundedYear() {
        return this.txtFoundedYear.getText();
    }
    
    public void setFoundedYear(String foundedYear) {
        this.txtFoundedYear.setText(foundedYear);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtSocialReason = new javax.swing.JTextField();
        lblSocialReason = new javax.swing.JLabel();
        txtFoundedYear = new javax.swing.JTextField();
        lblFoundedYear = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Company [Register]");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Register Company");

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblId.setText("ID");

        txtCnpj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblCnpj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCnpj.setText("CNPJ");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSocialReason.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblSocialReason.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSocialReason.setText("Social Reason");

        txtFoundedYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblFoundedYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFoundedYear.setText("FOUNDED YEAR");

        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegister.setText("Register");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("Cancel");

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFoundedYear)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFoundedYear, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(lblId)
                            .addComponent(txtId))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCnpj))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSocialReason)
                                    .addComponent(txtSocialReason, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(392, 392, 392)
                                .addComponent(btnRegister)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblCnpj)
                    .addComponent(lblSocialReason))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSocialReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblFoundedYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFoundedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMaterialOceanicIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyRegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblFoundedYear;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblSocialReason;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtFoundedYear;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSocialReason;
    // End of variables declaration//GEN-END:variables
}
