package com.ritesh.studyhabitanalyzer.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritesh.studyhabitanalyzer.model.StudySession;
import com.ritesh.studyhabitanalyzer.model.User;
import com.ritesh.studyhabitanalyzer.repository.StudySessionRepository;

@Service
public class StudySessionService {

    @Autowired
    private StudySessionRepository studySessionRepository;

    // Save
    public void saveStudySession(StudySession session) {
        studySessionRepository.save(session);
    }

    // Get Sessions
    public List<StudySession> getSessionsByUser(User user) {
        return studySessionRepository.findByUser(user);
    }

    // Total Hours
    public double getTotalHours(User user) {
        return getSessionsByUser(user)
                .stream()
                .mapToDouble(StudySession::getHours)
                .sum();
    }

    // Subject Count
    public int getSubjectCount(User user) {
        return (int) getSessionsByUser(user)
                .stream()
                .map(StudySession::getSubject)
                .distinct()
                .count();
    }

    // Average Productivity
    public int getAverageProductivity(User user) {

        List<StudySession> sessions = getSessionsByUser(user);

        if (sessions.isEmpty())
            return 0;

        return (int) sessions.stream()
                .mapToInt(StudySession::getProductivity)
                .average()
                .orElse(0);
    }

    // Total Sessions
    public int getSessionCount(User user) {
        return getSessionsByUser(user).size();
    }

    // Best Subject
    public String getBestSubject(User user) {

        List<Object[]> result = studySessionRepository.getBestSubject(user);

        if (result.isEmpty())
            return "No Data";

        return result.get(0)[0].toString();
    }

    // Weakest Subject
    public String getWeakestSubject(User user) {

        List<Object[]> result = studySessionRepository.getWeakestSubject(user);

        if (result.isEmpty())
            return "No Data";

        return result.get(0)[0].toString();
    }

    // ==========================
    // CURRENT STREAK
    // ==========================

    public int getCurrentStreak(User user) {

        System.out.println("\n===============================");
        System.out.println("CURRENT STREAK DEBUG");
        System.out.println("===============================");

        List<StudySession> sessions = getSessionsByUser(user);

        System.out.println("Logged User ID : " + user.getId());
        System.out.println("Today's Date   : " + LocalDate.now());
        System.out.println("Session Count  : " + sessions.size());

        Set<LocalDate> studyDates = new HashSet<>();

        System.out.println("\n----- DATABASE RECORDS -----");

        for (StudySession s : sessions) {

            System.out.println(
                    "ID=" + s.getId()
                    + "  USER=" + s.getUser().getId()
                    + "  DATE=" + s.getStudyDate()
                    + "  SUBJECT=" + s.getSubject());

            if (s.getStudyDate() != null) {
                studyDates.add(s.getStudyDate());
            }
        }

        System.out.println("----------------------------");
        System.out.println("Unique Dates : " + studyDates);

        if (studyDates.isEmpty()) {
            return 0;
        }

        LocalDate checkDate = LocalDate.now();

        if (!studyDates.contains(checkDate)) {
            checkDate = checkDate.minusDays(1);
        }

        System.out.println("Starting Check From : " + checkDate);

        int streak = 0;

        while (studyDates.contains(checkDate)) {

            System.out.println("Found : " + checkDate);

            streak++;

            checkDate = checkDate.minusDays(1);
        }

        System.out.println("Stopped At : " + checkDate);
        System.out.println("FINAL STREAK = " + streak);
        System.out.println("===============================\n");

        return streak;
    }

}