package com.book.dao;

import org.apache.ibatis.annotations.*;
import com.book.domain.Lend;
import java.util.List;

@Mapper
public interface LendDao {

    @Update("UPDATE lend_list SET back_date = #{date} WHERE book_id = #{id} AND back_date is NULL")
    int bookReturnOne(@Param("date") String date,@Param("id") long bookId);

    @Update("UPDATE book_info SET state = 1 WHERE book_id = #{id} ")
    int bookReturnTwo(@Param("id") long bookId);

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

    //TODO sub getAmount
    @Update("update book_info set amount= amount -1 where book_id = #{id} and amount >=1")
    int subAmount(@Param("id") long bookId);
}
