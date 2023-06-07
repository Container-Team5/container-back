package com.example.containerback.palette;

import com.example.containerback.user.User;
import com.example.containerback.user.UserRepository;
import com.example.containerback.user.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaletteService {

    private final UserRepository userRepository;
    private final PaletteRepository paletteRepository;

    public List<Palette> getPaletteDetails(Long paletteId) {
        if(null != paletteId) {
            return paletteRepository.findAllByPaletteId(paletteId);
        } else {
            return paletteRepository.findAll();
        }
    }

    @Transactional
    public Long save(final PaletteSaveRequestDto requestDto, String userId) {
        User user = userRepository.findByUserIdAndState(userId, UserStatus.NORMAL, User.class).get();
        return paletteRepository.save(requestDto.toEntity(user)).getPaletteId();
    }

}