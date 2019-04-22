package com.book.service;

import com.book.dao.ReaderInfoDao;
import com.book.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReaderInfoService {

    @Autowired
    private ReaderInfoDao readerInfoDao;

    public List<ReaderInfo> readerInfos(){
        return readerInfoDao.getAllReaderInfo();
    }

    public boolean deleteReaderInfo(int readerId){
        return readerInfoDao.deleteReaderInfo(readerId)>0;
    }

    public ReaderInfo getReaderInfo(int readerId){
        return readerInfoDao.findReaderInfoByReaderId(readerId);
    }
    public boolean editReaderInfo(ReaderInfo readerInfo){
        return readerInfoDao.editReaderInfo(readerInfo)>0;
    }
    public boolean addReaderInfo(ReaderInfo readerInfo){
        return  readerInfoDao.addReaderInfo(readerInfo)>0;
    }
}
