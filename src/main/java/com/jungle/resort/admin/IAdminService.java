package com.jungle.resort.admin;

import com.jungle.resort.domain.Admin;


public interface IAdminService {
	public Admin addAdmin(Admin admin);
	public void deleteAdmin(int id);
	public Admin getAdminById(int id);
}
