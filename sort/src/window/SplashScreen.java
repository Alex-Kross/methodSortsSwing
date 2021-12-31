package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class SplashScreen create start window in program
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class SplashScreen extends JFrame{
    private JButton jbtContinue;    // button for move main window
    private JButton jbtExit;        // button for exit from program

    /**
     * Constructors for instantiation SplashScreen
     * */
    public SplashScreen(){
        initUI();
    }

    /**
     * Create graphic element and set them place.
     * Process click button with inner class listener
     */
    private void initUI() {
        // create panel for place ui elements
        JPanel jPanelButton = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
        JPanel jMainPanel = new JPanel(new BorderLayout(5,20));
        JPanel jPanelTopText = new JPanel(new BorderLayout(5,5));
        JPanel jPanelCenterText = new JPanel(new BorderLayout(5,5));
        JPanel jPanelCenterPart = new JPanel(new BorderLayout(5,20));
        JPanel jPanelSubCenPart1 = new JPanel(new BorderLayout(5, 5));
        JPanel jPanelSubCenPart2 = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel jPanelSubCenPartText = new JPanel(new BorderLayout (5,20));
        JPanel jPanelSubCenText1 = new JPanel(new BorderLayout (5,5));
        JPanel jPanelSubCenText2 = new JPanel(new BorderLayout (5,5));
        JPanel jPanelBottomPart = new JPanel(new GridLayout(2, 1));

        // create image process sorting
        ImageIcon iconSorting = new ImageIcon("D:/My/java/coursework(sort)/sort/src/images/iconSorting.png");

        // variables contained text
        String topText1 = "Белорусский национальный технический университет";
        String topText2 = "Факультет информационных технологий и робототехники";
        String topText3 = "Кафедра программного обеспечения информационных систем  технологий";
        String centerText1 = "Курсовая работа";
        String centerText2 = "По дисциплине 'Программирование на Java'";
        String centerText3 = "Сортировка данных методами выбора и пузырьком";
        String subCenterText1 = "Выполнил: Студент группы 10702119";
        String subCenterText2 = "Карпук Артём Юрьевич";
        String subCenterText3 = "Преподаватель: к.ф.-м.н., доц.";
        String subCenterText4 = "Сидорик Валерий Владимирович";

        // create buttons and set up
        jbtContinue = new JButton("Continue");
        jbtContinue.setFont(new Font("Dialog", Font.PLAIN, 17));
        jbtContinue.setPreferredSize(new Dimension(320,45));

        jbtExit = new JButton("Exit");
        jbtExit.setFont(new Font("Dialog", Font.PLAIN, 17));
        jbtExit.setPreferredSize(new Dimension(320,45));

        JLabel jLabelBottomText = new JLabel("Минск, 2021", SwingConstants.CENTER);
        jLabelBottomText.setFont(new Font("Times New Romance", Font.BOLD, 14));

        // set texting variable in creating labels
        JLabel jLabelTopText1 = new JLabel(topText1,SwingConstants.CENTER);
        JLabel jLabelTopText2 = new JLabel(topText2,SwingConstants.CENTER);
        JLabel jLabelTopText3 = new JLabel(topText3,SwingConstants.CENTER);
        JLabel jLabelCenterText1 = new JLabel(centerText1,SwingConstants.CENTER);
        JLabel jLabelCenterText2 = new JLabel(centerText2,SwingConstants.CENTER);
        JLabel jLabelCenterText3 = new JLabel(centerText3,SwingConstants.CENTER);
        JLabel jLabelSubCenterText1 = new JLabel(subCenterText1, SwingConstants.LEFT);
        JLabel jLabelSubCenterText2 = new JLabel(subCenterText2,SwingConstants.LEFT);
        JLabel jLabelSubCenterText3 = new JLabel(subCenterText3,SwingConstants.LEFT);
        JLabel jLabelSubCenterText4 = new JLabel(subCenterText4,SwingConstants.LEFT);

        // set up labels
        jLabelTopText1.setFont(new Font("Times New Romance", Font.BOLD, 14));
        jLabelTopText2.setFont(new Font("Times New Romance", Font.BOLD, 14));
        jLabelTopText3.setFont(new Font("Times New Romance", Font.BOLD, 14));

        jLabelSubCenterText1.setFont(new Font("Times New Romance", Font.BOLD, 14));
        jLabelSubCenterText2.setFont(new Font("Times New Romance", Font.BOLD, 14));
        jLabelSubCenterText3.setFont(new Font("Times New Romance", Font.BOLD, 14));
        jLabelSubCenterText4.setFont(new Font("Times New Romance", Font.BOLD, 14));

        jLabelCenterText1.setFont(new Font("Times New Romance", Font.BOLD, 20));
        jLabelCenterText2.setFont(new Font("Times New Romance", Font.BOLD, 14));
        jLabelCenterText3.setFont(new Font("Times New Romance", Font.BOLD, 23));

        // labels place into panels
        jPanelSubCenText1.add(jLabelSubCenterText1, BorderLayout.NORTH);
        jPanelSubCenText1.add(jLabelSubCenterText2, BorderLayout.CENTER);
        jPanelSubCenText2.add(jLabelSubCenterText3, BorderLayout.NORTH);
        jPanelSubCenText2.add(jLabelSubCenterText4, BorderLayout.CENTER);
        jPanelSubCenPartText.add(jPanelSubCenText1, BorderLayout.NORTH);
        jPanelSubCenPartText.add(jPanelSubCenText2, BorderLayout.SOUTH);
        jPanelSubCenPart2.add(new JLabel(iconSorting));
        jPanelSubCenPart2.add(jPanelSubCenPartText);

        jPanelTopText.add(jLabelTopText1, BorderLayout.NORTH);
        jPanelTopText.add(jLabelTopText2, BorderLayout.CENTER);
        jPanelTopText.add(jLabelTopText3, BorderLayout.SOUTH);

        jPanelCenterText.add(jLabelCenterText1, BorderLayout.NORTH);
        jPanelCenterText.add(jLabelCenterText2, BorderLayout.CENTER);
        jPanelCenterText.add(jLabelCenterText3, BorderLayout.SOUTH);
        jPanelSubCenPart1.add(jPanelCenterText, BorderLayout.SOUTH);

        // buttons place into panels
        jPanelButton.add(jbtContinue);
        jPanelButton.add(jbtExit);

        jPanelButton.add(jbtContinue);
        jPanelButton.add(jbtExit);

        // add subpanels in panels
        jPanelBottomPart.add(jLabelBottomText);
        jPanelBottomPart.add(jPanelButton);

        jPanelCenterPart.add(jPanelSubCenPart1, BorderLayout.CENTER);
        jPanelCenterPart.add(jPanelSubCenPart2, BorderLayout.SOUTH);

        jMainPanel.add(jPanelTopText, BorderLayout.NORTH);
        jMainPanel.add(jPanelCenterPart, BorderLayout.CENTER);
        jMainPanel.add(jPanelBottomPart, BorderLayout.SOUTH);

        add(jMainPanel);    // add main panel into frame

        // create listener for buttons
        ButtonListener buttonListener = new ButtonListener();

        // register listener for buttons
        jbtContinue.addActionListener(buttonListener);
        jbtExit.addActionListener(buttonListener);

    }

    /**
     * Class ButtonListener is class listener for button
     */
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtContinue) {
                dispose();                              // clear splash window
                // create main window
                JFrame mainWindow = new MainWindow();
                mainWindow.setTitle("Sort arrive");
                mainWindow.setSize(800, 600);
                mainWindow.setLocation(300, 100);
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setVisible(true);
            } else if (e.getSource() == jbtExit) {
                System.exit(0);
            }
        }
    }
}
