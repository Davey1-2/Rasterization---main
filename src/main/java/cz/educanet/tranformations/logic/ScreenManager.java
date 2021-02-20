package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;
import cz.educanet.tranformations.presentation.Window;

import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) {

        // ABY TO NA ME NEŘVALO
        if (selectedPoints.size() < 3) {
            return false;
        }

        //INPUTY PRO BODY
        Coordinate[] coords = selectedPoints.toArray(new Coordinate[]{});

        Coordinate cord1 = coords[0];
        Coordinate cord2 = coords[1];
        Coordinate cord3 = coords[2];

        // MUJ HUMUS
        double a = 0;
        double b = 0;
        double y = 0;

        double a2 = 0;
        double b2 = 0;
        double y2 = 0;

        double a3 = 0;
        double b3 = 0;
        double y3 = 0;

        // HUMUS COORDINACE
        double cord1Y = cord1.getY();
        double cord1X = cord1.getX();
        double cord2Y = cord2.getY();
        double cord2X = cord2.getX();
        double cord3Y = cord3.getY();
        double cord3X = cord3.getX();

        //NEJAKY TRAPNY BOOLEANY
        boolean first = false;
        boolean second = false;
        boolean third = false;

        //NEJAKY TRAPNY ROVNICE
        a = (cord2Y - cord1Y) / (cord2X - cord1X);
        b = cord1Y - a * cord1X;


        a2 = (cord3Y - cord2Y) / (cord3X - cord2X);
        b2 = cord2Y - a2 * cord2X;


        a3 = (cord1Y - cord3Y) / (cord1X - cord3X);
        b3 = cord3Y - a3 * cord3X;

        // EQUASION 1 BOTH SIDES START
        if (cord3Y > a * cord3Y + b) {
            if (coordinate.getY() > a * coordinate.getX() + b) {
                first = true;
            }
        }

        if (cord3Y < a * cord3Y + b) {
            if (coordinate.getY() < a * coordinate.getX() + b) {
                first = true;
            }
        }
        // EQUASION 1 BOTH SIDES END

        // EQUASION 2 BOTH SIDES START
        if (cord1Y > a2 * cord1X + b2) {
            if (coordinate.getY() > a2 * coordinate.getX() + b2) {
                second = true;
            }
        }

        if (cord1Y < a2 * cord1X + b2) {
            if (coordinate.getY() < a2 * coordinate.getX() + b2) {
                second = true;
            }
        }
        // EQUASION 2 BOTH SIDES END

        // EQUASION 3 BOTH SIDES START
        if (cord2Y > a3 * cord2X + b3) {
            if (coordinate.getY() > a3 * coordinate.getX() + b3) {
                third = true;
            }
        }

        if (cord2Y < a3 * cord2X + b3) {
            if (coordinate.getY() < a3 + coordinate.getX() + b3) {
                third = true;
            }
        }
        // EQUASION 3 BOTH SIDES END

        // IF STATEMENT - RETURN
        if (first && second && third) {
            return true;
        }

        return false;
    }
}