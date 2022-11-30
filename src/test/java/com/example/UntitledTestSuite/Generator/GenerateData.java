package com.example.UntitledTestSuite.Generator;

import com.example.UntitledTestSuite.Model.ProfileData;
import com.example.UntitledTestSuite.Model.ProfileList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateData {
    public static void main(String[] args) {
        GenerateData generateData = new GenerateData();
        generateData.marshal(3);
    }

    public void marshal(int count) {
        List<ProfileData> profileDataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            profileDataList.add(new ProfileData(String.format("Новый текст %d", i)));
        }

        ProfileList profileList = new ProfileList();
        System.out.println(profileList.getProfileDataList());
        profileList.setProfileDataList(profileDataList);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ProfileList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(profileList, new File("./profiles.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
