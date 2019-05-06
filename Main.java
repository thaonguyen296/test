package ADF2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/T1808M";
            Connection conn = DriverManager.getConnection(URL, "nguyenthao","minhquan1525");

            ArrayList<Book> list = new ArrayList<>();

            boolean stop = false;
            while (!stop) {
                System.out.println("Menu:");
                System.out.println("1. Add book records");
                System.out.println("2. Save");
                System.out.println("3. Display book records");
                System.out.println("4. Exit");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Chon 1 chuc nang: ");
                int menu = scanner.hasNextInt() ? scanner.nextInt() : 0;
                if (menu > 0 && menu < 5) {
                    switch (menu) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Book ID: ");
                            String id = scanner.nextLine();
                            System.out.println("Book name: ");
                            String name = scanner.nextLine();
                            System.out.println("Author: ");
                            String author = scanner.nextLine();
                            System.out.println("Price: ");
                            Integer price = scanner.nextInt();
                            list.add(new Book(id ,name, author, price));
                            System.out.println("Sach trong danh sach da nhap la: "+list.size());
                            break;
                        case 2:
                            add(conn, list);
                            break;
                        case 3:
                            display(conn);
                            break;
                        case 4:
                            stop = true;
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void display(Connection conn) throws Exception {
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM book";
        System.out.println("Book ID             Book Name               Author          Price");
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.print("" + rs.getString("Book ID"));
            System.out.print("-------------" + rs.getString("Book Name"));
            System.out.print("-------------" + rs.getString("Author"));
            System.out.print("-------------$" + rs.getString("Price"));
            System.out.println("");
        }
    }

    public static void add(Connection conn, ArrayList<Book> list) throws Exception{
        Statement statement = conn.createStatement();

        for (Book bk: list) {
            String insert_sql = "INSERT INTO book ('Book ID', 'Book Name', 'Author', 'Price') VALUES ('" + bk.BookID + "', '" + bk.Book_Tittle + "', '" + bk.Author + "', '"+ bk.Price+"')";
            statement.executeUpdate(insert_sql);
        }

        System.out.println("Da luu thanh cong "+list.size()+" sach");

    }
}
