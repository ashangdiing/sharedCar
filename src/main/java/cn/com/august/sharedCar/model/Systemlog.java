package cn.com.august.sharedCar.model;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.com.august.sharedCar.PathStaticVar.LogType;
import cn.com.august.sharedCar.ResultCode.Result;
import lombok.Data;

@Component
@Data
public class Systemlog {
	private LogType logType=LogType.SystemInfo;
	private Long id;
	private String methodName;
	private String operatorName;
	private String operatorIP;
	private String description;
	private String info;
	private Result result;
	private Exception exception;
	private Object data;
	private long durationTime; 
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime recordtime=LocalDateTime.now();
	public Systemlog(LogType logType, String methodName,Result result, String description) {
		this.logType = logType;
		this.methodName = methodName;
		this.description = description;
		this.result = result;
	}
	public Systemlog( ) { }
}
