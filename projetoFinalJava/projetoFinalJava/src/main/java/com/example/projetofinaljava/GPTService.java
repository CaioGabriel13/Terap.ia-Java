package com.example.projetofinaljava;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GPTService {
    private static final String API_KEY = "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"; // Replace with your key
    private static final String ENDPOINT = "https://api.openai.com/v1/chat/completions";

    public String getGPTResponse(List<Map<String, String>> messages) {
        try {
            URL url = new URL(ENDPOINT);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setDoOutput(true);

            StringBuilder messagesJson = new StringBuilder("[");
            for (int i = 0; i < messages.size(); i++) {
                Map<String, String> msg = messages.get(i);
                messagesJson.append("{\"role\": \"")
                    .append(msg.get("role")).append("\", \"content\": \"")
                    .append(msg.get("content").replace("\"", "\\\"")).append("\"}");
                if (i < messages.size() - 1) messagesJson.append(",");
            }
            messagesJson.append("]");

            String body = "{" +
                "\"model\": \"gpt-3.5-turbo\"," +
                "\"messages\": " + messagesJson.toString() +
                "}";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(body.getBytes());
            }

            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            String resp = response.toString();
            int idx = resp.indexOf("\"content\":");
            if (idx != -1) {
                int start = resp.indexOf('"', idx + 11) + 1;
                int end = resp.indexOf('"', start);
                return resp.substring(start, end);
            }
            return "[Nenuhma resposta do GPT]";
        } catch (Exception e) {
            e.printStackTrace();
            return "[Erro conectando com a API do gpt]";
        }
    }
}