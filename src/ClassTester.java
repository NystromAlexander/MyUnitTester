/**
 * Created by Alexander Nyström(dv15anm) on 09/11/2016.
 *
 */
import javax.swing.*;
import java.lang.reflect.*;

/**
 * ClassTester is a class designed to test other classes following that they
 * meet certain requirements.
 * What specifies a test class is that they implement
 * the interface TestClass and has a nullary constructor and the methods for
 * testing starts with test in their name and they return a boolean.
 *
 * @version 1.0 14 Nov 2016
 * @author Alexander Nyström
 */
public class ClassTester {
    private int setUp;
    private int tearDown;
    private int failCount;
    private int successCount;
    private int exceptionFail;
    private boolean hasSetup;
    private boolean hasTeardown;
    private String className;
    private Method[] methods;
    private Class<?> testClass;
    private JTextArea txtOutput;

    /**
     * Construct a new ClassTester.
     * @param txtOutput The text area where the result will be shown.
     */
    public ClassTester(JTextArea txtOutput) {
        hasSetup = false;
        hasTeardown = false;
        this.txtOutput = txtOutput;
    }

    /**
     * Takes a name for a class and validates if it is a test class. Also checks
     * if the class has a setUp and tearDown methods.
     * @param className The name of the class to be tested.
     * @return True if it is a valid test class else false.
     */
    public Boolean setupTest(String className) {
        this.className = className;
        if (isValidClass() && isOfTestClass(this.testClass)) {
            methods = this.testClass.getMethods();
            gotSetUpTearDown();
            return true;
        }
        return false;
    }

    /**
     * Checks if the class have valid versions of the methods setUp
     * and tearDown.
     */
    private void gotSetUpTearDown() {
        for (int i = 0; i < methods.length;i++) {
            if ((methods[i].getName().compareTo("setUp") == 0) &&
                    (methods[i].getParameterCount() == 0)) {
                hasSetup = true;
                setUp = i;
            } else if ((methods[i].getName().compareTo("tearDown")) == 0 &&
                       (methods[i].getParameterCount() == 0)) {
                hasTeardown = true;
                tearDown = i;
            }
        }
    }

    /**
     * Checks that the given class is not an interface, and that it got a
     * constructor that does not take any parameters.
     * @return True if it's not an interface and has a nullary constructor. If
     * it's an interface or the class was not found return false.
     */
    private boolean isValidClass() {
        try {
            boolean valid = false;
            testClass = Class.forName(className);
            if (testClass.isInterface()) {
                txtOutput.append("Class is interface and cannot be " +
                                 "instanced\n");
                return false;
            }
            Constructor<?>[] constructors = testClass.getConstructors();
            for (Constructor con : constructors) {
                if (con.getParameterCount() == 0) {
                    valid = true;
                }
            }
            if (!valid) {
               txtOutput.append("Could not find a constructor that does not " +
                       "take any arguments\n");
            }
            return valid;
        }
        catch (ClassNotFoundException e) {
            txtOutput.append("Could not find class: " + className + "\n");
        }
        return false;
    }

    /**
     * Checks that the class implements the interface TestClass.
     * @param cls An instance of the class.
     * @return True if it implements TestClass else false.
     */
    private boolean isOfTestClass(Class<?> cls) {
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            if (anInterface.getName().compareTo("TestClass") == 0) {
                return true;
            }
        }
        txtOutput.append("Class does not implement the interface TestClass.\n");
        return false;
    }

    /**
     * Iterates the array of methods and passes each method and it's index as
     * well as the instantiated class.
     */
    public void runTests() {
        try {
            Object theClass = testClass.newInstance();
            for (int i = 0; i < methods.length;i++) {
                String methodName = methods[i].getName();

                if (!methodName.startsWith("test") ||
                        (methods[i].getReturnType() != boolean.class) ||
                        (methods[i].getParameterCount() > 0)) {
                    continue;
                }
                runMethod(theClass, methodName, i);
            }
        } catch (InstantiationException e) {
            txtOutput.append("The class could not be initialized. This " +
                             "could be caused by the class being abstract" +
                             " or an array class or a primitive type.\n");
        } catch (IllegalAccessException e) {
            txtOutput.append("Could not access the class or it's " +
                    "constructor.\n");
        }

        txtOutput.append("\n" + successCount + " Tests succeeded\n"+ failCount +
                         " Tests failed\n" + exceptionFail +
                         " Tests failed" + " by exceptions\n\n");
        successCount = 0;
        failCount = 0;
        exceptionFail = 0;
    }

    /**
     * Takes a method name an instantiated class and index in the mehtod array.
     * and will call the method and print to the JTextArea whether the test
     * succeeded or failed.
     * @param theClass Instance of the test class.
     * @param methodName The name of the method to be called.
     * @param methodIndex The index of the method in the method array.
     */
    private void runMethod(Object theClass, String methodName,
                           int methodIndex) {
        try{
            boolean methodReturn;
            if (hasSetup) {
                methods[setUp].invoke(theClass);
            }
            methodReturn = (Boolean) methods[methodIndex].invoke(theClass);
            if (methodReturn) {
                txtOutput.append(methodName+": SUCCESS\n");
                successCount++;
            } else {
                txtOutput.append(methodName+": FAIL\n");
                failCount++;
            }

            if (hasTeardown) {
                methods[tearDown].invoke(theClass);
            }
        } catch (InvocationTargetException e) {
            txtOutput.append(methodName + ": FAIL Generated " +
                    e.getTargetException() + "\n");
            exceptionFail++;
        } catch (IllegalAccessException e) {
            txtOutput.append("Could not access the the method " + methodName +
                             "\n");
        }
    }
}
