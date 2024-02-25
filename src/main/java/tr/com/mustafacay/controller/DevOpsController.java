package tr.com.mustafacay.controller;


import tr.com.mustafacay.dto.InfoResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

//   http://localhost:8080
@RestController
@RequestMapping
public class DevOpsController {


    //   http://localhost:8080
    @GetMapping
    public String devopsHello(){

        LocalDateTime myObj = LocalDateTime.now();
        System.out.println(myObj);
        return "DevOps Docker Hello: " + myObj;

    }

    //   http://localhost:8080/info
    @GetMapping("/info")
    public String devopsInfo(){

        LocalDateTime myObj = LocalDateTime.now();
        System.out.println(myObj);
        String hostName2="";
        String hostIp2="";
        try {
            hostName2 =InetAddress.getLocalHost().getCanonicalHostName()
            +" - "+        InetAddress.getLocalHost().getHostName();
            hostIp2 = new StringBuilder().append(InetAddress.getLocalHost().getHostAddress()).append(" - ").append(InetAddress.getLocalHost().getAddress()).toString();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return "DevOps Docker Info: "+
                " \nAd: "+System.getenv("USERNAME")+
                " \nSoyad: "+System.getenv("USERSURNAME")+
                " \nHost Name: "+hostName2+
                " \nHost IP: "+hostIp2+
                " \nDate Time: "+myObj;



    }
    @GetMapping("/status")
    public InfoResponseDTO devopsApiInfo(){
        InfoResponseDTO info=new InfoResponseDTO();
        LocalDateTime myObj = LocalDateTime.now();
        System.out.println(myObj);
        String hostName="";
        String hostIp="";
        try {
            hostName =InetAddress.getLocalHost().getCanonicalHostName()
                    +" - "+        InetAddress.getLocalHost().getHostName();
            hostIp = new StringBuilder().append(InetAddress.getLocalHost().getHostAddress()).append(" - ").append(InetAddress.getLocalHost().getAddress()).toString();

        } catch (UnknownHostException e) {

            throw new RuntimeException(e);
        }finally {
            info.setDateTime(myObj);
            info.setHostIp(hostIp);
            info.setHostName(hostName);
        }
        return info;
    }

}
