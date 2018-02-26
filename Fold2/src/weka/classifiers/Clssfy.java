package weka.classifiers;

import java.io.File;
import java.io.IOException;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

public class Clssfy {
	public static void main (String args[]){
		ProposedClassifier ww = new ProposedClassifier();
		 try {
			  CSVLoader loader = new CSVLoader();
			  loader.setSource(new File("src/fold2.csv"));
			  Instances data = loader.getDataSet();
			  data.setClassIndex(data.numAttributes()-1);
			  for (int i=0; i < data.numInstances(); i++){
				  Instance ni = data.instance(i);
				  //ww.chi2(ni);
				  String res = (ww.classifyInstance(ni)==1)?"FALSE":"TRUE";
				  System.out.println(res);
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
