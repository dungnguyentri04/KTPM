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
        long totalUsers = userRepository.countTotalUsers();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalUsers(totalUsers);
        return null;
    }

    @Override
    public StatisticDto getStatisticRoom() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticHotel() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomType() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticHotelType() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomStatus() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticHotelStatus() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomTypeStatus() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticHotelTypeStatus() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomTypePrice() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticHotelTypePrice() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }

    @Override
    public StatisticDto getStatisticRoomTypePriceStatus() {
        long totalRooms = roomRepository.countTotalRooms();
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setTotalRooms(totalRooms);
        return null;
    }
}
