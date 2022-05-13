package memory;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Exporter {

    public void writeToFile(int timeLimit, int moves, int wrongMoves, int gridsize, boolean win) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int rightMoves = moves -wrongMoves;

        try {
            File file = new File("/home/user/Documents/Memory/src/export.txt");
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(file, true);
                createFileHeader(fileWriter);
                fileWriter.write("\n" + timestamp + "\t\t" + timeLimit + "\t\t" + gridsize + "\t\t" + moves + "\t" + wrongMoves + "\t" + rightMoves + "\t" + win);
                fileWriter.close();

            } else {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write("\n" + timestamp + "\t\t" + timeLimit + "\t\t" + gridsize + "\t\t" + moves + "\t" + wrongMoves + "\t" + rightMoves + "\t" + win);
                fileWriter.close();
            }

        } catch (IOException e) {

        }


    }

    public void createFileHeader(FileWriter fileWriter) throws IOException {
        fileWriter.write("Timestemp\t\t\tTimelimit\tGridsize\tMoves\tWrong\tRight\tWin\n"
                + "=============================================================================================");


    }

}
