package com.book.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lend implements Serializable {

    private long sernum;
    private long book_id;
    private int reader_id;
    private Date lend_date;
    private Date back_date;


    public long getSernum() {
        return sernum;
    }

    public void setSernum(long sernum) {
        this.sernum = sernum;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getLend_date() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(lend_date);
    }

    public void setLend_date(Date lend_date) {
        this.lend_date = lend_date;
    }

    public String getBack_date() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if(back_date==null){
            return "";
        }
        else {
            return sdf.format(back_date);
        }
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }
}
