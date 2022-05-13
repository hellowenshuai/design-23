package org.example.D03_proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GPProxy {
    private static String ln = "\r\n";

    static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces, GPInvocationHandler h)   {

        //1.动态生成源文件.java
        String str = generateSrc(interfaces[0]);
        //2.Java文件输出到硬盘
        File file = WriteDisk(str);
        //3.把硬盘上的java文件编译成class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null,null,null,iterable);
        task.call();
        try {
            manager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4.把class文件加载到JVM中
        Constructor<?> constructor = null;
        try {
            Class<?> proxyClass = classLoader.findClass("$Proxy0");
            constructor = proxyClass.getConstructor(GPInvocationHandler.class);
            //5.返回字节码重组以后的新的代码对象。
            return constructor.newInstance(h);

        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
        //6.删除临时的java和class文件 todo
        return null;
    }

    private static File WriteDisk(String str)  {
        try {
            String path = GPProxy.class.getResource("").getPath();
            File file = new File(path+"$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(str);
            fw.flush();
            fw.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package org.example.D03_proxy.custom;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);

        src.append("GPInvocationHandler h;" + ln);

        src.append("public $Proxy0(GPInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }

        src.append("}");

        return src.toString();
    }


}
