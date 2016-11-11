/**
 * Created by Roguz on 09/11/2016.
 */
import javax.swing.*;
import java.lang.reflect.*;

public class ClassTester {

    private boolean hasSetup;
    private int setUp;
    private boolean hasTeardown;
    private int tearDown;
    private JTextArea txtOutput;
//    private boolean valid;
    private Method[] methods;
    private String testClass;
    private Class<?> cls;
    private int successCount;
    private int failCount;
    private int exceptionFail;

    public ClassTester(JTextArea txtOutput) {
        hasSetup = false;
        hasTeardown = false;
        this.txtOutput = txtOutput;
    }

    public void setupTest(String testClass) {
        this.testClass = testClass;
        if(isValidClass() && isOfTestClass(cls)){
            methods = cls.getMethods();
            gotSetUpTearDown();
        }

    }

    private void gotSetUpTearDown() {
        for (int i = 0; i < methods.length;i++) {
            if (methods[i].getName().compareTo("setUp") == 0) {
                hasSetup = true;
                setUp = i;
            } else if (methods[i].getName().compareTo("tearDown") == 0) {
                hasTeardown = true;
                tearDown = i;
            }
        }
    }

    private boolean isValidClass() {
        try {
            cls = Class.forName(testClass);
            if (cls.isInterface()) {
                txtOutput.append("Class is interface and cannot be instanced\n");
//                valid = false;
                return false;
                //Write to the output text field that the class is an interface
            }
            boolean valid = false;
            Constructor<?>[] constructors = cls.getConstructors();
            for (Constructor con : constructors) {
                if (con.getParameterCount() == 0) {
                    valid = true;
                }
            }
            if(valid){
               return true;
            }
            return false;
        }
        catch (ClassNotFoundException e) {
            txtOutput.append("Could not find class: " + testClass + "\n");
            //Write to the output text field that there is no such class
        }
        return false;
    }

    private boolean isOfTestClass(Class<?> cls) {
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            if (anInterface.getName().compareTo("TestClass") == 0) {
                return true;
            }
        }
        return false;
    }

    public void runTests() {
        try {
            Object theClass = cls.newInstance();
            for(int i = 0; i < methods.length;i++) {
                String methName = methods[i].getName();
                if(!methName.startsWith("test") ||
                        (methods[i].getReturnType() != boolean.class) ||
                        (methods[i].getParameterCount() > 0)) {
                    continue;
                }
                try{
                    if(hasSetup) {
                        methods[setUp].invoke(theClass);
                    }
                    boolean methodReturn = (Boolean) methods[i].invoke(theClass);
                    if(methodReturn) {
                        txtOutput.append(methName+": SUCCESS+\n");
                        successCount++;
                    } else {
                        txtOutput.append(methName+": FAIL\n");
                        failCount++;
                    }
                } catch (InvocationTargetException e) {
                    txtOutput.append(methName+": FAIL Generated"+
                                        e.getTargetException()+"\n");
                    exceptionFail++;
                }


            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        txtOutput.append("\n"+successCount+" Tests succeeded\n"+failCount+
                            " Tests failed\n"+exceptionFail+" Tests failed" +
                " by exceptions\n");

    }
}
