package util;
import view.Printer;

import java.io.*;

/**
 * Class WorkWithFile write(read) array in(from) file
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class WorkingWithFile {
    // Path location file
    private String fileName;

    /**
     * Constructors for instantiation fileName
     *
     * @param fileName path location file
     * */
    public WorkingWithFile(String fileName){
        this.fileName = fileName;
    }

    /**
     * Write in file array
     *
     * @param array array which will be record in file
     * */
    public void writeInFile(String array){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            bw.write(array.toString());
        }
        catch(IOException ex){

            Printer.printInConsole(ex.getMessage());
        }
    }

    /**
     * Read from file string with array
     *
     * @return str string with array
     * */
    public String getDataFromFile(){
        String c, stringInFie = "";
        try(BufferedReader br = new BufferedReader (new FileReader(fileName)))
        {
            while((c=br.readLine())!=null){
                stringInFie += c;
            }
        }
        catch(IOException ex){
            Printer.printInConsole(ex.getMessage());
        }
        return stringInFie;
    }
}
