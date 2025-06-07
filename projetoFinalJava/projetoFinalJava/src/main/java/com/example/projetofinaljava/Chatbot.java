package com.example.projetofinaljava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chatbot {
    private GPTService gptService = new GPTService();
    private List<Map<String, String>> messages = new ArrayList<>();

    public Chatbot() {
        Map<String, String> systemMsg = new HashMap<>();
        systemMsg.put("role", "system");
        systemMsg.put("content", "You are a helpful, empathetic, and supportive psychologist assistant. Respond with care, encouragement, and practical advice.");
        messages.add(systemMsg);
    }

    public String getResponse(String input) {
        Map<String, String> userMsg = new HashMap<>();
        userMsg.put("role", "user");
        userMsg.put("content", input);
        messages.add(userMsg);
        String response = gptService.getGPTResponse(messages);
        Map<String, String> assistantMsg = new HashMap<>();
        assistantMsg.put("role", "assistant");
        assistantMsg.put("content", response);
        messages.add(assistantMsg);
        return response;
    }
}
