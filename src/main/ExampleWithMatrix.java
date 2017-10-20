package main;

import processing.core.PApplet;

public class ExampleWithMatrix extends PApplet {

    public static final int SCREEN_X = 1024;
    public static final int SCREEN_Y = 768;
    private char lastkey = '0';

    Vec2 ex = Vec2.of(100,0);
    Vec2 ey = Vec2.of(0,100);

    public static void main(String[] args) {
        PApplet.main("main.ExampleWithMatrix");
    }

    @Override
    public void settings() {
        size(SCREEN_X,SCREEN_Y, "processing.opengl.PGraphics2D");
    }

    Matrix2 matrix = Matrix2.unit();

    @Override
    public void draw() {
        background(255);

        // mit Taste 1 kann die erste Spalte der Matrix manipuliert werden
        if (lastkey == '1') {
            ex = Vec2.of(mouseX-SCREEN_X/2, mouseY-SCREEN_Y/2);
        }

        // mit Taste 2 kann die zweite Spalte der Matrix manipuliert werden
        if (lastkey == '2') {
            ey = Vec2.of(mouseX-SCREEN_X/2, mouseY-SCREEN_Y/2);
        }

        // Matrix zusammensetzen
        matrix = Matrix2.of(ex.x/100f, ey.x/100f, ex.y/100f, ey.y/100f);

        // Kirche einmal im Original und einmal mit der Matrix abgebildet zeichnen
        church(Matrix2.unit());
        church(matrix.scale(2, 1));
        church(matrix.rotate(45));

        // die Spaltern der MAtrix als Vektor
        line(SCREEN_X/2, SCREEN_Y/2, SCREEN_X/2+ex.x, SCREEN_Y/2+ex.y);
        line(SCREEN_X/2, SCREEN_Y/2, SCREEN_X/2+ey.x, SCREEN_Y/2+ey.y);


        // Matrixwerte mit Processing-Textausgabe anzeigen
        fill(0);
        textSize(16);
        text(String.format("%.2f",matrix.a11), 400,400);
        text(String.format("%.2f",matrix.a12), 440,400);
        text(String.format("%.2f",matrix.a21), 400,430);
        text(String.format("%.2f",matrix.a22), 440,430);
    }

    private void church(Matrix2 matrix) {
        // Punkte des Polygons
        Vec2[] points = { Vec2.of(100,100), Vec2.of(120, 50), Vec2.of(140, 100), Vec2.of(250,100), Vec2.of(270,120), Vec2.of(270,180), Vec2.of(100,180) };

        // Verbindungen zeichnen. Dabei jeden Punkt abbilden
        for (int i= 0; i<points.length; i++) {
            Vec2 p1 = matrix.mult(points[i]);
            Vec2 p2 = matrix.mult(points[(i + 1) % points.length]);

            line(p1.x+SCREEN_X/2, p1.y+SCREEN_Y/2, p2.x+SCREEN_X/2, p2.y+SCREEN_Y/2);
        }
    }

    // Hilfsmethode von Processing: Tastendruck
    @Override
    public void keyTyped() {
        lastkey = key;
    }
}