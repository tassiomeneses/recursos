package br.com.recursos.scheduled;


import br.com.recursos.entity.Pessoa;
import br.com.recursos.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final String TIME_ZONE = "America/Fortaleza";

    @Autowired
    PessoaService pessoaService;

//    @Transactional
//    @Scheduled(cron = "0 0/1 * * * *", zone = TIME_ZONE)
//    public void processar() throws Exception {
//        log.info("ScheduledTasks.processar {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        pessoaService.mockapi();
//    }

}
