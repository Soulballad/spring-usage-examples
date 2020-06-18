package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.model.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/18 21:52
 */
@Service
public class UserService implements UserDetailsService {

    private List<AuthUser> userList = new ArrayList<>();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<AuthUser> existUsers = userList.stream().filter(user -> username.equals(user.getUsername())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(existUsers)) {
            throw new UsernameNotFoundException("username or password is incorrect!");
        }else {
            return existUsers.get(0);
        }
    }

    @PostConstruct
    public void init() {
        String encPass = passwordEncoder.encode("123456");
        userList.add(new AuthUser("zhangsan", encPass, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userList.add(new AuthUser("lisi", encPass, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userList.add(new AuthUser("wangwu", encPass, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }
}
