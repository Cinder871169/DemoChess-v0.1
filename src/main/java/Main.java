import view.LoginFrm;

public class Main {
    public static void main(String[] args) {
        // Set the Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display the login form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrm().setVisible(true);
            }
        });
    }
}