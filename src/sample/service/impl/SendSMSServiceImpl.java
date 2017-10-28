package sample.service.impl;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SendSMSServiceImpl implements SendSMSService{
  public static final String ACCOUNT_SID = "AC83e24267d7533223dc56eda9d8333bca";
  public static final String AUTH_TOKEN = "2783793852b494aa4941fa1e3e7b0ea9";
  public static final String FROM_NUMBER = "+19098295141";
  public static final String TO_NUMBER = "+919505899648";

  public String sendSMS(String from, String to, String body) { 
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), body).create();
    System.out.println(message.getSid());
	return message.getSid();
  }
}
