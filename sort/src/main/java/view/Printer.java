package view;

import javax.swing.JTextArea;

/**
 * Class Print for output string in different elements program
 * Can output string to console or textArea and always might add
 * new element for output string
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class Printer {
    private JTextArea jTextArea;    // text area where will be output string

    public Printer(){
    }
    /**
     * Constructors for instantiation JTextArea
     *
     * @param jTextArea element text area
     * */
    public Printer(JTextArea jTextArea){
        this.jTextArea = jTextArea;
    }

    /**
     * return field text area
     *
     * @return jTextArea element text area
     * */
    public JTextArea getjTextArea() {
        return jTextArea;
    }

    /**
     * set field text area
     *
     * @param jTextArea element text area
     * */
    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    /**
     * Print string in console
     *
     * @param str string data
     * */
    public static void printInConsole(String str){
        System.out.println(str);
    }

    /**
     * Print string in text area
     *
     * @param str string data
     * */
    public void printInTextArea(String str){
        jTextArea.append(str);
    }
}
