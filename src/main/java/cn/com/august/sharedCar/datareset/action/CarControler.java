package cn.com.august.sharedCar.datareset.action;

import java.util.List;
import java.util.Optional;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import cn.com.august.sharedCar.model.Car;
import io.swagger.annotations.Api;

@RepositoryRestResource(path = "car")
@Api(tags="repCar")
public interface CarControler  extends JpaRepository<Car, Long>{ 
	
	
}
