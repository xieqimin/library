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
    public boolean bookReturn(long bookId,long readerId){
        // update bookReturnOne 可以归还 return 1
        //应该先查询是否借阅

        if(lendDao.bookReturnOne(df.format(new Date()),bookId,readerId)>0){
            lendDao.addAmount(bookId);
            lendDao.bookReturnTwo(bookId);
            return true;
        }else {
            return false;
        }
    }

    //TODO bug 同一人可以借多本相同内容的书籍
    @Transactional
    public boolean bookLend(long bookId,int readerId){
        // Amount==0 返回0
        if(lendDao.subAmount(bookId)>0) {
            int amount=lendDao.getAmount(bookId);
            if(amount==0){
                lendDao.bookLendTwo(bookId);
            }
            return lendDao.bookLendOne(bookId, readerId, df.format(new Date())) > 0;
        }else {
            return false;
        }
    }

    public List<Lend> lendList(){
        return lendDao.lendList();
    }

    public List<Lend> myLendList(int readerId){
        return lendDao.myLendList(readerId);
    }
}
