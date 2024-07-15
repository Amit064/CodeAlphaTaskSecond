    import java.util.HashMap;
    import java.util.Map;
    
    public class Portfolio {
        private Map<String, Integer> stocks = new HashMap<>();
        private double cash;
    
        public Portfolio(double initialCash) {
            this.cash = initialCash;
        }
    
        public Map<String, Integer> getStocks() {
            return stocks;
        }
    
        public double getCash() {
            return cash;
        }
    
        public void addStock(String symbol, int quantity) {
            stocks.put(symbol, stocks.getOrDefault(symbol, 0) + quantity);
        }
    
        public void removeStock(String symbol, int quantity) {
            stocks.put(symbol, stocks.get(symbol) - quantity);
        }
    
        public void addCash(double amount) {
            cash += amount;
        }
    
        public void subtractCash(double amount) {
            cash -= amount;
        }
    }
    
    

