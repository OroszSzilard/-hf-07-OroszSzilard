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
	            System.out.println(book.toString());
	        }
	    }

	    public static Book getLongestBook(Book[] books) {
	        Book longestBook = books[0];
	        for (int i = 1; i < books.length; i++) {
	            if (books[i].getPages() > longestBook.getPages()) {
	                longestBook = books[i];
	            }
	        }
	        return longestBook;
	    }
	    
	    public static Book getLongestEvenPagesBook(Book[] books) {
	        Book maxBook = null;
	        for (Book book : books) {
	            if (book.getPages() % 2 == 0) {
	                maxBook = book;
	                break;
	            }
	        }
	        for (Book book : books) {
	            if (book.getPages() % 2 == 0 && book.getPages() > maxBook.getPages()) {
	                maxBook = book;
	            }
	        }
	        return maxBook;
	    }
	    
	    public static void authorStatistics(Book[] books) {
	        for (int i = 0; i < books.length; i++) {
	            int count = 1;
	            if (books[i] != null) {
	                String author = books[i].getAuthor();
	                System.out.print(author + ": ");

	                for (int j = i + 1; j < books.length; j++) {
	                    if (books[j] != null && books[j].getAuthor().equals(author)) {
	                        count++;
	                        books[j] = null; // Azonos szerzőjű könyvek jelölése, hogy ne számoljuk újra
	                    }
	                }

	                System.out.println(count);
	            }
	        }
	    }
	    
	    public static int listBooksWithStyle(Book[] books, String style)
		{
			int szamlalo=0;
			for(int i=0;i<books.length;i++)
			{
				if(books[i].style.equals(style))
				{
					System.out.println(books[i].toString());
					szamlalo++;
				}
			}
			return szamlalo;
		}
	    
	    public static void discountBooks(Book[] books, String style)
		{
			for(int i=0;i<books.length;i++)
			{
				if(books[i].style.equals(style))
				{
					books[i].price=books[i].price-((books[i].price/100)*10);
				}
			}
		}
	    
	    public static int avgPrice(Book[] books, String style)
		{
			int osszar=0;
			int megszam=0;
			for(int i=0;i<books.length;i++)
			{
				if(books[i].style.equalsIgnoreCase(style))
				{
					megszam++;
					osszar=books[i].price+osszar;
				}
			}
			if(megszam!=0)
			return osszar/megszam;
			else return 0;
		}
	    
	    public static int countStyles(Book[] books)
		{
			String[] stilusok = new String[books.length];
			stilusok[0]=books[0].style;
			Boolean asd = false;
			int t=0;
			for(int i=0; i<books.length;i++)
			{
				for(int j=0; j<stilusok.length;j++)
				{	
					if(books[i].style.equals(stilusok[j]))
					{
						asd=true;
					}
				}
				if(asd==false)
				{	
					t++;
					stilusok[t]=books[i].style;
				}
				asd=false;
			}
			int szamlalo=0;
			for(int i=0;i<stilusok.length;i++)
			{
				if(stilusok[i]!=null)
				{
					szamlalo++;
				}
				System.out.println(stilusok[i]);
			}
			return szamlalo;
		}
	    
	    public void decreasePrice(int percent)
		{
			if(this.style.equals("children"))
			{
				this.price=price-Math.round(((float)price/100)*(percent+7));
			}
			else if(this.style.equals("guide"))
			{
				this.price=price-Math.round(((float)price/100)*(percent+5));
			}
			else
			this.price=price-((price/100)*percent);
		}
}
