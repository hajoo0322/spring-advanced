package org.example.develop.service;

import org.example.develop.dto.PageResponseDto;
import org.example.develop.dto.PatchRequestCalendarDto;
import org.example.develop.dto.RequestCalendarDto;
import org.example.develop.dto.ResponseCalendarDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceCalendar {

    ResponseCalendarDto addCalendar(RequestCalendarDto requestCalendarDto, Long id);

    List<ResponseCalendarDto> getCalendar(Long id);

    Page<PageResponseDto> getPageCalendar(Pageable pageable);

    ResponseCalendarDto updateCalendar(PatchRequestCalendarDto patchRequestCalendarDto);

    void deleteCalendar(Long id);
}
