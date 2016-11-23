import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;

import java.io.File;
import java.io.IOException;

/**
 * Created by cgnal on 17/11/16.
 */
public class CSVconv {
    public static void main(String [] args) throws Exception {

        String filePath = "/Users/cgnal/fabianaTD/cancellami/TeamDigitale/consegna/unbalancedDbForWEKA.csv";
        String filePath2 = "/Users/cgnal/fabianaTD/cancellami/TeamDigitale/consegna/unbalancedDbForWEKA.arff";
        //String filePath = "prova.csv";
        //String filePath2 = "prova.arff";

        CSVLoader loader  = new CSVLoader();
        loader.setSource(new File(filePath));
        Instances data  = loader.getDataSet();

        NumericToNominal filter = new NumericToNominal();
        String[] options = new String[2];
        options[0] = "-R";
        options[1] = "first-last";
        filter.setOptions(options);
        filter.setInputFormat(data);
        data = Filter.useFilter(data , filter);

        //Attribute diabete = data.attribute("DIABETE3");
        //data.setClass(diabete);
        System.out.println(data.get(0).attribute(0).isNominal());

        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File(filePath2));
        saver.setDestination(new File(filePath2));
        saver.writeBatch();
        System.out.println(filePath2);
    }

}
