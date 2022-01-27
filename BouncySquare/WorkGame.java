import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
/**
 * Class WorkGame - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class WorkGame extends Applet implements ActionListener,KeyListener,MouseListener
{
    private Image BackgroundGame;
    private Image BackgroundPic;
    private int level;
    private int xBox,yBox,xBoxinc,yBoxinc;
    private Timer timer;
    private int Charax, Charay;
    private float highBox=10; //jump height
    private boolean jumpBox=false;
    private boolean spaceBox=false;
    private boolean gravity;

    public void init()
    {
        timer=new Timer(45, this);
        timer.start();
        xBox=10;
        yBox=370;
        xBoxinc=3;
        yBoxinc=3;
        setBackground(Color.GRAY);
        BackgroundPic=getImage(getDocumentBase(),"BGpic.jpg");
        BackgroundGame=getImage(getDocumentBase(),"BGgame.gif");

        addKeyListener(this);
    }

    public void keyReleased(KeyEvent ke){
        if (ke.getKeyCode()==KeyEvent.VK_SPACE){
            spaceBox=false;

        }
    }

    public void keyPressed(KeyEvent ke){
        if (ke.getKeyCode()==KeyEvent.VK_ENTER){
            level=1;

        }
        if (ke.getKeyCode()==KeyEvent.VK_RIGHT){
            xBox+=xBoxinc;

        }
        if (ke.getKeyCode()==KeyEvent.VK_LEFT){
            xBox-=xBoxinc;
        }
        if (ke.getKeyCode()==KeyEvent.VK_SPACE){
            spaceBox=true;

        }
    }

    public void keyTyped(KeyEvent ke){
    }

    public void mouseExited(MouseEvent ke){
    }

    public void mouseEntered(MouseEvent ke){
    }

    public void mouseReleased(MouseEvent ke){
    }

    public void mousePressed(MouseEvent ke){
    }

    public void mouseClicked(MouseEvent ke){

    }

    public void actionPerformed(ActionEvent ae){
        repaint();
    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object fovr this applet
     */
    public void paint(Graphics g)
    {

        if(level==0){
            g.drawImage(BackgroundPic,0,0,499,499,this);

            g.setFont(new Font("Serif",Font.ITALIC,24));
            g.drawString("Bouncy Ball", 150, 150);
            g.drawString("Press Enter To Play", 150, 260);

        }
        if(level==1){
            g.drawImage(BackgroundGame,0,0,499,499,this);

            g.setColor(Color.GREEN);
            g.fillRect(0,410,500,10);
            g.setColor(Color.RED);
            g.fillRect(0,420,500,70);
            g.drawRect(0,420,20,20);
            g.setColor(Color.MAGENTA);
            g.fillRect(xBox,yBox-6,45,45);

            //             //FIRSt CHARACTER
            //             g.setColor(Color.WHITE); //first eye
            //             g.fillOval(xBox+9,yBox+7,9,10);
            //             
            //             g.setColor(Color.BLACK); //circle in eye
            //             g.fillOval(xBox+9,yBox+11,9,6);
            //             
            //             g.setColor(Color.WHITE); //second eye
            //             g.fillOval(xBox+28,yBox+7,9,10);
            //             
            //             g.setColor(Color.BLACK); //circle in eye
            //             g.fillOval(xBox+28,yBox+11,9,6);
            //             
            //             g.setColor(Color.WHITE); //mouth
            //             g.fillArc(xBox+9,yBox+18,28,11,360,-180);
            //             

            //SECOND CHARACTER
            g.setColor(Color.WHITE); //first eye
            g.fillOval(xBox+9,yBox+7,9,10);

            //circle in eye
            g.setColor(Color.BLACK);
            g.fillOval(xBox+12,yBox+8,7,9);

            g.setColor(Color.WHITE); //second eye
            g.fillOval(xBox+28,yBox+7,9,10);

            //circle in eye
            g.setColor(Color.BLACK);
            g.fillOval(xBox+31,yBox+8,7,9);

            g.setColor(Color.WHITE); //mouth
            g.fillArc(xBox+11,yBox+20,25,6,360,-180);

            //STAR
            g.setColor(Color.YELLOW);
            Polygon p2=new Polygon();
            p2.addPoint(90,225); // TOP POINT 1
            p2.addPoint(83,240); //
            p2.addPoint(66,240); //TOP POINT 2
            p2.addPoint(80,250); //
            p2.addPoint(75,265); //TOP POINT 3
            p2.addPoint(90,255); //
            p2.addPoint(106,265); //TOP POINT 4
            p2.addPoint(100,250); //
            p2.addPoint(115,240); //TOP POINT 5
            p2.addPoint(97,240); 
            g.fillPolygon(p2);

            
            
            g.setColor(Color.BLACK); //dont switch y values of the ground points
            Polygon p3=new Polygon();
            p3.addPoint(150,410); //1
            p3.addPoint(165,395); //2
            p3.addPoint(180,410); //3
            p3.addPoint(195,395); //first
            p3.addPoint(210,410); //Second
            //p3.addPoint(290,390);
            //p3.addPoint(320,410);
            p3.addPoint(330,410);
            p3.addPoint(345,395);
            p3.addPoint(360,410);

            p3.addPoint(475,410);
            p3.addPoint(487,395);
            p3.addPoint(500,410);
            g.fillPolygon(p3);
            //First character
            //             g.setColor(Color.MAGENTA); //the square
            //             g.fillRect(xBox,yBox,100,100);
            //             g.setColor(Color.WHITE); //first eye
            //             g.fillOval(xBox+20,yBox+25,25,25);
            //             g.setColor(Color.BLACK); 
            //             g.fillOval(xBox+63,yBox+35,17,15); //circle in eye
            //             //g.setColor(Color.BLACK);
            //             //g.fillArc(Charax+60,Charay+33,25,20,360,90); //arc of eye
            //             g.setColor(Color.WHITE);//second eye
            //             g.fillOval(xBox+56,yBox+25,25,25);
            //             g.setColor(Color.BLACK);
            //             g.fillOval(xBox+63,yBox+35,17,15); //circle in eye
            //             //g.setColor(Color.BLACK);
            //             //g.fillArc(Charax+20,Charay+33,25,20,360,-180); //arc of eye
            //             g.setColor(Color.WHITE);
            //             g.fillArc(xBox,yBox,50,30,360,-180); //mouth

            //             //SECOND CHARACTER
            //             g.setColor(Color.MAGENTA); //the square
            //             g.fillRect(Charax,Charay,100,100);
            //             g.setColor(Color.WHITE); //first eye
            //             g.fillOval(Charax+20,Charay+25,25,25);
            //             // g.fillArc(Charax+20,Charay+33,25,20,360,-180); //arc of eye
            //             //g.setColor(Color.WHITE);
            //             g.setColor(Color.BLACK);
            //             g.fillOval(Charax+24,Charay+35,17,15);
            //             g.setColor(Color.WHITE);//second eye
            //             g.fillOval(Charax+58,Charay+25,25,25);
            //             // g.setColor(Color.BLACK);
            //             // g.fillArc(Charax+56,Charay+33,25,20,360,-180); //arc of eye
            //             g.setColor(Color.BLACK);
            //             g.fillOval(Charax+62,Charay+35,17,15); //circle in eyes
            //             g.setColor(Color.WHITE);
            //             g.fillArc(27,65,50,10,360,-180); //mouth
            if(xBox>480){
                level=4;
            }
            //JUMP EQUATION
            if (spaceBox==true && !jumpBox){    // jumping 

                jumpBox= true;

            }
            if (jumpBox){

                yBox-=highBox;
                highBox-=20;
                xBox+=10;

            }
            if (yBox>=350){      //ground is the point you won’t go below

                highBox=100;
                jumpBox=false;
            }
        }
        if(level==2){
            g.setColor(Color.WHITE);
            g.drawString("OH NO",150,150);
        }
        if(level==3){
            g.setColor(Color.WHITE);
            g.drawString("YOU WON",150,150);

        }
        if(level==4){
            g.setColor(Color.GREEN);
            g.fillRect(0,410,500,10);
            g.setColor(Color.RED);
            g.fillRect(0,420,500,70);
            g.drawRect(0,420,20,20);
            g.setColor(Color.BLACK);
            g.drawRect(xBox,yBox,40,40);
            g.setColor(Color.BLACK);
        }

    }
}
