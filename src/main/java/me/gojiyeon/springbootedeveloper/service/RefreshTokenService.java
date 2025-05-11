package me.gojiyeon.springbootedeveloper.service;

import lombok.RequiredArgsConstructor;
import me.gojiyeon.springbootedeveloper.domain.RefreshToken;
import me.gojiyeon.springbootedeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
