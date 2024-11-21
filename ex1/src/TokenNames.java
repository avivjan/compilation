/************************************/
/* FILE NAME: TokenNames.java       */
/************************************/
public interface TokenNames {
  // Symbols
  public static final int LPAREN = 1; // (
  public static final int RPAREN = 2; // )
  public static final int LBRACK = 3; // [
  public static final int RBRACK = 4; // ]
  public static final int LBRACE = 5; // {
  public static final int RBRACE = 6; // }
  public static final int NIL = 7; // nil
  public static final int PLUS = 8; // +
  public static final int MINUS = 9; // -
  public static final int TIMES = 10; // *
  public static final int DIVIDE = 11; // /
  public static final int COMMA = 12; // ,
  public static final int DOT = 13; // .
  public static final int SEMICOLON = 14; // ;
  public static final int ASSIGN = 15; // :=
  public static final int EQ = 16; // =
  public static final int LT = 17; // <
  public static final int GT = 18; // >

  // Keywords
  public static final int ARRAY = 19; // array
  public static final int CLASS = 20; // class
  public static final int EXTENDS = 21; // extends
  public static final int RETURN = 22; // return
  public static final int WHILE = 23; // while
  public static final int IF = 24; // if
  public static final int NEW = 25; // new

  // Types
  public static final int TYPE_INT = 26; // int
  public static final int TYPE_VOID = 27; // void
  public static final int TYPE_STRING = 28; // string

  // Values
  public static final int INT = 29; // integer value
  public static final int STRING = 30; // string value
  public static final int ID = 31; // identifier

  public static final int ERROR = 32; // error

  // End of File
  public static final int EOF = 0; // End of file token
}
