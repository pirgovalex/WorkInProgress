package Library;
import java.time.LocalDate;
import java.util.List;
class Book extends Library {
    private String title;
    private String genre;
    private String author;
    private String publisher;
    private int year;
    private String isbn;
    private int pageCount;
    private String language;
    private boolean isAvailable;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private int borrowingPeriod;
    private int timesBorrowed;

    public Book(String libName, String address, int employeeCount,
                List<Book> books, String title, String genre, String author, String publisher,
                int year, String isbn, int pageCount, String language, boolean isAvailable,
                LocalDate borrowedDate, LocalDate returnDate, int borrowingPeriod,
                int timesBorrowed) {
        super(libName, address, employeeCount, books);
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.language = language;
        this.isAvailable = isAvailable;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.borrowingPeriod = borrowingPeriod;
        this.timesBorrowed = timesBorrowed;
        this.returnDate = calculateReturnDate();
    }

    public Book() {
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public LocalDate getBorrowedDate() { return borrowedDate; }
    public void setBorrowedDate(LocalDate borrowedDate) { this.borrowedDate = borrowedDate; }

    public int getBorrowingPeriod() { return borrowingPeriod; }
    public void setBorrowingPeriod(int borrowingPeriod) { this.borrowingPeriod = borrowingPeriod; }
    public LocalDate getReturnDate(){
        return calculateReturnDate();
    }
    public int getTimesBorrowed(){
        return timesBorrowed;
    }

//hii!!
    private LocalDate calculateReturnDate() {
        if (borrowedDate != null && borrowingPeriod > 0) {
            return borrowedDate.plusDays(borrowingPeriod);
        }
        return null;
    }

    public void setBorrowBook() {
        ++this.timesBorrowed;
    }
//book bookbbok blqblqblq
}
