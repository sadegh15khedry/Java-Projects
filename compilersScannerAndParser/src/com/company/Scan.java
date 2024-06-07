package com.company;


import java.util.ArrayList;
import java.util.HashMap;

public class Scan {
    private int lookahead=0;
    private int stateNumber=0;
    private char inputBuffer[]=null;
    private ArrayList<String> scannerOutput=null;


    public Scan(char[] inputBuffer) {
        this.inputBuffer = inputBuffer;
        scannerOutput=new ArrayList<>();
    }

    public ArrayList<String> scanner(){
        System.out.println("scan started");
        int size = inputBuffer.length;
        while (lookahead<size){
            char i = inputBuffer[lookahead];
            if (i==' '){
                stateNumber=0;
                lookahead++;
            }
            else if (i=='+'||i=='-'||i=='/'||i=='*'){
                stateNumber=0;
                lookahead++;
                scannerOutput.add("operand");
                System.out.println("operand added");
            }

            else if (i=='='){
                stateNumber=0;
                lookahead++;
                scannerOutput.add("=");
                System.out.println("= added");
            }

            else if ((i=='1'||i=='2'||i=='3'||i=='4'||i=='5'||
                    i=='6'||i=='7'||i=='8'||i=='9')&&stateNumber==0){
                stateNumber=1;
                scannerOutput.add("number");
                System.out.println("number added");
                lookahead++;
            }
            else if ((i=='1'||i=='2'||i=='3'||i=='4'||i=='5'||
                    i=='6'||i=='7'||i=='8'||i=='9')&&stateNumber==1){
                lookahead++;
            }
            else if (stateNumber==1&&(i!='1'&&i!='2'&&i!='3'&&i!='4'&&i!='5'&&
                    i!='6'&&i!='7'&&i!='8'&&i!='9'&&i!=' ')){
                System.out.println("error in scanning : numbers should not be fallow by characters!!");
                System.exit(1);
            }
            else if (stateNumber==0&&(i!='1'&&i!='2'&&i!='3'&&i!='4'&&i!='5'&&
                    i!='6'&&i!='7'&&i!='8'&&i!='9'&&i!=' ')){
                lookahead++;
                stateNumber=2;
                scannerOutput.add("id");
                System.out.println("id found");
            }
            else if (stateNumber==2){
                lookahead++;
            }

//            else if (i =='('){
//                stateNumber=0;
//                lookahead++;
//                scannerOutput.add("(");
//                System.out.println("( added");
//            }
//            else if (i ==')'){
//                stateNumber=0;
//                lookahead++;
//                scannerOutput.add(")");
//                System.out.println(") added");
//            }
//            else if (inputBuffer[lookahead]=='i'&&stateNumber==0){
//                stateNumber=1;
//                lookahead++;
//                System.out.println("i found");
//            }
//            else if (inputBuffer[lookahead]=='f'&&stateNumber==1){
//                stateNumber=2;
//                lookahead++;
//                System.out.println("f found");
//            }
//            else if (inputBuffer[lookahead]==' '&&stateNumber==2){
//                stateNumber=0;
//                lookahead++;
//                scannerOutput.add("if");
//                System.out.println("if found");
//                System.out.println(stateNumber);
//            }
//
//            else if (inputBuffer[lookahead]=='e'&&stateNumber==0){
//                stateNumber=1;
//            }

        }


        return this.scannerOutput;
    }

    public void printScannerOutput(){
        System.out.print("scanner result is: ");
        for (int i=0;i<this.scannerOutput.size();i++){
            System.out.print(scannerOutput.get(i)+" ");
        }

    }
}
