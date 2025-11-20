package com.schoolProject.infra.referral;

import com.schoolProject.application.referral.SendReferralEmail;
import com.schoolProject.domain.student.Student;

public class SendReferralEmailWithJavaMail implements SendReferralEmail {

    @Override
    public void sendTo(Student refereeStudent) {
        //implements java Mail Lib to test
    }
}
