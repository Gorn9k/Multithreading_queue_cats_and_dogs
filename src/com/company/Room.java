package com.company;

public class Room {
    String name;
    static final int max = 10;
    private boolean for_cat = false;    //Для кошек true, для собак false
    private boolean is_fool = false;
    private volatile boolean is_free = true;
    String[] animals_name;

    Room(String name){
        this.name = name;
    }

    public void put_in_room() {
        if (for_cat == true) {
            animals_name = new String[4];
            for (int i = 0; i < animals_name.length; i++) {
                animals_name[i] = Main.cats.poll().name;
            }
            is_fool = true;
        } else {
            animals_name = new String[2];
            for (int i = 0; i < animals_name.length; i++) {
                animals_name[i] = Main.dogs.poll().name;
            }
            is_fool = true;
        }
    }

    public static boolean isFool(){
        int i = 0;
        while(i!=max){
            i = 0;
            for (Room room : Main.rooms) {
                if(room.is_fool){
                    i++;
                }
            }
        }
        return true;
    }

    public void setIs_free(boolean bool){
        this.is_free = bool;
    }

    public boolean getIs_free(){
        return this.is_free;
    }

    public void setFor_cat(boolean bool){
        this.for_cat = bool;
    }

    public boolean getFor_cat(){
        return this.for_cat;
    }
}
