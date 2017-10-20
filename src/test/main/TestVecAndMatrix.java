package main;

import org.junit.Test;

import static org.junit.Assert.*;


// einige unit-tests für Vektoren und Matrizen, bei weitem nicht vollständig
public class TestVecAndMatrix {
    public static final float EPSILON = 0.00001f;

    @Test
    public void testAdd() {
        assertEquals(
                Vec2.of(5,7),
                Vec2.of(1,2).add(Vec2.of(4,5)));
    }

    @Test
    public void testSub() {
        assertEquals(
                Vec2.of(0,0),
                Vec2.of(1,2).sub(Vec2.of(1,2)));
    }

    @Test
    public void testMult() {
        assertEquals(
                Vec2.of(2,4),
                Vec2.of(1,2).mult(2));
    }

    @Test
    public void testDiv() {
        assertEquals(
                Vec2.of(1,2),
                Vec2.of(2,4).div(2));
    }

    @Test
    public void testLength() {
        assertEquals(
                Math.sqrt(4+9),
                Vec2.of(2,3).length(),
                EPSILON);
    }

   @Test
    public void testUnit() {
        System.out.println(Vec2.of(2,3).unit().length());
        assertEquals(
                Vec2.of(2,3).unit().length(),
                1.0,
                EPSILON);
    }

    @Test
    public void testNeg() {
        assertEquals(
                 Vec2.of(2,3),
                 Vec2.of(-2,-3).neg());
    }

    @Test
    public void testSkalarProdukt() {
        assertEquals(
                Vec2.of(1,2).skalarProd(Vec2.of(3,4)),
                1*3+2*4,
                EPSILON);
    }

    @Test
    public void testMatrixMatrixMult() {
        Matrix2 m1 = Matrix2.of(
                1,2,
                3,4
        );

        Matrix2 m2 = Matrix2.of(
                5,6,
                7,8
        );

        Matrix2 m3 = Matrix2.of(
                19,22,
                43,50
        );

        assertEquals(
                m1.mult(m2),
                m3);
    }

    @Test
    public void testMatrixVectorMult() {
        Matrix2 m1 = Matrix2.of(
                1,2,
                3,4
        );

        Vec2 v = Vec2.of(1,2);

        assertEquals(
                m1.mult(v),
                Vec2.of(5, 11));
    }


}
