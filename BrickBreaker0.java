
package brickbreaker0;

import javax.swing.JFrame;

public class BrickBreaker0 {
    public static void main(String[] args){
        JFrame obj1 =new JFrame();
        gameplay game = new gameplay() {};
   
        obj1.setBounds(20,10,700,600);
        obj1.setTitle("Brick Breaker Game");
        obj1.setResizable(false);
        obj1.setVisible(true);
        obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj1.add(game);
    }
}
  
  

