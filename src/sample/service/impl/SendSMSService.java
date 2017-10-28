package sample.service.impl;

public interface SendSMSService {
	String sendSMS(String from, String to, String body);
}
