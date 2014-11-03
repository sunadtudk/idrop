/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.irods.jargon.conveyor.core.ConveyorExecutionException;
import org.irods.jargon.core.utils.MiscIRODSUtils;
import static org.irods.jargon.idrop.desktop.systraygui.TransferAccountingManagerDialog.log;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.SynchConfigTableModel;
import org.irods.jargon.idrop.finder.IRODSFinderDialog;
import org.irods.jargon.transfer.dao.domain.FrequencyType;
import org.irods.jargon.transfer.dao.domain.Synchronization;
import org.irods.jargon.transfer.dao.domain.SynchronizationType;
import org.openide.util.Exceptions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mikeconway
 */
public class SynchronizationDialog extends javax.swing.JDialog implements ListSelectionListener {

    private final IDROPCore idropCore;

    private static final org.slf4j.Logger log = LoggerFactory
            .getLogger(SynchronizationDialog.class);

    private Synchronization synchronization = null;

    /**
     * Creates new form SynchronizationDialog
     */
    public SynchronizationDialog(java.awt.Frame parent, boolean modal, final IDROPCore idropCore) {
        super(parent, modal);
        if (idropCore == null) {
            throw new IllegalArgumentException("null idropCore");
        }

        this.idropCore = idropCore;
        initComponents();
        this.tblSynchs.getSelectionModel().addListSelectionListener(this);
        buildSynchTable();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlMain = new javax.swing.JPanel();
        toolBarTop = new javax.swing.JToolBar();
        btnAddSynchActionPerformed = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnRemoveSelected = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnLaunchSelected = new javax.swing.JButton();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        jSeparator3 = new javax.swing.JToolBar.Separator();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnRefresh = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        splitMasterdetail = new javax.swing.JSplitPane();
        pnlTable = new javax.swing.JPanel();
        pnlSynchDetails = new javax.swing.JPanel();
        lblSynchDetails = new javax.swing.JLabel();
        scrollPanelSynchs = new javax.swing.JScrollPane();
        tblSynchs = new javax.swing.JTable();
        pnlSizer = new javax.swing.JPanel();
        pnlSynch = new javax.swing.JPanel();
        lblSynchNameLabel = new javax.swing.JLabel();
        txtSynchName = new javax.swing.JTextField();
        lblLocalDirectory = new javax.swing.JLabel();
        btnLocalDirectory = new javax.swing.JButton();
        lblIrodsDirectory = new javax.swing.JLabel();
        btnIrodsDirectory = new javax.swing.JButton();
        lblSynchType = new javax.swing.JLabel();
        comboBoxSynchType = new javax.swing.JComboBox();
        lblSynchFrequency = new javax.swing.JLabel();
        comboSynchFrequency = new javax.swing.JComboBox();
        pnlBottom = new javax.swing.JPanel();
        bntClose = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("synchronizationDialog"); // NOI18N

        pnlMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 4, 4, 4));
        pnlMain.setLayout(new java.awt.BorderLayout());

        toolBarTop.setFloatable(false);
        toolBarTop.setRollover(true);

        btnAddSynchActionPerformed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_190_circle_plus.png"))); // NOI18N
        btnAddSynchActionPerformed.setMnemonic('a');
        btnAddSynchActionPerformed.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnAdd.text")); // NOI18N
        btnAddSynchActionPerformed.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnAdd.toolTipText")); // NOI18N
        btnAddSynchActionPerformed.setActionCommand(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnAdd.actionCommand")); // NOI18N
        btnAddSynchActionPerformed.setFocusable(false);
        btnAddSynchActionPerformed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddSynchActionPerformed.setName("btnAdd"); // NOI18N
        btnAddSynchActionPerformed.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAddSynchActionPerformed.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddSynchActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSynchActionPerformedActionPerformed(evt);
            }
        });
        toolBarTop.add(btnAddSynchActionPerformed);
        toolBarTop.add(jSeparator4);

        btnRemoveSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_191_circle_minus.png"))); // NOI18N
        btnRemoveSelected.setMnemonic('d');
        btnRemoveSelected.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnDelete.text")); // NOI18N
        btnRemoveSelected.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnDelete.toolTipText")); // NOI18N
        btnRemoveSelected.setEnabled(false);
        btnRemoveSelected.setFocusable(false);
        btnRemoveSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemoveSelected.setName("btnDelete"); // NOI18N
        btnRemoveSelected.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemoveSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSelectedActionPerformed(evt);
            }
        });
        toolBarTop.add(btnRemoveSelected);
        toolBarTop.add(filler6);

        btnLaunchSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_173_play.png"))); // NOI18N
        btnLaunchSelected.setMnemonic('l');
        btnLaunchSelected.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnLaunch.text")); // NOI18N
        btnLaunchSelected.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnLaunch.toolTipText")); // NOI18N
        btnLaunchSelected.setEnabled(false);
        btnLaunchSelected.setFocusable(false);
        btnLaunchSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLaunchSelected.setName("btnLaunch"); // NOI18N
        btnLaunchSelected.setPreferredSize(new java.awt.Dimension(80, 80));
        btnLaunchSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLaunchSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaunchSelectedActionPerformed(evt);
            }
        });
        toolBarTop.add(btnLaunchSelected);
        toolBarTop.add(filler9);
        toolBarTop.add(jSeparator3);
        toolBarTop.add(filler10);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_081_refresh.png"))); // NOI18N
        btnRefresh.setMnemonic('f');
        btnRefresh.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnRefresh.text")); // NOI18N
        btnRefresh.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnRefresh.toolTipText")); // NOI18N
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setName("btnRefresh"); // NOI18N
        btnRefresh.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        toolBarTop.add(btnRefresh);
        toolBarTop.add(filler11);
        toolBarTop.add(filler13);

        pnlMain.add(toolBarTop, java.awt.BorderLayout.NORTH);

        splitMasterdetail.setDividerLocation(200);
        splitMasterdetail.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        pnlTable.setLayout(new java.awt.BorderLayout());

        lblSynchDetails.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.lblSynchDetails.text")); // NOI18N
        pnlSynchDetails.add(lblSynchDetails);

        pnlTable.add(pnlSynchDetails, java.awt.BorderLayout.NORTH);

        tblSynchs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSynchs.setName("synchronizationList"); // NOI18N
        scrollPanelSynchs.setViewportView(tblSynchs);

        pnlTable.add(scrollPanelSynchs, java.awt.BorderLayout.CENTER);

        splitMasterdetail.setLeftComponent(pnlTable);

        pnlSizer.setLayout(new java.awt.BorderLayout());

        pnlSynch.setPreferredSize(new java.awt.Dimension(1000, 600));
        pnlSynch.setLayout(new java.awt.GridBagLayout());

        lblSynchNameLabel.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.lblSynchNameLabel.text")); // NOI18N
        lblSynchNameLabel.setMaximumSize(null);
        lblSynchNameLabel.setMinimumSize(null);
        lblSynchNameLabel.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        pnlSynch.add(lblSynchNameLabel, gridBagConstraints);

        txtSynchName.setEditable(false);
        txtSynchName.setColumns(20);
        txtSynchName.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.name.text")); // NOI18N
        txtSynchName.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.name.toolTipText")); // NOI18N
        txtSynchName.setEnabled(false);
        txtSynchName.setName("name"); // NOI18N
        txtSynchName.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlSynch.add(txtSynchName, gridBagConstraints);

        lblLocalDirectory.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.lblLocalDirectory.text")); // NOI18N
        lblLocalDirectory.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlSynch.add(lblLocalDirectory, gridBagConstraints);

        btnLocalDirectory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_144_folder_open.png"))); // NOI18N
        btnLocalDirectory.setMnemonic('l');
        btnLocalDirectory.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnLocalDirectory.text")); // NOI18N
        btnLocalDirectory.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnLocalDirectory.toolTipText")); // NOI18N
        btnLocalDirectory.setEnabled(false);
        btnLocalDirectory.setMaximumSize(new java.awt.Dimension(143, 31));
        btnLocalDirectory.setMinimumSize(new java.awt.Dimension(143, 31));
        btnLocalDirectory.setName("btnLocalDirectory"); // NOI18N
        btnLocalDirectory.setPreferredSize(new java.awt.Dimension(143, 31));
        btnLocalDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalDirectoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlSynch.add(btnLocalDirectory, gridBagConstraints);

        lblIrodsDirectory.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.lblIrodsDirectory.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlSynch.add(lblIrodsDirectory, gridBagConstraints);

        btnIrodsDirectory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_144_folder_open.png"))); // NOI18N
        btnIrodsDirectory.setMnemonic('i');
        btnIrodsDirectory.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnIrodsDirectory.text")); // NOI18N
        btnIrodsDirectory.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnIrodsDirectory.toolTipText")); // NOI18N
        btnIrodsDirectory.setEnabled(false);
        btnIrodsDirectory.setName("btnIrodsDirectory"); // NOI18N
        btnIrodsDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrodsDirectoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlSynch.add(btnIrodsDirectory, gridBagConstraints);

        lblSynchType.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.lblSynchType.text")); // NOI18N
        lblSynchType.setMaximumSize(null);
        lblSynchType.setMinimumSize(null);
        lblSynchType.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlSynch.add(lblSynchType, gridBagConstraints);

        comboBoxSynchType.setModel(new SynchTypeModel());
        comboBoxSynchType.setEnabled(false);
        comboBoxSynchType.setMinimumSize(null);
        comboBoxSynchType.setName("synchType"); // NOI18N
        comboBoxSynchType.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlSynch.add(comboBoxSynchType, gridBagConstraints);

        lblSynchFrequency.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.lblSynchFrequency.text")); // NOI18N
        lblSynchFrequency.setMaximumSize(null);
        lblSynchFrequency.setMinimumSize(null);
        lblSynchFrequency.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlSynch.add(lblSynchFrequency, gridBagConstraints);

        comboSynchFrequency.setModel(new FrequencyTypeModel());
        comboSynchFrequency.setEnabled(false);
        comboSynchFrequency.setMinimumSize(null);
        comboSynchFrequency.setName("frequency"); // NOI18N
        comboSynchFrequency.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnlSynch.add(comboSynchFrequency, gridBagConstraints);

        pnlSizer.add(pnlSynch, java.awt.BorderLayout.CENTER);

        splitMasterdetail.setRightComponent(pnlSizer);

        pnlMain.add(splitMasterdetail, java.awt.BorderLayout.CENTER);

        pnlBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        bntClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_192_circle_remove.png"))); // NOI18N
        bntClose.setMnemonic('c');
        bntClose.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnCancel.text")); // NOI18N
        bntClose.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnCancel.toolTipText")); // NOI18N
        bntClose.setFocusable(false);
        bntClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntClose.setName("btnCancel"); // NOI18N
        bntClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCloseActionPerformed(evt);
            }
        });
        pnlBottom.add(bntClose);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_193_circle_ok.png"))); // NOI18N
        btnUpdate.setMnemonic('u');
        btnUpdate.setText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnOk.text")); // NOI18N
        btnUpdate.setToolTipText(org.openide.util.NbBundle.getMessage(SynchronizationDialog.class, "SynchronizationDialog.btnOk.toolTipText")); // NOI18N
        btnUpdate.setEnabled(false);
        btnUpdate.setMargin(null);
        btnUpdate.setName("btnOk"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlBottom.add(btnUpdate);

        pnlMain.add(pnlBottom, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSelectedActionPerformed
            log.info("btnRemoveSelectedActionPerformed");
              if (synchronization == null) {
            log.error("cannot de;ete, no synch provided");
        }

        log.info("deleting synch:{}", synchronization);
        try {
            idropCore.getConveyorService().getSynchronizationManagerService().deleteSynchronization(synchronization);
            MessageManager.showMessage(this, "Synchronization was deleted");
            this.clearDetailData();
            this.enableDataEntry(false);
            this.buildSynchTable();
        } catch (ConveyorExecutionException ex) {
            log.error("unable to launch synchronization", ex);
            MessageManager.showError(this, ex.getMessage());
        }



    }//GEN-LAST:event_btnRemoveSelectedActionPerformed

    private void btnLaunchSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaunchSelectedActionPerformed

        log.info("launching synchronization...");

        if (synchronization == null) {
            log.error("cannot launch, no synch provided");
        }

        log.info("launching synch:{}", synchronization);
        try {
            idropCore.getConveyorService().getSynchronizationManagerService().triggerSynchronizationNow(synchronization);
            MessageManager.showMessage(this, "Synchronization was triggered");
        } catch (ConveyorExecutionException ex) {
            log.error("unable to launch synchronization", ex);
            MessageManager.showError(this, ex.getMessage());
        }

    }//GEN-LAST:event_btnLaunchSelectedActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        final SynchronizationDialog dialog = this;

        log.info("refreshing transfer table");

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dialog.buildSynchTable();

            }
        });
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void bntCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCloseActionPerformed
        this.dispose();


    }//GEN-LAST:event_bntCloseActionPerformed

    private void btnAddSynchActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSynchActionPerformedActionPerformed
        final SynchronizationDialog dialog = this;

        log.info("refreshing transfer table");

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                clearDetailData();
                enableDataEntry(true);
                txtSynchName.requestFocus();
                dialog.synchronization = new Synchronization();
            }
        });
    }//GEN-LAST:event_btnAddSynchActionPerformedActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        final SynchronizationDialog dialog = this;

        log.info("refreshing transfer table");

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                log.info("updating!");
                if (synchronization == null) {
                    synchronization = new Synchronization();
                }

                synchronization.setSynchronizationMode((SynchronizationType) comboBoxSynchType.getModel().getSelectedItem());
                synchronization.setFrequencyType((FrequencyType) comboSynchFrequency.getModel().getSelectedItem());

                if (synchronization.getGridAccount() == null) {
                    log.info("no grid account, this is a new synch, use the present iRODS account ot set the the grid account");
                    try {
                        synchronization.setGridAccount(idropCore.getConveyorService().getGridAccountService().findGridAccountByIRODSAccount(idropCore.irodsAccount()));
                    } catch (ConveyorExecutionException ex) {
                        log.error("exception setting grid account", ex);
                        MessageManager.showError(dialog, ex.getMessage());
                    }
                }

                // source and target should be set, and are altered by using the lookup buttons and stored in the synchronization object, so i don't need
                // to update them here
                synchronization.setName(txtSynchName.getText());
                try {
                    idropCore.getConveyorService().getSynchronizationManagerService().addOrUpdateSynchronization(synchronization);
                    MessageManager.showMessage(dialog,"Synchronization updated");
                    buildSynchTable();
                } catch (ConveyorExecutionException ex) {
                    log.error("exception saving synchronization", ex);
                    MessageManager.showError(dialog, ex.getMessage());
                }

            }

        });
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLocalDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalDirectoryActionPerformed
        log.info("btnLocalDirectoryActionPerformed");

        final JFileChooser localFileChooser = new JFileChooser();
        localFileChooser.setMultiSelectionEnabled(false);
        localFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        localFileChooser.setDialogTitle("Select synchronization target");
        localFileChooser.setLocation((int) this.getLocation().getX(),
                (int) this.getLocation().getY());
        final int returnVal = localFileChooser.showOpenDialog(this);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String localPath = localFileChooser.getSelectedFile()
                            .getAbsolutePath();
                    lblLocalDirectory.setText(MiscIRODSUtils.abbreviateFileName(localPath));
                    lblLocalDirectory.setToolTipText(localPath);
                    synchronization.setLocalSynchDirectory(localPath);
                }

            }
        });
    }//GEN-LAST:event_btnLocalDirectoryActionPerformed

    private void btnIrodsDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrodsDirectoryActionPerformed

        log.info("btnIrodsDirectoryActionPerformed");

        final SynchronizationDialog thisDialog = this;
        final IDROPCore thisIdropCore = idropCore;

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                IRODSFinderDialog irodsFinder = new IRODSFinderDialog(null, false,
                        thisIdropCore, thisIdropCore.irodsAccount());
                irodsFinder.setTitle("Select iRODS Collection Upload Target");
                irodsFinder
                        .setSelectionType(IRODSFinderDialog.SelectionType.COLLS_ONLY_SELECTION_MODE);
                irodsFinder.setLocation((int) thisDialog.getLocation().getX(), (int) thisDialog
                        .getLocation().getY());
                irodsFinder.setVisible(true);

                String selectedPath = irodsFinder.getSelectedAbsolutePath();
                if (selectedPath != null) {
                    lblIrodsDirectory.setText(MiscIRODSUtils.abbreviateFileName(selectedPath));
                    lblIrodsDirectory.setToolTipText(selectedPath);
                    synchronization.setIrodsSynchDirectory(selectedPath);
                }
            }
        });

    }//GEN-LAST:event_btnIrodsDirectoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntClose;
    private javax.swing.JButton btnAddSynchActionPerformed;
    private javax.swing.JButton btnIrodsDirectory;
    private javax.swing.JButton btnLaunchSelected;
    private javax.swing.JButton btnLocalDirectory;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemoveSelected;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox comboBoxSynchType;
    private javax.swing.JComboBox comboSynchFrequency;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JLabel lblIrodsDirectory;
    private javax.swing.JLabel lblLocalDirectory;
    private javax.swing.JLabel lblSynchDetails;
    private javax.swing.JLabel lblSynchFrequency;
    private javax.swing.JLabel lblSynchNameLabel;
    private javax.swing.JLabel lblSynchType;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSizer;
    private javax.swing.JPanel pnlSynch;
    private javax.swing.JPanel pnlSynchDetails;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JScrollPane scrollPanelSynchs;
    private javax.swing.JSplitPane splitMasterdetail;
    private javax.swing.JTable tblSynchs;
    private javax.swing.JToolBar toolBarTop;
    private javax.swing.JTextField txtSynchName;
    // End of variables declaration//GEN-END:variables

    private void buildSynchTable() {
        log.info("buildSynchTable()");
        try {
            List<Synchronization> synchs = idropCore.getConveyorService().getSynchronizationManagerService().listAllSynchronizations();
            SynchConfigTableModel synchConfigTableModel = new SynchConfigTableModel(idropCore, synchs);
            tblSynchs.setModel(synchConfigTableModel);
            if (synchs.size() > 0) {
                tblSynchs.getSelectionModel().setLeadSelectionIndex(0);
            }
        } catch (ConveyorExecutionException ex) {
            log.error("error listing synchs", ex);
            MessageManager.showError(this, ex.getMessage());
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (e.getValueIsAdjusting()) {
            return;
        }

        int selectedRow = tblSynchs.getSelectedRow();

        if (selectedRow >= 0) {
            selectedRow = tblSynchs.convertRowIndexToModel(selectedRow);
            SynchConfigTableModel synchConfigTableModel = (SynchConfigTableModel) tblSynchs.getModel();
            this.setSynchronization(synchConfigTableModel.getSynchronizationAt(selectedRow));
            initViewFromSynch();
            log.info("selected:{}", this.getSynchronization());
        }

    }

    private void initViewFromSynch() {
        if (synchronization == null) {
            synchronization = new Synchronization();
        }

        final SynchronizationDialog dialog = this;

        log.info("refreshing transfer table");

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                dialog.lblIrodsDirectory.setText(MiscIRODSUtils.abbreviateFileName(synchronization.getIrodsSynchDirectory()));
                dialog.lblIrodsDirectory.setToolTipText(synchronization.getIrodsSynchDirectory());

                dialog.lblLocalDirectory.setText(MiscIRODSUtils.abbreviateFileName(synchronization.getLocalSynchDirectory()));
                dialog.lblIrodsDirectory.setToolTipText(synchronization.getLocalSynchDirectory());

                dialog.txtSynchName.setText(synchronization.getName());
                dialog.comboBoxSynchType.setSelectedItem(synchronization.getSynchronizationMode());
                dialog.comboSynchFrequency.setSelectedItem(synchronization.getFrequencyType());

                configureButtonsForSynchSelected();
                enableDataEntry(true);
            }

        });

    }

    private void enableDataEntry(boolean enabled) {

        txtSynchName.setEnabled(enabled);
        txtSynchName.setEditable(enabled);
        comboBoxSynchType.setEnabled(enabled);
        comboSynchFrequency.setEnabled(enabled);
        this.btnIrodsDirectory.setEnabled(enabled);
        this.btnLocalDirectory.setEnabled(enabled);
        this.btnUpdate.setEnabled(enabled);

    }

    synchronized void setSynchronization(final Synchronization synchronization) {
        this.synchronization = synchronization;
    }

    synchronized Synchronization getSynchronization() {
        return this.synchronization;
    }

    private void clearDetailData() {
        final SynchronizationDialog dialog = this;

        log.info("refreshing transfer table");

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                lblIrodsDirectory.setText("");
                lblIrodsDirectory.setToolTipText("");
                lblLocalDirectory.setText("");
                lblLocalDirectory.setToolTipText("");
                txtSynchName.setText("");
            }
        });

    }

    private void configureButtonsForSynchSelected() {
        this.txtSynchName.setEditable(true);
        this.btnLaunchSelected.setEnabled(true);
        this.btnRemoveSelected.setEnabled(true);
    }

}

class SynchTypeModel extends AbstractListModel<SynchronizationType> implements ComboBoxModel<SynchronizationType> {

    private SynchronizationType selected = null;
    
    
    SynchronizationType[] synchronizationTypes = {SynchronizationType.ONE_WAY_LOCAL_TO_IRODS};//SynchronizationType.values();

    @Override
    public int getSize() {
        return synchronizationTypes.length;
    }

    @Override
    public SynchronizationType getElementAt(int index) {
        return synchronizationTypes[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (SynchronizationType) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

}

class FrequencyTypeModel extends AbstractListModel<FrequencyType> implements ComboBoxModel<FrequencyType> {

    private FrequencyType selected = null;

    FrequencyType[] frequencyTypes = FrequencyType.values();

    @Override
    public int getSize() {
        return frequencyTypes.length;
    }

    @Override
    public FrequencyType getElementAt(int index) {
        return frequencyTypes[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (FrequencyType) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

}
