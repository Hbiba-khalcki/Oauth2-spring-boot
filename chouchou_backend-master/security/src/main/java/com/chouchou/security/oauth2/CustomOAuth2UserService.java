package com.chouchou.security.oauth2;

import com.chouchou.dao.RoleRepository;
import com.chouchou.dao.UserRepository;
import com.chouchou.model.AuthProvider;
import com.chouchou.model.Role;
import com.chouchou.model.UserManager;
import com.chouchou.security.UserPrincipal;
import com.chouchou.security.oauth2.user.OAuth2UserInfo;
import com.chouchou.security.oauth2.user.OAuth2UserInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;


@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
       /* System.out.println("***0 *** \n");
        System.out.println(oAuth2UserRequest.getClientRegistration().getRegistrationId());
        System.out.println("*** 1*** \n");
        System.out.println(oAuth2UserRequest.getAccessToken().getTokenType().getValue());
        System.out.println("***2 *** \n");
        System.out.println(oAuth2UserRequest.getAccessToken().getTokenValue());
        System.out.println("*** 37*** \n");*/
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        /*System.out.println(oAuth2User.getAttributes());*/
        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            /*System.out.println("***4 *** \n");
            System.out.println(ex.getStackTrace().toString());
            System.out.println("*** 6*** \n");*/
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }


    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
    /*    System.out.println("*** facebook 13*** \n");
        System.out.println(oAuth2User.toString());
        System.out.println("***14 facebook *** \n");
        System.out.println(oAuth2User.getName());
        System.out.println("*** facebook 15*** \n");*/
        System.out.println(oAuth2User.getAuthorities());
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());

        Optional<UserManager> userOptional = Optional.ofNullable(userRepository.findByLogin(oAuth2UserInfo.getEmail()));
        UserManager user;
        if (userOptional.isPresent()) {
            user = (UserManager) userOptional.get();
/*            System.out.println("***16 facebook *** \n");
            System.out.println(user.getLogin());*/
            if (!user.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                System.out.println("Looks like you're signed up with " +
                        user.getProvider() + " account. Please use your " + user.getProvider() +
                        " account to login.");
            }
            user = updateExistingUser(user, oAuth2UserInfo);
        } else {
            /*System.out.println("*** fb 108 providerid 17*** \n");*/
            user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
           /* System.out.println(user.getProviderId());*/
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private UserManager registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        UserManager user = new UserManager();

        user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        user.setProviderId(oAuth2UserInfo.getId());
        user.setNom(oAuth2UserInfo.getName());
        user.setLogin(oAuth2UserInfo.getEmail());
        Role role = roleRepository.getByName("ROLE_CLIENT");
        List<Role> roles = roleRepository.findAll();
        roles.clear();
        roles.add(role);
        user.setRoles(roles);
        UserManager result = userRepository.save(user);
        return userRepository.save(user);
    }

    private UserManager updateExistingUser(UserManager existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.setNom(oAuth2UserInfo.getName());
        return userRepository.save(existingUser);
    }

}