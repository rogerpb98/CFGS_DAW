/**
 * This class includes a bunch of static methods to help with testing
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
public class UtilTests {
    
    /**
     * Returns whether the given class has a declared field with the given name
     * @param classInstance: the class
     * @param name: the name of the field
     * @return the result
     */
    static boolean classHasField(Class<?> classInstance, String name) {
        return classHasField(classInstance, name, false);
    }

    /**
     * Returns whether the given class has a field with the given name
     * @param classInstance: the class
     * @param name: the name of the field
     * @param declaredOnly: consider only declared members
     * @return the result
     */
    static boolean classHasField(Class<?> classInstance, String name, boolean declaredOnly) {
        Field[] fields = (declaredOnly ? classInstance.getDeclaredFields() : classInstance.getFields());
        for (Field field: fields) {
            if (field.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether the given class has a public declared field with the given name
     * @param classInstance: the class
     * @param name: the name of the field
     * @return the result
     */
    static boolean classHasPublicField(Class<?> classInstance, String name) {
        return classHasPublicField(classInstance, name, false);
    }

    /**
     * Returns whether the given class has a public field with the given name
     * @param classInstance: the class
     * @param name: the name of the field
     * @param declaredOnly: consider only declared members
     * @return the result
     */
    static boolean classHasPublicField(Class<?> classInstance, String name, boolean declaredOnly) {
        Field[] fields = (declaredOnly ? classInstance.getDeclaredFields() : classInstance.getFields());
        for (Field field: fields) {
            if (field.getName().equals(name)) {
                return Modifier.isPublic(field.getModifiers());
            }
        }
        return false;
    }

    /**
     * Returns whether the given class has a private declared field with the given name
     * @param classInstance: the class
     * @param name: the name of the field
     * @return the result
     */
    static boolean classHasPrivateField(Class<?> classInstance, String name) {
        Field[] fields = classInstance.getDeclaredFields();
        for (Field field: fields) {
            if (field.getName().equals(name)) {
                return Modifier.isPrivate(field.getModifiers());
            }
        }
        return false;
    }


    /**
     * Returns whether the given class has a public method (procedure)
     * with the given name with no params
     * @param classInstance: the class
     * @param name: the name of the field
     * @param declaredOnly: consider only declared members
     * @return the result
     */
    static boolean classHasPublicMethod(Class<?> classInstance, String name,
                                        boolean declaredOnly) {
        return classHasPublicMethod(classInstance, name, new Type[] {}, void.class, declaredOnly);
    }

    /**
     * Returns whether the given class has a public method (procedure) with the given name
     * @param classInstance: the class
     * @param name: the name of the field
     * @param params: array of expected params
     * @param declaredOnly: consider only declared members
     * @return the result
     */
    static boolean classHasPublicMethod(Class<?> classInstance, String name, Type[] params,
                                        boolean declaredOnly) {
        return classHasPublicMethod(classInstance, name, params, void.class, declaredOnly);
    }

    /**
     * Returns whether the given class has a public method with the given name and no params
     * @param classInstance: the class
     * @param name: the name of the field
     * @param returnType: type of return value
     * @param declaredOnly: consider only declared members
     * @return the result
     */
    static boolean classHasPublicMethod(Class<?> classInstance, String name, Type returnType,
                                         boolean declaredOnly) {
        return classHasPublicMethod(classInstance, name, new Type[] {}, returnType, declaredOnly);
    }


    /**
     * Returns whether the given class has a public method with the given name
     * @param classInstance: the class
     * @param name: the name of the field
     * @param params: array of expected params
     * @param returnType: type of return value
     * @param declaredOnly: consider only declared members
     * @return the result
     */
    static boolean classHasPublicMethod(Class<?> classInstance, String name, Type[] params,
            Type returnType, boolean declaredOnly) {
        Method[] methods = (declaredOnly ? classInstance.getDeclaredMethods() : classInstance.getMethods());
        for (Method method: methods) {
            if (method.getName().equals(name) &&
                    Arrays.equals(params, method.getGenericParameterTypes()) &&
                    returnType.equals(method.getReturnType())) {
                return Modifier.isPublic(method.getModifiers());
            }
        }
        return false;
    }

    /**
     * Returns whether the given class has a public default constructor
     * @param classInstance: the class
     * @return the result
     */
    static boolean classHasPublicDefaultConstructor(Class<?> classInstance) {
        return classHasPublicConstructor(classInstance, new Type[] {});
    }

    /**
     * Returns the number of constructors declared by this class
     * @param classInstance: the class
     * @return the result
     */
    static int numberOfPublicConstructorsInClass(Class<?> classInstance) {
        return classInstance.getDeclaredConstructors().length;
    }


    /**
     * Returns whether the given class has a public constructor with the given params
     * @param classInstance: the class
     * @param params: array of expected params
     * @return the result
     */
    static boolean classHasPublicConstructor(Class<?> classInstance, Type[] params) {
        Constructor[] constructors = classInstance.getDeclaredConstructors();
        for (Constructor constructor: constructors) {
            if (Arrays.equals(params, constructor.getGenericParameterTypes())) {
                return Modifier.isPublic(constructor.getModifiers());
            }
        }
        return false;
    }

}
