
package com.example.showinfor.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Photo")
    @Expose
    private String photo;
    @SerializedName("Finger")
    @Expose
    private String finger;
    @SerializedName("NameEn")
    @Expose
    private String nameEn;
    @SerializedName("NameVn")
    @Expose
    private String nameVn;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("Bod")
    @Expose
    private String bod;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("PaperType")
    @Expose
    private String paperType;
    @SerializedName("PassportNumber")
    @Expose
    private String passportNumber;
    @SerializedName("IssueDate")
    @Expose
    private String issueDate;
    @SerializedName("ExpireDate")
    @Expose
    private String expireDate;
    @SerializedName("Cccd")
    @Expose
    private String cccd;
    @SerializedName("Cmtc")
    @Expose
    private String cmtc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFinger() {
        return finger;
    }

    public void setFinger(String finger) {
        this.finger = finger;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameVn() {
        return nameVn;
    }

    public void setNameVn(String nameVn) {
        this.nameVn = nameVn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getCmtc() {
        return cmtc;
    }

    public void setCmtc(String cmtc) {
        this.cmtc = cmtc;
    }


}