package com.bookStore.service;

import com.bookStore.entity.EmailDetails;

public interface IemailService {

	// Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);

}
