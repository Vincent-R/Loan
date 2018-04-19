package com.loan.service.serviceImpl;

import com.loan.dao.AnnouncementDao;
import com.loan.entity.Announcement;
import com.loan.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDao announcementDao;

    @Transactional
    @Override
    public Announcement save(Announcement announcement) {
        return announcementDao.save(announcement);
    }

    @Override
    public Announcement findById(int id) {
        return announcementDao.findOne(id);
    }

    @Override
    public List<Announcement> findAll() {
        return announcementDao.findAll();
    }
}
