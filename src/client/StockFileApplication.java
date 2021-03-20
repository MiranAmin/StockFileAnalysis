package client;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockFileApplication {

    public static void main(String args[]) throws IOException {
        StockFileReader fr = new StockFileReader("table.csv");

        List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
        StockFileData fileData = new StockFileData();
        fileData.addData(dataResult);
        fileData.printData();
        System.out.println(dataResult.size());
    }

    /**
     * Complete the method body so that it returns the given structure needed to
     * populate the data field in the StockFileData class.
     *
     * @param headers
     * @param lines
     * @return List
     */
    public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
        List<HashMap<String, Double>> dataResult = new ArrayList<>();
        HashMap<String, Double> headerValueMap = new HashMap<>();
        for (String line : lines) {
            String[] values = line.split(",");
            int count = 0;
            for (String value : values) {
                Double doubleValue = Double.parseDouble(value);
                headerValueMap.put(headers.get(count), doubleValue);
                count++;
            }
            dataResult.add(headerValueMap); //gets each new line added to it after loop reaches end of values
        }
        return dataResult;
    }


}
