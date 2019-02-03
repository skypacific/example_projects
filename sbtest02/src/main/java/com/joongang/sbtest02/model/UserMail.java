package com.joongang.sbtest02.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserMail {
    String id;
    String parentFolderId;
    Date dateTimeReceived;
    Date dateTimeSent;
    int size;
    String itemClass;
    String subject;
}
