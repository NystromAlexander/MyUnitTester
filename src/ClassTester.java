/**
 * Created by Roguz on 09/11/2016.
 */
import javax.swing.*;
import java.lang.reflect.*;

public class ClassTester {

    private boolean hasSetup = false;
    private boolean hasTeardown = false;
    private JTextArea txtOutput;
    private boolean valid = false;

    public ClassTester(String className, JTextArea txtOutput){
        this.txtOutput = txtOutput;
        Class<?> cls = isValidClass(className);
        if(valid && isOfTestClass(cls)){
             gotSetUpTearDown(cls);
        }

    }

    private void gotSetUpTearDown(Class<?> cls){
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.getName().compareTo("setUp") == 0) {
                hasSetup = true;
            } else if (method.getName().compareTo("tearDown") == 0) {
                hasTeardown = true;
            }
        }
    }

    private Class<?> isValidClass(String className){
        try {
            Class<?> cls = Class.forName(className);
            if(cls.isInterface()){
                txtOutput.append("Class is interface and cannot be instanced\n");
                //Write to the output text field that the class is an interface
            }
            valid = true;
            return cls;
        }
        catch (ClassNotFoundException e) {
            txtOutput.append("Could not find class: " + className + "\n");
            //Write to the output text field that there is no such class
        }
        return null;
    }

    private boolean isOfTestClass(Class<?> cls){
        Class<?>[] interfaces = cls.getInterfaces();
        for(int j = 0; j < interfaces.length;j++) {
            if(interfaces[j].getName().compareTo("TestClass") == 0){
                return true;
            }
        }
        return false;
    }

    public void runTests(){

    }
}
