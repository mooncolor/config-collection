package com.cms.kernel.config;

import com.cms.front.service.HlszService;
import com.cms.front.service.TcsjxzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimerTaskConfig {

    private static final Logger logger = LoggerFactory.getLogger(TimerTaskConfig.class);

    @Autowired
    private HlszService hlszService;
    @Autowired
    private TcsjxzService tcsjxzService;

    @Scheduled(cron="0 55 12 * * ?")
    public void dsUpdateHl(){
        hlszService.dsUpdateHl();
    }

    @Scheduled(cron="0 0 13 * * ?")
    public void tbwszts(){
        tcsjxzService.tbwszts();
    }

}
