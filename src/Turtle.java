import java.awt.*;

public class Turtle {
    public double Angle,
            LPX, LPY;
    private double WX1, WY1, WX2, WY2,
            VX1, VY1, VX2, VY2,
            FACTX, FACTY;
    private Graphics g;

    public Turtle() {
        Angle = 0;
        LPX = LPY = 0;
    }

    public void setGraphics(Graphics g) {
        this.g = g;
    }

    public Graphics getGraphics() {
        return g;
    }

    public void view(int x1, int y1, int x2, int y2) {
        g.setClip(x1, y1, x2 - x1, y2 - y1);
        VX1 = (double) x1;
        VY1 = (double) y1;
        VX2 = (double) x2;
        VY2 = (double) y2;
        FACTX = (VX2 - VX1) / (WX2 - WX1);
        FACTY = (VY2 - VY1) / (WY2 - WY1);
    }

    public void window(double x1, double y1, double x2, double y2) {
        WX1 = x1;
        WY1 = y1;
        WX2 = x2;
        WY2 = y2;
        FACTX = (VX2 - VX1) / (WX2 - WX1);
        FACTY = (VY2 - VY1) / (WY2 - WY1);
    }

    public void warp(double l) {
        LPX = LPX + l * Math.cos(Math.toRadians(Angle));
        LPY = LPY + l * Math.sin(Math.toRadians(Angle));
    }

    public void move(double l) {
        double x, y, x1, y1, x2, y2;
        x = LPX + l * Math.cos(Math.toRadians(Angle));
        y = LPY + l * Math.sin(Math.toRadians(Angle));
        x1 = (LPX - WX1) * FACTX + VX1;
        y1 = (WY2 - LPY) * FACTY + VY1;
        x2 = (x - WX1) * FACTX + VX1;
        y2 = (WY2 - y) * FACTY + VY1;
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        LPX = x;
        LPY = y;
    }

    public void moveto(double x, double y) {
        double x1, y1, x2, y2;
        x1 = (LPX - WX1) * FACTX + VX1;
        y1 = (WY2 - LPY) * FACTY + VY1;
        x2 = (x - WX1) * FACTX + VX1;
        y2 = (WY2 - y) * FACTY + VY1;
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        LPX = x;
        LPY = y;
    }

    public void setpoint(double x, double y) {
        LPX = x;
        LPY = y;
    }

    public void pset(double x, double y) {
        setpoint(x, y);
        moveto(x, y);
    }

    public void line(double x1, double y1, double x2, double y2) {
        setpoint(x1, y1);
        moveto(x2, y2);
    }

    public void turn(double a) {
        Angle = Angle + a;
        Angle = Angle - (int) Angle + ((int) Angle % 360);
    }

    public void setangle(double a) {
        Angle = a;
    }
}
