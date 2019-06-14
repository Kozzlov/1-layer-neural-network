package nai_3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final File TE = new File("D:\\Рабочий стол\\Task3\\English\\En.txt");
    public static final File TF = new File("D:\\Рабочий стол\\Task3\\French\\Fr.txt");
    public static final File TS = new File("D:\\Рабочий стол\\Task3\\Spanish\\Sp.txt");


	public static void main(String[] args) {
		
        LangVector eng = new LangVector("eng");
        eng.readData(TE);
        Perceptron EP = new Perceptron(eng);
        EP.actualOutput =EP.ActualOutputOfLanguege(eng);
        EP.calculateOutput(eng);        
       
        LangVector frch = new LangVector("frch");
        frch.readData(TF);
        Perceptron FP = new Perceptron(frch);
        FP.actualOutput = FP.ActualOutputOfLanguege(frch);
        FP.calculateOutput(frch);


        LangVector span = new LangVector("span");
        span.readData(TS);
        Perceptron SP = new Perceptron(span);
        SP.actualOutput = SP.ActualOutputOfLanguege(span);
        SP.calculateOutput(span);
        

        List <Perceptron> perceptrons = new ArrayList<Perceptron>();
        perceptrons.add(EP);
        perceptrons.add(FP);
        perceptrons.add(SP);
         int size ;
         System.out.println(size = perceptrons.size());
         
         Perceptron.learn(perceptrons);


        


        
        
        //Perceptron englishPerceptron = new Perceptron(englishVector);
	}
}
