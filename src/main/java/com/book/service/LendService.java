package com.book.service;

import com.book.dao.LendDao;
import com.book.domain.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@Service
public class LendService {

    @Autowired
    private LendDao lendDao;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Transactional
    public boolean bookReturn(long bookId){
        return lendDao.bookReturnOne(df.format(new Date()),bookId)>0 && lendDao.bookReturnTwo(bookId)>0;
    }

    @Transactional
    public boolean bookLend(long bookId,int readerId){
        return lendDao.bookLendOne(bookId,readerId,df.format(new Date()))>0 && lendDao.bookLendTwo(bookId)>0;
    }

    public List<Lend> lendList(){
        return lendDao.lendList();
    }

    public List<Lend> myLendList(int readerId){
        return lendDao.myLendList(readerId);
    }
}
