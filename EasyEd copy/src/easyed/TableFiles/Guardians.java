/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed.TableFiles;

/**
 *
 * @author Stan
 */
public class Guardians {
    private String firstName;
    private String otherNames;
    private String occupation;
    private String sex;
    private String nationality;
    private String stateOfOrigin;
    private String lga;
    private String religion;
    private String rAddress;
    private String oAddress;
    private String Phone;

    public Guardians(String firstName, String otherNames, String occupation, String sex, String nationality, String stateOfOrigin, String lga, String religion, String rAddress, String oAddress, String Phone) {
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.occupation = occupation;
        this.sex = sex;
        this.nationality = nationality;
        this.stateOfOrigin = stateOfOrigin;
        this.lga = lga;
        this.religion = religion;
        this.rAddress = rAddress;
        this.oAddress = oAddress;
        this.Phone = Phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getrAddress() {
        return rAddress;
    }

    public void setrAddress(String rAddress) {
        this.rAddress = rAddress;
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Guardians{" + "firstName=" + firstName + ", otherNames=" + otherNames + ", occupation=" + occupation + ", sex=" + sex + ", nationality=" + nationality + ", stateOfOrigin=" + stateOfOrigin + ", lga=" + lga + ", religion=" + religion + ", rAddress=" + rAddress + ", oAddress=" + oAddress + ", Phone=" + Phone + '}';
    }
    
    
    
}
