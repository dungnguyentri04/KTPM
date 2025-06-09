package com.example.demo.service.Impl;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.StatisticDto;
import com.example.demo.repositories.*;
import com.example.demo.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private DemographicsRepository demographicsRepository;

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private ContributionRepository contributionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public StatisticDto getStatistic() {
        long totalRooms = roomRepository.countTotalRooms();
        long countOccupiedRooms = roomRepository.countOccupiedRooms();
        long totalHouseholds = householdRepository.countTotalHouseholds();
        long totalUsers = userRepository.countTotalUsers();
        long totalDemographics = demographicsRepository.countTotalDemographics();
        long householdPaid = contributionRepository.countHouseholdsWithCompleteContribution();
        long householdUnpaid = contributionRepository.countHouseholdsWithIncompleteContribution();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        statisticDto.setCountOccupiedRooms(countOccupiedRooms);
        statisticDto.setTotalHouseholds(totalHouseholds);
        statisticDto.setTotalUsers(totalUsers);
        statisticDto.setTotalDemographics(totalDemographics);
        statisticDto.setHouseholdPaid(householdPaid);
        statisticDto.setHouseholdUnpaid(householdUnpaid);
        return statisticDto;
    }

    @Override
    public StatisticDto getStatisticUser() {
        return null;
    }

    @Override
    public StatisticDto getStatisticRoom() {
        return null;
    }

    @Override
    public StatisticDto getStatisticHotel() {
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomType() {
        return null;
    }

    @Override
    public StatisticDto getStatisticHotelType() {
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomStatus() {
        return null;
    }

    @Override
    public StatisticDto getStatisticHotelStatus() {
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomTypeStatus() {
        return null;
    }

    @Override
    public StatisticDto getStatisticHotelTypeStatus() {
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomTypePrice() {
        return null;
    }

    @Override
    public StatisticDto getStatisticHotelTypePrice() {
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomTypePriceStatus() {
        return null;
    }
}
