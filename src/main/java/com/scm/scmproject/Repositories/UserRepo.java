package com.scm.scmproject.Repositories;

import com.scm.scmproject.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users ,String>
{

    Optional<Users> findByEmail(String email);
    Optional<Users> findByEmailAndPassword(String email ,String password);
}
