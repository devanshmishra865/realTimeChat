package com.chatApp.app.repos;

import com.chatApp.app.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepo extends JpaRepository<ChatMessage,Long> {
}
