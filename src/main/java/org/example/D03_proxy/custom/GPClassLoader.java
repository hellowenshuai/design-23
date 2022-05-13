package org.example.D03_proxy.custom;

import java.io.*;





public class GPClassLoader extends ClassLoader {

    private File baseDir;

    protected GPClassLoader() {
        String path = GPClassLoader.class.getResource("").getPath();
        this.baseDir = new File(path);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String calssName = GPClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            File file = new File(baseDir, name.replace("\\.", "/") + ".class");
            if (file.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(file);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff,0,len);
                    }
                    return defineClass(calssName, out.toByteArray(), 0, out.size());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
