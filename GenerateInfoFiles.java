import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class GenerateInfoFiles {
    //Method for generating the sellers file
    public static void createSellerInfoFile(int sellerCount) throws IOException {
        FileWriter writer = new FileWriter("sellers.txt");
        Random random = new Random();
        String[] names = {"Kilian", "David", "Karoll", "Pepe", "Lionel"};
        String[] surnames = {"Joropa", "Gomez", "Rodriguez", "Lopez", "Martinez"};

        for (int i = 0; i < sellerCount; i++) {
            int id = random.nextInt(99999);
            String name = names[random.nextInt(names.length)];
            String surname = surnames[random.nextInt(surnames.length)];
            writer.write("CC;" + id + ";" + name + ";" + surname + "\n");
        }
        writer.close();
        JOptionPane.showMessageDialog(null ,"Seller file successfully generated.");
    }
    //Method to generate the product file
    public static void createProductsFile(int productCount) throws IOException {
        FileWriter writer = new FileWriter("products.txt");
        Random rand = new Random();
        String[] products = {"Laptop", "Mouse", "keyboard", "monitor", "headphones"};

        for (int i = 0; i < productCount; i++) {
            int id = rand.nextInt(9999);
            String name = products[rand.nextInt(products.length)];
            double price = rand.nextDouble() * 1000; //Random price between 0 and 1000
            writer.write(id + ";" + name + ";" + String.format("%.2f", price) + "\n");
        }
        writer.close();
        JOptionPane.showMessageDialog(null ,"Product archive successfully generated.");
    }
    //Method to generate the sales file for a seller
    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        FileWriter writer = new FileWriter("sales_" + id + ".txt");
        Random random = new Random();

        for (int i = 0; i < randomSalesCount; i++) {
            int productId = random.nextInt(9999);
            int amountSold = random.nextInt(50) + 1; //Quantity sold between 1 and 50
            writer.write(productId + ";" + amountSold + "\n");
        }
        writer.close();
        JOptionPane.showMessageDialog(null ,"Sales file successfully generated for " + name);
    }
    public static void main(String[] args) {
        try {
            createSellerInfoFile(5); // Generate 5 sellers
            createProductsFile(5); // Generate 5 products
            createSalesMenFile(10, "Kilian Gomez", 12345); // Generate 10 sales for a seller
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null ,"Error generating files: " + exception.getMessage());
        }
    }
}