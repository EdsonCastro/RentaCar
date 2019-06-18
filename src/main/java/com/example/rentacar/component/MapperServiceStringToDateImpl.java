package com.example.rentacar.component;



import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class MapperServiceStringToDateImpl {

    public LocalDateTime  map(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate dateTime = LocalDate.parse(dateString,formatter);
        LocalDateTime ldt = LocalDateTime.of(dateTime, LocalTime.of(0,0));
        return ldt;
    }


}
