package fr.sigma.proxybus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class IndexController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/")
    public String hello() {
        String messsage = "hello";


        return messsage;
    }

    @RequestMapping("/stomppost")
    public String stomppost() throws ExecutionException, InterruptedException {
        String messsage = "ok";

        simpMessagingTemplate.convertAndSend("/queue/message", "hello");


        return messsage;
    }
}
