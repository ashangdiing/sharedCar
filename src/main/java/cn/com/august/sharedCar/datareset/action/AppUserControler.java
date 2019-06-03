package cn.com.august.sharedCar.datareset.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cn.com.august.sharedCar.model.AppUser;
import io.swagger.annotations.Api;
@RepositoryRestResource(path = "app_user")
@Api(tags="repAppUer")
public interface AppUserControler extends JpaRepository<AppUser, Long>{

}
