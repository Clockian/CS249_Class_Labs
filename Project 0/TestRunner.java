
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println();
        //,Project0GraderTests.class   in line below, inside parentheses
        Result result = JUnitCore.runClasses(Project0Tests.class);
        for (Failure failure : result.getFailures()) {
            Throwable exception = failure.getException();
            if(exception != null)
            {
                System.out.println(failure.getTestHeader() +" exception:");
                System.out.println(exception);
                for(int i = 0; i < exception.getStackTrace().length; i++)
                {
                    System.out.println(exception.getStackTrace()[i]);
                }

            }
            else {
                System.out.println(failure.toString());
            }
            System.out.println();
        }
        System.out.println("All passed: "+result.wasSuccessful());
    }
}
