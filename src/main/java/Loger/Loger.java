package Loger;

import Model.ComplexNumberM;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;

public class Loger {
    public void loger1(String s, ComplexNumberM.ComplexNumber result) throws IOException {
        try (FileWriter fileWriter = new FileWriter("ComplexCalc.txt", true)){
                fileWriter.append(new Date()+ "\n Исполнена математическая операция - >>> " + s + "\n" + "result of Math Complex Numbers " + result + "\n\r");
            }
        }

    }

