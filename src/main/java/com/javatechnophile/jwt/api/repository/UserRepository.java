package com.javatechnophile.jwt.api.repository;

import com.javatechnophile.jwt.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>  {
    User findByUserName(String userName);
}
