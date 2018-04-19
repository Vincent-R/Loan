package com.loan.service;

import com.loan.entity.Announcement;

import java.util.List;

public interface AnnouncementService {

    Announcement findById(int id);

    List<Announcement> findAll();

    Announcement save(Announcement announcement);
}
