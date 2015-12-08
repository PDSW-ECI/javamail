package br.com.thiaguten.javamail.core;

public interface Email {

    String getFrom();

    String getTo();

    String getCc();

    String getBcc();

    String getSubject();

    String getMessage();

}
