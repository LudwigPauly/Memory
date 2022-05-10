package memory;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exporter {

    public void writeToFile() {
        try {
            File file = new File("");
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(file, true);
                createFileHeader(fileWriter);
                fileWriter.write("");

            } else {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write("");
            }

        } catch (IOException e) {

        }


    }

    public void createFileHeader(FileWriter fileWriter) throws IOException {
        fileWriter.write("");


    }

}
