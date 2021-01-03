package Package;


public class Main {

    public static void main(String[] args) {

        AlumniSystem test = new AlumniSystem();
        String[] jobRequirements = {"Java", "Python"};
        test.setJobRequirements(jobRequirements);

        test.registerNewGrad("Example", "Two", new String[]{"Java", "Python"});
        test.registerNewGrad("Example", "One", new String[]{"Python"});

        while(!test.loggedIn){    //keeps program in log-in mode, allows multiple log-ins
            test.sheCodesLogin();
        }

    }
}
