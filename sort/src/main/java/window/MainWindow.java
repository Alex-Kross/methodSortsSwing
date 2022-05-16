package window;

import entity.Array;
import entity.SortedArray;
import logic.BubbleSort;
import logic.SelectSort;
import util.ArrayCreator;
import util.Converter;
import util.WorkingWithFile;
import view.Printer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class MainWindow create main window
 * Create all graphic elements and process interaction with them
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class MainWindow<optionPane_f> extends JFrame {
    private Array array;                                                                  // object contain array
    private SortedArray bubbleSortedArray;                                                // object contain array sorting Bubble
    private SortedArray selectSortedArray;                                                // object contain array sorting Select
    private final String PATHFILESORTEDARRAY = "src/arrayFiles/sortedArray.txt";          // path to file for sorted array
    private final String PATHFILEORIGINARRAY = "src/arrayFiles/sourceArray.txt";          // path to file for origin array
    private WorkingWithFile savingOriginArray = new WorkingWithFile(PATHFILEORIGINARRAY); // object for save origin array in file
    private WorkingWithFile savingSortedArray = new WorkingWithFile(PATHFILESORTEDARRAY); // object for save sorted array in file
    private JMenuItem saveSortedMenuItem;           // menu item for save sorted array
    private JMenuItem saveOriginMenuItem;           // menu item for save origin array
    private JMenuItem exitMenuItem;                 // menu item for exit from program
    private JMenuItem aboutProgramMenuItem;         // menu item for show window about program
    private JMenuItem aboutAuthorMenuItem;          // menu item for show window about author
    private JButton jbtSaveOrigin;                  // button for save origin array
    private JButton jbtSaveSorting;                 // button for save sorted array
    private JButton jbtExit;                        // button for exit from program
    private JButton jbtCreateArrive;                // button for create array
    private JButton jbtSort;                        // button for sort array
    private JButton jbtOpenPreviously;              // button for open previously origin array
    private JTextField jtfValueArray ;       // text field for input max value array
    private JTextField jtfSizeArray ;        // text field for input size array
    private JTextArea jTextAreaBubbleSort;          // text area for show bubble sort
    private JTextArea jTextAreaSelectSort;          // text area for show select sort
    private String speedBubbleSort;                 // string for show speed bubble sort
    private String speedSelectSort;                 // string for show speed select sort
    private JLabel jlbSpeedSorting1;             // label contain string speedBubbleSort
    private JLabel jlbSpeedSorting2;             // label contain string speedSelectSort
    /**
     * Constructors for instantiation MainWindow
     * */
    public MainWindow() {
        initUI();
    }

    /**
     * Create graphic element and set them place.
     * Process click button with anonymous inner class and inner class listener
     */
    private void initUI() {
        // call method for creating menubar
        createMenu();

        // create panels for place elements
        JPanel jMainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));     // major panel for all panels
        JPanel jInteractPanel = new JPanel(new GridLayout(8, 1, 10, 15));  // panel with buttons and fields input
        JPanel jPanelSizeArray = new JPanel(new BorderLayout(10, 5));                // panel for input size array
        JPanel jPanelValueArray = new JPanel(new BorderLayout(10, 5));               // panel for input max value array
        JPanel jPanelArray = new JPanel(new BorderLayout(3, 35));                    // panel for arrays
        JPanel jPanelSpeedSorting = new JPanel(new GridLayout(1, 2));                 // panel for speeds sorting
        JPanel jPanelSortedArray = new JPanel(new BorderLayout(3, 10));              // panel for sorted array
        JPanel jPanelUnsortedArray = new JPanel(new BorderLayout(3, 10));            // panel for unsorted array

        //initial element input max value array and place them
        JLabel jlbValueArray = new JLabel("Max value array");
        jtfValueArray = new JTextField(10);
        jPanelValueArray.add(jlbValueArray, BorderLayout.NORTH);
        jPanelValueArray.add(jtfValueArray, BorderLayout.SOUTH);

        //initial element input size array and place them
        JLabel jlbSizeArray = new JLabel("Size array");
        jtfSizeArray = new JTextField(10);
        jPanelSizeArray.add(jlbSizeArray, BorderLayout.NORTH);
        jPanelSizeArray.add(jtfSizeArray, BorderLayout.SOUTH);

        jtfSizeArray.setText("10");      // set initial size array
        jtfValueArray.setText("100");    // set initial max value array

        // initial text area and label for unsorted array and place them
        JLabel jlbBubbleSort = new JLabel("Bubble sorting array");
        jTextAreaBubbleSort = new JTextArea();
        jTextAreaBubbleSort.setColumns(25);
        jTextAreaBubbleSort.setRows(22);
        jTextAreaBubbleSort.setEditable(false);
        JScrollPane jScrollPanelBubbleSort = new JScrollPane(jTextAreaBubbleSort);
        jPanelUnsortedArray.add(jlbBubbleSort, BorderLayout.NORTH);
        jPanelUnsortedArray.add(jScrollPanelBubbleSort);

        // initial text area and label for sorted array and place them
        JLabel jlbSelectSort = new JLabel("Select sorting array");
        jTextAreaSelectSort = new JTextArea();
        jTextAreaSelectSort.setColumns(25);
        jTextAreaSelectSort.setRows(22);
        jTextAreaSelectSort.setEditable(false);
        JScrollPane jScrollPanelSelectSort = new JScrollPane(jTextAreaSelectSort);
        jPanelSortedArray.add(jlbSelectSort, BorderLayout.NORTH);
        jPanelSortedArray.add(jScrollPanelSelectSort);

        // initial label for speed sorting and place them
        speedBubbleSort = "Speed method Bubble sort: ";
        speedSelectSort = "Speed method Select sort: ";
        jlbSpeedSorting1 = new JLabel(speedBubbleSort);
        jlbSpeedSorting2 = new JLabel(speedSelectSort);
        jPanelSpeedSorting.add(jlbSpeedSorting1);
        jPanelSpeedSorting.add(jlbSpeedSorting2);

        // group speed sorting and text areas for array on common panel
        jPanelArray.add(jPanelSpeedSorting, BorderLayout.NORTH);
        jPanelArray.add(jPanelUnsortedArray, BorderLayout.WEST);
        jPanelArray.add(jPanelSortedArray);

        // create buttons for interact with user and place them
        jbtCreateArrive = new JButton("Create arrive");                     // create random arrive
        jbtSort = new JButton("Sorting");                                   // sort arrive
        jbtSaveOrigin = new JButton("Save origin arrive");                  // save unsorted arrive
        jbtSaveSorting = new JButton("Save sort arrive");                   // save sorted arrive
        jbtOpenPreviously = new JButton("Open Previously arrive");          // open previously arrive
        jbtExit = new JButton("Exit");                                      // exit from program
        jInteractPanel.add(jPanelValueArray);
        jInteractPanel.add(jPanelSizeArray);
        jInteractPanel.add(jbtCreateArrive);
        jInteractPanel.add(jbtSort);
        jInteractPanel.add(jbtSaveOrigin);
        jInteractPanel.add(jbtSaveSorting);
        jInteractPanel.add(jbtOpenPreviously);
        jInteractPanel.add(jbtExit);

        // place panels on Major panel
        jMainPanel.add(jPanelArray);
        jMainPanel.add(jInteractPanel);

        // place Major panels on Frame
        add(jMainPanel);

        // create listener for all buttons
        ButtonListener buttonListener = new ButtonListener();

        // register listener for buttons
        jbtCreateArrive.addActionListener(buttonListener);
        jbtSort.addActionListener(buttonListener);
        jbtSaveOrigin.addActionListener(buttonListener);
        jbtSaveSorting.addActionListener(buttonListener);
        jbtOpenPreviously.addActionListener(buttonListener);
        jbtExit.addActionListener(buttonListener);

        // Anonymous inner class listener for closing program when window will be closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // record empty string in files
                savingOriginArray.writeInFile("");
                savingSortedArray.writeInFile("");
                super.windowClosing(e);
            }
        });
    }

    /**
     * Create menu Bar
     */
    private void createMenu() {
        // create menu bar
        JMenuBar jMenuBar = new JMenuBar();

        //create menus
        JMenu fileMenu = new JMenu("File");
        JMenu infoMenu = new JMenu("Information");

        // create menu items
        saveSortedMenuItem = new JMenuItem("Save sorted array");
        saveOriginMenuItem = new JMenuItem("Save origin array");
        exitMenuItem = new JMenuItem("Exit");
        aboutProgramMenuItem = new JMenuItem("About program");
        aboutAuthorMenuItem = new JMenuItem("About author");

        // add menu item to menus
        fileMenu.add(saveSortedMenuItem);
        fileMenu.add(saveOriginMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        infoMenu.add(aboutProgramMenuItem);
        infoMenu.add(aboutAuthorMenuItem);

        // add menu to menubar
        jMenuBar.add(fileMenu);
        jMenuBar.add(infoMenu);

        // set menubar for frame
        setJMenuBar(jMenuBar);

        // create listener for menu items
        ButtonListener buttonListener = new ButtonListener();

        // register listener for menu items
        saveSortedMenuItem.addActionListener(buttonListener);
        saveOriginMenuItem.addActionListener(buttonListener);
        exitMenuItem.addActionListener(buttonListener);
        aboutProgramMenuItem.addActionListener(buttonListener);
        aboutAuthorMenuItem.addActionListener(buttonListener);
    }

    /**
     * Class ButtonListener is class listener for all button and menu items in MainWindow
     */
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtSaveOrigin || e.getSource() == saveOriginMenuItem) {
                try {
                    savingOriginArray.writeInFile(array.toString());
                } catch (NullPointerException exception) {
                    Printer.printInConsole("Create arrive!");
                }
            }
            else if (e.getSource() == jbtSaveSorting || e.getSource() == saveSortedMenuItem) {
                try {
                    savingSortedArray.writeInFile(bubbleSortedArray.toString());
                } catch (NullPointerException exception) {
                    Printer.printInConsole("Sort arrive!");
                }
            }
            else if (e.getSource() == jbtExit || e.getSource() == exitMenuItem) {
                // record empty string in files
                savingOriginArray.writeInFile("");
                savingSortedArray.writeInFile("");
                System.exit(0);
            }
            else if (e.getSource() == jbtCreateArrive) {
                try {
                    String stringMaxRange = jtfValueArray.getText();
                    String stringSizeArray = jtfSizeArray.getText();

                    // check input size array on empty
                    if (stringSizeArray.equals("")) {
                        throw new IllegalArgumentException("Input size array");
                    }

                    // check input max value array on empty
                    if (stringMaxRange.equals("")) {
                        throw new IllegalArgumentException("Input max value array ");
                    }

                    // check length number for set size array
                    if (stringSizeArray.charAt(0) == '-') {
                        if (stringSizeArray.length() > 7) {
                            throw new IllegalArgumentException("Size array can be only length 1-6");
                        }
                    }
                    else if (stringSizeArray.length() > 6) {
                        throw new IllegalArgumentException("Size array can be only length 1-6");
                    }

                    // check length number for set max range
                    if (stringMaxRange.charAt(0) == '-') {
                        if (stringMaxRange.length() > 11) {
                            throw new IllegalArgumentException("Max range can be only length 1-10");
                        }
                    }
                    else if (stringMaxRange.length() > 10) {
                        throw new IllegalArgumentException("Max range can be only length 1-10");
                    }

                    // set parameters array
                    int maxRange = Integer.parseInt(stringMaxRange);
                    int sizeArray = Integer.parseInt(stringSizeArray);

                    // check input max value array on negative
                    if (maxRange <= 0) {
                        throw new IllegalArgumentException("Max value can be only positive!");
                    }

                    // check input size array on negative
                    if (sizeArray <= 0) {
                        throw new IllegalArgumentException("Size array can be only positive!");
                    }
                    // create array and fill random number
                    array = new Array(sizeArray);
                    ArrayCreator arrayCreator = new ArrayCreator(maxRange);
                    arrayCreator.fillRandomNumber(array.getArray());

                    // record arrive in areas text
                    jTextAreaBubbleSort.setText(array.toString());
                    jTextAreaSelectSort.setText(array.toString());

                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(MainWindow.this,
                            "Input integer number or you exceed access number length! ");
                    Printer.printInConsole("Input integer number or you exceed access number length! ");
                }
                catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(MainWindow.this, exception.getMessage());
                    Printer.printInConsole(exception.getMessage());
                }

            }
            else if (e.getSource() == jbtSort) {
                try {
                    // create objects sort
                    BubbleSort bubbleSort = new BubbleSort();
                    SelectSort selectSort = new SelectSort();

                    // record arrive in areas text
                    jTextAreaBubbleSort.setText(array.toString());
                    jTextAreaSelectSort.setText(array.toString());

                    // sort arrive through two arrive
                    bubbleSortedArray = new SortedArray(bubbleSort.sortArray(array.getArray()));
                    selectSortedArray = new SortedArray(selectSort.sortArray(array.getArray()));

                    // linking class Print with certain area text
                    Printer printerBubbleSort = new Printer(jTextAreaBubbleSort);
                    Printer printerSelectSort = new Printer(jTextAreaSelectSort);

                    //print sorts step by step
                    printerBubbleSort.printInTextArea(bubbleSort.getStepByStepSorting());
                    printerSelectSort.printInTextArea(selectSort.getStepByStepSorting());

                    // set speed sorting on labels
                    jlbSpeedSorting1.setText(speedBubbleSort + bubbleSort.getTimeSort());
                    jlbSpeedSorting2.setText(speedSelectSort + selectSort.getTimeSort());
                } catch (NullPointerException exception) {
                    JOptionPane.showMessageDialog(MainWindow.this, exception.getMessage());
                    Printer.printInConsole("Create arrive!");
                }

            }
            else if (e.getSource() == jbtOpenPreviously) {

                // get string from previously origin array
                String data = savingOriginArray.getDataFromFile();

                // calculation number elements in string for setting size array
                int sizeNewArray = Converter.CulNumElsInString(data);

                // create array with new size
                array = new Array(sizeNewArray);

                // convert string in arrive and set array  in object array
                Converter.fromStringToArray(data, array.getArray());

                // record arrive in areas text
                jTextAreaBubbleSort.setText(array.toString());
                jTextAreaSelectSort.setText(array.toString());
            }
            else if (e.getSource() == aboutAuthorMenuItem) {
                //create window about author
                JFrame windowAboutAuthor = new WindowAboutAuthor();
                windowAboutAuthor.setTitle("About Author");
                windowAboutAuthor.setSize(300, 440);
                windowAboutAuthor.setLocation(300, 100);
                windowAboutAuthor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                windowAboutAuthor.setVisible(true);
            }
            else if (e.getSource() == aboutProgramMenuItem) {
                //create window about program
                JFrame windowAboutProgram = new WindowAboutProgram();
                windowAboutProgram.setTitle("About Program");
                windowAboutProgram.setSize(560, 500);
                windowAboutProgram.setLocation(300, 100);
                windowAboutProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                windowAboutProgram.setVisible(true);
            }
        }
    }
}
