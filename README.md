# brfss_analysis
Analysis of Behavioral Risk Factor Surveillance System dataset

The repository contains the following files:
1. DescribeData.ipynb: contanins the data understaing task
2. preprocess_UnBalanced_dataset.ipynb: contains the data preparation task
3. Classification.ipynb: contains the modeling and evaluation task.

The project *wekaAnalisys* is a java project which us the Weka SMOTE algorithm to generate a balanced dataset. 
To use this project save the dataset returned by DescribeData.ipynb script in a csv format. It returns a new balanced dataset in a csv format.
Use that to execute the preprocessing task, the model learning and the evaluation tasks.

For running the code in *wekaAnalisys*:
1. sbt assembly
2. java -Xmx30G -cp /path_to/wekaANalysis-assembly-1.0.jar MainClass  unbalancedDbForWEKA.csv

