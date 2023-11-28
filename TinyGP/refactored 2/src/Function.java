import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Function {
    public String equation;
    public double[][] targets;

    public int
        variableNumber,
        constantsNumber,
        instanceNumber;
    
    public double
        randomMax,
        randomMin;

    //! ---------- CONSTRUCTORS ----------
    public Function(String equation, String dataPath, String functionName) {
        this.equation = equation;

        var f = functionName.split("_");
        dataPath = dataPath + '/' + f[0] + '/' + functionName + "/dat/";

        String dataFile = dataPath + "_data.txt";
        String programOutFile = dataPath + "ari_fun.dat";
        String statisticsOutFile = dataPath + "ari_sts.csv";

        var programOut = OutInterface.createOutputToFile(programOutFile);
        var statisticsOut = OutInterface.createOutputToFile(statisticsOutFile);
        
        TinyGP.setupOutput(programOut, statisticsOut, System.out::print);

        try {
            setupTargets(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + dataFile);
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Error while reading file: " + dataFile);
            System.exit(1);
        }
    }


    //! ---------- SETUP ----------
    public void setupTargets(String datafile) throws Exception {
        var reader = new BufferedReader(new FileReader(datafile));

        String line = reader.readLine();
        var tokens = new StringTokenizer(line);
        
        variableNumber = Integer.parseInt(tokens.nextToken().trim());
        constantsNumber = Integer.parseInt(tokens.nextToken().trim());
        randomMin = Double.parseDouble(tokens.nextToken().trim());
        randomMax = Double.parseDouble(tokens.nextToken().trim());
        instanceNumber = Integer.parseInt(tokens.nextToken().trim());

        
        if (variableNumber + constantsNumber > Program.Const.FSET_START) {
            reader.close();
            throw new Exception("Too many variables and constants");
        }
        
        targets = new double[instanceNumber][variableNumber + 1];
        for (int i = 0; i < instanceNumber; i++) {
            line = reader.readLine();
            tokens = new StringTokenizer(line);
            
            targets[i] = new double[variableNumber + 1];
            for (int j = 0; j <= variableNumber; j++)
                targets[i][j] = Double.parseDouble(tokens.nextToken().trim());
        }

        reader.close();
    }
}
