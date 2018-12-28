/* Question asks to create a number calculator that int/long cant handle (big numbers)
the use of Bigdecimal and Biginteger was not allowed
I manipulated the string, fast input was needed so I used a scanner class from online www.dmoj.ca
*/
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.io.*;
public class AplusBBBB{
  public static void main(String[]args)throws IOException{
    FastInputReader sc =new FastInputReader();
    calculator calc = new calculator();
    int x = sc.nextInt();
    for(int i =0;i<x;i++){
    integer a = new integer(sc.next());
    integer b = new integer(sc.next());
    String str =calc.add(a,b);
   if(str.equals("-0")) str = "0";
    if(str.length() >1){
      while(str.charAt(0) == '0' && str.length()>1 || str.startsWith("-0")){
      str = str.replaceFirst("0","");
    }
    }
    System.out.println(str.equals("-")?0:str);
    }
  }
}

class calculator{

   
  public calculator(){
  }
  

  
 public String add(integer first,integer second){
   if(first.isNegative() && second.isNegative() || !first.isNegative()&& !second.isNegative()){
     return addPos(first,second);
   }
   return addNeg(first,second);
        }
 
 public String addNeg(integer first,integer second){
   StringBuilder sb = new StringBuilder();
   int y = first.compare(second);
   if(y == -1){
     integer n = new integer(first.getString(),first.isNegative());
     first = new integer(second.getString(),second.isNegative());
     second = new integer(n.getString(),n.isNegative());
   }
   fill(first,second);
   int carry = 0;
 //  System.out.println(first.getString() + second.getString());
   for(int x =first.length()-1;x >=0;x--){
     int cur = first.intAt(x) - second.intAt(x) -carry;
     //System.out.println(cur);
     if(cur <0){
       carry = 1;
       cur+=10;
       
     }
     else carry = 0;
     sb.append(cur);
   }
   
   if(first.isNegative())
     sb.append("-");
   return sb.reverse().toString();
 }
 
 public String addPos(integer first,integer second){
   StringBuilder sb = new StringBuilder();
  int y = first.compare(second);
  if(y == -1){
     integer n = new integer(first.getString(),first.isNegative());
     first = new integer(second.getString(),second.isNegative());
     second = new integer(n.getString(),n.isNegative());
   }
   fill(first,second);
   int carry = 0;
   for(int x = first.length()-1;x>=0;x--){
     //System.out.println(first.intAt(x) +  " " + second.intAt(x));
     int cur  = first.intAt(x) + second.intAt(x)+carry;
     if(cur >= 10){
       cur -=10;
       carry =1;
     }
     
     else carry = 0;
     sb.append(cur);
   }
   if(carry == 1) sb.append(1);
   if(first.isNegative())
     sb.append("-");
   return sb.reverse().toString();
   
 }
    
 
  
  public void fill(integer first,integer second){
    int max = Math.max(first.length(),second.length());
    if(first.length() < max){
      while(first.length()<max){
        first.set("0"+first.getString());
    }
    }
    if(second.length() < max){
      while(second.length() < max){
        second.set("0"+second.getString());
      }
    }
     
      
  }
 
  
}
class integer{
  private String number;
  private boolean negative;
  public integer(String number){
    if(number.charAt(0) =='-'){
      negative = true;
      this.number = number.substring(1);
    }
    else{
      this.number = number;
      negative = false;
    }
  }
  public integer(String number,boolean n){
    this.number = number;
    negative = n;
    }
  public String getString(){
    return number;
  }
  public void set(String str){
    number = str;
  }
  public boolean isNegative(){
    return negative;
  }
  public int intAt(int x){
    return Character.getNumericValue(number.charAt(x));
  }
  public void swap(integer x){
    number = x.getString();
    negative = x.isNegative();
  }
  public int length(){
    return number.length();
  }
  public int compare(integer second){
    if(number.equals(second.getString())) return 0;
    if(length() > second.length())return 1;
    if(length() < second.length())return -1;
    for(int x =0;x<getString().length();x++){
      if(intAt(x) >second.intAt(x)) return 1;
      if(intAt(x) <second.intAt(x)) return -1;
    }
    return 0;
  }
}

class FastInputReader {
    private final InputStream in;
    private final String delim;
    private final byte[] buffer = new byte[4096];
    private int bufferSize = 0;
    private int bufferPointer = 0;
    private byte[] input = new byte[32];
    private int inputPointer = 0;
    private int inputLength = 0;
    private byte lastDelim = (byte)'\n';
   
    public FastInputReader() {
        in = new FileInputStream(FileDescriptor.in);
        delim=" \t\n";
    }
   
    public FastInputReader(String delim) {
        in = new FileInputStream(FileDescriptor.in);
        this.delim=delim;
    }
   
    public FastInputReader(InputStream is) {
        in = is;
        delim=" \t\n";
    }
   
    public FastInputReader(InputStream is, String delim) {
        in = is;
        this.delim=delim;
    }
   
    public FastInputReader(File F) throws FileNotFoundException {
        in = new FileInputStream(F);
        delim=" \t\n";
    }
   
    public FastInputReader(File F, String delim) throws FileNotFoundException {
        in = new FileInputStream(F);
        this.delim=delim;
    }
 
    private void nextBytesInternal() throws IOException {
        while(true){
            byte c = read();
            for(int i=0;i<delim.length();i++) {
                if(c == (byte)delim.charAt(i)) {
                    inputLength = inputPointer;
                    inputPointer = 0;
                    lastDelim = c;
                    return;
                }
            }
            input[inputPointer++] = c;
        }
    }
 
    public String next() throws IOException {
        nextBytesInternal();
        return new String(input, 0, inputLength, StandardCharsets.US_ASCII);
    }
 
    public byte nextByte() throws IOException {
        nextBytesInternal();
        byte val = 0;
        byte mul = 1;
        for(int i = 0; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if('0' <= c && c <= '9') {
                val = (byte) (val * 10 + c - '0');
            }
        }
        return (byte) (val * mul);
    }
   
    public byte[] nextBytes() throws IOException {
        nextBytesInternal();
        byte[] newArray = new byte[inputLength];
        if(inputLength < 24) {
            for(int i = 0; i < inputLength; ++i) {
                newArray[i] = input[i];
            }
        }
        else {
            System.arraycopy(input, 0, newArray, 0, inputLength);
        }
        return newArray;
    }
 
    public char nextChar() throws IOException {
        nextBytesInternal();
        return (char)input[0];
    }
   
    public double nextDouble() throws IOException {
        nextBytesInternal();
        double val=0;
        byte mul = 1;
        int i=0;
        for(; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if(c == '.') {
                break;
            }
            if('0' <= c && c <= '9') {
                val = val * 10 + c - '0';
            }
        }
        long base = 1;
        for(; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if('0' <= c && c <= '9') {
                base *= 10 ;
                val = val + (double)(c - '0') / base;
            }
        }
        return val * mul;
    }
   
    public float nextFloat() throws IOException {
        nextBytesInternal();
        float val=0;
        byte mul = 1;
        int i=0;
        for(; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if(c == '.') {
                break;
            }
            if('0' <= c && c <= '9') {
                val = val * 10 + c - '0';
            }
        }
        long base = 1;
        for(; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if('0' <= c && c <= '9') {
                base *= 10 ;
                val = val + (float)(c - '0') / base;
            }
        }
        return val * mul;
    }
   
    public int nextInt() throws IOException {
        nextBytesInternal();
        int val = 0;
        byte mul = 1;
        for(int i = 0; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if('0' <= c && c <= '9') {
                val = val * 10 + c - '0';
            }
        }
        return val * mul;
    }
 
    public String nextLine() throws IOException {
        while(lastDelim!='\n') {
            lastDelim = read();
        }
        while(true){
            byte c = read();
            if(c == (byte)'\n') {
                inputLength = inputPointer;
                inputPointer = 0;
                lastDelim = '\n';
                return new String(input, 0, inputLength, StandardCharsets.US_ASCII);
            }
            input[inputPointer++] = c;
        }
    }
   
    public long nextLong() throws IOException {
        nextBytesInternal();
        long val = 0;
        byte mul = 1;
        for(int i = 0; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if('0' <= c && c <= '9') {
                val = val * 10 + c - '0';
            }
        }
        return val * mul;
    }
   
    public short nextShort() throws IOException {
        nextBytesInternal();
        short val = 0;
        byte mul = 1;
        for(int i = 0; i < inputLength; ++i) {
            int c = input[i] & 0xFF;
            if(c == '-') {
                mul = -1;
            }
            if('0' <= c && c <= '9') {
                val = (short) (val * 10 + c - '0');
            }
        }
        return (short) (val * mul);
    }
   
    private byte read() throws IOException {
        if(bufferPointer >= bufferSize) {
            bufferSize = in.read(buffer, 0, 4096);
            bufferPointer = 0;
        }
        if(inputPointer >= input.length) {
            byte[] newInput = new byte[inputPointer * 2 + 1];
            if(input.length < 24) {
                for(int i = 0; i < input.length; ++i) {
                    newInput[i] = input[i];
                }
            }
            else {
                System.arraycopy(input, 0, newInput, 0, input.length);
            }
            input = newInput;
        }
        return buffer[bufferPointer++];
    }
}
// </editor-fold>
 
// <editor-fold defaultstate="collapsed" desc=" Pair ">
class Pair<T1, T2> {
    public T1 first;
    public T2 second;
   
    public Pair() {
        first=null;
        second=null;
    }
   
    public Pair(T1 f, T2 s) {
        first=f;
        second=s;
    }
}
