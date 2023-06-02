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
            System.out.println("Invalid input.");
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
