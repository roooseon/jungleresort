package com.jungle.resort.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jungle.resort.domain.Admin;

@Repository
public interface AdminDAO extends CrudRepository<Admin, Integer>{

}
