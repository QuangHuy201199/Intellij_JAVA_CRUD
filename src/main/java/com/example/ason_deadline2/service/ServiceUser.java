package com.example.ason_deadline2.service;

import com.example.ason_deadline2.model.inUser.InUser;
import com.example.ason_deadline2.model.respondUser.RespondUser;
import org.springframework.stereotype.Service;

@Service
public interface ServiceUser {
    RespondUser pagination(Integer page, Integer limit);
    RespondUser create(InUser inUser);
    RespondUser delete(Integer id);
    RespondUser update(Integer id, InUser inUser);
    RespondUser updateStatus(Integer id, InUser inUser);
}
