package com.company;


import java.util.ArrayList;

public class Parser {
    private ArrayList<String>tokens=null;
    private int lookAhead=0;
    private int state=0;

    public Parser(ArrayList<String> token) {
        this.tokens = token;
    }

    public boolean pars(){
        int size = tokens.size();
        boolean answer=false;
        System.out.println("parsing starts now!!");
        while (lookAhead<size){
            String i = tokens.get(lookAhead);

            if (state==0&&i.equals("id")){
                lookAhead++;
                state=1;
                System.out.println("going state 1 in parsing");
            }
            else if (state==1&&i.equals("=")){
                lookAhead++;
                state=2;
                System.out.println("going state 2 in parsing");
            }
            else if (state==2&&(i.equals("id")||i.equals("number"))){
                lookAhead++;
                state=3;
                System.out.println("going state 3 in parsing");
            }
            else if (state==3&&i.equals("operand")){
                lookAhead++;
                state=4;
                System.out.println("going state 4 in parsing");
            }

            else if (state==4&&(i.equals("id")||i.equals("number"))){
                lookAhead++;
                state=3;
                System.out.println("going state 3 in parsing");
            }
            //error-----------------------------------------------------------------------
            else if (state==0&&(i.equals("number")||i.equals("=")||i.equals("operand"))){
                System.out.println("cant start assignment with = or number or operand!!");
                break;
            }
            else if (state==1&&!i.equals("=")){
                System.out.println("need a = after using an id in assignment");
                break;
            }
            else if (state==2&&i.equals("operand")){
                System.out.println("cant use operand after using =");
            }
            else if (state==4&&(i.equals("operand"))){
                System.out.println("cant use two operands back to back");
                state=10;
                break;
            }
            else if (state==3&&(i.equals("id")||i.equals("number"))){
                System.out.println("can fallow a id or number with another id or number!!");
                state=10;
                break;
            }
            else if (state!=1&&i.equals("=")){
                System.out.println("cant have two = in one assignment");
                state=10;
                break;
            }
        }
        if (state==2){
            System.out.println("answer : you need to assign your id to something!!");
        }
        else if (this.state==3){
            answer=true;
        }
        else if (state==4){
            System.out.println("answer : you have to add a number or id after using operand!!");
        }

        return answer;
    }
}
