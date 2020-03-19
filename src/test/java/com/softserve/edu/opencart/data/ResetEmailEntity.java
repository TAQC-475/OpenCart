package com.softserve.edu.opencart.data;

public class ResetEmailEntity {
    private String subject;
    private String bodyLinkDomain;

    public ResetEmailEntity(String subject, String bodyLinkDomain) {
        this.subject = subject;
        this.bodyLinkDomain = bodyLinkDomain;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBodyLinkDomain() {
        return bodyLinkDomain;
    }

    public void setBodyLinkDomain(String bodyLinkDomain) {
        this.bodyLinkDomain = bodyLinkDomain;
    }
}
