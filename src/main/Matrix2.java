package main;

/*
    Eine einfache Klasse zur Verwaltung von 2x2-Matrizen
 */
public class Matrix2 {

    // die Werte der Matrix - wir speichern sie nicht als Array, sondern direkt in 4 Variablen

    public final float a11; // erste Zeile, erstes Element
    public final float a21; // erste Zeile, zweites Element
    public final float a12; // zweite Zeile...
    public final float a22;

    // Konstruktor - privat, zur Erzeugung wird die Factory-Methode of verwendet
    // Beispiel siehe unit (Erzeugung der Einheitsmatrix)
    private Matrix2(float a11, float a12, float a21, float a22) {
        this.a11 = a11;
        this.a21 = a21;
        this.a12 = a12;
        this.a22 = a22;
    }

    // sin und cos für float (in Java Math sind diese als double definiert, hier also Hilfsmethoden)
    private static float sin(float alpha) {
        return (float) Math.sin(alpha);
    }
    private static float cos(float alpha) {
        return (float) Math.cos(alpha);
    }

    // Factory
    public static Matrix2 of(float a11, float a12, float a21, float a22) {
        return new Matrix2(a11, a12, a21, a22);
    }

    // einige Standard-Matrizen für typische Abbildungen

    // einheitsMatrix
    public static Matrix2 unit() {
        return Matrix2.of(
                1, 0,
                0, 1
        );
    }

    // Hilfsmethode : Erzeugt eine Rotationsmatrix, siehe Skript
    public static Matrix2 rotate(float alpha) {
        return Matrix2.of(
                cos(alpha), -sin(alpha),
                sin(alpha), cos(alpha)
        ); // TODO: Hier soll eine Rotationsmatrix für den Winkel alpha erzeugt werden - verwenden Sie sin und cos (Bodenmaß!)
    }

    // Skalierung
    public static Matrix2 scale(float sx, float sy) {
        return Matrix2.of(
                1 * sx, 0,
                0, 1 * sy
        ); // TODO: Hier soll eine Skalierungsmatrix erzeugt werden
    }

    // Matrix x Matrix
    public Matrix2 mult(Matrix2 m) {
        return new Matrix2(
                this.a11 * m.a11 + this.a12 * m.a21, this.a11 * m.a12 + this.a12 * m.a22,
                this.a21 * m.a11 + this.a22 * m.a21, this.a21 * m.a12 + this.a22 * m.a22); // TODO: Implementieren Sie die Matrix-Matrix-Multiplikation
    }

    // Matrix x Vector
    public Vec2 mult(Vec2 v) {
        return Vec2.of(
                this.a11 * v.x + this.a12 * v.y,
                this.a21 * v.x + this.a22 * v.y); // TODO: Implementieren Sie die Matrix-Vektor-Multiplikation
    }

    // Vergleich zweier Matrizen
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix2 matrix2 = (Matrix2) o;

        if (Float.compare(matrix2.a11, a11) != 0) return false;
        if (Float.compare(matrix2.a21, a21) != 0) return false;
        if (Float.compare(matrix2.a12, a12) != 0) return false;
        return Float.compare(matrix2.a22, a22) == 0;
    }

    @Override
    public String toString() {
        return "Matrix2{" +
                "a11=" + a11 +
                ", a21=" + a21 +
                ", a12=" + a12 +
                ", a22=" + a22 +
                '}';
    }
}
