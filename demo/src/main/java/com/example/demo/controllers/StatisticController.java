package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.StatisticDto;
import com.example.demo.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    @GetMapping("/statistics")
    public ResponseEntity<ApiResponse<StatisticDto>> statistic() {
        StatisticDto statisticDto = statisticService.getStatistic();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/user")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticUser() {
        StatisticDto statisticDto = statisticService.getStatisticUser();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/room")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticRoom() {
        StatisticDto statisticDto = statisticService.getStatisticRoom();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/hotel")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticHotel() {
        StatisticDto statisticDto = statisticService.getStatisticHotel();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/roomType")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticRoomType() {
        StatisticDto statisticDto = statisticService.getStatisticRoomType();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/hotelType")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticHotelType() {
        StatisticDto statisticDto = statisticService.getStatisticHotelType();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/roomStatus")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticRoomStatus() {
        StatisticDto statisticDto = statisticService.getStatisticRoomStatus();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/hotelStatus")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticHotelStatus() {
        StatisticDto statisticDto = statisticService.getStatisticHotelStatus();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/roomTypeStatus")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticRoomTypeStatus() {
        StatisticDto statisticDto = statisticService.getStatisticRoomTypeStatus();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/hotelTypeStatus")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticHotelTypeStatus() {
        StatisticDto statisticDto = statisticService.getStatisticHotelTypeStatus();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/roomTypePrice")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticRoomTypePrice() {
        StatisticDto statisticDto = statisticService.getStatisticRoomTypePrice();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/statistics/hotelTypePrice")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticHotelTypePrice() {
        StatisticDto statisticDto = statisticService.getStatisticHotelTypePrice();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/statistics/roomTypePriceStatus")
    public ResponseEntity<ApiResponse<StatisticDto>> statisticRoomTypePriceStatus() {
        StatisticDto statisticDto = statisticService.getStatisticRoomTypePriceStatus();
        ApiResponse<StatisticDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(statisticDto);
        apiResponse.setMessage("Get statistic successfully");
        apiResponse.setStatus("success");
        return ResponseEntity.ok(apiResponse);
    }
}
