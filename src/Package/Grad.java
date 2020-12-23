package Package;

import java.util.ArrayList;


   public class Grad {
       private String firstName;
       private String lastName;
       private String id;
       private char[] otp;
       private char[] password;
       private ArrayList<String> resume;
       private String linkedinPage;
       private String jobSearchStatus;
       private boolean openForJobOffer;

       //Constructors
       public Grad() {

       }

       public Grad(String firstName, String lastName, String firstCourse) {
           this.firstName = firstName;
           this.lastName = lastName;
           resume = new ArrayList<>();
           resume.add(firstCourse);
           linkedinPage = "";
           jobSearchStatus = "";
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

       public char[] getOtp() {
           return otp;
       }
       public void setOtp(char[] otp) {
           this.otp = otp;
       }
       public char[] getPassword() {
           return password;
       }

       public void setPassword(char[] password) {
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
           this.jobSearchStatus = jobSearchStatus;
       }

       public boolean isOpenForJobOffer() {
           return openForJobOffer;
       }

       public void setOpenForJobOffer(boolean openForJobOffer) {
           this.openForJobOffer = openForJobOffer;
       }



       @Override
       public String toString() {
           return
                   "First name: " + firstName + '\n' +
                   "Last Name: " + lastName + '\n' +
                   "Resume: " + resume + '\n' +
                   "LinkedIn Page: " + linkedinPage + '\n' +
                   "Job search status: " + jobSearchStatus;

       }
   }



