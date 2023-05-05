package com.example.containerback.container;

import com.example.containerback.controller.CreateContainerRequest;
import com.example.containerback.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Container")
@Entity
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long cId; // 컨테이너 ID

    @Column(length = 2, nullable = false)
    private float width;  // 가로

    @Column(length = 2, nullable = false)
    private float length;  // 세로

    @Column(length = 2, nullable = false)
    private float height;  // 높이

    @Column(length = 10, nullable = false)
    private float volume;  // 부피

    @Column(length = 6, nullable = false)
    private float weight;  // 무게

    @Column(length = 6, nullable = false)
    private float wlimit;  // 무게제한

    public Container(CreateContainerRequest request){
        this.width = request.width;
        this.length = request.length;
        this.height = request.height;
        this.volume = this.width * this.length * this.height;
        this.weight = request.weight;
        this.wlimit = request.wlimit;

    }
}
