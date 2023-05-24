# hyphen-outliers

Setup Instructions

Assumptions 
This projects assumes that you have maven and Java 11 installed on your system and property added in Environment PATH variable.

The Project is using ZScore Outlier Detection Algorithm.

1. Unzip the zip project
2. Go to "outliers" directory in the project
    cd <Path to Hyphen Folder>/outliers
3. Run the following command
    mvn clean
4. Run the following command
    mvn clean compile assembly:single

5. Run the following command 
    java -jar target/outliers-1.0-SNAPSHOT-jar-with-dependencies.jar

The last command will create a file cleanData.csv with all the outliers Removed.