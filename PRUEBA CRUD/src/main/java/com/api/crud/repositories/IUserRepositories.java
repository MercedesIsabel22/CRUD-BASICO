package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //nos permite hacer consultas,query a una bd
public interface IUserRepositories extends JpaRepository<UserModel, Long> {


}
