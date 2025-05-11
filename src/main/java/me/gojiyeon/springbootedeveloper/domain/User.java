package me.gojiyeon.springbootedeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Entity //엔티티로 지정
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails { //UserDatails를 상속받아 인증객체로 사용

    @Id //기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name="email", nullable=false, unique = true)
    private String email;

    @Column(name="password")  //nullable=false안함..?
    private String password;

    //사용자이름
    @Column(name="nickname", unique=true)
    private String nickname;

    @Builder
    public User(String email, String password, String auth, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    @Override //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    //사용자의 id를 반환 (고유값)
    @Override
    public String getUsername() {
        return email;
    }

    //사용자의 패스워드 반환
    @Override
    public String getPassword() {
        return password;
    }

    //계정만료여부 반환
    @Override
    public boolean isAccountNonExpired(){
        //만료되었는지 확인하는 로직
        return true; //아직 만료안됨
    }

    //계정 잠금여부 반환
    @Override
    public boolean isAccountNonLocked() {
        //계정 잠겼는지 확인 로직
        return true; //잠금되지 않음
    }

    //패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired(){
        //패스워드 만료 확인 로직
        return true; //만료되지 않음
    }

    //계정 사용가능 여부 확인
    @Override
    public boolean isEnabled() {
        //계정 사용 가능 확인 로직
        return true; //사용가능
    }

    //사용자 이름 변경
    public User update(String nickname) {
        this.nickname = nickname;

        return this;
    }
}
