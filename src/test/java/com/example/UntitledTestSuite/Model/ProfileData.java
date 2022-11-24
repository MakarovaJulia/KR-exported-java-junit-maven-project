package com.example.UntitledTestSuite.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileData {
    @XmlElement(name = "text", required = true)
    private String profileContent;

    public ProfileData(String profileContent) {
        this.profileContent = profileContent;
    }

    public String getProfileContent() {
        return profileContent;
    }

    public void setProfileContent(String profileContent) {
        this.profileContent = profileContent;
    }

    public ProfileData(){

    }
}
