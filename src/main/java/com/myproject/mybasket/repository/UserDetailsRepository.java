package com.myproject.mybasket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.mybasket.user.ScheduleDetailsEntity;

@Repository
public interface UserDetailsRepository extends JpaRepository<ScheduleDetailsEntity, Long>{

}
