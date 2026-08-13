package com.example.rest_api.controller;

import com.example.rest_api.dto.ApiResponse;
import com.example.rest_api.model.Schedule;
import com.example.rest_api.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<Schedule>> createSchedule(
            @Valid @RequestBody Schedule schedule) {

        Schedule createdSchedule = scheduleService.createSchedule(schedule);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Schedule created successfully",
                        createdSchedule
                ));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<Schedule>>> getAllSchedules() {

        List<Schedule> schedules = scheduleService.getAllSchedules();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Schedules retrieved successfully",
                        schedules
                )
        );
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Schedule>> getScheduleById(
            @PathVariable Long id) {

        Schedule schedule = scheduleService.getScheduleById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Schedule retrieved successfully",
                        schedule
                )
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Schedule>> updateSchedule(
            @PathVariable Long id,
            @Valid @RequestBody Schedule schedule) {

        Schedule updatedSchedule =
                scheduleService.updateSchedule(id, schedule);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Schedule updated successfully",
                        updatedSchedule
                )
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSchedule(
            @PathVariable Long id) {

        scheduleService.deleteSchedule(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Schedule deleted successfully",
                        null
                )
        );
    }
}