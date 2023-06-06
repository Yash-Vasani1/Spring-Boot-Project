package com.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category_details")
public class category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	private String cname;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category1")
	Set<subcategory> scategory;
	
	@ManyToOne
	@JoinColumn(name = "uId", referencedColumnName = "uId")
	UserEntity usercategory;
	
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<subcategory> getScategory() {
		return scategory;
	}
	public void setScategory(Set<subcategory> scategory) {
		this.scategory = scategory;
	}
	public UserEntity getUsercategory() {
		return usercategory;
	}
	public void setUsercategory(UserEntity usercategory) {
		this.usercategory = usercategory;
	}
	
}
