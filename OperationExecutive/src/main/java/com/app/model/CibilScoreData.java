package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class CibilScoreData {
	@Id
	private int cibilId;
	private int cibilScore;
	private String cibilScoreDateTime;
	private String status;
	private String cibilRemark;
	
}
