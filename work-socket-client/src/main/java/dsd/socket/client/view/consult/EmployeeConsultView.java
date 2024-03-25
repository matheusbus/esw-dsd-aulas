/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dsd.socket.client.view.consult;

import dsd.socket.client.model.Customer;
import dsd.socket.client.model.Employee;
import dsd.socket.client.view.base.BaseConsultView;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public final class EmployeeConsultView extends BaseConsultView {

    private DefaultTableModel grid;

    public EmployeeConsultView() {
        initLayout();
    }

    @Override
    public void initLayout() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        grid = (DefaultTableModel) tblCustomer.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        lblCpf = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee [Consult]");

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CPF", "NAME", "ADDRESS", "POSITION", "SALARY", "ACTIVE", "COMPANY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomer.getTableHeader().setResizingAllowed(false);
        tblCustomer.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCustomer);
        if (tblCustomer.getColumnModel().getColumnCount() > 0) {
            tblCustomer.getColumnModel().getColumn(0).setResizable(false);
            tblCustomer.getColumnModel().getColumn(1).setResizable(false);
            tblCustomer.getColumnModel().getColumn(2).setResizable(false);
            tblCustomer.getColumnModel().getColumn(3).setResizable(false);
            tblCustomer.getColumnModel().getColumn(4).setResizable(false);
            tblCustomer.getColumnModel().getColumn(5).setResizable(false);
        }

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCpf.setText("CPF:");

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("Search");

        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegister.setText("Register");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("Update");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Employees");

        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemove.setText("Remove");

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefresh.setText("R");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnSearch)
                                .addGap(36, 36, 36)
                                .addComponent(btnRegister)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh)
                                .addGap(55, 55, 55)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemove)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnRegister)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addActionBtnRegister(ActionListener action) {
        btnRegister.addActionListener(action);
    }

    public void addActionBtnUpdate(ActionListener action) {
        btnUpdate.addActionListener(action);
    }

    public void addActionBtnRemove(ActionListener action) {
        btnRemove.addActionListener(action);
    }

    public void addActionBtnSearch(ActionListener action) {
        btnSearch.addActionListener(action);
    }
    
    public void addActionBtnRefresh(ActionListener action) {
        btnRefresh.addActionListener(action);
    }

    @Override
    public void clearSelection() {
        tblCustomer.clearSelection();
    }

    @Override
    public void clearTable() {
        grid.setRowCount(0);
    }

    public void fillTable(Map<String, Employee> employees) {
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            grid.addRow(entry.getValue().getData());
        }
    }

    public String getIdTableRecord() {
        int selectedRow = tblCustomer.getSelectedRow();
        if (selectedRow != -1) {
            Object value = grid.getValueAt(selectedRow, 0);
            if (value != null) {
                return value.toString();
            }
        }
        return null;
    }

    public String getFilter() {
        return this.txtSearch.getText();
    }

    public boolean searchTable(String id) {
        int incidencia = -1;
        for (int i = 0; i < tblCustomer.getRowCount(); i++) {
            if (grid.getValueAt(i, 0).equals(id)) {
                incidencia = i;
            }
        }
        if (incidencia != -1) {
            tblCustomer.setRowSelectionInterval(incidencia, incidencia);
            return true;
        } else {
            return false;
        }
    }
    
    public void clearSearch() {
        this.txtSearch.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
