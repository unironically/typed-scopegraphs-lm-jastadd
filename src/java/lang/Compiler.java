package lm;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import lm.ast.LMParser;
import lm.ast.LMScanner;
import lm.ast.Program;

public class Compiler {

  public static Program parse(String[] args) throws IOException, beaver.Parser.Exception {
    String filename = args[args.length - 1]; // Assumes filename is the last argument
    LMScanner scanner = new LMScanner(new FileReader(filename));
    LMParser parser = new LMParser();
    Program prog = (Program) parser.parse(scanner);
    return prog;
  }

  public static void main(String[] args) {
    try {
      if (args.length != 1) {
        System.err.println("You must specify a source file on the command line!");
        System.exit(1);
      }
      Program prog = parse(args);
      System.out.println(prog.treePrint());
      System.out.println((prog.ok()) ? "Good!" : "Not good!");
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
