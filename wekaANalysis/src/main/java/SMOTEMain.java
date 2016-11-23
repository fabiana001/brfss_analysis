import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;
import weka.filters.Filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by cgnal on 17/11/16.
 */
public class SMOTEMain {
    public static void main(String [] args) throws Exception {

        String input = "/Users/cgnal/fabianaTD/cancellami/TeamDigitale/consegna/unbalancedDbForWEKA.arff";
        String output = "/Users/cgnal/fabianaTD/cancellami/TeamDigitale/consegna/balancedDataset.csv";
        BufferedReader reader = new BufferedReader(new FileReader(input));
        ArffLoader.ArffReader arff = new ArffLoader.ArffReader(reader);
        Instances data = arff.getData();

        SMOTE smote = new SMOTE();
        smote.setClassValue("DIABETE3");
        //smote.setPercentage(factor * 100.0);
        //smote.setNearestNeighbors(5);
        //smote.setPercentage(10);
        smote.setInputFormat(data);
        Instances instancesNew = Filter.useFilter(data, smote);

        System.out.println("SMOTE APPLIED: " + data.numInstances() + " " + instancesNew.numInstances() +" for class" + smote.getClassValue());

        CSVSaver saver = new CSVSaver();
        saver.setInstances(data);
        saver.setFile(new File(output));
        saver.writeBatch();
        System.out.println("CSV saved in " + output);

    }
}
