package com.gannyee.accessingdatawithmysql.repository;

import com.gannyee.accessingdatawithmysql.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
