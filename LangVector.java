package nai_3;

import java.io.BufferedReader; 

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.charset.StandardCharsets.UTF_8;

public class LangVector {
	// NUMBER OF LETTERS IN ASCII ALPHABET
	public double letters[] = new double[26];
    public double points[] = new double[26];
    public int BeingActiveValue;
    public int trueValue;
    public String language;

    
    
    public LangVector(String language){
        this.language = language;
    }
    
    public LangVector(){
    }
    
    
    public void createLangVector(String line) {
        line = line.toLowerCase();
        for (int letter = 0; letter < line.length(); letter++) {
            if (line.charAt(letter) >= 'a'  && line.charAt(letter) <= 'z')
                this.letters[line.charAt(letter) - 'a']++;
            }
        }
    
    public static File [] getlangList(String path) {
    	return new File(path).listFiles(File::isDirectory);
    }

    public void readData(File file) {
        if (!file.exists() || !file.isFile()) {
            System.out.println("NO FILE");
            System.exit(-1);
        }
        try {
            BufferedReader readData = Files.newBufferedReader(Paths.get(file.toURI()), UTF_8);
            String line = readData.readLine();
            while (line != null) {
            	createLangVector(line);
                line = readData.readLine();
            }
            readData.close();
        }
        catch (IOException e) {
            System.out.println("NOT PROPPER FORMAT OF DATA");
            System.exit(-2);
        }
        proportion();
    }
    
    public void printLetters(){
        char letter = 'A';
        for (int i = 0; i < this.letters.length ; i++) {
            System.out.print(letter + "." + (int) this.letters[i] + " ");
            if (i % 3 == 0) System.out.println();
            ++letter;
        }
        System.out.println();
    }
    
    public void proportion() {
        double totalLetters = 0;
        for (double letter : this.letters) {
            totalLetters += letter;
        }
        System.out.println(this.language + " " + totalLetters + " INPUT");
        for (int i = 0; i < this.letters.length; i++) {
            this.points[i] = this.letters[i]+1 / totalLetters;
        }
    }

    @Override
    public String toString(){
        StringBuilder allPoints = new StringBuilder("[");
        for (int i = 0; i < this.points.length - 1; ++i) {
            allPoints.append(this.points[i]).append(", ");
        }
        allPoints.append(this.points[this.points.length - 1]).append("]");
        allPoints.append(" - ").append(this.trueValue);
        return allPoints.toString();
    }
}
