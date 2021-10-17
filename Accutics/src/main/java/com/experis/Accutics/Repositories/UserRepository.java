package com.experis.Accutics.Repositories;


import com.experis.Accutics.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getUsersByEmail (String email);
    public List<User> getUsersByName (String name);
}
