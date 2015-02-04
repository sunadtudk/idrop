/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.CollectionAO;
import org.irods.jargon.core.pub.DataObjectAO;
import org.irods.jargon.core.pub.IRODSFileSystem;
import org.irods.jargon.core.pub.domain.AvuData;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.MetadataTableModel;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lisa
 */
public class AddMetadataDialog extends javax.swing.JDialog implements
		DocumentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 564076120927810344L;
	private AvuData avuData;
	private final IRODSFileSystem irodsFileSystem;
	private final IRODSAccount irodsAccount;
	private final boolean isCollection;
	private final String selectedObjectFullPath;
	private final MetadataTableModel tableModel;
	public static org.slf4j.Logger log = LoggerFactory
			.getLogger(EditMetaDataDialog.class);

	/**
	 * Creates new form AddMetadataDialog
	 */
	public AddMetadataDialog(final javax.swing.JDialog parent,
			final boolean modal, final String selectedObjectFullPath,
			final boolean isCollection, final IRODSFileSystem irodsFileSystem,
			final IRODSAccount irodsAccount, final MetadataTableModel model) {

		super(parent, modal);
		initComponents();

		this.irodsFileSystem = irodsFileSystem;
		this.irodsAccount = irodsAccount;
		this.isCollection = isCollection;
		this.selectedObjectFullPath = selectedObjectFullPath;
		tableModel = model;

		// add document listener to metadata text fields
		txtAttribute.getDocument().addDocumentListener(this);
		txtValue.getDocument().addDocumentListener(this);
		txtUnit.getDocument().addDocumentListener(this);
	}

	private void updateMetadataAddBtnStatus() {
		// add button should only be enabled when all text fields are populated
		btnAdd.setEnabled((txtAttribute.getText().length() > 0)
				&& (txtValue.getText().length() > 0));
	}

	public AvuData getAvuData() {
		return avuData;
	}

	private void setAvuData(final String attr, final String value,
			final String unit) {
		avuData = new AvuData();
		avuData.setAttribute(attr);
		avuData.setValue(value);
		avuData.setUnit(unit);
	}

	// Document Listener methods
	@Override
	public void insertUpdate(final DocumentEvent de) {
		updateMetadataAddBtnStatus();
	}

	@Override
	public void removeUpdate(final DocumentEvent de) {
		updateMetadataAddBtnStatus();
	}

	@Override
	public void changedUpdate(final DocumentEvent de) {
		updateMetadataAddBtnStatus();
	}

	// end Document Listener methods

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAttribute = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        pnlBottom = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.title")); // NOI18N
        setName("addMetadataDialog"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 300));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

        jLabel1.setText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.jLabel1.text")); // NOI18N

        txtAttribute.setText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.attribute.text")); // NOI18N
        txtAttribute.setName("attribute"); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.jLabel2.text")); // NOI18N

        txtValue.setText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.value.text")); // NOI18N
        txtValue.setName("value"); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.jLabel3.text")); // NOI18N

        txtUnit.setText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.unit.text")); // NOI18N
        txtUnit.setName("unit"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel1)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtUnit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtAttribute, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(27, 27, 27)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtAttribute, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtUnit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pnlBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_192_circle_remove.png"))); // NOI18N
        btnCancel.setMnemonic('c');
        btnCancel.setText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.cancelButton.text")); // NOI18N
        btnCancel.setToolTipText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.cancelButton.toolTipText")); // NOI18N
        btnCancel.setName("cancelButton"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlBottom.add(btnCancel);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_193_circle_ok.png"))); // NOI18N
        btnAdd.setMnemonic('O');
        btnAdd.setText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.okButton.text")); // NOI18N
        btnAdd.setToolTipText(org.openide.util.NbBundle.getMessage(AddMetadataDialog.class, "AddMetadataDialog.okButton.toolTipText")); // NOI18N
        btnAdd.setEnabled(false);
        btnAdd.setName("okButton"); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlBottom.add(btnAdd);

        getContentPane().add(pnlBottom, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnCancelActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
		dispose();
	}// GEN-LAST:event_btnCancelActionPerformed

	private void btnAddActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
		CollectionAO collectionAO;
		DataObjectAO dataObjectAO;

		// save avudata entered
		setAvuData(txtAttribute.getText(), txtValue.getText(),
				txtUnit.getText());

		// now save to iRODS and update table
		try {
			if (isCollection) {
				collectionAO = irodsFileSystem.getIRODSAccessObjectFactory()
						.getCollectionAO(irodsAccount);
				collectionAO.addAVUMetadata(selectedObjectFullPath, avuData);
			} else {
				dataObjectAO = irodsFileSystem.getIRODSAccessObjectFactory()
						.getDataObjectAO(irodsAccount);
				dataObjectAO.addAVUMetadata(selectedObjectFullPath, avuData);
			}

			tableModel.addRow(selectedObjectFullPath, avuData.getAttribute(),
					avuData.getValue(), avuData.getUnit());

			JOptionPane.showMessageDialog(this, "Metadata Added Successfully",
					"Add Metadata", JOptionPane.PLAIN_MESSAGE);

		} catch (JargonException ex) {
			log.error("cannot add metadata", ex);
			JOptionPane.showMessageDialog(this, "Metadata Add Failed",
					"Add Metadata", JOptionPane.PLAIN_MESSAGE);

		} finally {
			irodsFileSystem.closeAndEatExceptions();
		}

		dispose();
	}// GEN-LAST:event_btnAddActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JTextField txtAttribute;
    private javax.swing.JTextField txtUnit;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
