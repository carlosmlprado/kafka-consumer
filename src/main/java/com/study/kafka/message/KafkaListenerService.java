package com.study.kafka.message;

import com.study.kafka.dto.UserDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class KafkaListenerService {

    @KafkaListener(
            topics = "email-topic",
            groupId="email",
            containerFactory="familiaDTOKafkaListenerContainerFactory")
    void listener(UserDTO familiaDTO) {
        log.info("CustomUserListener [{}]", familiaDTO);
    }
}
