/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dsd.socket.client.view;

import dsd.socket.client.infra.observer.RequestObserver;
import dsd.socket.client.infra.socket.WorkSocketClient;
import dsd.socket.client.view.base.BaseView;
import java.awt.event.ActionListener;

/**
 *
 * @author Matheus
 */
public class MainView extends BaseView implements RequestObserver {

    /**
     * Creates new form MainView
     */
    public MainView() {
        WorkSocketClient.getInstance().registerObserver(this);
        initLayout();
    }

    @Override
    public void initLayout() {
        initComponents();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
    }

    public void addActionBtnCompanyConsult(ActionListener acao) {
        miCompanyConsult.addActionListener(acao);
    }

    public void addActionBtnCompanyRegister(ActionListener acao) {
        miCompanyRegister.addActionListener(acao);
    }

    public void addActionBtnCompanyPayroll(ActionListener acao) {
        miCompanyPayroll.addActionListener(acao);
    }

    public void addActionBtnCompanyReceivable(ActionListener acao) {
        miCompanyReceivable.addActionListener(acao);
    }

    public void addActionBtnCustomerConsult(ActionListener acao) {
        miCustomerConsult.addActionListener(acao);
    }

    public void addActionBtnCustomerRegister(ActionListener acao) {
        miCustomerRegister.addActionListener(acao);
    }

    public void addActionBtnCustomerPayment(ActionListener acao) {
        miCustomerPayment.addActionListener(acao);
    }

    public void addActionBtnEmployeeConsult(ActionListener acao) {
        miEmployeeConsult.addActionListener(acao);
    }

    public void addActionBtnEmployeeRegister(ActionListener acao) {
        miEmployeeRegister.addActionListener(acao);
    }

    @Override
    public void update(String message) {
        this.txtLog.append(message + "\n" + "\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        lxlLogInformation = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        muCompany = new javax.swing.JMenu();
        miCompanyConsult = new javax.swing.JMenuItem();
        miCompanyRegister = new javax.swing.JMenuItem();
        miCompanyPayroll = new javax.swing.JMenuItem();
        miCompanyReceivable = new javax.swing.JMenuItem();
        muCustomer = new javax.swing.JMenu();
        miCustomerConsult = new javax.swing.JMenuItem();
        miCustomerRegister = new javax.swing.JMenuItem();
        miCustomerPayment = new javax.swing.JMenuItem();
        muEmployee = new javax.swing.JMenu();
        miEmployeeConsult = new javax.swing.JMenuItem();
        miEmployeeRegister = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtLog.setEditable(false);
        txtLog.setColumns(20);
        txtLog.setFont(new java.awt.Font("Liberation Mono", 0, 14)); // NOI18N
        txtLog.setForeground(new java.awt.Color(0, 153, 153));
        txtLog.setLineWrap(true);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        lxlLogInformation.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lxlLogInformation.setText("Log Information");

        muCompany.setText("Company");

        miCompanyConsult.setText("Consult");
        muCompany.add(miCompanyConsult);

        miCompanyRegister.setText("Register");
        muCompany.add(miCompanyRegister);

        miCompanyPayroll.setText("Payroll");
        muCompany.add(miCompanyPayroll);

        miCompanyReceivable.setText("Receivable");
        muCompany.add(miCompanyReceivable);

        jMenuBar1.add(muCompany);

        muCustomer.setText("Customer");

        miCustomerConsult.setText("Consult");
        muCustomer.add(miCustomerConsult);

        miCustomerRegister.setText("Register");
        muCustomer.add(miCustomerRegister);

        miCustomerPayment.setText("Payment");
        muCustomer.add(miCustomerPayment);

        jMenuBar1.add(muCustomer);

        muEmployee.setText("Employee");

        miEmployeeConsult.setText("Consult");
        muEmployee.add(miEmployeeConsult);

        miEmployeeRegister.setText("Register");
        muEmployee.add(miEmployeeRegister);

        jMenuBar1.add(muEmployee);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lxlLogInformation)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lxlLogInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lxlLogInformation;
    private javax.swing.JMenuItem miCompanyConsult;
    private javax.swing.JMenuItem miCompanyPayroll;
    private javax.swing.JMenuItem miCompanyReceivable;
    private javax.swing.JMenuItem miCompanyRegister;
    private javax.swing.JMenuItem miCustomerConsult;
    private javax.swing.JMenuItem miCustomerPayment;
    private javax.swing.JMenuItem miCustomerRegister;
    private javax.swing.JMenuItem miEmployeeConsult;
    private javax.swing.JMenuItem miEmployeeRegister;
    private javax.swing.JMenu muCompany;
    private javax.swing.JMenu muCustomer;
    private javax.swing.JMenu muEmployee;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables

}
