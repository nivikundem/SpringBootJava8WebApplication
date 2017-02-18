package com.vehicle.org.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JmsClientServiceImpl implements JmsClientService {
	
	
    @Autowired
    JmsProducer jmsProducer;
     
    @Override
    public void send(String msg) {
        jmsProducer.send(msg);
    }
 
   
}
