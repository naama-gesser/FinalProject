package Package;

import java.util.*;

public class AlumniSystem {

    private Alumni alumni;
    static HashMap<String, Alumni> hmap = new HashMap<>();
    boolean loggedIn;
    private Set<String> jobRequirements = new HashSet<>();
    Scanner input = new Scanner(System.in);

    // registerNewGrad: creates new Grad object, creates id & temporary password and prints them, adds object to map
    public Alumni registerNewGrad(String firstName, String lastName, String[] completedCourses) {
        Alumni alumni =  new Alumni(firstName, lastName, completedCourses);
        String id = firstName + "." + lastName + ".she-codes";
        alumni.setId(id);
        alumni.setOtp(generateOtp());
        alumni.setPassword(alumni.getOtp());
        hmap.put(id, alumni);
        System.out.println("Alumni Id: " + id);
        System.out.print("Temporary Password: ");
        System.out.print(alumni.getOtp());
        System.out.println();

        return alumni;
    }

    //  Login
    public void sheCodesLogin() {
        System.out.println("\nWelcome to She-Codes Alumni System, please log in:");
        String id;
        String password;

        System.out.println("Alumni ID: ");
        id = input.next();

        while (!(hmap.containsKey(id))) {
            System.out.println("Alumni not found, please try again");
            id = input.next();
        }
        alumni = hmap.get(id);
        System.out.println("Password: ");
        password = input.next();

        while (!(password.equals(alumni.getPassword()) || password.equals(alumni.getOtp()))) {
            System.out.println("Wrong Password, please try again");
            password = input.next();
        }
        loggedIn = true;
        updateDetails();
    }

    // updateDetails (not in project instructions) after login, prints details + lets user update them
    public void updateDetails() {
        System.out.println("Hello, " + alumni.getFirstName() + "!");

        //first login- must change password
        if (alumni.getPassword().equals(alumni.getOtp())) {
            setNewPassword();
        }

        while (loggedIn) {
            int choice;

            System.out.println("\n" + alumni + "\n");

            if (shouldOfferJob(jobRequirements)) {
                System.out.println("You have a job offer! \n");
            }

            System.out.println("Update details: \n" +
                    "1. Change Password \n" +
                    "2. Add more courses to resume \n" +
                    "3. Update LinkedIn page \n" +
                    "4. Update job search status \n" +
                    "0. Log out \n");


            choice = input.nextInt();
            switch (choice) {
                case 1:
                    setNewPassword();
                    break;
                case 2:
                    String newCourse;
                    System.out.println("Enter the name of the course you want to add to your resume");
                    newCourse = input.next();
                    newCourse = newCourse.substring(0, 1).toUpperCase() + newCourse.substring(1); //makes sure course name is capitalised
                    if (!alumni.getResume().contains(newCourse)) {
                        alumni.setResume(newCourse);
                        System.out.println("Added " + newCourse + " to your resume");
                    } else {
                        System.out.println(newCourse + " is already in your resume");
                    }
                    break;
                case 3:
                    System.out.println("Enter your linkedIn page");
                    String linkedIn = input.next();
                    while (!(linkedIn.contains("linkedin.com"))) {  //make sure it's a linkedin page
                        System.out.println("Please make sure you enter a valid LinkedIn page");
                        linkedIn = input.next();
                    }
                    alumni.setLinkedinPage(linkedIn);
                    System.out.println("LinkedIn page updated");
                    break;
                case 4:
                    setJobStatus();
                    break;
                case 0:
                    System.out.println("Logging out");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Please choose one of the options");
            }
        }
    }

    // shouldOfferJob - returns true if the resume fits the requirements and the alumni is open for job offers, re-evaluates after details update
    public boolean shouldOfferJob(Set<String> jobRequirements) {
        return alumni.getResume().containsAll(jobRequirements) && (alumni.getJobSearchStatus().equals("not looking but open for suggestions")||alumni.getJobSearchStatus().equals("looking for a new challenge"));
    }



                                //Supporting Methods

    //creates random temporary password on registration
    public String generateOtp() {
        String otp;
        char[] otpArr = new char[8];
        String chars = "abcdefghijklmnopqrstuvwxyz";
        chars = chars + chars.toUpperCase() + "0123456789";
        int l = chars.length();

        for (int i = 0; i < otpArr.length; i++) {
            Random rnd = new Random();
            otpArr[i] = chars.charAt(rnd.nextInt(l));
        }
        otp = String.valueOf(otpArr);
        return otp;
    }


    //checks password is comprised of 8 alphanumerical character
    public boolean checkPassword(String password) {
        if (password.equals(alumni.getPassword()) || password.equals(alumni.getOtp())) {
            System.out.println("can't use current or temporary password");
            return false;
        }
        int alphanumerical = 0;
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Arrays.sort(chars);
        for (char p : password.toCharArray()) {             //counts the number of characters that are contained in chars (=are alphanumerical)
            if ((p >= 48 && p <= 57) || (p >= 65 && p <= 90) || (p >= 97 && p<= 122)) {
                alphanumerical++;
            }
        }
        if (alphanumerical == 8) {//if all 8 characters are alphanumerical
            return true;
        } else {
            System.out.println("Please make sure password is comprised of 8 alphanumerical characters");
            return false;
        }
    }

    //update password (after checking it)
    public void setNewPassword() {
        Scanner input = new Scanner(System.in);
        String newPassword;
        System.out.println("Please enter new password:");
        newPassword = input.next();
        while (!(checkPassword(newPassword))) {
            newPassword = input.next();
        }
        alumni.setPassword(newPassword);
        System.out.println("Password updated \n");
    }

    //lets user choose job search option and updates (boolean) whether she's open to job offers
    public void setJobStatus() {
        String a = "not looking for a change", b = "not looking but open for suggestions", c = "looking for a new challenge";
        System.out.println("Enter the number of the option most fitting your job status" + System.lineSeparator() +
                "1." + a + System.lineSeparator() +
                "2." + b + System.lineSeparator() +
                "3." + c);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                alumni.setJobSearchStatus(a);
                System.out.println("your job status was set to: " + a);
                break;
            case 2:
                alumni.setJobSearchStatus(b);
                System.out.println("your job status was set to: " + b);
                break;
            case 3:
                alumni.setJobSearchStatus(c);
                System.out.println("Job status was set to: " + c);
                break;
            default:
                System.out.println("Job status was not updated");
        }
    }

    //allows changing the job requirements from main for use in shouldOfferJob()
    public void setJobRequirements(String[] jobRequirements) {
        Collections.addAll(this.jobRequirements, jobRequirements);
    }


}

