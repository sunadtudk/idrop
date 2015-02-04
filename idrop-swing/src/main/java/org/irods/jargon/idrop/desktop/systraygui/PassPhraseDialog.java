/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.irods.jargon.conveyor.core.ConveyorBusyException;
import org.irods.jargon.conveyor.core.ConveyorExecutionException;
import org.irods.jargon.transfer.exception.PassPhraseInvalidException;

/**
 * 
 * @author lisa
 */
public class PassPhraseDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7668804077892143218L;
	private final IDROPCore idropCore;
	private boolean validated = false;

	/**
	 * Creates new form PassPhraseDialog
	 */
	public PassPhraseDialog(final java.awt.Frame parent, final boolean modal,
			final IDROPCore idropCore) {
		super(parent, modal);
		this.idropCore = idropCore;
		initComponents();
		makeTextAreaLikeLabel();

		// make the okay button defulat so you can just enter
		// pass phrase and hit return
		getRootPane().setDefaultButton(btnOkay);
	}

	private void makeTextAreaLikeLabel() {

		txtAreaWelcomeLabel.setEditable(false);
		txtAreaWelcomeLabel.setCursor(null);
		txtAreaWelcomeLabel.setOpaque(false);
		txtAreaWelcomeLabel.setFocusable(false);
		txtAreaWelcomeLabel.setFont(UIManager.getFont("Label.font"));
		txtAreaWelcomeLabel.setWrapStyleWord(true);
		txtAreaWelcomeLabel.setLineWrap(true);
	}

	public boolean isValidated() {
		return validated;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        txtAreaWelcomeLabel = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPassPhrase = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnForgotPassPhrase = new javax.swing.JButton();
        btnOkay = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.title")); // NOI18N
        setName("passPhraseDialog"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 300));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 14, 4, 14));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 90));
        jPanel1.setLayout(new java.awt.BorderLayout());

        txtAreaWelcomeLabel.setEditable(false);
        txtAreaWelcomeLabel.setBackground(new java.awt.Color(238, 238, 238));
        txtAreaWelcomeLabel.setColumns(20);
        txtAreaWelcomeLabel.setRows(5);
        txtAreaWelcomeLabel.setText(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.txtAreaWelcomeLabel.text")); // NOI18N
        jPanel1.add(txtAreaWelcomeLabel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 14, 4, 14));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 200));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel1, gridBagConstraints);

        txtPassPhrase.setText(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.passPhrase.text")); // NOI18N
        txtPassPhrase.setName("passPhrase"); // NOI18N
        txtPassPhrase.setPreferredSize(new java.awt.Dimension(300, 28));
        txtPassPhrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassPhraseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(txtPassPhrase, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 14, 8, 14));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel4, java.awt.BorderLayout.WEST);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.setLayout(new java.awt.BorderLayout());

        btnForgotPassPhrase.setText(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.btnIForgot.text")); // NOI18N
        btnForgotPassPhrase.setName("btnIForgot"); // NOI18N
        btnForgotPassPhrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotPassPhraseActionPerformed(evt);
            }
        });
        jPanel5.add(btnForgotPassPhrase, java.awt.BorderLayout.CENTER);

        btnOkay.setText(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.btnOK.text")); // NOI18N
        btnOkay.setActionCommand(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.btnOK.text")); // NOI18N
        btnOkay.setLabel(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.btnOK.text")); // NOI18N
        btnOkay.setName("btnOk"); // NOI18N
        btnOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkayActionPerformed(evt);
            }
        });
        jPanel5.add(btnOkay, java.awt.BorderLayout.EAST);

        btnCancel.setText(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.btnCancel.text")); // NOI18N
        btnCancel.setActionCommand(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.btnCancel.actionCommand")); // NOI18N
        btnCancel.setLabel(org.openide.util.NbBundle.getMessage(PassPhraseDialog.class, "PassPhraseDialog.btnCancel.text")); // NOI18N
        btnCancel.setName("btmCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancel, java.awt.BorderLayout.WEST);

        jPanel3.add(jPanel5, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassPhraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassPhraseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassPhraseActionPerformed

	private void btnCancelActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
		System.exit(0);
	}// GEN-LAST:event_btnCancelActionPerformed

	private void btnForgotPassPhraseActionPerformed(
			final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnForgotPassPhraseActionPerformed
		int ans = JOptionPane
				.showConfirmDialog(
						this,
						"In order to reset your pass phrase, all of your saved grid account information will be removed.\nAre you sure you wish to procede?",
						"Reset Pass Phrase", JOptionPane.YES_NO_OPTION);

		if (ans == JOptionPane.YES_OPTION) {

			try {
				// first clear out everything
				idropCore.getConveyorService().getGridAccountService()
						.resetPassPhraseAndAccounts();
			} catch (ConveyorBusyException ex) {
				Logger.getLogger(PassPhraseDialog.class.getName()).log(
						Level.SEVERE, null, ex);
				JOptionPane
						.showMessageDialog(
								this,
								"Reset of pass phrase failed.\nTransfer for this grid account is currently in progess.\nPlease try again later.",
								"Reset Pass Phrase", JOptionPane.ERROR_MESSAGE);
			} catch (ConveyorExecutionException ex) {
				Logger.getLogger(PassPhraseDialog.class.getName()).log(
						Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(this,
						"Reset of pass phrase failed.", "Reset Pass Phrase",
						JOptionPane.ERROR_MESSAGE);
			}

			// now start up initial pass phrase dialog to create new pass phrase
			final InitialPassPhraseDialog initialPassPhraseDialog = new InitialPassPhraseDialog(
					null, true, idropCore);
			Toolkit tk = getToolkit();
			int x = (tk.getScreenSize().width - initialPassPhraseDialog
					.getWidth()) / 2;
			int y = (tk.getScreenSize().height - initialPassPhraseDialog
					.getHeight()) / 2;
			initialPassPhraseDialog.setLocation(x, y);
			initialPassPhraseDialog.toFront();
			initialPassPhraseDialog.setVisible(true);
			validated = initialPassPhraseDialog.isValidated();
		} else {
			// answer was No so just return
			return;
		}

		dispose();
	}// GEN-LAST:event_btnForgotPassPhraseActionPerformed

	private void btnOkayActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOkayActionPerformed

		String passPhrase = new String(txtPassPhrase.getPassword());

		// make sure pass phrase is entered
		if ((passPhrase == null) || (passPhrase.length() <= 0)) {
			JOptionPane.showMessageDialog(this, "Please enter a pass phrase.",
					"Validate Pass Phrase", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			idropCore.getConveyorService().getGridAccountService()
					.validatePassPhrase(passPhrase);
		} catch (PassPhraseInvalidException ex) {
			Logger.getLogger(PassPhraseDialog.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(this,
					"Pass phrase is invalid. Please try again.",
					"Validate Pass Phrase", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (ConveyorExecutionException ex) {
			Logger.getLogger(PassPhraseDialog.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(this,
					"Validation of pass phrase failed.",
					"Validate Pass Phrase", JOptionPane.ERROR_MESSAGE);
			return;
		}

		validated = true;

		dispose();
	}// GEN-LAST:event_btnOkayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnForgotPassPhrase;
    private javax.swing.JButton btnOkay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextArea txtAreaWelcomeLabel;
    private javax.swing.JPasswordField txtPassPhrase;
    // End of variables declaration//GEN-END:variables
}
