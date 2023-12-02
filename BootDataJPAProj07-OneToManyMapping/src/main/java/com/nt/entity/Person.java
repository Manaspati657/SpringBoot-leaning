package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="AM_PERSON_DETAILS")
@Setter
@Getter
public class Person implements Serializable {
	
	@Id
	@SequenceGenerator(name="gen1",initialValue=1000,allocationSize=1,sequenceName="PID_SEQ1")
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer pid;
	
	@Column(length=20)
	private String pname;
	
	@Column(length=20)
	private String paddress;
	
	/*
	 *  "cascade=CascadeType.ALL" -indicates all non-select persistence operations performed
	 *  on the parent obj should be propagated to associated child obj .e.g if we delete any 
	 *  parent row corresponding child row automatically deleted.    
	 *  
	 *  
	 *  "fetch=FetchType.LAZY" --  In oneToMany association parent object will loaded normally but
	 *  the associated child object will be loaded lazily (on demand basis)
	 *  
	 *   or "fetch=FetchType.EAGER" -- the child object will loaded along with parent object
	 *  
	 *  
     */
	
	@OneToMany(targetEntity=PhoneNumber.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="PERSON_ID",referencedColumnName="PID")
	private Set<PhoneNumber> phonesinfo;

	
	public String toString() {
		return "Person (parent)[id="+pid+",name="+pname+",address="+paddress;
	}
}







