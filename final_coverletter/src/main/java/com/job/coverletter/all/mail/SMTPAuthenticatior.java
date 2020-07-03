package com.job.coverletter.all.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticatior extends Authenticator {

    @Override
       protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication("woguswldnjs@naver.com","SMTPtest");
       }
}

