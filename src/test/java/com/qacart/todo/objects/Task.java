package com.qacart.todo.objects;

public class Task {

    private boolean isCompleted;
    private String item;

    // constractor
    public Task(boolean isCompleted,String item){
        this.item= item;
        this.isCompleted=isCompleted;
    }

    public void setIsCompleted(boolean isCompleted){

        this.isCompleted= isCompleted;
    }
    public boolean getIsCompleted(){
        return isCompleted;
    }
    public void setItem(String item){
        this.item= item;

    }
    public String getItem(){
        return item;
    }
}
