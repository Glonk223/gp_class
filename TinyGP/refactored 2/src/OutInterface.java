import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public interface OutInterface {
    void print(String s);
    default void println(String s) {
        print(s + '\n');
    }

    default void print(Object o) {
        print(o.toString());
    }
    default void println(Object o) {
        print(o.toString() + '\n');
    }

    default void close() {}

    static OutInterface createOutputToFile(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                System.out.println("File already exists: " + filename);
                System.out.print("Overwrite? [y/n] ");
                int input = System.in.read();
                System.in.read();
                if (input != 'y' && input != 'Y') {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                file.delete();
            }

            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            return new FileOutputInterface(writer);
        } catch (IOException e) {
            System.out.println("Error while creating output to file: " + filename);
            System.exit(1);
            return null;
        }
    }

    class FileOutputInterface implements OutInterface {
        private final BufferedWriter writer;

        public FileOutputInterface(BufferedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void print(String s) {
            try {
                writer.write(s);
                writer.flush();
            } catch (IOException e) {
                System.out.println("Error while writing to file.");
                System.exit(1);
            }
        }
        
        @Override
        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while closing file writer.");
                System.exit(1);
            }
        }
    }
}
