package com.nt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name="EMPLOYEE_COLLECTION_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eid;
	
	@Column(length=20)
	private String ename;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_FRIENDS",
	     joinColumns=@JoinColumn(name="EMP_ID",referencedColumnName="EID"))
	@OrderColumn(name="FRIEND_INDEX")
	@ListIndexBase(value=1)
	@Column(name="FRIEND_NAME",length=20)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String> friends;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_PHONE_NUMBERS",
	     joinColumns=@JoinColumn(name="EMP_ID",referencedColumnName="EID"))
	@Column(name="PHONE_NUMBER",length=11)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Long> phoneNumbers;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_ID_DETAILS",
	    joinColumns=@JoinColumn(name="EMP_ID",referencedColumnName="EID"))
    @MapKeyColumn(name="CARD_TYPE",length=20)
	@Column(name="CARD_NUMBER",length=20)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Map<String,String> idDetails;
	
	
	
}
