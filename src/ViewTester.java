import javax.swing.*;

/**
 * Temporary class just made it for testing the GUI
 */
public class ViewTester {
    public static void main(String[] args) {
        QuerySession model = new  QuerySession();
        SwingUtilities.invokeLater(() -> {
            MainView view = new MainView(model);
            view.setVisible(true);
        });
    }
}
