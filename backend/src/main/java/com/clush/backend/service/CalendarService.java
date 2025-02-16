package com.clush.backend.service;

import com.clush.backend.dto.CalendarEventRequest;
import com.clush.backend.dto.CalendarEventResponse;
import com.clush.backend.mapper.CalendarEventMapper;
import com.clush.backend.model.CalendarEvent;
import com.clush.backend.repository.CalendarEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarEventRepository calendarEventRepository;
    private final CalendarEventMapper calendarEventMapper;

    @Transactional(readOnly = true)
    public List<CalendarEventResponse> getAllEvents() {
            return null;

    }

    @Transactional
    public CalendarEventResponse createEvent(CalendarEventRequest request) {
        CalendarEvent event = calendarEventMapper.toEntity(request);
        CalendarEvent savedEvent = calendarEventRepository.save(event);
        return calendarEventMapper.toResponse(savedEvent);
    }

    @Transactional
    public CalendarEventResponse updateEvent(Long id, CalendarEventRequest request) {
            return null;
        // 구현 예정
    }

    @Transactional
    public void deleteEvent(Long id) {
        calendarEventRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<CalendarEventResponse> getEventsByPeriod(LocalDateTime start, LocalDateTime end) {
            return null;
        // 구현 예정
    }

    @Transactional
    public CalendarEventResponse shareEvent(Long eventId, String targetUser) {
            return null;
        // 구현 예정
    }

    @Transactional(readOnly = true)
    public List<CalendarEventResponse> searchEvents(String keyword) {
            return null;
        // 구현 예정
    }

    // 월별 일정 조회
    @Transactional(readOnly = true)
    public List<CalendarEventResponse> getEventsByMonth(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.with(TemporalAdjusters.lastDayOfMonth());
        List<CalendarEvent> events = calendarEventRepository.findByStartDateBetween(start, end);
        if(events == null || events.isEmpty()) {
            return Collections.emptyList();
        }
        return events.stream()
                .map(calendarEventMapper::toResponse)
                .collect(Collectors.toList());
    }
} 