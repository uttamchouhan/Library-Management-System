public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author, boolean  isAvailable){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getBookId() {
		return bookId;
	}
	
	public void setId(int bookId) {
		this.bookId = bookId;
	}

    public String getTitle(){
        return  title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return  author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public Boolean getIsAvailable(){
        return  isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}