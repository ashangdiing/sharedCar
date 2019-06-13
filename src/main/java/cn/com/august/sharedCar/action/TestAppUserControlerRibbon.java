package cn.com.august.sharedCar.action;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.com.august.sharedCar.Config;
import cn.com.august.sharedCar.model.AppUser;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/shacar/test_app_user")
public class TestAppUserControlerRibbon {
	 @Autowired
	 RestTemplate restTemplate;
	 
	 
	
	 @RequestMapping(value="/addUser",method =RequestMethod.GET)
	 @ApiOperation(value="添加用户信息", notes="根据用户状态和到期时间为条件")
	 @ApiImplicitParams({ 
		 @ApiImplicitParam( name = "userName", value = "用户名字", required = false, dataType = "Long") ,
			 })
	public String addUser(Principal principal,@RequestParam(required = false) String userName) {
		log.debug("test_app_user addUser:"+userName);
		 HttpHeaders headers = new HttpHeaders();

		//传递Map集合
			Map<String, Object> params=new HashMap<>();
			params.put("appUserId", userName);
			params.put("userName", userName);
	        HttpEntity<Map> entity = new HttpEntity<>(params,headers);
		 
	        return	this.restTemplate.postForObject("http://SHAREDCAR/api_data_rest/app_user",entity,String.class );
	}
	 
	 
	 @RequestMapping(value="/",method =RequestMethod.GET)
	 @ApiOperation(value="获取所有的用户信息", notes="根据用户状态和到期时间为条件")
	 @ApiImplicitParams({ 
		 @ApiImplicitParam( name = "page", value = "页码", required = false, dataType = "Long") ,
		 @ApiImplicitParam( name = "pageSize", value = "分页大小", required = false, dataType = "Long") ,
			 })
	public String queryAllUser(Principal principal,@RequestParam(required = false) int page,@RequestParam(required = false) int pageSize) {
		 log.debug("test_app_user  queryUser page:"+page+" pageSize:"+pageSize);
		 return this.restTemplate.getForObject("http://SHAREDCAR/api_data_rest/app_user?page={1}&size={2}",String.class,new Object[]{page,pageSize});
	}
	 
	 
	 @RequestMapping(value="/{id}",method =RequestMethod.GET)
	 @ApiOperation(value="获取用户信息", notes="根据用户状态和到期时间为条件")
	 @ApiImplicitParams({ 
		 @ApiImplicitParam( name = "id", value = "用户的id编号，/{id} @PathVariable", required = false, dataType = "Long") ,
	 })
	 public String queryUser(Principal principal,@PathVariable("id")  int id) {
		 log.debug("test_app_user  queryUser id:"+id);
		 return this.restTemplate.getForObject("http://SHAREDCAR/api_data_rest/app_user/{1}",String.class,new Object[]{id});
	 }
	 
	 
	 
	 
}
