package cn.com.august.sharedCar.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
@Data
@Entity
@Table(name = "Car")
@DynamicInsert 
@DynamicUpdate
public class Car  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private	long id;
	
	private	String carId;
	
	@Column(nullable=false,columnDefinition="varchar(10) default 'white'")
	private	String Color;
	@Column(nullable=false,columnDefinition="varchar(40) default 'BYD'")
	private	String brand;
	
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	private LocalDateTime buyTime;
	//一个车会有很多个单子，关系被LtineraryRecords的car属性维护
	@OneToMany(mappedBy = "car",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private	List<LtineraryRecord> LtineraryRecords;
}
