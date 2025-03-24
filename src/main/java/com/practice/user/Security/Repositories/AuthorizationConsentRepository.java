//package com.practice.user.Security.Repositories;
//
//import java.util.Optional;
//import com.practice.user.Security.Model.AuthorizationConsent;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface AuthorizationConsentRepository extends JpaRepository<AuthorizationConsent, AuthorizationConsent.AuthorizationConsentId> {
//    Optional<AuthorizationConsent> findByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
//    void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
//}
//
