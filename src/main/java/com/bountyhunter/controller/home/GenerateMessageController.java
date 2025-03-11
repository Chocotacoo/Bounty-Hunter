package com.bountyhunter.controller.home;

import com.bountyhunter.dto.GenerateMessageDTO;
import com.bountyhunter.service.GenerateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/bountyhunter/generatemessage")
public class GenerateMessageController {

    @Autowired
    GenerateMessageService generateMessageService;

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> generateMessage(@RequestBody GenerateMessageDTO generateMessage) {
        Map<String, Object> response = new HashMap<>();

        String carrierText = generateMessage.getSmsMessage();
        String secretMessage = generateMessage.getSecretMessage();

        String encodedText = generateMessageService.encode(carrierText, secretMessage);
        System.out.println("Encoded Text: " + encodedText);

        String decodedMessage = generateMessageService.decode(encodedText);
        System.out.println("Decoded Message: " + decodedMessage);

        response.put("message", "Message Generation Successfully.");

        return ResponseEntity.ok(response);
    }

}
