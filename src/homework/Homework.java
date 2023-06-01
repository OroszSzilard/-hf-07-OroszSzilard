package homework;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of E-books (1-10): ");
        int n = readInt(scanner, 1, 10);

        EBook[] eBooks = new EBook[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for E-book #" + (i + 1));
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Price: ");
            int price = readInt(scanner);
            System.out.print("Pages: ");
            int pages = readInt(scanner);
            System.out.print("Style: ");
            String style = scanner.nextLine();
            System.out.print("URL: ");
            String url = scanner.nextLine();

            eBooks[i] = new EBook(author, pages, title, url, price, pages, pages, style, url);
        }

        // Test the implemented methods
        listBookArray(eBooks);
        Book longestBook = getLongestBook(eBooks);
        System.out.println("Longest book: " + longestBook);
        Book longestEvenPagesBook = getLongestEvenPagesBook(eBooks);
        System.out.println("Longest book with even pages: " + longestEvenPagesBook);
        authorStatistics(eBooks);
    }

    public static void listBookArray(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static Book getLongestBook(Book[] books) {
        Book longestBook = null;
        int maxLength = 0;
        for (Book book : books) {
            if (book.getPages() > maxLength) {
                maxLength = book.getPages();
                longestBook = book;
            }
        }
        return longestBook;
    }

    public static Book getLongestEvenPagesBook(Book[] books) {
        Book maxBook = null;
        for (Book book : books) {
            if (book.hasEvenPages()) {
                maxBook = book;
                break;
            }
        }
        for (Book book : books) {
            if (book.hasEvenPages() && book.getPages() > maxBook.getPages()) {
                maxBook = book;
            }
        }
        return maxBook;
    }

    public static void authorStatistics(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            String author = books[i].getAuthor();
            boolean isNewAuthor = true;
            for (int j = 0; j < i; j++) {
                if (books[j].getAuthor().equalsIgnoreCase(author)) {
                    isNewAuthor = false;
                    break;
                }
            }
            if (isNewAuthor) {
                int count = 1;
                for (int k = i + 1; k < books.length; k++) {
                    if (books[k].getAuthor().equalsIgnoreCase(author)) {
                        count++;
                    }
                }
                System.out.println(author + ": " + count + " book(s)");
            }
        }
    }

    public static int countStyles(Book[] books) {
        int count = 0;
        String[] styles = new String[books.length];
        for (Book book : books) {
            String style = book.getStyle();
            boolean isNewStyle = true;
            for (int i = 0; i < count; i++) {
                if (styles[i].equalsIgnoreCase(style)) {
                    isNewStyle = false;
                    break;
                }
            }
            if (isNewStyle) {
                styles[count] = style;
                count++;
            }
        }
        return count;
    }

    public static void discountBooks(Book[] books, String style) {
        for (Book book : books) {
            if (book.getStyle().equalsIgnoreCase(style)) {
                book.decreasePrice(10);
            }
        }
    }

    public static int listBooksWithStyle(Book[] books, String style) {
        int count = 0;
        for (Book book : books) {
            if (book.getStyle().equalsIgnoreCase(style)) {
                System.out.println(book);
                count++;
            }
        }
        return count;
    }

    public static int avgPrice(Book[] books, String style) {
        int sum = 0;
        int count = 0;
        for (Book book : books) {
            if (book.getStyle().equalsIgnoreCase(style)) {
                sum += book.getPrice();
                count++;
            }
        }
        if (count > 0) {
            return sum / count;
        } else {
            return 0;
        }
    }

    public static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    public static int readInt(Scanner scanner, int min, int max) {
        int number = readInt(scanner);
        while (number < min || number > max) {
            System.out.println("Invalid input. Please enter an integer between " + min + " and " + max + ".");
            number = readInt(scanner);
        }
        return number;
    }
}