package com.ada.systemlab.systemlabV1.repository;

import com.ada.systemlab.systemlabV1.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User,Integer> {
}
