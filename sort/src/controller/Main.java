package controller;
import window.SplashScreen;
import javax.swing.*;

/**
 * Class Main point start in program
 * Create starting splash window
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class Main {
    public static void main(String[] args) {
        JFrame splashScreen = new SplashScreen();
        splashScreen.setTitle("Splash screen");
        splashScreen.setSize(700, 550);
        splashScreen.setLocation(300, 100);
        splashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashScreen.setVisible(true);
    }
}
