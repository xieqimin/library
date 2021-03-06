package com.book.dao;

import org.apache.ibatis.annotations.*;
import com.book.domain.Lend;
import java.util.List;

@Mapper
public interface LendDao {

    //TODO reader id
    @Update("UPDATE lend_list SET back_date = #{date} WHERE book_id = #{bookId} AND back_date is NULL and reader_id = #{readerId}")
    int bookReturnOne(@Param("date") String date,@Param("bookId") long bookId,@Param("readerId") long readerId);


    @Update("UPDATE book_info SET state = 1 WHERE book_id = #{bookId} ")
    int bookReturnTwo(@Param("bookId") long bookId);

    @Insert("INSERT INTO lend_list (book_id,reader_id,lend_date) VALUES ( #{bookId} , #{readerId} , #{date} )")
    int bookLendOne(@Param("bookId") long bookId,@Param("readerId") int readerId,@Param("date") String date);

    @Update("UPDATE book_info SET state = 0 WHERE book_id = #{id}")
    int bookLendTwo(@Param("id") long bookId);

    @Select("SELECT * FROM lend_list")
    List<Lend> lendList();

    @Select("SELECT * FROM lend_list WHERE reader_id = #{id} ")
    List<Lend> myLendList(@Param("id") int readerId);

    // add bookAmount
    @Update("update book_info set amount= amount +1 where book_id = #{id}")
    int addAmount(@Param("id") long bookId);

    @Update("update book_info set amount= amount -1 where book_id = #{id} and amount >=1")
    int subAmount(@Param("id") long bookId);

    @Select("select amount from book_info where book_id = #{id}")
    int getAmount(@Param("id") long bookId);

    @Delete("delete from lend_list where sernum=#{sernum}")
    int deleteSernum(@Param("sernum") long sernum);

    @Select("select count(*) from lend_list where book_id=#{bookId} and reader_id=#{readerId} and back_date is null;")
    int lendRecordCount(@Param("bookId") long bookId,@Param("readerId") long readerId);
}
