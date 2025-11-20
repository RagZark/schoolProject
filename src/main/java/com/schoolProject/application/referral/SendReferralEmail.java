package com.schoolProject.application.referral;

import com.schoolProject.domain.student.Student;

public interface SendReferralEmail {
    void sendTo(Student refereeStudent);
}
