package com.zdr.sun.service.Kr36;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdr.sun.dao.Kr36.Kr36Mapper;
import com.zdr.sun.pojo.Kr36.news24th;

@Service
public class Kr36ServiceImpl implements Kr36Service {

    @Resource
    private Kr36Mapper kr36mapper;

    @Override
    public int getnewsCount() throws Exception {
	// TODO Auto-generated method stub
	return kr36mapper.getnewsCount();
    }

    @Override
    public boolean insert(news24th news) throws Exception {
	// TODO Auto-generated method stub
	boolean tf = false;
	if (kr36mapper.insert(news) > 0) {
	    tf = true;
	}
	return tf;
    }

    @Override
    public int read() throws Exception {
	// TODO Auto-generated method stub
	int read = 0;
	if (kr36mapper.read() != null) {
	    read = kr36mapper.read();
	}

	return read;
    }

}
