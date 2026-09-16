package com.chatApp.app.controller;

import com.chatApp.app.model.ChatMessage;
import com.chatApp.app.repos.ChatMessageRepo;
import lombok.Getter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChatController {

    private final ChatMessageRepo chatMessageRepo;

    public ChatController(ChatMessageRepo chatMessageRepo) {
        this.chatMessageRepo = chatMessageRepo;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    //now we have to handle the message and add some more annotation.
    @MessageMapping("/sendMessage")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(ChatMessage message) {

        // Save message to MySQL
        chatMessageRepo.save(message);

        // Send message to all connected users
        return message;
    }


    // Get all previous messages
    @GetMapping("/messages")
    @ResponseBody
    public List<ChatMessage> getMessages() {

        return chatMessageRepo.findAll();
    }
}
