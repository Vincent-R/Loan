package com.loan.dao;

import com.loan.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementDao extends JpaRepository<Announcement, Integer>{
}
