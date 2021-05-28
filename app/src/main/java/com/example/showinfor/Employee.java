
package com.example.showinfor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("Photo")
    @Expose
    private String Photo;
    @SerializedName("Finger")
    @Expose
    private String Finger;
    @SerializedName("NameEn")
    @Expose
    private String NameEn;
    @SerializedName("NameVn")
    @Expose
    private String NameVn;
    @SerializedName("Gender")
    @Expose
    private String Gender;
    @SerializedName("Bod")
    @Expose
    private String Bod;
    @SerializedName("Country")
    @Expose
    private String Country;
    @SerializedName("Address")
    @Expose
    private String Address;
    @SerializedName("PaperType")
    @Expose
    private String PaperType;
    @SerializedName("PassportNumber")
    @Expose
    private String PassportNumber;
    @SerializedName("IssueDate")
    @Expose
    private String IssueDate;
    @SerializedName("ExpireDate")
    @Expose
    private String ExpireDate;
    @SerializedName("Cccd")
    @Expose
    private String Cccd;
    @SerializedName("Cmtc")
    @Expose
    private String Cmtc;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getFinger() {
        return Finger;
    }

    public void setFinger(String finger) {
        Finger = finger;
    }

    public String getNameEn() {
        return NameEn;
    }

    public void setNameEn(String nameEn) {
        NameEn = nameEn;
    }

    public String getNameVn() {
        return NameVn;
    }

    public void setNameVn(String nameVn) {
        NameVn = nameVn;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getBod() {
        return Bod;
    }

    public void setBod(String bod) {
        Bod = bod;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPaperType() {
        return PaperType;
    }

    public void setPaperType(String paperType) {
        PaperType = paperType;
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }

    public String getCccd() {
        return Cccd;
    }

    public void setCccd(String cccd) {
        Cccd = cccd;
    }

    public String getCmtc() {
        return Cmtc;
    }

    public void setCmtc(String cmtc) {
        Cmtc = cmtc;
    }
}