package com.example.m6_01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AirportView extends View {
    private int cellSize = 100;
    private List<Airplane> airplanes = new ArrayList<>();
    private int columns = 10;
    private int rows = 10;

    public AirportView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeAirplanes();
    }

    private void initializeAirplanes() {
        airplanes.clear();
        int airplaneCount = 20; // Más aviones
        java.util.Random random = new java.util.Random();
        // Usar una lista de posiciones posibles para evitar superposición y distribuir mejor
        List<int[]> posiciones = new ArrayList<>();
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                posiciones.add(new int[]{x, y});
            }
        }
        // Mezclar las posiciones
        java.util.Collections.shuffle(posiciones, random);
        for (int i = 0; i < airplaneCount && i < posiciones.size(); i++) {
            int[] pos = posiciones.get(i);
            Airplane.Direction direction = Airplane.Direction.values()[random.nextInt(Airplane.Direction.values().length)];
            airplanes.add(new Airplane(pos[0], pos[1], direction));
        }
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        if (airplanes == null) {
            this.airplanes = new ArrayList<>();
        } else {
            this.airplanes = airplanes;
        }
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cellSize = Math.min(w / columns, h / rows);
        columns = w / cellSize;
        rows = h / cellSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGrid(canvas);
        drawAirplanes(canvas);
    }

    private void drawGrid(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        for (int i = 0; i <= columns; i++) {
            int x = i * cellSize;
            canvas.drawLine(x, 0, x, rows * cellSize, paint);
        }
        for (int i = 0; i <= rows; i++) {
            int y = i * cellSize;
            canvas.drawLine(0, y, columns * cellSize, y, paint);
        }
    }

    private void drawAirplanes(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(4);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(cellSize * 0.7f);
        for (Airplane airplane : airplanes) {
            int x = airplane.getPosX() * cellSize + cellSize / 2;
            int y = airplane.getPosY() * cellSize + cellSize / 2 + (int) (cellSize * 0.25f);
            if (airplane.isAtDestination()) {
                paint.setColor(Color.GREEN);
            } else if (airplane.isCollided()) {
                paint.setColor(Color.RED);
            } else {
                paint.setColor(Color.BLUE);
            }
            float angle = 0;
            switch (airplane.getDirection()) {
                case NORTH: angle = 0; break;
                case EAST: angle = 90; break;
                case SOUTH: angle = 180; break;
                case WEST: angle = 270; break;
            }
            canvas.save();
            canvas.rotate(angle, x, y - (int) (cellSize * 0.25f));
            if (airplane.isCollided() || airplane.isAtDestination()) {
                // Dibuja un círculo relleno
                float radio = cellSize * 0.3f;
                canvas.drawCircle(x, y - (int) (cellSize * 0.25f), radio, paint);
            } else {
                // Dibuja la letra "A" como antes
                canvas.drawText("A", x, y, paint);
            }
            canvas.restore();
        }
    }
}
