package com.example.m6_01;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private AirportView airportView;
    private TextView stepsTextView, collisionsTextView;
    private int steps = 0;
    private int collisions = 0;
    private java.util.Stack<List<Airplane>> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        airportView = findViewById(R.id.vistaAeropuerto);
        stepsTextView = findViewById(R.id.tvPasos);
        collisionsTextView = findViewById(R.id.tvColisiones);

        findViewById(R.id.btnSiguiente).setOnClickListener(v -> nextStep());
        findViewById(R.id.btnAnterior).setOnClickListener(v -> previousStep());
    }

    private void nextStep() {
        if (hasCollidedAirplanes() || hasBorderAirplanes()) {
            removeCollidedAndBorderAirplanes();
        } else {
            List<Airplane> newAirplanes = calculateNewPositions();
            detectCollisions(newAirplanes);
            markBorderAirplanes(newAirplanes);
            if (history == null) history = new java.util.Stack<>();
            history.push(new ArrayList<>(airportView.getAirplanes()));
            airportView.setAirplanes(newAirplanes);
            steps++;
            updateCounters();
            airportView.invalidate();
        }
    }

    private boolean hasCollidedAirplanes() {
        for (Airplane airplane : airportView.getAirplanes()) {
            if (airplane.isCollided()) return true;
        }
        return false;
    }

    private boolean hasBorderAirplanes() {
        for (Airplane airplane : airportView.getAirplanes()) {
            if (airplane.isCollided() && airplane.isAtBorder(airportView.getColumns(), airportView.getRows())) return true;
        }
        return false;
    }

    private void removeCollidedAndBorderAirplanes() {
        List<Airplane> airplanes = airportView.getAirplanes();
        airplanes.removeIf(Airplane::isCollided);
        airportView.setAirplanes(airplanes);
        airportView.invalidate();
    }

    private void markBorderAirplanes(List<Airplane> airplanes) {
        for (Airplane airplane : airplanes) {
            if (!airplane.isCollided() && airplane.isAtBorder(airportView.getColumns(), airportView.getRows())) {
                airplane.setCollided(true);
                airplane.setAtDestination(true);
            }
        }
    }

    private List<Airplane> calculateNewPositions() {
        List<Airplane> copy = new ArrayList<>();
        int columns = airportView.getColumns();
        int rows = airportView.getRows();
        for (Airplane original : airportView.getAirplanes()) {
            Airplane airplaneCopy = new Airplane(original.getPosX(), original.getPosY(), original.getDirection());
            airplaneCopy.move(columns, rows);
            copy.add(airplaneCopy);
        }
        return copy;
    }

    private List<Airplane> detectCollisions(List<Airplane> airplanes) {
        Map<String, List<Airplane>> positions = new HashMap<>();
        List<Airplane> collided = new ArrayList<>();
        for (Airplane airplane : airplanes) {
            String key = airplane.getPosX() + "-" + airplane.getPosY();
            positions.computeIfAbsent(key, k -> new ArrayList<>()).add(airplane);
        }
        for (List<Airplane> group : positions.values()) {
            if (group.size() > 1) {
                collisions += group.size();
                group.forEach(airplane -> {
                    airplane.setCollided(true);
                    collided.add(airplane);
                });
            }
        }
        return collided;
    }

    private void updateCounters() {
        stepsTextView.setText(getString(R.string.pasos, steps));
        collisionsTextView.setText(getString(R.string.colisiones, collisions));
    }

    private void previousStep() {
        if (history != null && !history.isEmpty()) {
            airportView.setAirplanes(history.pop());
            steps--;
            updateCounters();
            airportView.invalidate();
        }
    }
}
