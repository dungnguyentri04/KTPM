package com.example.demo.service;

import com.example.demo.dto.StatisticDto;

public interface StatisticService {
    public StatisticDto getStatistic();

    public StatisticDto getStatisticUser();

    public StatisticDto getStatisticRoom();

    public StatisticDto getStatisticHotel();

    public StatisticDto getStatisticRoomType();

    public StatisticDto getStatisticHotelType();

    public StatisticDto getStatisticRoomStatus();

    public StatisticDto getStatisticHotelStatus();

    public StatisticDto getStatisticRoomTypeStatus();

    public StatisticDto getStatisticHotelTypeStatus();

    public StatisticDto getStatisticRoomTypePrice();

    public StatisticDto getStatisticHotelTypePrice();

    public StatisticDto getStatisticRoomTypePriceStatus();
}
