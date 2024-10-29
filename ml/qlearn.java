///usr/bin/env jbang "$0" "$@" ; exit $?

//REPOS mavencentral,jitpack=https://jitpack.io
//DEPS com.github.micycle1:processing-core-4:4.3.3

import static java.lang.System.out;

import processing.core.PApplet;

public class qlearn extends PApplet {

    public static void main(String... args) {
        out.println("Start qlearn");
        PApplet.main("qlearn");
    }

    static final int N = 5;

    int[][] grid = new int[N][N];

    @Override
    public void settings() {
        size(400, 400);
    }

    @Override
    public void setup() {
        background(255);

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = count++;
            }
        }
    }

    int x(int j) {
        return (width / N) * j;
    }

    int y(int i) {
        return (height / N) * i;
    }

    int centerX(int j) {
        return (x(j) + x(j + 1)) / 2;
    }

    int centerY(int i) {
        return (y(i) + y(i + 1)) / 2;
    }

    @Override
    public void draw() {
        stroke(0);
        for (int i = 1; i < N; i++) {
            line(y(i), 0, y(i), width);
        }
        for (int j = 1; j < N; j++) {
            line(0, x(j), height, x(j));
        }

        fill(0);
        textSize(20);
        textAlign(CENTER, CENTER);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                text(grid[i][j], centerX(j), centerY(i));
            }
        }
    }
}
