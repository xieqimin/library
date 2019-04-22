package com.book.dao;

import com.book.domain.ReaderCard;
import com.book.domain.ReaderInfo;
import org.apache.ibatis.annotations.*;


@Mapper
public interface ReaderCardDao {

    //根据用户查询的SQL语句
    @Select("select count(*) from reader_card where reader_id = #{id} and passwd = #{pw} ")
    int getMatchCount(@Param("id") int readerId,@Param("pw") String passwd);

    @Select("select reader_id, name, passwd, card_state from reader_card where reader_id = #{id}")
    ReaderCard findReaderByReaderId(@Param("id") int userId);

    @Update("UPDATE reader_card set passwd = #{pw} where reader_id = #{id} ")
    int rePassword(@Param("id") int readerId,@Param("pw") String newPasswd);

    @Insert("INSERT INTO reader_card (reader_id,name) values ( #{reader_id} , #{name})")
    int addReaderCard(ReaderInfo readerInfo);

    @Update("UPDATE reader_card set name = #{name} where reader_id = #{id}")
    int updateName(@Param("id") int readerId,@Param("name") String name);
}
