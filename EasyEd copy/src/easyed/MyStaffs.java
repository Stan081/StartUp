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
public class MyStaffs {
    private String id;
    private String firstName;
    private String otherNames;
    private String dateOfBirth;
    private String sex;
    private String nationality;
    private String stateOfOrigin;
    private String lga;
    private String qualification;
    private String dateOfEmp;
    private String resAddress;
    private String oAddress;
    private String maritalStatus;
    private String email;
    private String Phone;
    private String role;
    private String Religion;

    public MyStaffs() {
    }

    public MyStaffs(String firstName, String otherNames, String dateOfBirth, String sex, String nationality, String stateOfOrigin, String lga, String qualification, String dateOfEmp, String resAddress, String oAddress, String maritalStatus, String email, String Phone, String role, String Religion) {
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.stateOfOrigin = stateOfOrigin;
        this.lga = lga;
        this.qualification = qualification;
        this.dateOfEmp = dateOfEmp;
        this.resAddress = resAddress;
        this.oAddress = oAddress;
        this.maritalStatus = maritalStatus;
        this.email = email;
        this.Phone = Phone;
        this.role = role;
        this.Religion = Religion;
    }

    public MyStaffs(String id, String firstName, String otherNames, String dateOfBirth, String sex, String Phone) {
        this.id = id;
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.Phone = Phone;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDateOfEmp() {
        return dateOfEmp;
    }

    public void setDateOfEmp(String dateOfEmp) {
        this.dateOfEmp = dateOfEmp;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String Religion) {
        this.Religion = Religion;
    }

    @Override
    public String toString() {
        return "MyStaffs{" + "id=" + id + ", firstName=" + firstName + ", otherNames=" + otherNames + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", nationality=" + nationality + ", stateOfOrigin=" + stateOfOrigin + ", lga=" + lga + ", qualification=" + qualification + ", dateOfEmp=" + dateOfEmp + ", resAddress=" + resAddress + ", oAddress=" + oAddress + ", maritalStatus=" + maritalStatus + ", email=" + email + ", Phone=" + Phone + ", role=" + role + ", Religion=" + Religion + '}';
    }

  
    
    
}
