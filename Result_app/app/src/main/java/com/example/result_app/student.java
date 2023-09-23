package com.example.result_app;

public class student {
    String RollNo,Name,Gender,CGPA,SGPA,Remarks,Supply;

    public student(String Name,String RollNo,String CGPA,String SGPA,String Gender,String Remarks,String Supply){
//        this.id=id;
//        this.Program=Program;
//        this.RegNo=RegNo;
        this.RollNo=RollNo;
        this.Name=Name;
        this.Gender=Gender;
        this.CGPA=CGPA;
        this.SGPA=SGPA;
        this.Remarks=Remarks;
        this.Supply=Supply;
    }
//    public String getId(){return id;}
//    public String getProgram(){return Program;}
//    public String getRegNo(){return RegNo;}
    public String getRollNo(){return RollNo;}
    public String getName(){return Name;}
    public String getGender(){return Gender;}
    public String getCGPA(){return CGPA;}
    public String getSGPA(){return SGPA;}
    public String getRemarks(){return Remarks;}
    public String getSupply(){return Supply;}
}
