package org.laki.filtertest;

import org.laki.filtertest.dto.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailService implements UserDetailsService {

    private List<User> users = new ArrayList<>();

    public AppUserDetailService() {
        users.add(new User()
                .setUserName("lakshman").setPassword("$2a$12$MbtoFbAi9bMqxCphqIVffOgOvnyyU4KSvailqdf0/sVXEAYQ26JFu"))
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
