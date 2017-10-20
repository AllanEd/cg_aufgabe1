package main;

public class Vec2 {
    /**
     * Vektoren sind unveränderlich - jede Rechenoperation erzeugt einen neuen Vektor
     * x und y werden also bei Kontstruktion einmal gesetzt und sind dann unveränderlich
     */
    public final float x;
    public final float y;

    /**
     * Konstruktor privat - wir nutzen eine einfache Factory-Methode of zur Erzeugung
     */
    private Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Factory-Methode:
     *
     *     Vec2 v = Vec2.of(2,3);
     *
     *  erzeugt den Vektor (2,3)
     */
    public static Vec2 of(float x, float y) {
        return new Vec2(x,y);
    }

    // Implementieren Sie die folgenden Methoden

    public Vec2 add(Vec2 other) {
        return new Vec2(this.x + other.x, this.y + other.y); // TODO: implementieren Sie die Vektoraddition - geben Sie ein neues Vektorobjekt zurück!
    }

    public Vec2 sub(Vec2 other) {
        return this.add(other.mult(-1)); // TODO: Subtraktion - Tipp: Vielleicht können Sie diese Operation mit Hilfe von add und mult ausdrücken?
    }

    public Vec2 mult(float d) {
        return new Vec2(this.x * d, this.y * d); // TODO Multiplikation mit einer Zahl / Skalierung
    }

    public Vec2 div(float d) {
        return this.mult(1 / d); // TODO Division: Tipp - kann durch Multiplikation ausgedrückt werden
    }

    public Vec2 neg() {
        return new Vec2(this.x * -1, this.y * -1); // TODO Negation (ein Vektor der gleichen Länge, der in die umgekehrte Richtung weist.)
    }

    public float length() {
        double powX = Math.pow(this.x, 2);
        double powY = Math.pow(this.y, 2);
        return (float)Math.sqrt(powX + powY); // TODO Länge berechnen. Nutzen Sie Math.sqrt, aber Vorsicht, unsere Vektoren rechnen mit float
    }

    public Vec2 unit() {
        float l = this.length();
        return new Vec2(this.x / l, this.y / l); // TODO: Normieren eines Vektors (so umrechnen, dass der Vektor die Länge 1 hat, aber die Richtung nicht ändert)
    }

    // Skalarprodukt
    public float skalarProd(Vec2 other) {
        return this.x * other.x + this.y * other.y; // TODO Berechnen Sie das Skalarprodukt
    }


    /**
     * String-Darstellung für Debug-Ausgabe
     */
    @Override
    public String toString() {
        return "Vec2 {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * wie genau vergleichen wir? Wird in der equals-Methode verwendet
     */
    private static final float EPSILON = 0.0001f;

    /**
     * Vergleich mit anderen Vektoren
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vec2 vec2 = (Vec2) o;

        if (Math.abs(vec2.x -  x) > EPSILON) return false;
        return Math.abs(vec2.y -  y) < EPSILON;
    }
}
