package com.pluralsight.conferencedemo.services;
import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> list() {
        return sessionRepository.findAll();
    }

    public Session get(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    public Session create(final Session session) {

        return sessionRepository.saveAndFlush(session);
    }

    public void delete(Long id) {
        get(id).remove();
        sessionRepository.deleteById(id);
    }

    public Session update(Long id, Session session){
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");

            if ((!session.getSession_id().toString().isEmpty()) && (!session.getSession_name().isEmpty()) && (!session.getSession_description().isEmpty()) && (!session.getSession_length().toString().isEmpty())) {
                return sessionRepository.saveAndFlush(existingSession);
            }

        return existingSession;
    }
}