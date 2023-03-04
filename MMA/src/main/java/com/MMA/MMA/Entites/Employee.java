


package com.MMA.MMA.Entites;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false, updatable = false)
        private Long id;
        private String name;
        private Integer level;
        private String email;
        private String password;
        private String onbenchsince;

        @Enumerated(EnumType.STRING)
        private Role role;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority(role.name()));
        }

        @Override
        public String getPassword() {
                return password;
        }

        @Override
        public String getUsername() {
                return email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}



//package com.MMA.MMA.member;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Date;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table
//public class RegularUser implements UserDetails {
//
//
//        private String name;
//        @Id
//        private String username;
//        private String password;
//        private Integer level;
//        private String email;
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//                return null;
//        }
//
//        @Override
//        public String getUsername() {
//                return username;
//        }
//        @Override
//        public String getPassword() {
//                return password;
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//                return false;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//                return false;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//                return false;
//        }
//
//        @Override
//        public boolean isEnabled() {
//                return false;
//        }
//}
