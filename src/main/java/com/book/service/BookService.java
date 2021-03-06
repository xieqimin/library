package com.book.service;

import com.book.dao.BookDao;
import com.book.domain.Book;
import com.book.domain.BookRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> queryBook(String searchWord){
        String word="%"+searchWord+"%";
        System.out.println("word"+word);
        return  bookDao.queryBook(word);
    }

    public List<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }

    public int deleteBook(long bookId){
        return bookDao.deleteBook(bookId);
    }

    public boolean matchBook(String searchWord){
        String word="%"+searchWord+"%";
        System.out.println("word"+word);
        System.out.println(bookDao.matchBook(word));
        return bookDao.matchBook(word)>0;
    }

    public boolean addBook(Book book){
        return bookDao.addBook(book)>0;
    }

    public Book getBook(Long bookId){
        Book book=bookDao.getBook(bookId);
        return book;
    }
    public boolean editBook(Book book){
        return bookDao.editBook(book)>0;
    }

    public List<BookRank> getBookRank(){
        return bookDao.getBookRank();
    }

}
