package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class dateTime {


    public static String setDate(){
    String date =  new SimpleDateFormat("dd MMMM yyyy").format(new Date());
    return date;
    }




}
