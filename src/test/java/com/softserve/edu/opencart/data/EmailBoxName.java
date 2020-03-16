package com.softserve.edu.opencart.data;

public enum EmailBoxName {
    INBOX("INBOX"),
    DRAFTS("DRAFTS"),
    SENT("SENT"),
    SPAM("SPAM"),
    TRASH("TRASH");

    private String name;

    private EmailBoxName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
