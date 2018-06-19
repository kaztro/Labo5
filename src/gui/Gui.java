package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import threads.AnimalThread;

public class Gui extends JFrame{
    private JLabel [] labels;

    private JButton inicio,restart;

    private String [] nombres = {"Canguro","tortuga","dragon"};

    public Gui(){
        super("Carrera de animales");
        initialComponents();
    }

    private void initialComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        restart = new JButton("restart");
        Container container = getContentPane();

        for(int i=0;i<3;i++){
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);
        }
        inicio.setBounds(10,0,100,30);
        container.add(inicio);

        restart.setBounds(100,0,100,30);
        container.add(restart);
        restart.setVisible(false);

        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                AnimalThread canguro = new AnimalThread("canguro",labels[0].getX()+30,labels[0].getY(),510,labels[0]);
                AnimalThread tortuga = new AnimalThread("tortuga",labels[1].getX()-100,labels[1].getY(),510,labels[1]);
                AnimalThread dragon = new AnimalThread("dragon",labels[2].getX()+60,labels[2].getY(),510,labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
                inicio.setVisible(false);
                restart.setVisible(true);
            }

        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0;i<3;i++){
                    labels[i].setLocation(10,(i*220));
                    inicio.setVisible(true);
                    restart.setVisible(false);
                }
            }

        });
        setSize(700,650);

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                new Gui().setVisible(true);
            }
        });

    }


}