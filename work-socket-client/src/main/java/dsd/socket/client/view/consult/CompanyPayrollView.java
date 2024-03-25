/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dsd.socket.client.view.consult;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;
import dsd.socket.client.model.Company;
import dsd.socket.client.view.base.BaseConsultView;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public final class CompanyPayrollView extends BaseConsultView {

    private DefaultTableModel grid;

    public CompanyPayrollView() {
        initLayout();
    }

    @Override
    public void initLayout() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        grid = (DefaultTableModel) tblCompany.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompany = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Company [Consult]");

        tblCompany.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "CNPJ", "SOCIAL REASON", "AMOUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCompany.getTableHeader().setResizingAllowed(false);
        tblCompany.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCompany);
        if (tblCompany.getColumnModel().getColumnCount() > 0) {
            tblCompany.getColumnModel().getColumn(0).setResizable(false);
            tblCompany.getColumnModel().getColumn(1).setResizable(false);
            tblCompany.getColumnModel().getColumn(2).setResizable(false);
            tblCompany.getColumnModel().getColumn(3).setResizable(false);
        }

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblId.setText("ID:");

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("Search");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Companies Payroll");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatMaterialOceanicIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyPayrollView().setVisible(true);
            }
        });
    }

    public void addActionBtnSearch(ActionListener action) {
        btnSearch.addActionListener(action);
    }
    @Override
    public void clearSelection() {
        tblCompany.clearSelection();
    }

    @Override
    public void clearTable() {
        grid.setRowCount(0);
    }

    public void fillTable(List<Object[]> records) {
        for (Object[] record : records) {
            grid.addRow(record);
        }
    }

    public String getIdTableRecord() {
        int selectedRow = tblCompany.getSelectedRow();
        if (selectedRow != -1) { // Verifica se alguma linha está selecionada
            Object value = grid.getValueAt(selectedRow, 0);
            if (value != null) { // Verifica se o valor não é nulo
                return value.toString(); // Converte o valor para String
            }
        }
        return null;
        //return (String) grid.getValueAt(tblCompany.getSelectedRow(), 0);
    }

    public String getFilter() {
        return this.txtSearch.getText();
    }

    public boolean searchTable(String id) {
        int incidencia = -1;
        for (int i = 0; i < tblCompany.getRowCount(); i++) {
            if (grid.getValueAt(i, 0).equals(Integer.valueOf(id))) {
                incidencia = i;
            }
        }
        if (incidencia != -1) {
            tblCompany.setRowSelectionInterval(incidencia, incidencia);
            return true;
        } else {
            return false;
        }
    }
    
    public void clearSearch() {
        this.txtSearch.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblCompany;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
