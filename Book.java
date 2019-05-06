package ADF2;

public class Book {
    public String BookID;
    public String Book_Tittle;
    public String Author;
    public Integer Price;

    public Book() {
    }

    public Book(String bookID, String book_Tittle, String author, Integer price) {
        BookID = bookID;
        Book_Tittle = book_Tittle;
        Author = author;
        Price = price;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getBook_Tittle() {
        return Book_Tittle;
    }

    public void setBook_Tittle(String book_Tittle) {
        Book_Tittle = book_Tittle;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }
}
