
import javax.swing.SwingUtilities;

/**
 *
 * @author ulra7
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow mw = new MainWindow();
                mw.setSize(600, 400);
                mw.setTitle("Snake and Ladder");
                mw.setVisible(true);
            }
        });
    }

}
