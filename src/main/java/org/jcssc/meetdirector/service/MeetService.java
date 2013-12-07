package org.jcssc.meetdirector.service;

import java.util.List;

import org.jcssc.meetdirector.bean.Meet;
import org.jcssc.meetdirector.dao.IMeetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetService
{
    @Autowired
    private IMeetDAO meetRepository;

    public List<Meet> findAll()
    {
        return meetRepository.findAll();
    }
}
