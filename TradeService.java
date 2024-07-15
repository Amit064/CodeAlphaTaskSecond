public class TradeService {
    private MarketService marketService;
    private Portfolio portfolio;

    public TradeService(MarketService marketService, Portfolio portfolio) {
        this.marketService = marketService;
        this.portfolio = portfolio;
    }

    public boolean buyStock(String symbol, int quantity) {
        Stock stock = marketService.getStock(symbol);
        if (stock != null) {
            double cost = stock.getPrice() * quantity;
            if (portfolio.getCash() >= cost) {
                portfolio.addStock(symbol, quantity);
                portfolio.subtractCash(cost);
                return true;
            }
        }
        return false;
    }

    public boolean sellStock(String symbol, int quantity) {
        Stock stock = marketService.getStock(symbol);
        if (stock != null && portfolio.getStocks().getOrDefault(symbol, 0) >= quantity) {
            double revenue = stock.getPrice() * quantity;
            portfolio.removeStock(symbol, quantity);
            portfolio.addCash(revenue);
            return true;
        }
        return false;
    }
}

