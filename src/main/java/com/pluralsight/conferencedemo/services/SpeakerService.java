package com.pluralsight.conferencedemo.services;
import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    public SpeakerService(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    public Speaker get(@PathVariable Long id){
        return speakerRepository.findById(id).orElse(null);
    }

    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    public void delete(@PathVariable Long id){
        speakerRepository.getOne(id).remove();
        speakerRepository.deleteById(id);
    }

    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        //Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        if ((!speaker.getSpeaker_id().toString().isEmpty()) && (!speaker.getFirst_name().isEmpty())
                && (!speaker.getLast_name().isEmpty()) && (!speaker.getSpeaker_bio().isEmpty())
                && (!speaker.getCompany().isEmpty()) && (!speaker.getTitle().isEmpty())) {
            return speakerRepository.saveAndFlush(existingSpeaker);
        }
        return existingSpeaker;
    }

}
