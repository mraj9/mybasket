package com.myproject.mybasket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.mybasket.user.CorporateScheduleDetailsEntity;

public interface CorporateUserDetailsRepository extends JpaRepository<CorporateScheduleDetailsEntity, Long> {

}
