package homework;

import homework.product.Product;

public class Book extends Product {
	private String author;
    private String title;
    private int price;
    private final int yearOfPublication;
    private int pages;
    private String style;
    
    
 

    public Book(String name, int price, String author, String title, int price2, int yearOfPublication, int pages,
			String style) {
		super(name, price);
		this.author = author;
		this.title = title;
		price = price2;
		this.yearOfPublication = yearOfPublication;
		this.pages = pages;
		this.style = style;
	}
    
    

	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getPages() {
		return pages;
	}



	public void setPages(int pages) {
		this.pages = pages;
	}



	public int getYearOfPublication() {
		return yearOfPublication;
	}



	public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public void decreasePrice(int percent) {
        super.decreasePrice(percent);
        if (style.equalsIgnoreCase("children")) {
            super.decreasePrice(7);
        } else if (style.equalsIgnoreCase("guide")) {
            super.decreasePrice(5);
        }
    }



	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", price=" + price + ", yearOfPublication="
				+ yearOfPublication + ", pages=" + pages + ", style=" + style + "]";
	}

	  public boolean hasEvenPages() {
	        return pages % 2 == 0;
	    }
}