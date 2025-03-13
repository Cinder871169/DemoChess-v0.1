package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.ChessPlayer;
import model.Receptionist;
import dao.ChessPlayerDAO;

public class ManagePlayersFrm extends javax.swing.JFrame implements ActionListener {

    private Receptionist manager;

    public ManagePlayersFrm(Receptionist manager) {
        initComponents();
        this.manager = manager;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton_AddPlayer = new javax.swing.JButton();
        jButton_EditPlayer = new javax.swing.JButton();
        jButton_DeletePlayer = new javax.swing.JButton();
        jButton_Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Manage Players");

        jButton_AddPlayer.setText("Add Player");
        jButton_AddPlayer.addActionListener(this);

        jButton_EditPlayer.setText("Edit Player");
        jButton_EditPlayer.addActionListener(this);

        jButton_DeletePlayer.setText("Delete Player");
        jButton_DeletePlayer.addActionListener(this);

        jButton_Back.setText("Back");
        jButton_Back.addActionListener(this);

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
                                                        .addComponent(jButton_AddPlayer,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton_EditPlayer,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton_DeletePlayer,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton_Back,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                .addContainerGap(100, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jButton_AddPlayer)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_EditPlayer)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_DeletePlayer)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Back)
                                .addContainerGap(50, Short.MAX_VALUE)));

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton_AddPlayer) {
            String name = JOptionPane.showInputDialog(this, "Enter player name:");
            String dob = JOptionPane.showInputDialog(this, "Enter player date of birth (yyyy-mm-dd):");
            String national = JOptionPane.showInputDialog(this, "Enter player nationality:");

            ChessPlayer player = new ChessPlayer();
            player.setName(name);
            player.setDob(java.sql.Date.valueOf(dob));
            player.setNational(national);

            ChessPlayerDAO dao = new ChessPlayerDAO();
            if (dao.addChessPlayer(player)) {
                JOptionPane.showMessageDialog(this, "Player added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add player.");
            }
        } else if (e.getSource() == jButton_EditPlayer) {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter player ID to edit:"));
            String name = JOptionPane.showInputDialog(this, "Enter new player name:");
            String dob = JOptionPane.showInputDialog(this, "Enter new player date of birth (yyyy-mm-dd):");
            String national = JOptionPane.showInputDialog(this, "Enter new player nationality:");

            ChessPlayer player = new ChessPlayer();
            player.setId(id);
            player.setName(name);
            player.setDob(java.sql.Date.valueOf(dob));
            player.setNational(national);

            ChessPlayerDAO dao = new ChessPlayerDAO();
            if (dao.updateChessPlayer(player)) {
                JOptionPane.showMessageDialog(this, "Player updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update player.");
            }
        } else if (e.getSource() == jButton_DeletePlayer) {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter player ID to delete:"));

            ChessPlayerDAO dao = new ChessPlayerDAO();
            if (dao.deleteChessPlayer(id)) {
                JOptionPane.showMessageDialog(this, "Player deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete player.");
            }
        } else if (e.getSource() == jButton_Back) {
            this.dispose();
            new ManagerHomeFrm(manager).setVisible(true);
        }
    }

    private javax.swing.JButton jButton_AddPlayer;
    private javax.swing.JButton jButton_EditPlayer;
    private javax.swing.JButton jButton_DeletePlayer;
    private javax.swing.JButton jButton_Back;
    private javax.swing.JLabel jLabel1;
}