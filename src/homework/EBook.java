package homework;

public class EBook extends Book
{
	private String url;

	public EBook(String title, String author, int price, int pages, String style, String url) {
		super(author, title, price, pages, style);
		this.url = url;
	}

	@Override
	public String toString() {
		return "EBook [url=" + url + "]";
	}

	

	
	
}
