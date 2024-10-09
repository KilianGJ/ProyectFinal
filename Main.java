import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Main {
    //Method to process sales and generate the report for sales per seller
    public static void generateSellerReport() throws IOException {
        BufferedReader sellerReader = new BufferedReader(new FileReader("sellers.txt"));
        FileWriter writer = new FileWriter("seller_report.csv");

        Map<String, Double> sellersWrite = new HashMap<>();
        String line;
        while ((line = sellerReader.readLine()) != null) {
            String[] sellerData = line.split(";");
            String fullName = sellerData[2] + " " + sellerData[3];
            //Simulate the total sales (this should be read from the sales files)
            double totalSales = new Random().nextDouble() * 1000;
            sellersWrite.put(fullName, totalSales);
        }
        sellerReader.close();
        //Sort by sales in descending order
        sellersWrite.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> {
                try {
                    writer.write(entry.getKey() + ";" + String.format("%.2f", entry.getValue()) + "\n");
                } catch (IOException excep) {
                    excep.printStackTrace();
                }
            });
        writer.close();
        JOptionPane.showMessageDialog(null ,"Sellers report generated successfully.");
    }
    //Method to process products and generate the report for most sold products
    public static void generateProductReport() throws IOException {
        BufferedReader productReader = new BufferedReader(new FileReader("products.txt"));
        FileWriter writer = new FileWriter("product_report.csv");

        Map<String, Integer> productsSold = new HashMap<>();
        String line;
        while ((line = productReader.readLine()) != null) {
            String[] productData = line.split(";");
            String productName = productData[1];
            // Simulate the quantity sold (this should be read from the sales files)
            int quantitySold = new Random().nextInt(100);
            productsSold.put(productName, quantitySold);
        }
        productReader.close();
        //Sort by quantity sold in descending order
        productsSold.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> {
                try {
                    writer.write(entry.getKey() + ";" + entry.getValue() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        writer.close();
        JOptionPane.showMessageDialog(null ,"Product report generated successfully.");
    }
    public static void main(String[] args) {
        try {
            generateSellerReport();
            generateProductReport();
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null ,"Error generating reports: " + exception.getMessage());
        }
    }
}