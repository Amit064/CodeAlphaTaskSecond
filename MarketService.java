import java.util.HashMap;
import java.util.Map;

public class MarketService {
    private Map<String, Stock> marketData = new HashMap<>();

    public MarketService() {
        marketData.put("AAPL", new Stock("AAPL", 150.0));
        marketData.put("GOOGL", new Stock("GOOGL", 2800.0));
    }

    public Stock getStock(String symbol) {
        return marketData.get(symbol);
    }
}
