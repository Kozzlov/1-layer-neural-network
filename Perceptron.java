package nai_3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Perceptron {
	private LangVector language = new LangVector();
	private LangVector weight = new LangVector();
	private double theta = 0.1;
	private double alpha = 0.5;
	public double actualOutput = 0.0;

					
	public Perceptron(LangVector language) {
		this.language = language;
		for(int i=0;i<this.weight.points.length; i++) {
			this.weight.points[i]=0.1;
		}
	}
	public LangVector getWeight() {
		return this.weight;
	}
	
	public int calculateOutput(LangVector vector) {
		double output=0.0;
		for(int i=0; i<vector.points.length; i++){
			output+=this.weight.points[i]*vector.points[i];
		}
		if(output>=this.theta)vector.BeingActiveValue=1;
		else vector.BeingActiveValue=0;
		System.out.println("BeingActiveValue : "+vector.BeingActiveValue);
		return vector.BeingActiveValue;
	}
	
	public double ActualOutputOfLanguege(LangVector vector) {
		double output=0.0;
		for(int i=0; i<vector.points.length; i++){
			//System.out.println("Index " + i + " value: " + this.weight.points[i] + " Vector " + vector.points[i]);
			output+=this.weight.points[i]*vector.points[i];
		}
		output=output-this.theta;
		System.out.println("output  : "+output);
		return output;
	}
	
public static void learn(List<Perceptron> trainVectors ){
    for (Perceptron perceptron : trainVectors){
    	int correctOutputs = 0;
    	int incorrectOutputs = 0;
    	for(Perceptron language: trainVectors) {
    		if(perceptron.actualOutput == perceptron.ActualOutputOfLanguege(language.language)) {
    			if(perceptron.language == language.language) {
    				correctOutputs++;
    			}else {
    				incorrectOutputs++;
    			}
    		}else {
    			incorrectOutputs++;
    		}
    	}
    	System.out.println("Correct outputs :"+correctOutputs+" , incorrectOutputs :"+incorrectOutputs);
    }
}
//double err=0;

    public void trainPerceptron(LangVector vector) {
        int errRange = vector.trueValue - vector.BeingActiveValue;
        if (errRange == 0) return;
        LangVector newWeight = new LangVector();
        for (int i = 0; i < vector.points.length; ++i) {
            newWeight.points[i] = this.weight.points[i] + (errRange * this.alpha * vector.points[i]);
        }
        this.weight = newWeight;
        this.theta += errRange * this.alpha * -1;
    }
}


