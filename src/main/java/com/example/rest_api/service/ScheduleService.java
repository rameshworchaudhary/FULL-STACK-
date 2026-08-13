package com.example.rest_api.service;

import com.example.rest_api.model.Schedule;
import com.example.rest_api.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Schedule not found with id: " + id));
    }

    public Schedule updateSchedule(Long id, Schedule updatedSchedule) {

        Schedule existingSchedule = getScheduleById(id);

        existingSchedule.setTitle(updatedSchedule.getTitle());
        existingSchedule.setScheduledAt(updatedSchedule.getScheduledAt());

        return scheduleRepository.save(existingSchedule);
    }

    public void deleteSchedule(Long id) {
        Schedule existingSchedule = getScheduleById(id);
        scheduleRepository.delete(existingSchedule);
    }
}