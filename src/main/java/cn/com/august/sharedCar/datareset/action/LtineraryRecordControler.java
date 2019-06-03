package cn.com.august.sharedCar.datareset.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cn.com.august.sharedCar.model.Car;
import cn.com.august.sharedCar.model.LtineraryRecord;
import io.swagger.annotations.Api;
@RepositoryRestResource(path = "ltinerary_record")
@Api(tags="repLtineraryRecord")
public interface LtineraryRecordControler   extends JpaRepository<LtineraryRecord, Long>{

}
