package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {

    String filePath = null;

    public StockFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getHeaders() throws IOException {
        String line = readFirstLine(filePath);
        String[] header = line.split(",");
        List<String> values = Arrays.asList(header); // converts the array values to ArrayList values
        return values;
    }

    static String readFirstLine(String path) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /**
     * Complete the body of this method.
     *
     * @return List
     * @throws IOException
     */
    public List<String> readFileData() throws IOException {
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath));){
            //skip first line
            br.readLine();
            String line;
            //advance from second line
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }


}
