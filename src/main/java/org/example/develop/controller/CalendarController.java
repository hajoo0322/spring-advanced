package org.example.develop.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.develop.dto.PageResponseDto;
import org.example.develop.dto.PatchRequestCalendarDto;
import org.example.develop.dto.RequestCalendarDto;
import org.example.develop.dto.ResponseCalendarDto;
import org.example.develop.service.ServiceCalendar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    ServiceCalendar serviceCalendar;

    public CalendarController(ServiceCalendar serviceCalendar) {
        this.serviceCalendar = serviceCalendar;
    }

    @PostMapping
    public ResponseEntity<ResponseCalendarDto> addCalendar(@Valid @RequestBody RequestCalendarDto requestCalendarDto, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return new ResponseEntity<>(serviceCalendar.addCalendar(requestCalendarDto,userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseCalendarDto>> getCalendar(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return new ResponseEntity<>(serviceCalendar.getCalendar(userId), HttpStatus.OK);
    }

    @GetMapping("/all/page")
    public ResponseEntity<Page<PageResponseDto>> getAllCalendar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("lastModifiedDate").descending());
        return new ResponseEntity<>(serviceCalendar.getPageCalendar(pageable), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<ResponseCalendarDto> updateCalendar(@Valid @RequestBody PatchRequestCalendarDto patchRequestCalendarDto) {
        return new ResponseEntity<>(serviceCalendar.updateCalendar(patchRequestCalendarDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCalendar(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        serviceCalendar.deleteCalendar(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
