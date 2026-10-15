package net.enter.yggdrasil.importer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/** Reads basic metadata from a selected JAR archive. */
public class JarImportService {

    public int countClassEntries(Path jarPath) throws IOException {
        int classCount = 0;
        try (JarFile jarFile = new JarFile(jarPath.toFile())) {
            var entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                    classCount++;
                }
            }
        }
        return classCount;
    }
}
