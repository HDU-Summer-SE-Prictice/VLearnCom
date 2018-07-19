package com.vlearncom.service;

import com.vlearncom.dao.MessageRepository;
import com.vlearncom.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    SysUserService SysUserService;
    @Autowired
    MessageRepository messageRepository;


    public List<Message> findAll(){
        return messageRepository.findAll();
    }

}
