/**
 * Created by cgnal on 17/11/16.
 */
public class MainClass {

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            String path_X = args[0];

            String arffFile = "./out.arff";
            String out = "./balancedDataset.csv";
            System.out.println(path_X + " " + arffFile + " " + out);
            System.out.println("Starting Arff generation");
            CsvConverter.run(path_X, "", arffFile);
            System.out.println("End Arff generation");
            System.out.println("starting SMOTE");
            Long start = System.currentTimeMillis();
            Oversampler.run(arffFile, out);
            Long end = (System.currentTimeMillis()-start)/1000;
            System.out.println("END SMOTE after " + end + "sec ");
        } else {
            String path_X = "./unbalancedDbForWEKA_X.csv";
            String path_Y = "./unbalancedDbForWEKA_Y.csv";
            String arffFile = "./out.arff";
            String out = "./balanced_dataset.csv";
            CsvConverter.run(path_X, path_Y, arffFile);
            Oversampler.run(arffFile, out);
        }
    }
}
