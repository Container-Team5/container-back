package com.example.containerback.controller;

import java.time.LocalDateTime;

public class CreatePaletteRequest {
    public String pName;  // 상품명
    public int quantity;  // 수량
    public float width;  // 가로
    public float length;  // 세로
    public float height;  // 높이
    public float weight;  // 무게
    public LocalDateTime dline;
    public String firstDel;  // 1차 배송지
    public String finalDel;  // 최종 배송지
}