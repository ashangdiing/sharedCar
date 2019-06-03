package cn.com.august.sharedCar.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;


@Data
@Entity
@Table(name = "LtineraryRecord")
@DynamicInsert 
@DynamicUpdate
public class LtineraryRecord  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private	long id;
	private String ltineraryRecordId;
	
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	@ManyToOne(cascade=CascadeType.DETACH,optional=false)
	@JoinColumn(name = "app_user_id", referencedColumnName = "appUserId")
	private	AppUser appUser;
	//一对一关联，不做级联，避免删除这边记录删除另一边,optional=false表示一个单子必须有车对应
	@ManyToOne(cascade=CascadeType.DETACH,optional=false)
	//新建car_id与Car类的carId进行关联
	@JoinColumn(name = "car_id", referencedColumnName = "carId")
	private	Car car;
}
