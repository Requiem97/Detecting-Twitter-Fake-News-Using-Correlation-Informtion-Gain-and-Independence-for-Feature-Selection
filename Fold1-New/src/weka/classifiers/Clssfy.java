package weka.classifiers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

public class Clssfy {
	public static void main (String args[]){
		ProposedClassifier ww = new ProposedClassifier();
		 try {
			  CSVLoader loader = new CSVLoader();
			  loader.setSource(new File("src/fold1.csv"));
			  Instances data = loader.getDataSet();
			  data.setClassIndex(data.numAttributes()-1);
			  FileWriter fileWriter = new FileWriter("src/out.txt");
		      PrintWriter printWriter = new PrintWriter(fileWriter);
			  for (int i=0; i < data.numInstances(); i++){
				  Instance ni = data.instance(i);
				  //ww.chi2(ni);
				  String res = (ww.classifyInstance(ni)==1)?"FALSE":"TRUE";
				  printWriter.println(res);
				  System.out.println(res);
			  }
			  printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
