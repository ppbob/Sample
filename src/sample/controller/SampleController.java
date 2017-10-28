package sample.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sample.service.impl.SendSMSService;
import sample.vo.SmsVO;
@RestController
public class SampleController {
	@Autowired
	private SendSMSService sendSMSService;
	
    @RequestMapping(value="/sample")
    public Map<String,String> sample(@RequestParam(value="name", defaultValue="World") String name) {
    Map<String,String> result = new HashMap<>();
    result.put("message", String.format("Hello, %s", name));
    return result;
    }
    
    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> sendSMS(@RequestBody SmsVO smsVO) {
        Map<String,String> result = new HashMap<>();
        result.put("message", String.format("Message %s Sent!!!", sendSMSService.sendSMS(smsVO.getFrom(), smsVO.getTo(), smsVO.getBody())));
        return result;
    }
}