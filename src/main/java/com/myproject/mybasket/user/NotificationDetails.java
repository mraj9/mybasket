package com.myproject.mybasket.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "NotificationDetails")
@EntityListeners(AuditingEntityListener.class)
public class NotificationDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "Message")
	private String message;
	
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "schedule_id", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private ScheduleDetailsEntity scheduleDetails;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "corporate_schedule_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CorporateScheduleDetailsEntity corporateScheduleDetailsEntity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	 public ScheduleDetailsEntity getScheduleDetails() {
			return scheduleDetails;
		}

		public CorporateScheduleDetailsEntity getCorporateScheduleDetailsEntity() {
		return corporateScheduleDetailsEntity;
	}

	public void setCorporateScheduleDetailsEntity(CorporateScheduleDetailsEntity corporateScheduleDetailsEntity) {
		this.corporateScheduleDetailsEntity = corporateScheduleDetailsEntity;
	}

		public void setScheduleDetails(ScheduleDetailsEntity scheduleDetails) {
			this.scheduleDetails = scheduleDetails;
		}

			

	 
	 
}
