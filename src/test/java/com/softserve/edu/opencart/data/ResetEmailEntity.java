package com.softserve.edu.opencart.data;

public class ResetEmailEntity {
    private String subject;
    private String bodyLinkPart;

    public ResetEmailEntity(String subject, String bodyLinkPart) {
        this.subject = subject;
        this.bodyLinkPart = bodyLinkPart;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBodyLinkPart() {
        return bodyLinkPart;
    }

    public void setBodyLinkDomain(String bodyLinkPart) {
        this.bodyLinkPart = bodyLinkPart;
    }
}
