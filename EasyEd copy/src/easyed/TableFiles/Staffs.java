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
public class Staffs {
    private String firstName;
    private String otherNames;
    private String sex;
    private String nationality;
    private String stateOfOrigin;
    private String lga;
    private String religion;
    private String rAddress;
    private String email;
    private String Phone;
    private String salary;
    private String jobDescription;
    private String alloClass;
    private String dateOfEmployment;

    public Staffs(String firstName, String otherNames, String sex, String nationality, String stateOfOrigin, String lga, String religion, String rAddress, String email, String Phone, String salary, String jobDescription, String alloClass, String dateOfEmployment) {
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.sex = sex;
        this.nationality = nationality;
        this.stateOfOrigin = stateOfOrigin;
        this.lga = lga;
        this.religion = religion;
        this.rAddress = rAddress;
        this.email = email;
        this.Phone = Phone;
        this.salary = salary;
        this.jobDescription = jobDescription;
        this.alloClass = alloClass;
        this.dateOfEmployment = dateOfEmployment;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getAlloClass() {
        return alloClass;
    }

    public void setAlloClass(String alloClass) {
        this.alloClass = alloClass;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Staffs{" + "firstName=" + firstName + ", otherNames=" + otherNames + ", sex=" + sex + ", nationality=" + nationality + ", stateOfOrigin=" + stateOfOrigin + ", lga=" + lga + ", religion=" + religion + ", rAddress=" + rAddress + ", email=" + email + ", Phone=" + Phone + ", salary=" + salary + ", jobDescription=" + jobDescription + ", alloClass=" + alloClass + ", dateOfEmployment=" + dateOfEmployment + '}';
    }
    
    
    
}
