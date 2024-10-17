package com.TeamNull.LostArk.LostArk.user;

import java.util.Optional;

import com.TeamNull.LostArk.LostArk.DataNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public SiteUser create(String username,String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));

        this.userRepository.save(user);
        return user;
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
        if(siteUser.isPresent()) {
            return siteUser.get();
        }else {
            throw new DataNotFoundException("사용자를 찾지 못했습니다.");
        }
    }

}

