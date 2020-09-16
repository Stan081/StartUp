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
public class Guardians {
     private String pFirstName;
     private String pOtherNames ;
     private String PNationality;
     private String PstateOfOrigin;
     private String pLga;
     private String pSex;
     private String occupation ;
     private String email;
     private String religion;
     private String guardianPhone;
     private String rAddress;
     private String oAddress;

    public Guardians(String pFirstName, String pOtherNames, String PNationality, String PstateOfOrigin, String pLga, String pSex, String occupation, String email, String religion, String guardianPhone, String rAddress, String oAddress) {
        this.pFirstName = pFirstName;
        this.pOtherNames = pOtherNames;
        this.PNationality = PNationality;
        this.PstateOfOrigin = PstateOfOrigin;
        this.pLga = pLga;
        this.pSex = pSex;
        this.occupation = occupation;
        this.email = email;
        this.religion = religion;
        this.guardianPhone = guardianPhone;
        this.rAddress = rAddress;
        this.oAddress = oAddress;
    }

    public String getpFirstName() {
        return pFirstName;
    }

    public void setpFirstName(String pFirstName) {
        this.pFirstName = pFirstName;
    }

    public String getpOtherNames() {
        return pOtherNames;
    }

    public void setpOtherNames(String pOtherNames) {
        this.pOtherNames = pOtherNames;
    }

    public String getPNationality() {
        return PNationality;
    }

    public void setPNationality(String PNationality) {
        this.PNationality = PNationality;
    }

    public String getPstateOfOrigin() {
        return PstateOfOrigin;
    }

    public void setPstateOfOrigin(String PstateOfOrigin) {
        this.PstateOfOrigin = PstateOfOrigin;
    }

    public String getpLga() {
        return pLga;
    }

    public void setpLga(String pLga) {
        this.pLga = pLga;
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
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

    @Override
    public String toString() {
        return "Guardians{" + "pFirstName=" + pFirstName + ", pOtherNames=" + pOtherNames + ", PNationality=" + PNationality + ", PstateOfOrigin=" + PstateOfOrigin + ", pLga=" + pLga + ", pSex=" + pSex + ", occupation=" + occupation + ", email=" + email + ", religion=" + religion + ", guardianPhone=" + guardianPhone + ", rAddress=" + rAddress + ", oAddress=" + oAddress + '}';
    }

    
}