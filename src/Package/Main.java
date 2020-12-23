package Package;


public class Main {

    public static void main(String[] args) {

        AlumniSystem test = new AlumniSystem();
        String[] jobRequirements = {"Java", "Python"};
        test.setJobRequirements(jobRequirements);

        test.registerNewGrad("Naama", "Gesser", "Java");
        test.registerNewGrad("Emerenc", "Szeredás", "Python");

        while(!test.loggedIn){    //keeps program in log-in mode, allows multiple log-ins
            test.sheCodesLogin();
        }

    }
}
