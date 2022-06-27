package me.java8.section2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

public class DateTimeApp {
    public static void main(String[] args) {

        //기계적인 시간을 표현
        Instant instant = Instant.now();
        System.out.println(instant); //기준시 UTC, GMT

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        //일반적인 시간을 표현
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); //시스템의 ZONE 정보를 참고하여 반영

        //특정 Zone 의 시간
        ZonedDateTime nowInSeoul = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInSeoul);

        //Period 예시
        LocalDate today = LocalDate.now();
        LocalDate endOfYear = LocalDate.of(2022, Month.DECEMBER, 31);

        Period period = Period.between(today, endOfYear);
        System.out.println(period.getDays());

        Period until = today.until(endOfYear);
        System.out.println(until.get(ChronoUnit.DAYS));

        //전체 일수 차이를 구하려면 다음과 같음
//        long between = ChronoUnit.DAYS.between(today, endOfYear);
//        System.out.println(between);

        //format
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분");
        System.out.println(now.format(dtf));

        //parse
        LocalDate parse = LocalDate.parse("2023년 04월 12일 09시 20분", dtf);
        System.out.println(parse);
    }
}
