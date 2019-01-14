package com.myproject.mybasket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.mybasket.user.NotificationDetails;
import com.myproject.mybasket.user.ScheduleDetailsEntity;

public interface NotificationDetailsRepository extends JpaRepository<NotificationDetails, Long>{

}
