/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eq.point.of.sale.system;

import eq.point.of.sale.system.DBConnection.DBConnection;
import eq.point.of.sale.system.Queries.UserManagement;
import static eq.point.of.sale.system.Queries.UserManagement.rs;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author billy
 */
public class frmUserManagement extends javax.swing.JPanel {

    UserManagement db = new UserManagement();
    DBConnection DBCon = new DBConnection("localhost", "3306", "eqpos", "root", "001995234");
    String Account_ID;

    /**
     * Creates new form frmUserManagement
     */
    public frmUserManagement() {
        initComponents();
        cbAccessType.setSelectedIndex(-1);
        Access();
    }

    private void Access() {
        if (frmLogin.AccessType.equals("Cashier")) {
            txtPassword.setEditable(true);
            ReFreshAccounts();
            txtFname.setEditable(true);
            txtLname.setEditable(true);
            txtUsername.setEditable(true);
            txtPassword.setEditable(true);
            cbAccessType.setEnabled(true);
        } else if (frmLogin.AccessType.equals("Sales Rep")) {
            ReFreshAccountsUser();
            tblUser.removeColumn(tblUser.getColumnModel().getColumn(4));
            txtFname.setEditable(false);
            txtLname.setEditable(false);
            txtUsername.setEditable(false);
            txtPassword.setEditable(false);
            cbAccessType.setEnabled(false);
            btnCreate.setEnabled(false);
            btnActive.setEnabled(false);
            btnClear.setEnabled(true);
            btnDelete.setEnabled(false);
            btnUpdate.setEnabled(false);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnActive = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbAccessType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblInsentives = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        tblUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblUser.setRowHeight(30);
        tblUser.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        btnCreate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemIcons/AddAccount.png"))); // NOI18N
        btnCreate.setText("Create");
        btnCreate.setEnabled(false);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemIcons/Update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemIcons/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnActive.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnActive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemIcons/Access.png"))); // NOI18N
        btnActive.setText("Active");
        btnActive.setEnabled(false);
        btnActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActiveActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemIcons/Clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActive, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("First Name :");

        txtFname.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        txtLname.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Last Name :");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Username :");

        txtUsername.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Password :");

        txtPassword.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setText("Access Type :");

        cbAccessType.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cbAccessType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cashier", "Sale Rep" }));
        cbAccessType.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbAccessTypePopupMenuWillBecomeVisible(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Status :");

        lblStatus.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblStatus.setText("De-Active");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Insentives:");

        lblInsentives.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblInsentives.setText("null");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblInsentives, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbAccessType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtLname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFname, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLname)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbAccessType)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInsentives, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
private void ReFreshAccounts() {
        try {
            DBCon.Open();
            db.ReadAccounts();
            tblUser.setModel(DbUtils.resultSetToTableModel(rs));
            DBCon.Close();
        } catch (SQLException ex) {
            Logger.getLogger(frmUserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReFreshAccountsUser() {
        try {
            DBCon.Open();
            db.ReadAccountsUser();
            tblUser.setModel(DbUtils.resultSetToTableModel(rs));
            DBCon.Close();
        } catch (SQLException ex) {
            Logger.getLogger(frmUserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        try {
            if (txtFname.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Insert First Name!");
            } else if (txtLname.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Insert Last Name!");
            } else if (txtUsername.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Insert Username!");
            } else if (txtPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Insert Password!");
            } else if (cbAccessType.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Please Select Access Type!");
            } else {
                DBCon.Open();
                db.CheckAccountExist(txtUsername.getText(), Account_ID);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Username Already Taken!");
                } else {
                    DBCon.Open();
                    db.CreateAccount(txtFname.getText(), txtLname.getText(), txtUsername.getText(), txtPassword.getText(), cbAccessType.getSelectedItem().toString(), "De-Active");
                    DBCon.Close();
                    ReFreshAccounts();
                    JOptionPane.showMessageDialog(this, "Account Successfully Created");
                    ;
                    btnClearActionPerformed(evt);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:

        if (frmLogin.AccessType.equals("Cashier")) {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnActive.setEnabled(true);
            btnCreate.setEnabled(false);
            int row = tblUser.getSelectedRow();
            Account_ID = tblUser.getValueAt(row, 0).toString();
            txtFname.setText(tblUser.getValueAt(row, 1).toString());
            txtLname.setText(tblUser.getValueAt(row, 2).toString());
            txtUsername.setText(tblUser.getValueAt(row, 3).toString());
            txtPassword.setText(tblUser.getValueAt(row, 4).toString());
            String AccessType = tblUser.getValueAt(row, 5).toString();
            cbAccessType.setSelectedItem(AccessType);
            lblStatus.setText(tblUser.getValueAt(row, 6).toString());
            lblInsentives.setText(tblUser.getValueAt(row, 7).toString());
        } else if (frmLogin.AccessType.equals("Sales Rep")) {
            btnCreate.setEnabled(false);
            int row = tblUser.getSelectedRow();
            Account_ID = tblUser.getValueAt(row, 0).toString();
            txtFname.setText(tblUser.getValueAt(row, 1).toString());
            txtLname.setText(tblUser.getValueAt(row, 2).toString());
            txtUsername.setText(tblUser.getValueAt(row, 3).toString());
            String AccessType = tblUser.getValueAt(row, 4).toString();
            cbAccessType.setSelectedItem(AccessType);
            lblStatus.setText(tblUser.getValueAt(row, 5).toString());
            lblInsentives.setText(tblUser.getValueAt(row, 6).toString());
        }

        if (lblStatus.getText().equals("Active")) {
            btnActive.setText("De-Active");
        } else {
            btnActive.setText("Active");
        }

    }//GEN-LAST:event_tblUserMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            if (Account_ID.equals("")) {
                JOptionPane.showMessageDialog(this, "Please Select Account first");
            } else {
                int Delete = JOptionPane.showConfirmDialog(null, "Delete Account", "Are You Sure You want to Delete this Account", JOptionPane.YES_NO_OPTION);
                if (Delete == 0) {
                    DBCon.Open();
                    db.DeleteAccount(Account_ID);
                    DBCon.Close();
                    ReFreshAccounts();
                    btnClearActionPerformed(evt);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            if (txtFname.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Insert First Name!");
            } else if (txtLname.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Insert Last Name!");
            } else if (txtUsername.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Insert Username!");
            } else if (txtPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Insert Password!");
            } else if (cbAccessType.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Please Select Access Type!");
            } else {
                DBCon.Open();
                db.CheckAccountExist(txtUsername.getText(), Account_ID);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Username Already Taken!");
                } else {
                    int Update = JOptionPane.showConfirmDialog(null, "You want to Update", "UPDATE", JOptionPane.YES_NO_OPTION);
                    if (Update == 0) {
                        try {
                            DBCon.Open();
                            db.UpdateAccount(txtFname.getText(), txtLname.getText(), txtUsername.getText(), txtPassword.getText(), cbAccessType.getSelectedItem().toString(), Account_ID);
                            DBCon.Close();
                            ReFreshAccounts();
                            btnClearActionPerformed(evt);
                            JOptionPane.showMessageDialog(this, "Successfully Updated");

                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(this, e);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        if (frmLogin.AccessType.equals("Cashier")) {
            btnCreate.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnActive.setEnabled(false);
            tblUser.clearSelection();
            txtFname.setText("");
            txtLname.setText("");
            txtUsername.setText("");
            txtPassword.setText("");
            lblStatus.setText("");
            Account_ID = "";
            cbAccessType.setSelectedIndex(-1);
        } else {
            btnCreate.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnActive.setEnabled(false);
            tblUser.clearSelection();
            txtFname.setText("");
            txtLname.setText("");
            txtUsername.setText("");
            txtPassword.setText("");
            lblStatus.setText("");
            Account_ID = "";
            cbAccessType.setSelectedIndex(-1);
        }
            

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActiveActionPerformed
        // TODO add your handling code here:
        try {
            if (lblStatus.getText().equals("Active")) {
                DBCon.Open();
                db.UpdateStatus(Account_ID, "De-Active");
                DBCon.Close();
                lblStatus.setText("De-Active");
                btnActive.setText("Active");
            } else {
                DBCon.Open();
                db.UpdateStatus(Account_ID, "Active");
                DBCon.Close();
                lblStatus.setText("Active");
                btnActive.setText("De-Active");
            }
            ReFreshAccounts();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnActiveActionPerformed

    private void cbAccessTypePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbAccessTypePopupMenuWillBecomeVisible
        // TODO add your handling code here:
        cbAccessType.setSelectedIndex(-1);
    }//GEN-LAST:event_cbAccessTypePopupMenuWillBecomeVisible

    public final JTable RefreshUser() {
        try {
            DBCon.Open();
            db.ReadAccounts();
            tblUser.setModel(DbUtils.resultSetToTableModel(rs));
            btnCreate.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnActive.setEnabled(false);
            tblUser.clearSelection();
            txtFname.setText("");
            txtLname.setText("");
            txtUsername.setText("");
            txtPassword.setText("");
            lblStatus.setText("");
            Account_ID = "";
            cbAccessType.setSelectedIndex(-1);
            DBCon.Close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return tblUser;
    }

    public final JTable RefreshUser1() {
        try {
            DBCon.Open();
            db.ReadAccountsUser();
            tblUser.setModel(DbUtils.resultSetToTableModel(rs));
            btnCreate.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            btnActive.setEnabled(false);
            tblUser.clearSelection();
            txtFname.setText("");
            txtLname.setText("");
            txtUsername.setText("");
            txtPassword.setText("");
            lblStatus.setText("");
            Account_ID = "";
            cbAccessType.setSelectedIndex(-1);
            DBCon.Close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return tblUser;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActive;
    private javax.swing.JButton btnClear;
    public static javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbAccessType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInsentives;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
