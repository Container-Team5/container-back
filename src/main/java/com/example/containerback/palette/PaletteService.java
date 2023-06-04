package com.example.containerback.palette;

import com.example.containerback.admin.Admin;
import com.example.containerback.admin.AdminRepository;
import com.example.containerback.admin.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaletteService {

    private final AdminRepository adminRepository;
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
        Admin admin = adminRepository.findByUserIdAndState(userId, UserStatus.NORMAL, Admin.class).get();
        return paletteRepository.save(requestDto.toEntity(admin)).getPaletteId();}
}