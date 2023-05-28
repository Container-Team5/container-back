/*
package com.example.containerback.palette;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaletteControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PaletteRepository paletteRepository;

    @After
    public void tearDown() throws Exception{
        PaletteRepository.deleteAll();
    }

    @Test
    public void Palette_register() throws Exception {
        // given
        String pName; // 상품명

        int quantity;  // 수량

        float width;  // 가로

        float length;  // 세로

        float height;  // 높이

        float volume;  // 부피

        float weight;  // 무게

        LocalDateTime dLine;  // 출고 마감 시간

        String firstDel;  // 1차 배송지

        String finalDel;  // 최종 배송지
        PaletteSaveRequestDto requestDto = PaletteSaveRequestDto.builder()
                .pName(pName)
                .quantity(quantity)
                .width(width)
                .length(length)
                .height(height)
                .volume(volume)
                .weight(weight)
                .dLine(dLine)
                .firstDel(firstDel)
                .finalDel(finalDel)
                .build();

        String url = "http://localhost:" + port + "/palette";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.
                paletteForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Palette> all = paletteRepository.findAll();
        assertThat(all.get(0).getPName()).isEqualTo(pName);
        assertThat(all.get(0).getQuantity()).isEqualTo(quantity);
        assertThat(all.get(0).getWidth()).isEqualTo(width);
        assertThat(all.get(0).getLength()).isEqualTo(length);
        assertThat(all.get(0).getHeight()).isEqualTo(height);
        assertThat(all.get(0).getVolume()).isEqualTo(volume);
        assertThat(all.get(0).getWeight()).isEqualTo(w);
        assertThat(all.get(0).getDLine()).isEqualTo(dLine);
        assertThat(all.get(0).getFirstDel()).isEqualTo(firstDel);
        assertThat(all.get(0).getFinalDel()).isEqualTo(finalDel);
        
    }
}

*/
