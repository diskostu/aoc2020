package de.diskostu.util;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class InputFileSupplier implements Supplier<String> {

    private final String inputFile;


    @Override
    public String get() {
        final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        final URL resource = classloader.getResource(this.inputFile);
        if (resource == null) {
            throw new IllegalStateException(String.format("The file %s does not exist", this.inputFile));
        }

        final File input = new File(resource.getFile());
        try (final Scanner scanner = new Scanner(input)) {
            return scanner.useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
