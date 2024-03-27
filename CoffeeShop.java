import javax.swing.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
public class CoffeeShop {

    static double grand_total = 0.0;

    //sizes of the cups
    final static int small = 9;
    final static int medium = 12;
    final static int large = 15;

    //cost of the cups
    final static double s_price = 1.75;
    final static double m_price = 1.90;
    final static double l_price = 2.00;

    static int amount_of_cups = 0; //how many ounces we sold

    static int s_cups_sold = 0;
    static int m_cups_sold = 0;
    static int l_cups_sold = 0;


    public static void main(String[] args) {
        main_method();
    }

    public static void main_method() {
        Scanner input = new Scanner(System.in);
        while (true) {
            mainMenu();
            String userChoice = input.nextLine();
            if (userChoice.equals("1")) {
                order();
            }
            else if (userChoice.equals("2")) {
                totalMoney();
            }
            else if (userChoice.equals("3")) {
                totalSold();
            }
            else if (userChoice.equals("4")) {
                cupSize();
            }
            else if (userChoice.equals("5")) {
                printData();
            }
            else if (userChoice.equals("9")) {
                System.out.println("Thank you for using this program!");
                break;
            }
        }
    }

    public static void mainMenu() {
        System.out.println();
        System.out.println("1: Enter 1 to order coffee");
        System.out.println("2: Enter 2 to check the total money made up to this time.");
        System.out.println("3: Enter 3 to check the total amount of coffee sold up to this time.");
        System.out.println("4: Enter 4 to check the number of cups of coffee of each size sold.");
        System.out.println("5: Enter 5 to print the data.");
        System.out.println("9: Enter 9 to exit the program.");
    }

    public static void menu1() {
        System.out.println("1: Enter 1 to buy coffee in a small cup size (9 oz)");
        System.out.println("2: Enter 2 to buy coffee in a medium cup size (12 oz)");
        System.out.println("3: Enter 3 to buy coffee in a large cup size (15 oz)");
        System.out.println("9: Enter 9 to exit.");
    }

    public static void order() { //update total, grand total, and amounts of cups sold
        Scanner input = new Scanner(System.in);
        int orderChoice = 0;
        double price = 0.0;
        double g_price = 0.0;
        double price2 = 0.0;
        double price3 = 0.0;
        int amount = 0;
        int num_of_order = 0;
        while (true) {
            menu1();
            orderChoice = input.nextInt();
            if (orderChoice == 1) {
                System.out.print("Enter the amount of cups: ");
                num_of_order = input.nextInt();
                g_price = (s_price * num_of_order);
                price = price + (s_price * num_of_order);
                amount_of_cups = amount_of_cups + (small * num_of_order);
                s_cups_sold = s_cups_sold + num_of_order;
            } else if (orderChoice == 2) {
                System.out.print("Enter the amount of cups: ");
                num_of_order = input.nextInt();
                price = price + (m_price * num_of_order);
                g_price = (m_price * num_of_order);
                amount_of_cups = amount_of_cups + (medium * num_of_order);
                m_cups_sold = m_cups_sold + num_of_order;
            } else if (orderChoice == 3) {
                System.out.print("Enter the amount of cups: ");
                num_of_order = input.nextInt();
                price = price + (l_price * num_of_order);
                g_price = (l_price * num_of_order);
                amount_of_cups = amount_of_cups + (large * num_of_order);
                l_cups_sold = l_cups_sold + num_of_order;
            } else if (orderChoice == 9) {
                System.out.printf("Please pay: " + "%.2f",price);
                System.out.println();
                break;
            }
            grand_total = grand_total + g_price;
        }
    }

    public static void totalMoney(){
        System.out.println("Total money made: $" + grand_total );
    }

    public static void totalSold(){
        System.out.println("Total amount of coffee sold: " + amount_of_cups + " oz");
    }
    public static void cupSize(){
        System.out.println();
        System.out.println("Small cup count: " + s_cups_sold);
        System.out.println("Medium cup count: " + m_cups_sold);
        System.out.println("Large cup count: " + l_cups_sold);
    }
    public static void printData(){
        cupSize();
        totalSold();
        totalMoney();
    }

}