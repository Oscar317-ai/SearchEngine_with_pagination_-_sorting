//package com.yesii.Biclats;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class DatabaseLoader {
//
//    @Autowired
//    private UserRepo repo;
//
//    @Bean
//    public CommandLineRunner dataInit(){
//        return args -> {
//
//            MyUser u0 = new MyUser();
//            MyUser u1 = new MyUser();
//            MyUser u2 = new MyUser();
//            MyUser u3 = new MyUser();
//            MyUser u4 = new MyUser();
//            MyUser u5 = new MyUser();
//            MyUser u6 = new MyUser();
//            MyUser u7 = new MyUser();
//            MyUser u8 = new MyUser();
//            MyUser u9 = new MyUser();
//            MyUser u10 = new MyUser();
//            MyUser u11= new MyUser();
//            MyUser u12= new MyUser();
//            MyUser u13= new MyUser();
//            MyUser u14= new MyUser();
//            MyUser u15= new MyUser();
//            MyUser u16= new MyUser();
//            MyUser u17= new MyUser();
//            MyUser u18= new MyUser();
//            MyUser u19= new MyUser();
//            MyUser u20= new MyUser();
//            MyUser u21= new MyUser();
//            MyUser u22= new MyUser();
//
//            repo.saveAll(List.of(u1,u2,u3));
//        };
//    }
//}


package com.yesii.Biclats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DatabaseLoader {

    @Autowired
    private UserRepo repo;

    @Bean
    public CommandLineRunner dataInit(){
        return args -> {
            List<MyUser> users = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < 23; i++) {
                String name = "User" + i;
                String email = "user" + i + "@example.com";
                MyUser user = new MyUser(name, email);
                users.add(user);
            }

            repo.saveAll(users);
        };
    }
}
