package pgdp.security;

import java.util.Objects;

public class LightPanel extends SignalPost {


    private final String[] farbeDown = new String[]{"green", "blue", "yellow", "doubleYellow", "[SC]", "red", "end"};

    public LightPanel(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {
        switch (type) {
            case "green":
                if (getLevel() == 0) {
                    setLevel(1);
                    setDepiction("green");
                    return true;
                }
                else {
                    return false;
                }
            case "blue":
                if (getLevel() == 0 || Objects.equals(getDepiction(), "green")) {
                    setLevel(1);
                    setDepiction("blue");
                    return true;
                }
                else {
                    return false;
                }
            case "yellow":
                if (getLevel() == 0 || getLevel() == 1) {
                    setLevel(2);
                    setDepiction("yellow");
                    return true;
                }
                else {
                    return false;
                }
            case "doubleYellow":
                if (getLevel() == 0 || getLevel() == 1 || getLevel() == 2) {
                    setLevel(3);
                    setDepiction("doubleYellow");
                    return true;
                }
                else {
                    return false;
                }
            case "[SC]":
                if (getLevel() == 0 || getLevel() == 1 || getLevel() == 2 || Objects.equals(getDepiction(), "doubleYellow")) {
                    setLevel(3);
                    setDepiction("doubleYellow");
                    return true;
                }
                else {
                    return false;
                }
            case "red":
                if (getLevel() == 0 || getLevel() == 1 || getLevel() == 2 || getLevel() == 3) {
                    setLevel(4);
                    setDepiction("red");
                    return true;
                }
                else {
                    return false;
                }
            case "end":
                if (getLevel() == 0 || getLevel() == 1 || getLevel() == 2 || getLevel() == 3 || getLevel() == 4) {
                    setLevel(5);
                    setDepiction("yellow");
                    return true;
                }
                else {
                    return false;
                }
            default:
                return false;
        }
    }

    @Override
    public boolean down(String type) {
        switch (type) {
            case "clear":
                if (getLevel() == 0 && Objects.equals(getDepiction(), "")) {
                    return false;
                }
                else {
                    setLevel(0);
                    setDepiction("");
                    return true;
                }
            case "green":
                if (Objects.equals(getDepiction(), "green")) {
                    setLevel(0);
                    setDepiction("");
                    return true;
                }
               else {
                   return false;
                }
            case "blue":
                if (Objects.equals(getDepiction(), "blue")) {
                    setLevel(0);
                    setDepiction("");
                    return true;
                }
                else {
                    return false;
                }
            case "danger":
                if (getLevel() == 2 || getLevel() == 3 || getLevel() == 4) {
                    setLevel(1);
                    setDepiction("green");
                    return true;
                }
                else {
                    return false;
                }
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        if (getLevel() == 0) {
            return "Signal post " + getPostNumber() +
                    " of type light panel is in level " + getLevel() + " and is switched off";
        }
        else {
           return "Signal post " + getPostNumber() +
                    " of type light panel is in level " + getLevel() + " and is blinking " + getDepiction();
        }
    }
}
