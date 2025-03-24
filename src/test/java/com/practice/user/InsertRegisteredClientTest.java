//package com.practice.user;
//
//import com.practice.user.Security.Repositories.ClientRepository;
//import com.practice.user.Security.Repositories.JpaRegisteredClientRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.OidcScopes;
//import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
//import org.springframework.test.annotation.Commit;
//
//import java.util.UUID;
//
//@SpringBootTest
//public class InsertRegisteredClientTest {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private JpaRegisteredClientRepository jpaRegisteredClientRepository;
//
//    @Test
////    @Commit
//    public void insetNewClientToDb(){
////            RegisteredClient postmanClient = RegisteredClient.withId(UUID.randomUUID().toString())
////                    .clientId("productservice")
////                    .clientSecret(passwordEncoder.encode("pspassword"))
////                    .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
////                    .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
////                    .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
////                    .redirectUri("http://127.0.0.1:8080/login/oauth2/code/oidc-client")
////                    .postLogoutRedirectUri("http://127.0.0.1:8080/")
////                    .scope(OidcScopes.OPENID)
////                    .scope(OidcScopes.PROFILE)
////                    .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
////                    .build();
////
////            jpaRegisteredClientRepository.save(postmanClient);
//
//
//    }
//}
