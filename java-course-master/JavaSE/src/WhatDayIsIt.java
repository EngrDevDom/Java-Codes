import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WhatDayIsIt {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        SimpleDateFormat sdate = new SimpleDateFormat("MMM dd, yyyy");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String data = br.readLine();
            int year = Integer.parseInt(data.split("-")[0]);
            int month = Integer.parseInt(data.split("-")[1])-1;
            int day = Integer.parseInt(data.split("-")[2]);
            Date date = new Calendar.Builder().setDate(year, month, day).build().getTime();
            System.out.println(sdate.format(date).toUpperCase());
        } catch (NumberFormatException | IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
