/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import javax.swing.JLabel;

/**
 *
 * @author kaztro
 */
public class AnimalThread extends Thread{
    private String nombre;
    private int limite;
    private JLabel animal;
    private int x;
    private int y;
    private int limiteregre;
    
    public AnimalThread(){}

    public AnimalThread(String nombre, int limite, JLabel animal, int x, int y) {
        this.nombre = nombre;
        this.limite = limite;
        this.animal = animal;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for ( int i = x ; i <= this.limite ; i += 10){
            System.out.println(this.nombre + " avanza");
            this.animal.setLocation(i, y);
            try{
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(this.nombre + "a llegado a la meta");
        
        yield();
    }
    
    
    
    
}
