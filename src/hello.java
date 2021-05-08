import java.awt.*;
import java.util.*;
import javax.swing.*;
public class hello extends JFrame{
    MyPanel mp = null ;

    public static void main(String args[]){
        hello qwe = new hello();

        System.out.println("000");
    }

    public hello()
    {
        mp = new MyPanel();

        this.add(mp);
        this.setSize(400,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
class MyPanel extends JPanel	//我自己的面板，用於繪圖和實現繪圖區域
{
    private Turtle t;
    public MyPanel()
    {
        t = new Turtle();
        setBackground(Color.black);
    }

    //覆蓋JPanel的paint方法
    //Graphics是繪圖的重要類，可以理解成一支畫筆
    public void paint(Graphics g)
    {
        //1.呼叫父類函式完成初始化
        super.paint(g);		//這句話不能少
        //System.out.println("被呼叫");		//證明別調用

        g.setColor(Color.yellow);
        t.setGraphics(g);
        t.window(0, 0, getSize().width, getSize().height);
        t.view(0, 0, getSize().width, getSize().height);
        t.setpoint(100, 150);
        t.setangle(0);
        for (int i = 1; i <= 4; i++) {
            stech(4, 2, t);
            t.turn(90);
        }

    }
    public void stech(int n, double leng, Turtle t) {
        if (n == 0) {
            t.move(leng);
        } else {
            stech(n - 1, leng, t);
            t.turn(-90);
            stech(n - 1, leng, t);
            t.turn(90);
            stech(n - 1, leng, t);
            t.turn(90);
            stech(n - 1, leng, t);
            t.turn(-90);
            stech(n - 1, leng, t);
        }
    }
}
