package com.ritesh.studyhabitanalyzer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ritesh.studyhabitanalyzer.model.StudySession;
import com.ritesh.studyhabitanalyzer.model.User;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {


    // ==========================
    // All Sessions of User
    // Used for Dashboard + Streak Calculation
    // ==========================
    List<StudySession> findByUser(User user);



    // ==========================
    // Weekly Study Chart
    // ==========================
    @Query("""
            SELECT s.studyDate, SUM(s.hours)
            FROM StudySession s
            WHERE s.user = :user
            GROUP BY s.studyDate
            ORDER BY s.studyDate
            """)
    List<Object[]> getWeeklyStudyData(@Param("user") User user);



    // ==========================
    // Best Subject (Highest Hours)
    // ==========================
    @Query("""
            SELECT s.subject, SUM(s.hours)
            FROM StudySession s
            WHERE s.user = :user
            GROUP BY s.subject
            ORDER BY SUM(s.hours) DESC
            """)
    List<Object[]> getBestSubject(@Param("user") User user);



    // ==========================
    // Weakest Subject (Lowest Hours)
    // ==========================
    @Query("""
            SELECT s.subject, SUM(s.hours)
            FROM StudySession s
            WHERE s.user = :user
            GROUP BY s.subject
            ORDER BY SUM(s.hours) ASC
            """)
    List<Object[]> getWeakestSubject(@Param("user") User user);



    // ==========================
    // Subject Wise Study Hours
    // ==========================
    @Query("""
            SELECT s.subject, SUM(s.hours)
            FROM StudySession s
            WHERE s.user = :user
            GROUP BY s.subject
            ORDER BY SUM(s.hours) DESC
            """)
    List<Object[]> getSubjectWiseHours(@Param("user") User user);



    // ==========================
    // Average Productivity
    // ==========================
    @Query("""
            SELECT AVG(s.productivity)
            FROM StudySession s
            WHERE s.user = :user
            """)
    Double getAverageProductivity(@Param("user") User user);

}