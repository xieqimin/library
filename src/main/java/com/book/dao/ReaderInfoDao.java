package com.book.dao;

import com.book.domain.ReaderInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ReaderInfoDao {

    @Select("SELECT * FROM reader_info")
    List<ReaderInfo> getAllReaderInfo();

    @Select("SELECT * FROM reader_info where reader_id = #{readerId}")
    ReaderInfo findReaderInfoByReaderId(@Param("readerId") int readerId);

    @Delete("DELETE FROM reader_info where reader_id = #{readerId} ")
    int deleteReaderInfo(@Param("readerId") int readerId);

    int editReaderInfo(ReaderInfo readerInfo);

    @Insert("INSERT INTO reader_info VALUES(#{readerId},#{name},#{sex},#{birth},#{address},#{telcode})")
    int addReaderInfo(ReaderInfo readerInfo);


}
