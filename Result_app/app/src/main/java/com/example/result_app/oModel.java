package com.example.result_app;

public class oModel {
    private String Program,Reg_No,Roll_No,NAME,GEN,SGPA,CGPA,Remarks,Supple_in;

    public oModel( String roll_No, String NAME, String GEN, String SGPA, String CGPA, String remarks, String supple_in) {
        Roll_No = roll_No;
        this.NAME = NAME;
        this.GEN = GEN;
        this.SGPA = SGPA;
        this.CGPA = CGPA;
        Remarks = remarks;
        Supple_in = supple_in;
    }

    public oModel(){

    }

    public String getRoll_No() {
        return Roll_No;
    }

    public void setRoll_No(String roll_No) {
        Roll_No = roll_No;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getGEN() {
        return GEN;
    }

    public void setGEN(String GEN) {
        this.GEN = GEN;
    }

    public String getSGPA() {
        return SGPA;
    }

    public void setSGPA(String SGPA) {
        this.SGPA = SGPA;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getSupple_in() {
        return Supple_in;
    }

    public void setSupple_in(String supple_in) {
        Supple_in = supple_in;
    }
}
