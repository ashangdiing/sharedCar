package cn.com.august.sharedCar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "AppUser")
@DynamicInsert 
@DynamicUpdate
public class AppUser  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private	long id;
		private	String appUserId;
	
		private	String userName;
		//mappedBy = "car"  关系表示Car类的car字段维护
		@OneToMany(mappedBy = "appUser",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		private	List<LtineraryRecord> ltineraryRecords;
		
}
