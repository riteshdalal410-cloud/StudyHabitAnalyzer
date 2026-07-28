package com.ritesh.studyhabitanalyzer.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ritesh.studyhabitanalyzer.model.StudySession;
import com.ritesh.studyhabitanalyzer.model.User;
import com.ritesh.studyhabitanalyzer.service.StudySessionService;

import jakarta.servlet.http.HttpSession;


@Controller
public class DashboardController {


    @Autowired
    private StudySessionService studySessionService;



    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {


        System.out.println("========== NEW DASHBOARD CONTROLLER LOADED ==========");


        User loggedUser = 
                (User) session.getAttribute("loggedUser");


        if(loggedUser == null){

            return "redirect:/login";

        }



        List<StudySession> sessions =
                studySessionService.getSessionsByUser(loggedUser);



        // ==========================
        // Dashboard Statistics
        // ==========================


        double totalHours =
                studySessionService.getTotalHours(loggedUser);



        int totalSubjects =
                studySessionService.getSubjectCount(loggedUser);



        int averageProductivity =
                studySessionService.getAverageProductivity(loggedUser);



        int currentStreak =
                studySessionService.getCurrentStreak(loggedUser);



        String bestSubject =
                studySessionService.getBestSubject(loggedUser);



        String weakestSubject =
                studySessionService.getWeakestSubject(loggedUser);





        System.out.println("USER ID : " + loggedUser.getId());

        System.out.println("TOTAL HOURS : " + totalHours);

        System.out.println("CURRENT STREAK : " + currentStreak);




        // ==========================
        // Goal Calculation
        // ==========================


        double goalHours = 6;


        double completedHours =
                totalHours;



        double remainingHours =
                Math.max(goalHours - completedHours,0);



        int goalPercentage =
                (int)((completedHours / goalHours)*100);



        if(goalPercentage > 100){

            goalPercentage = 100;

        }




        // ==========================
        // Weekly Chart Data
        // ==========================


        Map<String,Double> weeklyStudy =
                new LinkedHashMap<>();


        for(StudySession s : sessions){

            String date =
                    s.getStudyDate().toString();


            weeklyStudy.put(
                    date,
                    s.getHours()
            );

        }




        // ==========================
        // AI Recommendation
        // ==========================


        String aiRecommendation;


        if(averageProductivity >= 90){

            aiRecommendation =
                    "Excellent! Maintain your study consistency.";

        }
        else if(averageProductivity >=75){

            aiRecommendation =
                    "Good progress. Try increasing focus time.";

        }
        else{

            aiRecommendation =
                    "Improve consistency and avoid distractions.";

        }




        // ==========================
        // Send Data To Dashboard
        // ==========================


        model.addAttribute(
                "loggedUser",
                loggedUser
        );


        model.addAttribute(
                "sessions",
                sessions
        );


        model.addAttribute(
                "totalHours",
                totalHours
        );


        model.addAttribute(
                "totalSubjects",
                totalSubjects
        );


        model.addAttribute(
                "averageProductivity",
                averageProductivity
        );


        model.addAttribute(
                "currentStreak",
                currentStreak
        );


        model.addAttribute(
                "bestSubject",
                bestSubject
        );


        model.addAttribute(
                "weakestSubject",
                weakestSubject
        );


        model.addAttribute(
                "weeklyStudy",
                weeklyStudy
        );


        model.addAttribute(
                "goalPercentage",
                goalPercentage
        );


        model.addAttribute(
                "completedHours",
                completedHours
        );


        model.addAttribute(
                "remainingHours",
                remainingHours
        );


        model.addAttribute(
                "aiRecommendation",
                aiRecommendation
        );



        return "dashboard";

    }

}