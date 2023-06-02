package homework;
import java.time.LocalDate;
import homework.product.Product;

public class Book extends Product {
	private String title;
	private String author;
	private int yearOfPublication;
	private int pages;
	private String style;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		if(yearOfPublication >= 1950 && yearOfPublication <= 2021)
			this.yearOfPublication = yearOfPublication;
		else
			this.yearOfPublication = 2021;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price>=1000)
			this.price = price;
		else
			this.price= 1000;
	}
	
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages >= 0) {
            this.pages = pages;
        } else {
            System.out.println("Érvénytelen oldalszám! Az oldalszám nem lehet negatív.");
        }
    }
    
    public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

    public Book(String author, String title, int price, int pages, String style) 
	{
		super("book",price);
		this.author = author;
		this.title = title;
		if(price<0)
		{
			this.price = 0;
		}
		else
		this.price = price;
		
		if(pages<0)
		{
			this.pages = 0;
		}
		else
		this.pages = pages;
		this.style = style;
	}

	public Book(String author, String title, String style) 
	{
		super("book", 2500);
		this.author = author;
		this.title = title;
		this.pages = 100;
		this.style = style;

	}
	 
	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", yearOfPublication=" + yearOfPublication + ", pages="
				+ pages + ", style=" + style + ", price=" + price + "]";
	}

	 
	 public static int comparePublicationDate(Book book1, Book book2) {
		    if (book1.yearOfPublication > book2.yearOfPublication) {
		        return 1;
		    } else if (book1.yearOfPublication < book2.yearOfPublication) {
		        return 2;
		    } else {
		        return 0;
		    }
		}
	 public static Book getLonger(Book book1, Book book2) {
	        if (book1.getPages() >= book2.getPages()) {
	            return book1;
	        } else {
	            return book2;
	        }
	    }

	    public boolean hasEvenPages() {
	        return pages % 2 == 0;
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
