package aggregators;

import fileprocessors.StockFileReader;
import java.io.IOException;
import java.util.List;
import static java.lang.Double.parseDouble;

public class AggregatorProcessor <E extends Aggregator> {
    private E aggregator;
    private String filePath;

    public AggregatorProcessor(E aggregator, String filePath) {
        this.aggregator = aggregator;
        this.filePath = filePath;
    }

    //must calculate the value of in a given column
    public double runAggregator(int column) throws IOException {
        StockFileReader reader = new StockFileReader(filePath);
        List<String> lines = reader.readFileData();
        String[] lineColumn;
        for (String line : lines) {
            lineColumn = line.split(",");
            aggregator.add(parseDouble(lineColumn[column-1]));
        }
        return aggregator.calculate();
    }
}
