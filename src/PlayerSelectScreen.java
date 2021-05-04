
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//needs massive aesthetic rewrites

/**
 *
 * @author ulra7
 */
public class PlayerSelectScreen extends JPanel {

    JButton go;
    JButton quit;
    MainWindow mw;

    JRadioButton opt1;
    JRadioButton opt2;
    JRadioButton opt3;

    /**
     *
     */
    public void quitButtonActionListener() {
        mw.showCard("One");
    }

    /**
     *
     */
    public void goButtonActionListener() {
        playerOptions();
        mw.s4.setUpPlayers();
        mw.showCard("Three");
    }

    /**
     *
     */
    public void playerOptions() {
        int m = 5;
        if (opt1.isSelected() == true) {
            m = 1;
        } else if (opt2.isSelected() == true) {
            m = 2;
        } else if (opt3.isSelected() == true) {
            m = 3;
        }
        mw.s4.setMaxPlayers(m);
    }

    /**
     *
     * @param mw
     */
    public PlayerSelectScreen(MainWindow mw) {
        this.mw = mw;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        final String seleccionaJugador = "Select Players: ";

        JLabel mess = new JLabel(seleccionaJugador);
        add(mess);
        final String jugadorPordefecto = "Default: 1Player";
        final String dosJugadores = "2 Players";
        final String tresJugadores = "3 Players";
        final String personalizarPantalla = "Customize Board";
        final String atras = "Back";

        JLabel uc = new JLabel(jugadorPordefecto);
        add(uc);

        //set up radio buttons
        opt1 = new JRadioButton(jugadorPordefecto);
        opt1.setSelected(true);

        opt2 = new JRadioButton(dosJugadores);

        opt3 = new JRadioButton(tresJugadores);

        ButtonGroup grp = new ButtonGroup();
        grp.add(opt1);
        grp.add(opt2);
        grp.add(opt3);

        add(opt1);
        add(opt2);
        add(opt3);

        opt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerOptions();
            }
        });
        opt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerOptions();
            }
        });

        opt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerOptions();
            }
        });

        go = new JButton(personalizarPantalla);

        quit = new JButton(atras);

        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                goButtonActionListener();
            }
        });

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                quitButtonActionListener();
            }
        });

        add(go);
        add(quit);

    }

}
