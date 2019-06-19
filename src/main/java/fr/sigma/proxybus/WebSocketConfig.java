package fr.sigma.proxybus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${rabbit.hostname}")
    String hostname;

    @Value("${rabbit.port}")
    int port;

    @Value("${rabbit.username}")
    String username;

    @Value("${rabbit.password}")
    String password;

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.setApplicationDestinationPrefixes("/app");
//        config.enableStompBrokerRelay("/queue", "/topic", "/exchange", "/amq/queue", "/")
//        .setRelayHost(hostname)
//        .setRelayPort(port)
//        .setClientLogin(username).setClientPasscode(password)
//        .setSystemLogin(username)
//        .setSystemPasscode(password);
//
//    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/queue");

    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/notifications-real-time").setAllowedOrigins("*").withSockJS();
    }

}