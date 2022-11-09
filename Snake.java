import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    private static final int KANAN = 0;
    private static final int KIRI = 1;
    private static final int ATAS = 2;
    private static final int BAWAH = 3;
    public int ARAH=KANAN;
    public int GRK;
    public boolean status;
    
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      gerak();
      //if(isTouching(Player.class)){
        //  MyWorld myw1 = (MyWorld)getWorld();
        //    myw1.updNyawa();
        //    setLocation(60,540); 
           //removeTouching(Player.class);
            //setImage(new GreenfootImage("isdet.jpg"));
            //setLocation(250, 300);
            //Greenfoot.stop();
          //  Greenfoot.playSound("snake.mp3");
      //  } 
    }    
    
    public void gerak()
    {
        if (!bisa_gerak(ARAH))
        {
            GRK= Greenfoot.getRandomNumber(4);
            while (GRK==ARAH)
                GRK= Greenfoot.getRandomNumber(4);
            ARAH=GRK;
        }   

            
        if (ARAH==KANAN)
        {
           setLocation(getX()+1,getY());
           if (isObstacle())
               setLocation(getX()-1,getY());
        }
        
        if (ARAH==KIRI)
        {
           setLocation(getX()-1,getY());
           if (isObstacle())
               setLocation(getX()+1,getY());
        }
        
        if (ARAH==ATAS)
        {
           setLocation(getX(),getY()-1);
           if (isObstacle())
               setLocation(getX(),getY()+1);
        }
        
        if (ARAH==BAWAH)
        {
           setLocation(getX(),getY()+1);
           if (isObstacle())
               setLocation(getX(),getY()-1);
        }
    }
    
    public int getARAH()
    {
        return ARAH;
    }
    
    public boolean bisa_gerak(int ARAH_GRK)
    {
        Actor Obstacle;
        switch (ARAH_GRK)
        {
            case KANAN : Obstacle = getOneObjectAtOffset(1,0,Obstacle.class);
                         if (Obstacle!=null || getX()==9) status=false; else status=true; break;
            
            case KIRI  : Obstacle = getOneObjectAtOffset(-1,0,Obstacle.class);
                         if (Obstacle!=null || getX()==0) status=false; else status=true; break;
            
            case ATAS  : Obstacle = getOneObjectAtOffset(0,-1,Obstacle.class);
                         if (Obstacle!=null || getY()==0) status=false; else status=true; break;
          
            case BAWAH : Obstacle = getOneObjectAtOffset(0,1,Obstacle.class);
                         if (Obstacle!=null || getY()==6) status=false; else status=true; break;
                         
            default    : status=false;
        }
        return (status);
    }
    
    public boolean isObstacle()
    {
        Actor Obstacle = getOneObjectAtOffset(0,0,Obstacle.class);
        if (Obstacle!=null)
            return true;
        else
            return false;
    }
    
    
}
