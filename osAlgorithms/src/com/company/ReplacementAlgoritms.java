package com.company;


import java.util.ArrayList;

public class ReplacementAlgoritms {
    private int cap=10;
    private ArrayList<Page> memory = new ArrayList<>(cap);
    private int useBitePointer;

    public void optimalRemove(Page page){
        int removalIndex=0;
        for (int i=1;i<=memory.size();i++){
            if (memory.get(removalIndex).getNextNeedTime()<memory.get(i).getNextNeedTime()){
                removalIndex=i;
            }
        }
        memory.remove(removalIndex);
        memory.add(page);
    }



    public void lruRemove(Page page){
        int removalIndex=0;
        for (int i=1;i<=memory.size();i++){
            if (memory.get(removalIndex).getLastTimeUsed()>memory.get(i).getLastTimeUsed()){
                removalIndex=i;
            }
        }
        memory.remove(removalIndex);
        memory.add(page);
    }



    public void clockRemoval(Page page){
        boolean havePlace = false;
        while (!havePlace){
            int index = useBitePointer%cap;
            if (this.memory.get(index).getUsebite()==1){
                this.memory.get(index).setUsebite(0);
                this.useBitePointer++;
            }
            else{
                this.memory.remove(index);
                page.setUsebite(1);
                memory.add(page);
                havePlace=true;
                useBitePointer++;
            }
        }
    }

}
