package com.example.lenovo.testfirebase;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by lenovo on 12/17/2017.
 */

public class Example {

    private String nameText;
    private String idText;
    private String phoneText;
    private String emailText;

    public Example() {
    }

    public Example(String nameText, String idText, String phoneText, String emailText) {
        this.nameText = nameText;
        this.idText = idText;
        this.phoneText = phoneText;
        this.emailText = emailText;
    }

    public String getNameText() {
        return nameText;
    }

    public String getIdText() {
        return idText;
    }

    public String getPhoneText() {
        return phoneText;
    }

    public String getEmailText() {
        return emailText;
    }
}
