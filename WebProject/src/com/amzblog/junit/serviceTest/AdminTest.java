package com.amzblog.junit.serviceTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.amzblog.model.Admin;
import com.amzblog.service.AdminService;

public class AdminTest {

	@Test
	public void test() {
		String adminName="admin1";
		String adminPassword="123";
		AdminService as=AdminService.getInstance();
		Admin admin=as.adminLogin(adminName, adminPassword);
		System.out.println(admin.getAdminNickname());
	}

}
