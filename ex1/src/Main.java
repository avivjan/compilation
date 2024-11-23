
import java.io.*;

import java_cup.runtime.Symbol;

public class Main {
	static public void main(String argv[]) {
		Lexer l;
		Symbol s;
		FileReader file_reader;
		PrintWriter file_writer;
		String inputFilename = argv[0];
		String outputFilename = argv[1];
		StringBuilder str = new StringBuilder();
		try {
			file_reader = new FileReader(inputFilename);
			l = new Lexer(file_reader);
			s = l.next_token(); // first token
			while (s.sym != TokenNames.EOF) {
				if (symToString(s.sym).equals("ERROR")) {
					str = new StringBuilder("ERROR\n");
					str.append("[" + l.getLine() + "," + l.getTokenStartPosition() + "]\n");
					break;
				}
				str.append(symToString(s.sym));
				if (s.value != null) {
					str.append("(" + s.value + ")");
				}
				str.append("[" + l.getLine() + "," + l.getTokenStartPosition() + "]\n");
				s = l.next_token();
			}

			file_writer = new PrintWriter(outputFilename);
			if (str.length() > 0) {
				// str.deleteCharAt(str.length() - 1);
				file_writer.print(str);
			}
			l.yyclose();
			file_writer.close();
			file_reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String symToString(int number) {
		switch (number) {
			case 0:
				return "EOF";
			case 1:
				return "LPAREN";
			case 2:
				return "RPAREN";
			case 3:
				return "LBRACK";
			case 4:
				return "RBRACK";
			case 5:
				return "LBRACE";
			case 6:
				return "RBRACE";
			case 7:
				return "NIL";
			case 8:
				return "PLUS";
			case 9:
				return "MINUS";
			case 10:
				return "TIMES";
			case 11:
				return "DIVIDE";
			case 12:
				return "COMMA";
			case 13:
				return "DOT";
			case 14:
				return "SEMICOLON";
			case 15:
				return "ASSIGN";
			case 16:
				return "EQ";
			case 17:
				return "LT";
			case 18:
				return "GT";
			case 19:
				return "ARRAY";
			case 20:
				return "CLASS";
			case 21:
				return "EXTENDS";
			case 22:
				return "RETURN";
			case 23:
				return "WHILE";
			case 24:
				return "IF";
			case 25:
				return "NEW";
			case 26:
				return "TYPE_INT";
			case 27:
				return "TYPE_VOID";
			case 28:
				return "TYPE_STRING";
			case 29:
				return "INT";
			case 30:
				return "STRING";
			case 31:
				return "ID";
			case 32:
				return "ERROR";
			default:
				return "UNKNOWN";
		}
	}
}
