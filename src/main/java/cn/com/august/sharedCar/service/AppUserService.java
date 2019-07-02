package cn.com.august.sharedCar.service;


import java.util.List;

import org.springframework.data.domain.Page;

import cn.com.august.sharedCar.model.AppUser;

public interface AppUserService  {
		public String addAppUser(AppUser appUser);
		public String updateAppUser(AppUser appUser);
		public String deleteAppUser(AppUser appUser);
		public AppUser queryAppUser(AppUser appUser);
		public List<AppUser> queryAllAppUser(int pageIndex, int size,String orderName);
}
