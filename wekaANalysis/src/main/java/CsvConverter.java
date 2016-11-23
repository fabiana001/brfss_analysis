import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;
import java.io.File;

/**
 * Created by cgnal on 17/11/16.
 */
public class CsvConverter {

    public static void run(String path_X, String path_Y, String output) throws Exception {
        Instances data_x = loadCSV(path_X);
//        Instances data_y = loadCSV(path_Y);
//
//        double[] values = data_y.attributeToDoubleArray(1);
//        String originalRelationName = data_x.relationName();
//        int size = data_x.numAttributes();
//        try {
//            Add addF = new Add();
//            addF.setAttributeName("DIABETE3");
//            //addF.setAttributeIndex(String.valueOf(size));
//            addF.setInputFormat(data_x);
//            data_x = Filter.useFilter(data_x, addF);
//
//            for (int i = 0; i < data_x.numInstances(); i++) {
//
//                data_x.instance(i).setValue(size, values[i]);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//




        NumericToNominal filter = new NumericToNominal();
        String[] options = new String[2];
        options[0] = "-R";
        options[1] = "first-last";
        filter.setOptions(options);
        filter.setInputFormat(data_x);
        data_x = Filter.useFilter(data_x , filter);
        data_x.setClassIndex(data_x.numAttributes()-1);



        ArffSaver saver = new ArffSaver();
        saver.setInstances(data_x);
        saver.setFile(new File(output));
        saver.setDestination(new File(output));
        saver.writeBatch();
        //System.out.println(data_x.numAttributes());

    }
    public static void main(String [] args) throws Exception {


        String path_X = "/Users/cgnal/Downloads/TeamDigitale/notebooks/unbalancedDbForWEKA.csv";
        String path_Y = "unbalancedDbForWEKA_Y.csv";
        //String filePath = "/Users/cgnal/fabianaTD/cancellami/TeamDigitale/consegna/prova.csv";
        String filePath2 = "output.arff";
        run(path_X, path_Y, filePath2);



    }

    public static Instances loadCSV(String path) throws Exception{
        CSVLoader loader  = new CSVLoader();
        loader.setSource(new File(path));
        Instances data  = loader.getDataSet();
        return data;
    }

}
