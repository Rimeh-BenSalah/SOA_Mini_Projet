package com.rimeh.message.functions;

import com.rimeh.message.LivreMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private static final Logger log =
            LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<LivreMessageDto,LivreMessageDto> email() {
        return livreMsgDto -> {
            log.info("Sending email with the details : " +
                    livreMsgDto.toString());
            return livreMsgDto;
        };
    }

    @Bean
    public Function<LivreMessageDto,Long> sms() {
        return livreMsgDto -> {
            log.info("Sending sms with the details : " +
                    livreMsgDto.toString());
            return livreMsgDto.livreId();
        };
    }

}
