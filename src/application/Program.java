package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static entities.enums.OrderStatus.PROCESSING;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner leia = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Enter client data:");
        String name = leia.nextLine();
        System.out.print("Email: ");
        String email = leia.next();
        System.out.print("Birth date (DD/MM/YYYY");
        Date birthDate = sdf.parse(leia.next());

        Client client = new Client(name, birthDate, email);
        System.out.println("Enter order data: ");
        System.out.print("Status: ");

        OrderStatus status = OrderStatus.valueOf(leia.next());
        Order order = new Order(new Date(), status, client);

        System.out.println("How many items to this order?");
        int n = leia.nextInt();
        for (int i = 1; i < n; i++) {

            System.out.println("Enter #" + i + "item data:");
            System.out.print("Product name:");
            String productName =leia.nextLine();
            leia.next();
            System.out.print("Product price:");
            double productPrice =leia.nextDouble();

            Product product = new Product(productName, productPrice);
            int quantity = leia.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        leia.close();
    }
}