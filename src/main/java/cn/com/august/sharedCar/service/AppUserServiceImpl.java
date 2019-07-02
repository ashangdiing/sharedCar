package cn.com.august.sharedCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.alibaba.dubbo.config.annotation.Service;

import cn.com.august.sharedCar.datareset.action.AppUserControler;
import cn.com.august.sharedCar.model.AppUser;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AppUserServiceImpl  implements AppUserService {
	
	@Autowired
	AppUserControler appUserControler;
	
	@Override
	public String addAppUser(AppUser appUser) {
		appUserControler.save(appUser);
		log.debug("添加成功{}",appUser.getUserName());
		
		return "添加成功"+appUser.getUserName();
	}

	@Override
	public String updateAppUser(AppUser appUser) {
		appUserControler.save(appUser);
		log.debug("更新成功{}",appUser.getAppUserId());
		return "更新成功"+appUser.getAppUserId();
	}

	@Override
	public String deleteAppUser(AppUser appUser) {
		appUserControler.delete(appUser);
		log.debug("删除成功{}",appUser.getAppUserId());
		return "删除成功"+appUser.getAppUserId();
	}

	@Override
	public AppUser queryAppUser(AppUser appUser) {
		Example<AppUser> userExample = Example.of(appUser);
		appUser=appUserControler.findOne(userExample).orElse(null);
		log.debug("查询成功{}",appUser);
		if(appUser==null)
			{appUser=new AppUser();
		appUser.setUserName("没查询到数据");
		}
		return appUser;
	}

	@Override
	public List<AppUser> queryAllAppUser(int pageIndex, int size,String orderName) {
		//根据id 进行降序
	      
        Sort.Order order =  new Sort.Order(Sort.Direction.DESC,orderName);
        Sort sort = new Sort(order);
		//index 1 从0开始 不是从1开始的
        Pageable page = new PageRequest(pageIndex,size,sort);
        Page<AppUser> all =appUserControler.findAll(page);
		log.debug("查询所有成功  第{}页的数据，  每页大小:{}  按{}属性排序. 一共{} 页,一共 {}条记录",pageIndex,size,orderName,all.getTotalPages(),all.getTotalElements());
		return all.getContent();
	}

}
