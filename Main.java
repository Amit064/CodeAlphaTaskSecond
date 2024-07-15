import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MarketService marketService = new MarketService();
        Portfolio portfolio = new Portfolio(10000); // Initial cash
        TradeService tradeService = new TradeService(marketService, portfolio);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = scanner.next();
                    System.out.print("Enter quantity: ");
                    int buyQuantity = scanner.nextInt();
                    if (tradeService.buyStock(buySymbol, buyQuantity)) {
                        System.out.println("Stock bought successfully!");
                    } else {
                        System.out.println("Failed to buy stock.");
                    }
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.next();
                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();
                    if (tradeService.sellStock(sellSymbol, sellQuantity)) {
                        System.out.println("Stock sold successfully!");
                    } else {
                        System.out.println("Failed to sell stock.");
                    }
                    break;
                case 3:
                    System.out.println("Portfolio: " + portfolio.getStocks());
                    System.out.println("Cash: $" + portfolio.getCash());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
