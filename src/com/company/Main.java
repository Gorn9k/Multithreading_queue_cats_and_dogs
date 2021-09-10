package com.company;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static Queue<Cat> cats = new ArrayDeque(Cat.max);
    static Queue<Dog> dogs = new ArrayDeque(Dog.max);
    static Room[] rooms = new Room[Room.max];

    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            cats.add(new Cat("Барсик " + (i + 1)));
            dogs.add(new Dog("Собака " + (i + 1)));
        }
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room("комната " + (i + 1));
        }
        new MyThread("cat").start();
        new MyThread("dog").start();
        if(Room.isFool()){
        for (Room room : rooms) {
            if(room.getFor_cat()){
                for (String name : room.animals_name) {
                    System.out.println("В " + room.name + " находится кошка по кличке " + name);
                }
            }
            else{
                for (String name : room.animals_name) {
                    System.out.println("В " + room.name + " находится собака по кличке " + name);
                }
            }
            System.out.println("-------------------------------------------------");
        }
        }
    }
}

