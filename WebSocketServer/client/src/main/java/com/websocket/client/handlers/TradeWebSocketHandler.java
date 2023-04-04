package com.websocket.client.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.client.model.Stock;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class TradeWebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    Random r = new Random();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        float oldPrice = 0.0f;
        for (int i=0; i < 100; i ++){
            float stockPrice = 12 + r.nextFloat() * (13 - 12);
            float roundedPrice = (float) (Math.round(stockPrice * 100.0) / 100.0);
            Stock stock = new Stock("Amazon",
                    "https://cdn.cdnlogo.com/logos/a/77/amazon-dark.svg",
                    roundedPrice);
            if (roundedPrice > oldPrice){
                stock.setIncreased(true);
            }
            oldPrice = roundedPrice;
            TextMessage message = new TextMessage(objectMapper.writeValueAsString(stock));
            session.sendMessage(message);
            Thread.sleep(3000);
        }
        sessions.add(session);
    }



    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    }

}
