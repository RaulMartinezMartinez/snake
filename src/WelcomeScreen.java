
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ulra7
 */
public class WelcomeScreen extends JPanel {

    JLabel title;
    JButton go;
    JButton quit;

    MainWindow mw;

    /**
     *
     * @param t
     */
    public void setTitle(String t) {
        title.setText(t);
    }

    /**
     *
     */
    public void quitButtonActionListener() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure?") == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    /**
     *
     */
    public void goButtonActionListener() {
        mw.showCard("Two");
    }

    /**
     *
     * @param mw
     */
    public WelcomeScreen(MainWindow mw) {
        this.mw = mw;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        title = new JLabel();
        add(title);

        //add formatting here
        go = new JButton(NUEVO_JUEGO);
        quit = new JButton(QUITAR);

        go.addActionListener((ActionEvent event) -> {
            goButtonActionListener();
        });

        quit.addActionListener((ActionEvent event) -> {
            quitButtonActionListener();
        });

        add(go);
        add(quit);
    }
    private static final String QUITAR = "Quit";
    private static final String NUEVO_JUEGO = "New Game";

}
