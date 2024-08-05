package com.scm.scmproject.Services.ServicesImple;

import com.scm.scmproject.Repositories.UserRepo;
import com.scm.scmproject.Services.UserService;
import com.scm.scmproject.entities.Users;
import com.scm.scmproject.helpers.ResourceNotfoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServicesImple implements UserService
{
   @Autowired
   private UserRepo userRepo;

   private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public Users saveUsers(Users users) {
        //user id dynamic generate
        String userId= UUID.randomUUID().toString();
        users.setUserId(userId);
        return userRepo.save(users);
    }

    @Override
    public Optional<Users> getUsersById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<Users> updateUsers(Users user) {

        Users user2 = userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotfoundException("user not found"));


       user2.setName(user.getName());
       user2.setEmail(user.getEmail());
       user2.setPassword(user.getPassword());
       user2.setAbout(user.getAbout());
       user2.setPhoneNumber(user.getPhoneNumber());
       user2.setProfilePic(user.getProfilePic());
       user2.setEnabled(user.isEnabled());
       user2.setEmailVerified(user.isEmailVerified());
       user2.setPhoneVerified(user.isPhoneVerified());
       user2.setProviderUserId(user.getProviderUserId());
       user2.setProvider(user.getProvider());


        Users save = userRepo.save(user2);
        return  Optional.ofNullable(save);
    }


    @Override
    public void deleteUsers(String id) {

        Users user2 = userRepo.findById(id).orElseThrow(()-> new ResourceNotfoundException("user not found"));
         userRepo.delete(user2);

    }

    @Override
    public boolean isUsersExistByEmail(String email) {
        Users users = userRepo.findByEmail(email).orElse(null);
        return  users != null ?true :false ;
    }

    @Override
    public boolean isUsersExist(String userId) {
        Users user2 = userRepo.findById(userId).orElse(null);
        return user2 !=null ? true :false;

    }

    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }
}
