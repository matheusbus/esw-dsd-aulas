/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dsd.socket.client.view.register;

import dsd.socket.client.view.base.BaseRegisterView;
import java.awt.event.ActionListener;

/**
 *
 * @author Matheus
 */
public final class EmployeeRegisterView extends BaseRegisterView {

    public EmployeeRegisterView() {
        initLayout();
    }

    @Override
    public void initLayout() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(880, 450);
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
        txtId.setEditable(false);
        txtCpf.setEditable(false);
        btnRegister.setEnabled(false);
        btnRegister.setVisible(false);
    }
    
    @Override
    public void showFrame() {
        super.showFrame();
    }
    
    public String getCpf() {
        return this.txtCpf.getText();
    }
    
    public void setCpf(String cpf) {
        this.txtCpf.setText(cpf);
    }
    
    public String getName() {
        return this.txtName.getText();
    }
    
    public void setName(String name) {
        this.txtName.setText(name);
    }
    
    public String getAddress() {
        return this.txtAddress.getText();
    }
    
    public void setAddress(String address) {
        this.txtAddress.setText(address);
    }
    
    public String getPosition() {
        return this.txtPosition.getText();
    }
    
    public void setPosition(String position) {
        this.txtPosition.setText(position);
    }
    
    public String getSalary() {
        return this.txtSalary.getText();
    }
    
    public void setSalary(String balanceDue) {
        this.txtSalary.setText(balanceDue);
    }
    
    public Boolean getActive() {
        return this.cbActive.getSelectedIndex() == 0;
    }
    
    public void setActive(Boolean active) {
        if(active) {
            this.cbActive.setSelectedIndex(0);
        } else {
            this.cbActive.setSelectedIndex(1);
        }
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
        txtCpf = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        lblPosition = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        lblSalary = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        cbActive = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee [Register]");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Register Employee");

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblId.setText("ID");

        txtCnpj.setEditable(false);
        txtCnpj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblCnpj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCnpj.setText("CNPJ");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSocialReason.setEditable(false);
        txtSocialReason.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblSocialReason.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSocialReason.setText("Social Reason");

        txtFoundedYear.setEditable(false);
        txtFoundedYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblFoundedYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFoundedYear.setText("FOUNDED YEAR");

        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegister.setText("Register");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("Update");

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setText("Cancel");

        txtCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCpf.setText("CPF");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setText("Name");

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAddress.setText("Address");

        txtPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblPosition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPosition.setText("Position");

        txtSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblSalary.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSalary.setText("Salary");

        lblActive.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblActive.setText("Active");

        cbActive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TRUE", "FALSE" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFoundedYear)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFoundedYear)
                                    .addComponent(lblId)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCnpj))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSocialReason)
                                            .addComponent(txtSocialReason, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegister)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancel)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf)
                            .addComponent(lblTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblName)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAddress)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbActive, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblActive)
                                            .addGap(216, 216, 216)))))
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPosition)
                            .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalary)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(322, 322, 322))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(lblName)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPosition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalary)
                            .addComponent(lblActive))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSalary)
                            .addComponent(cbActive))))
                .addGap(29, 29, 29)
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
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbActive;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblFoundedYear;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblSocialReason;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtFoundedYear;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtSocialReason;
    // End of variables declaration//GEN-END:variables
}
