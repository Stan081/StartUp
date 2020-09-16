/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyed;

/**
 *
 * @author Stan
 */
public class Students {
    private String id;
    private String firstName;
    private String otherNames;
    private String dateOfBirth;
    private String sex;
    private String nationality;
    private String stateOfOrigin;
    private String lga;
    private String dateOfAdmis;
    private String pClass;
    private String pSchool;
    private String disability;
    private String guardianPhone;

    public Students(String id, String firstName, String otherNames, String dateOfBirth, String sex, String nationality, String stateOfOrigin, String lga, String dateOfAdmis, String pClass, String pSchool, String disability, String guardianPhone) {
        this.id = id;
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.stateOfOrigin = stateOfOrigin;
        this.lga = lga;
        this.dateOfAdmis = dateOfAdmis;
        this.pClass = pClass;
        this.pSchool = pSchool;
        this.disability = disability;
        this.guardianPhone = guardianPhone;
    }

    public Students(String id, String firstName, String otherNames, String dateOfBirth, String sex, String guardianPhone) {
        this.id = id;
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.guardianPhone = guardianPhone;
    }

    public Students(String firstName, String otherNames, String dateOfBirth, String sex, String nationality, String stateOfOrigin, String lga, String dateOfAdmis, String pClass, String pSchool, String disability, String guardianPhone) {
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.stateOfOrigin = stateOfOrigin;
        this.lga = lga;
        this.dateOfAdmis = dateOfAdmis;
        this.pClass = pClass;
        this.pSchool = pSchool;
        this.disability = disability;
        this.guardianPhone = guardianPhone;
    }

    public Students(String id) {
        this.id = id;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfAdmis() {
        return dateOfAdmis;
    }

    public void setDateOfAdmis(String dateOfAdmis) {
        this.dateOfAdmis = dateOfAdmis;
    }

    public String getpClass() {
        return pClass;
    }

    public void setpClass(String pClass) {
        this.pClass = pClass;
    }

    public String getpSchool() {
        return pSchool;
    }

    public void setpSchool(String pSchool) {
        this.pSchool = pSchool;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    @Override
    public String toString() {
        return "Students{" + "id=" + id + ", firstName=" + firstName + ", otherNames=" + otherNames + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", nationality=" + nationality + ", stateOfOrigin=" + stateOfOrigin + ", lga=" + lga + ", dateOfAdmis=" + dateOfAdmis + ", pClass=" + pClass + ", pSchool=" + pSchool + ", disability=" + disability + ", guardianPhone=" + guardianPhone + '}';
    }

   
  
    
    
}
