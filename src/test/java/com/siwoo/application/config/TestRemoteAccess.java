package com.siwoo.application.config;

import com.siwoo.application.domain.Singer;
import com.siwoo.application.service.SingerService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.*;

@Log
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RemoteClientConfig.class)
public class TestRemoteAccess {

    @Autowired SingerService singerService;

    Consumer<List<Singer>> listSinger = singers -> {
        singers.stream().map(Singer::toString).forEach(log::warning);
    };

    @Test
    public void testFindAll(){
        List<Singer> singerList = singerService.findAll();
        assertEquals(singerList.size(),3,0);
        listSinger.accept(singerList);
    }

    public void testFindFirstName(){
        List<Singer> singerList = singerService.findByFirstName("Kim");
        assertEquals(singerList.size(),2,0);
        listSinger.accept(singerList);
    }
}
