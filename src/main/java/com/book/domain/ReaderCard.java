package com.book.domain;

import java.io.Serializable;

public class ReaderCard implements Serializable{

    private int reader_id;
    private String name;
    private String passwd;
    private int card_state;

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getCard_state() {
        return card_state;
    }

    public void setCard_state(int card_state) {
        this.card_state = card_state;
    }
}
