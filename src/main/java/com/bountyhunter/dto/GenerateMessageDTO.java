package com.bountyhunter.dto;

public class GenerateMessageDTO {

    private String smsMessage;
    private String secretMessage;

    public String getSmsMessage() {return smsMessage;}

    public void setSmsMessage(String smsMessage) {this.smsMessage = smsMessage;}

    public String getSecretMessage() {return secretMessage;}

    public void setSecretMessage(String secretMessage) {this.secretMessage = secretMessage;}
}
