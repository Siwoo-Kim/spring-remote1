package com.siwoo.application.repository;

import com.siwoo.application.domain.Singer;
import com.siwoo.application.service.SingerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Log
@Service("singerService") @Transactional(readOnly = true)
public class SingerServiceImpl implements SingerService {

    @Autowired SingerRepository singerRepository;

    private void logRemotingRequest(){
        log.info("Requested by Remote");
    }

    @Override
    public List<Singer> findAll() {
        logRemotingRequest();
        return singerRepository.findAll();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        Assert.hasText(firstName,"Argument should have text");
        return singerRepository.findByFirstName(firstName);
    }

    @Override
    public Singer findById(Long id) {
        return singerRepository.findById(id).orElse(null);
    }

    @Override @Transactional(readOnly = false)
    public Singer save(Singer singer) {
        Assert.notNull(singer,"Singer should not null");
        return singerRepository.save(singer);
    }

    @Override @Transactional(readOnly = false)
    public void delete(Singer singer) {
        Assert.notNull(singer,"Singer should not null");
        singerRepository.delete(singer);
    }
}
