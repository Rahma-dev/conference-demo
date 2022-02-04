package com.pluralsight.conferencedemo.controllers;
import com.pluralsight.conferencedemo.models.Session;

import com.pluralsight.conferencedemo.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {

        this.sessionService = sessionService;
    }

    @GetMapping
    public List<Session> list() {
        return sessionService.list();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionService.get(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionService.create(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionService.delete(id);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
     return sessionService.update(id,session);
    }
}
