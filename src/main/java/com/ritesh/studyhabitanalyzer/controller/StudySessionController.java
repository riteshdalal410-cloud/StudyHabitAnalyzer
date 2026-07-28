package com.ritesh.studyhabitanalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ritesh.studyhabitanalyzer.model.StudySession;
import com.ritesh.studyhabitanalyzer.model.User;
import com.ritesh.studyhabitanalyzer.service.StudySessionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/study")
public class StudySessionController {

    @Autowired
    private StudySessionService studySessionService;

    // ==========================
    // Show Add Study Session Page
    // ==========================

    @GetMapping("/add")
    public String showAddSessionPage(Model model) {

        model.addAttribute("studySession", new StudySession());

        return "add-session";
    }

    // ==========================
    // Save Study Session
    // ==========================

    @PostMapping("/save")
    public String saveStudySession(
            @ModelAttribute StudySession studySession,
            HttpSession session) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        studySession.setUser(loggedUser);

        studySessionService.saveStudySession(studySession);

        return "redirect:/dashboard";
    }

}