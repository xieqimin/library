package com.book.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface AdminDao {


    @Select("SELECT COUNT(*) FROM admin where admin_id = #{adminId} and password = #{password} ")
    int getMatchCount(@Param("adminId") int adminId,@Param("password") String password);

    @Update("UPDATE admin set password = #{newPasswd} where admin_id = #{adminId}")
    int rePassword(@Param("adminId") int adminId,@Param("newPasswd") String newPasswd);

    @Select("SELECT password from admin where admin_id = #{adminId}")
    String getPasswd(@Param("adminId") int adminId);

}
