package az.suzy.simulation.api.service;

import az.suzy.simulation.api.internal.SimulateData;
import az.suzy.simulation.api.internal.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Service {

    public ResponseEntity<List<User>> getAnswer(SimulateData simulateData) {
        int count = 0;
        for (User user : simulateData.getUsers()){
            count++;
            if(count==4){
                user.setIsAccept(0);
                count=0;
            }else{
                user.setIsAccept(1);
            }
            switch (simulateData.getSendWay()){
                case 1 : sms(simulateData.getMessage());break;
                case 2 : mail(simulateData.getMessage());break;
                default:break;
            }
        }

        return new ResponseEntity<>(simulateData.getUsers(), HttpStatus.OK);
    }

    private void sms(String message){
        log.info("data sent with sms...\n*************\nmessage:{}",message);

    }

    private void mail(String message){
        log.info("data sent with mail\n*************\nmessage:{}",message);

    }


}
