package com.ada.systemlab.systemlabV1.repository;

import com.ada.systemlab.systemlabV1.model.Role;
import com.ada.systemlab.systemlabV1.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoleRepository extends CrudRepository <Role,Integer> {

    @Query(value = "select r.* from role as r inner join user_role as ur " +
            "on r.id_role = ur.id_role where ur.id_user = :userId", nativeQuery = true)
    Collection<Role> getRolesByUser(@Param("userId") String userId );


}
