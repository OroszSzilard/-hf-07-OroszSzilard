package homework;

public class EBook extends Book {
    private String url;

    public EBook(String name, int price, String author, String title, int price2, int yearOfPublication, int pages,
			String style, String url) {
		super(name, price, author, title, price2, yearOfPublication, pages, style);
		this.url = url;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EBook: " + super.toString() + ", URL: " + url;
    }
}
