package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class WindowAboutAuthor create window about author
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class WindowAboutAuthor extends JFrame {
    /**
     * Constructors for instantiation WindowAboutAuthor
     * */
    public WindowAboutAuthor(){
        initUI();

    }

    /**
     * Create graphic element and set them place.
     * Process click button with inner class listener
     */
    private void initUI() {
        // create panel for place ui elements
        JPanel jGenericPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        JPanel jMainPanel = new JPanel(new BorderLayout(5,5));
        JPanel jPanelText = new JPanel(new GridLayout(4,1));

        // create button and set up
        JButton jButtonBack = new JButton("Back");
        jButtonBack.setPreferredSize(new Dimension(10,35));

        // create image
        ImageIcon iconMyPhoto = new ImageIcon("src/images/mePhoto1.jpg");

        // text variable
        String text1 = "Автор";
        String text2 = "студент группы 10702119";
        String text3 = "Карпук Артём Юрьевич";
        String text4 = "artemkirlanovia@gmail.com";

        // create label and text variable place in labels,
        JLabel jLabelText1 = new JLabel(text1, SwingConstants.CENTER);
        JLabel jLabelText2 = new JLabel(text2, SwingConstants.CENTER);
        JLabel jLabelText3 = new JLabel(text3, SwingConstants.CENTER);
        JLabel jLabelText4 = new JLabel(text4, SwingConstants.CENTER);

        // set up labels
        jLabelText1.setFont(new Font("Times New Romance", Font.BOLD, 15));
        jLabelText2.setFont(new Font("Times New Romance", Font.BOLD, 15));
        jLabelText3.setFont(new Font("Times New Romance", Font.BOLD, 15));
        jLabelText4.setFont(new Font("Times New Romance", Font.BOLD, 15));

        // add labels in panels
        jPanelText.add(jLabelText1);
        jPanelText.add(jLabelText2);
        jPanelText.add(jLabelText3);
        jPanelText.add(jLabelText4);

        // add panels into main panel
        jMainPanel.add(new JLabel(iconMyPhoto), BorderLayout.NORTH);
        jMainPanel.add(jPanelText, BorderLayout.CENTER);
        jMainPanel.add(jButtonBack, BorderLayout.SOUTH);

        jGenericPanel.add(jMainPanel);

        add(jGenericPanel); // add main panel in frame

        // Anonymous inner class listener for closing window
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
