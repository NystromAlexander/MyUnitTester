/**
 * Created by Roguz on 09/11/2016.
 */
import java.lang.reflect.*;

public class MethodTester {

    private boolean hasSetup = false;
    private boolean hasTeardown = false;

    public MethodTester(String className){
        try {
            Class<?> cls = Class.forName(className);

            if(cls.isInterface()){
                //Write to the output text field that the class is an interface
            }
            else{
                Method[] methods = cls.getMethods();
                for (Method method : methods) {
                    if (method.getName().compareTo("setUp") == 0) {
                        hasSetup = true;
                    } else if (method.getName().compareTo("tearDown") == 0) {
                        hasTeardown = true;
                    }
                }
            }
        }
        catch (ClassNotFoundException e)
        {
            //Write to the output text field that there is no such class
        }
    }
}
