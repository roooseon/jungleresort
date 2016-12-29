package com.jungle.resort.admin;

import org.springframework.beans.factory.annotation.Autowired;

import com.jungle.resort.domain.Admin;
import com.jungle.resort.repositories.AdminDAO;


public class AdminService implements IAdminService {

	@Autowired
	private AdminDAO admindao;
	
	@Override
	public Admin addAdmin(Admin admin) {
		return admindao.save(admin);
	}

	@Override
	public void deleteAdmin(int id) {
		admindao.delete(id);		
	}

	@Override
	public Admin getAdminById(int id) {
		return admindao.findOne(id);
	}

}
