package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subcategory_details")
public class subcategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scId;
	private String scName;
	
	@ManyToOne
	@JoinColumn(name = "cId", referencedColumnName = "cId")
	category category1;

	public Integer getScId() {
		return scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public category getCategory1() {
		return category1;
	}

	public void setCategory1(category category1) {
		this.category1 = category1;
	}
	
}
