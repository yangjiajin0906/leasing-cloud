//package com.leasing.sys.entity;
//
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
///**
// * @project:leasing-cloud
// * @date:2019/9/25
// * @author:wangjc@yonyou.com
// * @description:
// **/
//
//@Component
//public class AuditorAwareImpl implements AuditorAware<String> {
//
//    @Override
//    public Optional<String> getCurrentAuditor() {
//        return Optional.of("Ramesh");
//        // Use below commented code when will use Spring Security.
//    }
//}
//
///*class SpringSecurityAuditorAware implements AuditorAware<User> {
//
// public User getCurrentAuditor() {
//
//  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//  if (authentication == null || !authentication.isAuthenticated()) {
//   return null;
//  }
//
//  return ((MyUserDetails) authentication.getPrincipal()).getUser();
// }
//}*/