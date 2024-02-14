package com.example.sb_resthw.repository;

import com.example.sb_resthw.Authorities;
import java.util.Arrays;
import java.util.List;
import com.example.sb_resthw.exceptions.UnauthorizedUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository{

        public List<Authorities> getUserAuthorities(String user, String password) {
            if(user.equals("Sudarev") && password.equals("1234")) return Arrays.asList(Authorities.values());
            else throw new UnauthorizedUser("Unknown user " + user);
        }
}
