package com.example.UntitledTestSuite.Model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "profiles")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileList {

    @XmlElement(name = "profile")
    private List<ProfileData> profileDataList;

    public ProfileList(List<ProfileData> profileDataList) {
        this.profileDataList = profileDataList;
    }

    public List<ProfileData> getProfileDataList() {
        return profileDataList;
    }

    public void setProfileDataList(List<ProfileData> profileDataList) {
        this.profileDataList = profileDataList;
    }

    public ProfileList(){
    }
}
