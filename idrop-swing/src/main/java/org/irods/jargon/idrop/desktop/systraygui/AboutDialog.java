/*
 * Created on Oct 8, 2010, 7:54:33 AM
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.irods.jargon.core.utils.JargonVersion;
import org.irods.jargon.idrop.desktop.systraygui.utils.Version;

/**
 * 
 * @author mikeconway
 */
public class AboutDialog extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2532724831957628628L;

	/** Creates new form AboutDialog */
    public AboutDialog(final java.awt.Frame parent, final boolean modal) {
        super(parent, modal);
        initComponents();
        lblIdropVersion.setText(Version.VERSION + " - " + Version.BUILD_TIME);
        lblJargonVersion.setText(JargonVersion.VERSION + "-" + JargonVersion.BUILD_TIME);
        registerKeystrokeListener();
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

        jLabel1 = new javax.swing.JLabel();
        lblJargonVersionLabel = new javax.swing.JLabel();
        lblJargonVersion = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        lblIdropVersionLabel = new javax.swing.JLabel();
        lblIdropVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iDROP - About");
        setMinimumSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("iDROP - the iRODS Cloud Browser");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 14, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        lblJargonVersionLabel.setText("Jargon Version:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(lblJargonVersionLabel, gridBagConstraints);

        lblJargonVersion.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(lblJargonVersion, gridBagConstraints);

        btnOK.setMnemonic('O');
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        getContentPane().add(btnOK, gridBagConstraints);

        lblIdropVersionLabel.setText("iDrop Version:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(lblIdropVersionLabel, gridBagConstraints);

        lblIdropVersion.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(lblIdropVersion, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKPressed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKPressed
        disposeOfAbout();
    }// GEN-LAST:event_btnOKPressed

    private void disposeOfAbout() {
        this.dispose();
    }

    /**
     * Register a listener for the enter event, so login can occur.
     */
    private void registerKeystrokeListener() {

        KeyStroke enter = KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_ENTER, 0);
        Action enterAction = new AbstractAction() {

            /**
			 * 
			 */
			private static final long serialVersionUID = -2548141664399058996L;

			@Override
            public void actionPerformed(final ActionEvent e) {
                disposeOfAbout();
            }
        };
        btnOK.registerKeyboardAction(enterAction, enter,
                JComponent.WHEN_IN_FOCUSED_WINDOW);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIdropVersion;
    private javax.swing.JLabel lblIdropVersionLabel;
    private javax.swing.JLabel lblJargonVersion;
    private javax.swing.JLabel lblJargonVersionLabel;
    // End of variables declaration//GEN-END:variables
}
