import java.io.FileNotFoundException;
import java.io.IOException;

public class Compiler {

  public static void parse(String[] args) throws IOException {
    // Invoke parser, demand top level attr, etc ... 
  }

    public static void main(String[] args) {
        try {
          if (args.length != 1) {
            System.err.println("You must specify a source file on the command line!");
            System.exit(1);
          }
          parse(args);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Unexpected I/O exception. Perhaps permission problems?");
            e.printStackTrace();
            System.exit(1);
        }
    }

}
