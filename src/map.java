package brickbreaker0;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class map {
    public int map0 [][];
    public int brickwidth;
    public int brickheigh;
    public map( int row, int col){
        map0 = new int [row][col];
        for( int []map1 :map0){
            for( int j=0 ; j<map0[0].length;j++){
                map1[j]=1;
            }
        }
        brickwidth =540/col;
        brickheigh =150/row;
     
    }
  public void draw(Graphics2D g){
        for(int i=0; i<map0.length;i++){
            for(int j=0; j<map0[0].length;j++){
                if(map0[i][j]>0){
                    g.setColor(Color.blue);
                    g.fillRect(j*brickwidth+80, i* brickheigh+50, brickwidth,  brickheigh);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.pink);
                    g.drawRect(j*brickwidth+80, i*brickheigh+50,brickwidth,  brickheigh);
                }
            }
        }
        
       }  
  public void setBrickValue(int value,int row,int col){
      map0[row][col] = value;
  }
}
