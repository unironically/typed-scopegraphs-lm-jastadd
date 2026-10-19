package lm;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import lm.ast.LMParser;
import lm.ast.LMScanner;

public class Compiler {

  public static void parse(String[] args) throws IOException, beaver.Parser.Exception {
    String filename = args[args.length - 1]; // Assumes filename is the last argument
    LMScanner scanner = new LMScanner(new FileReader(filename));
    LMParser parser = new LMParser();
    parser.parse(scanner);
  }

  public static void main(String[] args) {
    try {
      if (args.length != 1) {
        System.err.println("You must specify a source file on the command line!");
        System.exit(1);
      }
      parse(args);
      System.out.println("Parse success!");
    } catch (FileNotFoundException e) {
        System.out.println("File not found!");
        System.exit(1);
    } catch (IOException e) {
        System.out.println("Unexpected I/O exception!");
        e.printStackTrace();
        System.exit(1);
    } catch (beaver.Parser.Exception e) {
        System.out.println("Parsing failed!");
        e.printStackTrace();
        System.exit(1);
    }
  }

}
