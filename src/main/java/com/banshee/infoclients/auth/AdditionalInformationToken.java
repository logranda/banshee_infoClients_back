package com.banshee.infoclients.auth;

import com.banshee.infoclients.domain.CustomerEntity;
import com.banshee.infoclients.service.ICustomerService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component
public class AdditionalInformationToken implements TokenEnhancer {

    @Autowired
    private ICustomerService customerService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        CustomerEntity customerEntity = customerService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("name", customerEntity.getFullName());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
