package com.scm.scmproject.Services;

import com.scm.scmproject.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    public Users saveUsers(Users users);

    // public Users getUsersById (String id);
    //another method(in optional we dont have to use if ..else to check user exists ..we use error handling)
    Optional<Users>  getUsersById (String id);



   // public Users updateUsers(Users users);
     Optional<Users> updateUsers(Users users);

    public void deleteUsers (String id);

    public boolean isUsersExistByEmail(String email);

    public boolean isUsersExist(String userId);

    public List<Users> getAllUsers();


}
