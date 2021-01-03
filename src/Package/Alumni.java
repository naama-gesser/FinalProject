package Package;

import java.util.ArrayList;
import java.util.Collections;

public class Alumni {
    private String firstName;
    private String lastName;
    private String id;
    private String otp;
    private ArrayList<String> resume;
    private String password;
    String[] courses;
    private String linkedinPage;
    private String status;

    public Alumni(String firstName, String lastName, String[] courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
        resume = new ArrayList<>();
        Collections.addAll(resume, courses);
        linkedinPage = "";
        status = "";
    }

    //Getter and Setters


    public String getFirstName() {
        return firstName;
    }


    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOtp() {
        return otp;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getResume() {
        return resume;
    }

    public void setResume(String course) {
        if (!resume.contains(course)){
            resume.add(course);
        }
    }

    public void setLinkedinPage(String linkedinPage) {
        this.linkedinPage = linkedinPage;
    }

    public void setJobSearchStatus(String jobSearchStatus) {
        this.status = jobSearchStatus;
    }

    public String getJobSearchStatus() {

        return status;
    }




    @Override
    public String toString() {
        return
                "First name: " + firstName + '\n' +
                        "Last Name: " + lastName + '\n' +
                        "Resume: " + resume + '\n' +
                        "LinkedIn Page: " + linkedinPage + '\n' +
                        "Job search status: " + status;

    }
}
