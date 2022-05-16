package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class WindowAboutProgram create window about program
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class WindowAboutProgram extends JFrame {
    /**
     * Constructors for instantiation WindowAboutAuthor
     * */
    public WindowAboutProgram(){
        initUI();

    }

    /**
     * Create graphic element and set them place.
     * Process click button with inner class listener
     */
    private void initUI() {
        // create panel for place ui elements
        JPanel jMainPanel = new JPanel(new BorderLayout(5,5));
        JPanel jPanelPicture = new JPanel(new GridLayout(1,2,5,5));
        JPanel jPanelBottomPart = new JPanel(new BorderLayout(5,5));
        JPanel jPanelText = new JPanel(new FlowLayout(FlowLayout.CENTER, 120,5));
        JPanel jPanelHeader = new JPanel(new GridLayout(2, 1, 5, 5));

        // create button and set up
        JButton jButtonBack = new JButton("Back");
        jButtonBack.setPreferredSize(new Dimension(10,35));

        // create labels and set pu
        JLabel jLabel1 = new JLabel("Сортировка пузырьком");
        JLabel jLabel2 = new JLabel("Сортировка выбором");
        JLabel jLabelHeader = new JLabel("Сортировка числовых данных методами " +
                "выбора и пузырьком", SwingConstants.CENTER);
        jLabel1.setFont(new Font("Times New Romance", Font.BOLD, 13));
        jLabel1.setFont(new Font("Times New Romance", Font.BOLD, 13));
        jLabelHeader.setFont(new Font("Times New Romance", Font.BOLD, 17));

        // create images
        ImageIcon iconBubbleSort = new ImageIcon("src/images/bubbleSort1.png");
        ImageIcon iconSelectSort = new ImageIcon("src/images/selectSort1.jpg");

        // create text pane and add into text
        JTextPane jTextPane = new JTextPane();
        String text = "Программа позволяет\n1. Получить массив случайных чисел\n" +
                "(размерность и максимальное значение задаётся или вводится)\n" +
                "2. Сортировать\n" +
                "3. Сохранять результат в файл, содержащий как исходный,\n" +
                "так и сортированный массив";

        jTextPane.setText(text);
        jTextPane.setEditable(false);
        jTextPane.setFont(new Font("Times New Romance", Font.BOLD, 15));

        // add labels and panel into more major panels
        jPanelText.add(jLabel1);
        jPanelText.add(jLabel2);

        jPanelHeader.add(jLabelHeader);
        jPanelHeader.add(jPanelText);

        jPanelPicture.add(new JLabel(iconBubbleSort));
        jPanelPicture.add(new JLabel(iconSelectSort));

        jPanelBottomPart.add(jTextPane, BorderLayout.NORTH);
        jPanelBottomPart.add(jButtonBack, BorderLayout.SOUTH);

        // add panels in main panel
        jMainPanel.add(jPanelHeader, BorderLayout.NORTH);
        jMainPanel.add(jPanelPicture, BorderLayout.CENTER);
        jMainPanel.add(jPanelBottomPart, BorderLayout.SOUTH);

        add(jMainPanel);    // add main panel into frame

        // Anonymous inner class listener for closing window
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
