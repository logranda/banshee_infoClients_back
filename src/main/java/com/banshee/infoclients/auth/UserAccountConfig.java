package com.banshee.infoclients.auth;

import com.banshee.infoclients.domain.CustomerEntity;
import com.banshee.infoclients.service.ICustomerService;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserAccountConfig implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserAccountConfig.class);

    @Autowired
    private ICustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity user = customerService.findByUsername(username);
        List<GrantedAuthority> authorities = Collections.singletonList("ROLE_ADMIN")
            .stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_ADMIN"))
            .peek(authority -> logger.info(MessageFormat.format("Role: {0}.", authority.getAuthority())))
            .collect(Collectors.toList());
        logger.info(MessageFormat.format("User authenticated: {0}.", username));
        return new User(user.getUsername(), user.getPassword(), true,
            true, true, true, authorities);
    }
}
