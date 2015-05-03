package br.com.thiaguten.javamail.core;

public interface Email {

    public String getFrom();

    public String getTo();

    public String getSubject();

    public String getMessage();

}
