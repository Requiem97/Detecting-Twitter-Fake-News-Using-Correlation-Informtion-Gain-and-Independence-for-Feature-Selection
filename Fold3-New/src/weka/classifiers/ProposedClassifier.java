package weka.classifiers;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;
import weka.classifiers.AbstractClassifier;

public class ProposedClassifier
  extends AbstractClassifier {

  /**
   * Returns only the toString() method.
   *
   * @return a string describing the classifier
   */
  public String globalInfo() {
    return toString();
  }

  /**
   * Returns the capabilities of this classifier.
   *
   * @return the capabilities
   */
  public Capabilities getCapabilities() {
    weka.core.Capabilities result = new weka.core.Capabilities(this);

    result.enable(weka.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.NUMERIC_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.DATE_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.MISSING_VALUES);
    result.enable(weka.core.Capabilities.Capability.NOMINAL_CLASS);
    result.enable(weka.core.Capabilities.Capability.MISSING_CLASS_VALUES);


    result.setMinimumNumberInstances(0);

    return result;
  }

  /**
   * only checks the data against its capabilities.
   *
   * @param i the training data
   */
  public void buildClassifier(Instances i) throws Exception {
    // can classifier handle the data?
    getCapabilities().testWithFail(i);
  }

  /**
   * Classifies the given instance.
   *
   * @param i the instance to classify
   * @return the classification result
   */
  int tt = 0;
  int tf = 0;
  int ft = 0;
  int ff = 0;
  public double classifyInstance(Instance i) throws Exception {
    Object[] s = new Object[i.numAttributes()];
    
    for (int j = 0; j < s.length; j++) {
      if (!i.isMissing(j)) {
    	  
        if (i.attribute(j).isNominal())
          s[j] = new String(i.stringValue(j));
        else if (i.attribute(j).isNumeric())
          s[j] = new Double(i.value(j));
      }
    }
 
    
    /*if(s[2].equals("TRUE")&&s[15].equals("TRUE")) tt++;
    else if(s[2].equals("TRUE")&&s[15].equals("FALSE")) tf++;
    else if(s[2].equals("FALSE")&&s[15].equals("TRUE")) ft++;
    else ff++;
    
    System.out.println("TT "+tt);
    System.out.println("TF "+tf);
    System.out.println("FT "+ft);
    System.out.println("FF "+ff);*/
    
   
    //2, 28
    // set class value to missing
    s[i.classIndex()] = null;
    
    return WekaClassifier.classify(s);
  }
  
  public void chi2(Instance i) throws Exception {
	    Object[] s = new Object[i.numAttributes()];
	    
	    for (int j = 0; j < s.length; j++) {
	      if (!i.isMissing(j)) {
	    	  
	        if (i.attribute(j).isNominal())
	          s[j] = new String(i.stringValue(j));
	        else if (i.attribute(j).isNumeric())
	          s[j] = new Double(i.value(j));
	      }
	    }
	    if(s[34].equals("TRUE")&&s[15].equals("TRUE")) tt++;
	    else if(s[34].equals("TRUE")&&s[15].equals("FALSE")) tf++;
	    else if(s[34].equals("FALSE")&&s[15].equals("TRUE")) ft++;
	    else ff++;
	    
	    System.out.println("TT "+tt);
	    System.out.println("TF "+tf);
	    System.out.println("FT "+ft);
	    System.out.println("FF "+ff);
  }

  /**
   * Returns the revision string.
   * 
   * @return        the revision
   */
  public String getRevision() {
    return RevisionUtils.extract("1.0");
  }

  /**
   * Returns only the classnames and what classifier it is based on.
   *
   * @return a short description
   */
  public String toString() {
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.8.1).\n" + this.getClass().getName() + "/WekaClassifier";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  /*public static void main(String args[]) {
    runClassifier(new WekaWrapper(), args);
  }*/
}

class WekaClassifier {

	public static double classify(Object[] i)
		    throws Exception {

		double p = 0;
	    return p;
	  }
		  
		  
}
