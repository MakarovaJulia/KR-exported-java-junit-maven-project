package com.example.UntitledTestSuite.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountsList {
    @XmlElement(name = "account")
    private List<AccountData> accountDataList;


    public AccountsList(List<AccountData> accountData) {
        this.accountDataList = accountData;
    }

    public List<AccountData> getAccountDataList() {
        return accountDataList;
    }

    public void setAccountDataList(List<AccountData> accountData) {
        this.accountDataList = accountData;
    }

    public AccountsList(){
    }
}
