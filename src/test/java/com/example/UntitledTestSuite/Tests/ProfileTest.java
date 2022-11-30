package com.example.UntitledTestSuite.Tests;

import com.example.UntitledTestSuite.AuthBase;
import com.example.UntitledTestSuite.Model.ProfileData;
import com.example.UntitledTestSuite.Model.ProfileList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.util.List;

@RunWith(Theories.class)
public class ProfileTest extends AuthBase {
    @Theory
    public void addProfile(ProfileData profileData) throws Exception {
        applicationManager.getNavigationHelper().OpenProfilePage();
        applicationManager.getProfileHelper().AddPost(profileData);
        Thread.sleep(3000);
        ProfileData newProfile = applicationManager.getProfileHelper().GetCreatedProfile();
        Assert.assertEquals(profileData.getProfileContent(), newProfile.getProfileContent());
    }


    @DataPoints
    public static List<ProfileData> getProfileList() throws Exception {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProfileList.class);
            ProfileList profileList = (ProfileList) jaxbContext.createUnmarshaller()
                    .unmarshal(new FileReader("./profiles.xml"));
            return profileList.getProfileDataList();
        } catch (JAXBException e){
            throw new RuntimeException();
        }
    }

    @Test
    public void changePost() throws Exception {
        ProfileData profileData = new ProfileData("hello");
        applicationManager.getNavigationHelper().OpenProfilePage();
        Thread.sleep(3000);
        applicationManager.getProfileHelper().ChangePost(profileData);
        Thread.sleep(5000);
        ProfileData newProfile = applicationManager.getProfileHelper().GetCreatedProfile();
        Assert.assertEquals(profileData.getProfileContent(), newProfile.getProfileContent());
    }
}
