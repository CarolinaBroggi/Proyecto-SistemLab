package com.ada.systemlab.systemlabV1.repository;

import com.ada.systemlab.systemlabV1.model.Resource;
import com.ada.systemlab.systemlabV1.model.Role;
import com.ada.systemlab.systemlabV1.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ResourceRepository extends CrudRepository <Resource,Integer> {

    @Query (value = "select r.* from resource as r inner join role_resource as rs " +
            "on r.id_resource = rs.id_resource where rs.id_role = :roleId",nativeQuery = true )
    Collection <Resource> getResourceByRole(@Param("roleId") String roleId);
}
