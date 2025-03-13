package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Receptionist;

/**
 * Manager Home Frame
 */
public class ManagerHomeFrm extends javax.swing.JFrame implements ActionListener {

    private Receptionist manager;

    public ManagerHomeFrm(Receptionist manager) {
        initComponents();
        this.manager = manager;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton_ManagePlayers = new javax.swing.JButton();
        jButton_ManageRounds = new javax.swing.JButton();
        jButton_Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Manager Home");

        jButton_ManagePlayers.setText("Manage Players");
        jButton_ManagePlayers.addActionListener(this);

        jButton_ManageRounds.setText("Manage Rounds");
        jButton_ManageRounds.addActionListener(this);

        jButton_Logout.setText("Logout");
        jButton_Logout.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jButton_ManagePlayers,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton_ManageRounds,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton_Logout,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                .addContainerGap(100, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addComponent(jButton_ManagePlayers)
                                .addGap(30, 30, 30)
                                .addComponent(jButton_ManageRounds)
                                .addGap(30, 30, 30)
                                .addComponent(jButton_Logout)
                                .addContainerGap(50, Short.MAX_VALUE)));

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton_ManagePlayers) {
            // Open Manage Players Frame
            JOptionPane.showMessageDialog(this, "Manage Players clicked");
        } else if (e.getSource() == jButton_ManageRounds) {
            // Open Manage Rounds Frame
            JOptionPane.showMessageDialog(this, "Manage Rounds clicked");
        } else if (e.getSource() == jButton_Logout) {
            // Logout and return to Login Frame
            new LoginFrm().setVisible(true);
            this.dispose();
        }
    }

    private javax.swing.JButton jButton_ManagePlayers;
    private javax.swing.JButton jButton_ManageRounds;
    private javax.swing.JButton jButton_Logout;
    private javax.swing.JLabel jLabel1;
}