package com.study.myhome.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.study.myhome.enums.Authority;
import com.study.myhome.menu.service.MenuService;
import com.study.myhome.menu.service.MenuVO;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;

public class MenuInfoInterceptor extends WebContentInterceptor {

	private static Logger LOG = LoggerFactory.getLogger(MenuInfoInterceptor.class);

	@Autowired
	private MenuService menuService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)	throws Exception {
		LOG.info("menuInterceptor postHandle");
		
		MenuVO menu;
		if (EgovUserDetailsHelper.isAuthenticated()) {
			LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
			//TODO 권한을 새로 갱신하는 구현해야 된다.
			int menu_idx = loginVO.getUserAuthority().getMenus().getMenu_idx();
			menu = menuService.findMenus(new MenuVO(Authority.values()[menu_idx]));
		} else {
			menu = menuService.findMenus(new MenuVO(Authority.NONMEMBER));
		}

		LOG.info("menuIdx : {}" , menu.getMenu_idx());
		
		request.setAttribute("menuIdx", menu.getMenu_idx());
		request.setAttribute("menus", menu.getMenuDetails());
	}

}
