package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import model.ChessPlayer;
import model.Receptionist;
import dao.ChessPlayerDAO;

public class ManagePlayersFrm extends javax.swing.JFrame implements ActionListener {

    private Receptionist manager;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton jButton_AddPlayer, jButton_EditPlayer, jButton_DeletePlayer, jButton_Back, jButton_Search,
            jButton_Save, jButton_ConfirmDelete;
    private JTextField jTextField_Search;
    private JScrollPane jScrollPane1;
    private JLabel jLabel1;
    private int selectedPlayerId;

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
        jButton_Search = new javax.swing.JButton();
        jButton_Save = new javax.swing.JButton();
        jButton_ConfirmDelete = new javax.swing.JButton();
        jTextField_Search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1280, 720); // Set the window size to 1280x720

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

        jButton_Search.setText("Search");
        jButton_Search.addActionListener(this);

        jButton_Save.setText("Save");
        jButton_Save.addActionListener(this);
        jButton_Save.setVisible(false);

        jButton_ConfirmDelete.setText("Delete");
        jButton_ConfirmDelete.addActionListener(this);
        jButton_ConfirmDelete.setVisible(false);

        tableModel = new DefaultTableModel(new Object[] { "ID", "Name", "DOB", "Nationality" }, 0);
        table.setModel(tableModel);
        jScrollPane1.setViewportView(table);

        // Initially hide search components
        jTextField_Search.setVisible(false);
        jButton_Search.setVisible(false);
        jScrollPane1.setVisible(false);

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
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton_Search,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField_Search,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 400,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 1000,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton_Save,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton_ConfirmDelete,
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
                                .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Search)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Save)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_ConfirmDelete)
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
            toggleSearchComponents(true);
            jButton_Save.setVisible(true);
            jButton_ConfirmDelete.setVisible(false);
        } else if (e.getSource() == jButton_DeletePlayer) {
            toggleSearchComponents(true);
            jButton_Save.setVisible(false);
            jButton_ConfirmDelete.setVisible(true);
        } else if (e.getSource() == jButton_Search) {
            searchPlayers();
        } else if (e.getSource() == jButton_Save) {
            savePlayer();
        } else if (e.getSource() == jButton_ConfirmDelete) {
            deletePlayer(selectedPlayerId);
        } else if (e.getSource() == jButton_Back) {
            this.dispose();
            new ManagerHomeFrm(manager).setVisible(true);
        }
    }

    private void toggleSearchComponents(boolean visible) {
        jTextField_Search.setVisible(visible);
        jButton_Search.setVisible(visible);
        jScrollPane1.setVisible(visible);
        jButton_AddPlayer.setVisible(!visible);
        jButton_EditPlayer.setVisible(!visible);
        jButton_DeletePlayer.setVisible(!visible);
    }

    private void searchPlayers() {
        String keyword = jTextField_Search.getText();
        ChessPlayerDAO dao = new ChessPlayerDAO();
        ArrayList<ChessPlayer> players = dao.searchChessPlayersByName(keyword);

        tableModel.setRowCount(0);
        for (ChessPlayer player : players) {
            tableModel.addRow(new Object[] { player.getId(), player.getName(), player.getDob(), player.getNational() });
        }

        if (players.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No players found.");
        } else {
            table.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        selectedPlayerId = (int) tableModel.getValueAt(selectedRow, 0);
                    }
                }
            });
        }
    }

    private void savePlayer() {
        ChessPlayerDAO dao = new ChessPlayerDAO();
        ChessPlayer player = dao.getChessPlayerById(selectedPlayerId);

        String name = JOptionPane.showInputDialog(this, "Enter new player name:", player.getName());
        String dob = JOptionPane.showInputDialog(this, "Enter new player date of birth (yyyy-mm-dd):", player.getDob());
        String national = JOptionPane.showInputDialog(this, "Enter new player nationality:", player.getNational());

        player.setName(name);
        player.setDob(java.sql.Date.valueOf(dob));
        player.setNational(national);

        if (dao.updateChessPlayer(player)) {
            JOptionPane.showMessageDialog(this, "Player updated successfully!");
            resetUI();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update player.");
        }
    }

    private void deletePlayer(int id) {
        ChessPlayerDAO dao = new ChessPlayerDAO();
        if (dao.deleteChessPlayer(id)) {
            JOptionPane.showMessageDialog(this, "Player deleted successfully!");
            resetUI();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete player.");
        }
    }

    private void resetUI() {
        jTextField_Search.setVisible(false);
        jButton_Search.setVisible(false);
        jScrollPane1.setVisible(false);
        jButton_Save.setVisible(false);
        jButton_ConfirmDelete.setVisible(false);
        jButton_AddPlayer.setVisible(true);
        jButton_EditPlayer.setVisible(true);
        jButton_DeletePlayer.setVisible(true);
        tableModel.setRowCount(0);
    }

}