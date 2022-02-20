package com.example.demo.controller;

import com.example.demo.model.Notice;
import com.example.demo.repository.NoticeRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class NoticesController {

    private final NoticeRepository noticeRepository;

    public NoticesController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @GetMapping("/notices")
    public List<Notice> getNotices() {
        List<Notice> notices = (List<Notice>) noticeRepository.findAll();
        if (CollectionUtils.isEmpty(notices)) {
            return Collections.emptyList();
        } else {
            return notices;
        }
    }

}
