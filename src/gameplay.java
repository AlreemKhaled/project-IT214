package brickbreaker0;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import javax.swing.Timer;


public abstract class gameplay extends JPanel implements KeyListener,ActionListener {
    private boolean play=false;
    private int score=0;
    private int totalBricks=21;
    private  Timer timer;
    private int delay =8;
    private int playerx=310;
    private int ballpoxX=120;
     private int ballpoxY=350;
     private int ballXDir=-1;
      private int ballYDir=-2;
      private map map0;
      
      public gameplay(){
          map0=new map(3,7);
          addKeyListener(this);
          setFocusable(true);
          setFocusTraversalKeysEnabled(false);
           timer =new Timer(delay,this);
           timer.start();
      }
      public void paint(Graphics g){
          g.setColor(Color.pink);
          g.fillRect(1, 1, 692, 592);
          map0.draw((Graphics2D) g);
          g.setColor(Color.yellow);
          g.fillRect(0, 0, 3, 592);
          g.fillRect(0, 0, 692, 3);
          g.fillRect(691, 0, 3, 592);
          g.setColor(Color.white);
          g.setFont(new Font("serif",Font.BOLD,25));
          g.drawString(""+score, 590, 30);
          g.setColor(Color.green);
          g.fillRect(playerx, 550, 100, 8);
          g.setColor(Color.red);
          g.fillOval(ballpoxX, ballpoxY, 20, 20);
          if(ballpoxY>570){
              play=false;
              ballXDir=0;
              ballYDir=0;
              g.setColor(Color.white);
              g.setFont(new Font("serif",Font.BOLD,30));
              g.drawString("Game Over Score : "+score, 190, 300);
              g.setFont(new Font("serif",Font.BOLD,30));
              g.drawString("Press Enter to Restart", 190, 340);
              
          }
          if(totalBricks==0){
              play=false;
              ballYDir=-2;
              ballXDir=-1;
              g.setColor(Color.red);
              g.setFont(new Font("serif",Font.BOLD,30));
              g.drawString("Game Over Score : "+score, 190, 300);
              g.setFont(new Font("serif",Font.BOLD,30));
              g.drawString("Press Enter to Restart", 190, 340);
          }
          g.dispose();
      }
       @Override
            public void actionPerformed(ActionEvent ke) {
                timer.start();
        if(play){
            if(new Rectangle(ballpoxX,ballpoxY,20,20).intersects(new Rectangle(playerx,550,100,8))) {
                ballYDir= -ballYDir;
            }  
            A:
            for(int i=0; i<map0.map0.length;i++){
                for(int j=0; j<map0.map0[0].length;j++){
                    if(map0.map0[i][j]>0){
                        int brickX=j*map0.brickwidth+80;
                        int brickY=i*map0.brickheigh+50;
                        int brickWidth=map0.brickwidth;
                        int brickHeigh=map0.brickheigh;
                        
                        Rectangle rect =new Rectangle(brickX,brickY,brickWidth,brickHeigh);
                         Rectangle ballrect =new Rectangle(ballpoxX,ballpoxY,20,20);
                         Rectangle brickrect = rect;
                         if(ballrect.intersects(brickrect)){
                             map0.setBrickValue(0, j, j);
                             totalBricks--;
                             score+=5;
                             if(ballpoxX+19 <= brickrect.x || ballpoxX+1 >=brickrect.x+brickWidth){
                                 ballXDir =-ballXDir;                                 
                            }else{
                                 ballYDir =-ballYDir;
                             }
                             break A;
                         }
                    }
                }
            }
            ballpoxX+=ballXDir;
            ballpoxY+=ballYDir;
            if(ballpoxX<0){
                ballXDir=- ballXDir;
            }
            if(ballpoxY<0){
                 ballYDir=- ballYDir;
            }
              if(ballpoxX> 670){
                   ballXDir=- ballXDir;
              }
             }
        repaint();
     }
            @Override
            public void keyPressed(KeyEvent ke) {
                 
         if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
             if(playerx>=600){
                 playerx=600;
             }else{
                 moveRight();
             }
         }
         if(ke.getKeyCode() == KeyEvent.VK_LEFT){
              if(playerx<10){
                  playerx=10;                 
              }else{
                  moveLeft();
              }
         }
         if(ke.getKeyCode() == KeyEvent.VK_ENTER){
             if(!play){
                 ballpoxX=120;
                 ballpoxY=350;
                 ballXDir=-1;
                 ballYDir=-2;
                 score=0;
                 playerx=310;
                 totalBricks=21;
                 map0=new map(3,7);
                 repaint();
             }
         }
      }
      public void moveRight(){
          play=true;
          playerx+=20;
      }
       public void moveLeft(){
              play=true;
          playerx-=20;
      }
            

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }

           
                   @Override
            public void keyTyped(KeyEvent ke) {
                
            }
};
        

    

          
      
         
        
