import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // database of doctors

        ArrayList<HashMap<String, Object>> database = new ArrayList<>();

        HashMap<String, Object> doctor1 = new HashMap<>();
        doctor1.put("name", "John Smith");
        doctor1.put("specialty", "Cardiology");
        doctor1.put("symptoms", "Chest pain");
        doctor1.put("gender", "Male");
        doctor1.put("min_age", 30);
        doctor1.put("max_age", 60);
        doctor1.put("location", "123 Main St.");
        doctor1.put("phone", "555-1234");
        doctor1.put("rating", 4.5);
        database.add(doctor1);

        HashMap<String, Object> doctor2 = new HashMap<>();
        doctor2.put("name", "Jane Doe");
        doctor2.put("specialty", "Dermatology");
        doctor2.put("symptoms", "Acne");
        doctor2.put("gender", "Female");
        doctor2.put("min_age", 18);
        doctor2.put("max_age", 50);
        doctor2.put("location", "456 Oak Ave.");
        doctor2.put("phone", "555-5678");
        doctor2.put("rating", 4.2);
        database.add(doctor2);

        HashMap<String, Object> doctor3 = new HashMap<>();
        doctor3.put("name", "Robert Johnson");
        doctor3.put("specialty", "Orthopedics");
        doctor3.put("symptoms", "Joint pain");
        doctor3.put("gender", "Male");
        doctor3.put("min_age", 40);
        doctor3.put("max_age", 70);
        doctor3.put("location", "789 Elm St.");
        doctor3.put("phone", "555-9012");
        doctor3.put("rating", 4.8);
        database.add(doctor3);

        HashMap<String, Object> doctor4 = new HashMap<>();
        doctor4.put("name", "Sara Lee");
        doctor4.put("specialty", "Gynecology");
        doctor4.put("symptoms", "Irregular menstruation");
        doctor4.put("gender", "Female");
        doctor4.put("min_age", 18);
        doctor4.put("max_age", 45);
        doctor4.put("location", "246 Elm St.");
        doctor4.put("phone", "555-3456");
        doctor4.put("rating", 4.6);
        database.add(doctor4);

        HashMap<String, Object> doctor5 = new HashMap<>();
        doctor5.put("name", "David Kim");
        doctor5.put("specialty", "Ophthalmology");
        doctor5.put("symptoms", "Blurry vision");
        doctor5.put("gender", "Male");
        doctor5.put("min_age", 25);
        doctor5.put("max_age", 60);
        doctor5.put("location", "789 Oak Ave.");
        doctor5.put("phone", "555-7890");
        doctor5.put("rating", 4.4);
        database.add(doctor5);

        HashMap<String, Object> doctor6 = new HashMap<>();
        doctor6.put("name", "Emily Chen");
        doctor6.put("specialty", "Pediatrics");
        doctor6.put("symptoms", "Fever");
        doctor6.put("gender", "Female");
        doctor6.put("min_age", 0);
        doctor6.put("max_age", 18);
        doctor6.put("location", "246 Main St.");
        doctor6.put("phone", "555-2345");
        doctor6.put("rating", 4.7);
        database.add(doctor6);

        HashMap<String, Object> doctor7 = new HashMap<>();
        doctor7.put("name", "William Lee");
        doctor7.put("specialty", "Neurology");
        doctor7.put("symptoms", "Migraine");
        doctor7.put("gender", "Male");
        doctor7.put("min_age", 18);
        doctor7.put("max_age", 65);
        doctor7.put("location", "567 Pine St.");
        doctor7.put("phone", "555-6789");
        doctor7.put("rating", 4.9);
        database.add(doctor7);

        String symptoms = "Fever";
        String gender = "Female";
        int age = 15;


        recommend_doctor(symptoms, gender, age, database);

    }

    public static void recommend_doctor(String symptoms, String gender, int age, ArrayList<HashMap<String, Object>> database) {
        ArrayList<HashMap<String, Object>> toRemove = new ArrayList<>();

        for (HashMap<String, Object> doctor : database) {
            String docSymptoms = (String) doctor.get("symptoms");
            String docGender = (String) doctor.get("gender");
            int docMinAge = (int) doctor.get("min_age");
            int docMaxAge = (int) doctor.get("max_age");
            if (!docSymptoms.equals(symptoms) || !docGender.equals(gender) || age < docMinAge || age > docMaxAge) {
                toRemove.add(doctor);
            }
        }

        database.removeAll(toRemove);

        if (database.size() == 1) {
            HashMap<String, Object> doctor = database.get(0);
            String name = (String) doctor.get("name");
            String phone = (String) doctor.get("phone");
            System.out.println("Based on your preferences, we recommend Dr. " + name + ". You can book an appointment with him/her at " + phone + ".");
        } else if (database.isEmpty()) {
            System.out.println("Sorry, we couldn't find any doctors that match your requirements. Please try again with different preferences.");
        }
    }

}


