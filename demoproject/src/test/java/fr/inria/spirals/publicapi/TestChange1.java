package fr.inria.spirals.publicapi;

import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;

public class TestChange1 {

    @Test
    public void testPrivateApiIsNeverReturned() throws ClassNotFoundException {
        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("fr.inria.spirals.publicapi"))));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        for (Class<?> aClass : allTypes) {
            for (Method method : aClass.getDeclaredMethods()) {
                if (Modifier.isPublic(method.getModifiers())) {
                    Class<?> returnType = method.getReturnType();
                    assertFalse(aClass.getName() + "#" + method.getName() + " return "+returnType.getName(), returnType.getName().contains("privateapi"));
                }
            }

        }

    }
}
