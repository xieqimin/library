package com.book.dao;

import com.book.domain.Book;
import com.book.domain.BookRank;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BookDao {

    //查询匹配图书的个数
    @Select("SELECT count(*) FROM book_info WHERE book_id like #{searchWord}  or name like #{searchWord}")
    int matchBook(@Param("searchWord") String searchWord);

    //根据图书id或者图书名进行模糊查找
    @Select("SELECT * FROM book_info WHERE book_id like #{searchWord}  or name like #{searchWord}")
    List<Book> queryBook(@Param("searchWord") String sw);

    //查找所有图书
    @Select("SELECT * FROM book_info")
    List<Book> getAllBooks();

    //根据图书id删除图书
    @Delete("delete from book_info where book_id = #{id}  ")
    int deleteBook(@Param("id") long bookId);

    @Insert("INSERT INTO book_info VALUES(NULL ,#{name},#{author},#{publish},#{isbn},#{introduction},#{language},#{price},#{pubdate},#{class_id},#{pressmark},#{state},#{amount})")
    int addBook(Book book);

    //根据书号查询图书
    @Select("SELECT * FROM book_info where book_id = #{id} ")
    Book getBook(@Param("id") Long bookId);

    //TODO getAmount ?
    @Update("update book_info set name= #{name} ,author= #{author} ,publish= #{publish} ,ISBN= #{isbn} ,introduction= #{introduction} ,language= #{language},price= #{price} ,pubdate= #{pubdate} ,class_id= #{class_id} ,pressmark= #{pressmark} ,state= #{state} ,amount =#{amount} where book_id= #{book_id}")
    int editBook(Book book);

    //获取图书排行榜
    @Select("SELECT book_info.name as name,book_info.author as author, book_info.publish as publish,a1.num as num\n" +
            "from (SELECT book_id,count(*) as num FROM lend_list\n" +
            "GROUP BY book_id) as a1,book_info\n" +
            "WHERE a1.book_id=book_info.book_id\n" +
            "ORDER BY a1.num DESC")
    List<BookRank> getBookRank();

}
