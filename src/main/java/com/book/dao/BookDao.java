package com.book.dao;

import com.book.domain.Book;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BookDao {

    //查询匹配图书的个数
    @Select("SELECT count(*) FROM book_info WHERE book_id like #{searchWord}  or name like #{searchWord}")
    int matchBook(@Param("searchWord") String searchWord);

    @Select("SELECT * FROM book_info WHERE book_id like #{searchWord}  or name like #{searchWord}")
    List<Book> queryBook(@Param("searchWord") String sw);

    @Select("SELECT * FROM book_info")
    List<Book> getAllBooks();

    @Delete("delete from book_info where book_id = #{id}  ")
    int deleteBook(@Param("id") long bookId);

    @Insert("INSERT INTO book_info VALUES(NULL ,#{name},#{author},#{publish},#{isbn},#{introduction},#{language},#{price},#{pubdate},#{class_id},#{pressmark},#{state},#{amount})")
    int addBook(Book book);

    //根据书号查询图书
    @Select("SELECT * FROM book_info where book_id = #{id} ")
    Book getBook(@Param("id") Long bookId);

    //TODO getAmount ?
    @Update("update book_info set name= #{name} ,author= #{author} ,publish= #{publish} ,ISBN= #{isbn} ,introduction= #{introduction} ,language= #{language},price= #{price} ,pubdate= #{pubdate} ,class_id= #{class_id} ,pressmark= #{pressmark} ,state= #{state})  where book_id= #{book_id})")
    int editBook(Book book);



}
