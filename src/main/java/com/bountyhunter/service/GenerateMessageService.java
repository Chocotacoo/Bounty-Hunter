package com.bountyhunter.service;

import org.springframework.stereotype.Service;

@Service
public class GenerateMessageService {

    // Zero-width characters for encoding
    private static final char ZERO_WIDTH_SPACE = '\u200B';  // Represents '1'
    private static final char ZERO_WIDTH_NON_JOINER = '\u200C';  // Represents '0'

    // Encode text into carrier
    public String encode(String carrier, String secret) {
        StringBuilder binary = new StringBuilder();
        for (char c : secret.toCharArray()) {
            String bin = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'); // Convert char to 8-bit binary
            binary.append(bin);
        }

        StringBuilder encodedText = new StringBuilder(carrier);
        for (char bit : binary.toString().toCharArray()) {
            encodedText.append(bit == '1' ? ZERO_WIDTH_SPACE : ZERO_WIDTH_NON_JOINER);
        }
        return encodedText.toString();
    }

    // Decode text to retrieve the hidden message
    public String decode(String stegoText) {
        StringBuilder binary = new StringBuilder();
        for (char c : stegoText.toCharArray()) {
            if (c == ZERO_WIDTH_SPACE) binary.append('1');
            else if (c == ZERO_WIDTH_NON_JOINER) binary.append('0');
        }

        StringBuilder message = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String byteString = binary.substring(i, Math.min(i + 8, binary.length()));
            char decodedChar = (char) Integer.parseInt(byteString, 2);
            message.append(decodedChar);
        }
        return message.toString();
    }
}
