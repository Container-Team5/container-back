package com.example.containerback.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Delivery")
@Entity
public class Delivery {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL의 AUTO_INCREMENT를 사용
    private Long orderId;  // 주문 번호

    @Column(length = 10, nullable = false)
    private String pName;  // 상품명

    @Column(length = 10, nullable = false)
    private int quantity;  // 주문 개수

    @Column(length = 10, nullable = false)
    private String oName;  // 주문자

    @Column(length = 10, nullable = false)
    private Timestamp orderDate;  // 주문일자

    @Column(length = 10, nullable = false)
    private Timestamp deliveryDeadline;  // 출고 마감 시간

    @Column(length = 100, nullable = false)
    private String firstDel;  // 1차 배송지(항구)

    @Column(length = 100, nullable = false)
    private String finalDel;  // 최종 배송지

    @Column(length = 10, nullable = false)
    private String delState;  // 배송 현황
}
