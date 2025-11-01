package com.schoolProject.domain.referFriend;


import com.schoolProject.domain.student.Student;

import java.time.LocalDateTime;

public class ReferAFriend {
    private Student referrer;
    private Student referee;
    private LocalDateTime dateRefer;

    public ReferAFriend (Student referrer, Student referee){
        this.referrer = referrer;
        this.referee = referee;
        this.dateRefer = LocalDateTime.now();
    }

    public Student getReferrer() {
        return referrer;
    }

    public Student getReferee() {
        return referee;
    }

    public LocalDateTime getDateRefer() {
        return dateRefer;
    }
}
