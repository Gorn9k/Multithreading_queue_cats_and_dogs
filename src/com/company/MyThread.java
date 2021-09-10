package com.company;

public class MyThread implements Runnable{
    Thread t;
    String for_animal;

    MyThread(String for_animal){
        t = new Thread(this);
        this.for_animal = for_animal;
    }

    @Override
    public void run() {
        for (Room room : Main.rooms) {
            if (room.getIs_free() == true){
                room.setIs_free(false);
                if(for_animal.equals("cat")){
                    room.setFor_cat(true);
                }
                else if (for_animal.equals("dog")){
                    room.setFor_cat(false);
                }
                room.put_in_room();
                System.out.println("Животное " + for_animal + " успешно заняло и заполнело " + room.name);
            }
            else {
                System.out.println("Животному " + for_animal + " не получилось занять " + room.name);
            }
        }
    }

    public void start(){
        this.t.start();
    }
}
