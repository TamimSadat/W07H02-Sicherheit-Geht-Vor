package pgdp.security;

public class LightPanel extends SignalPost {

    private static final String[] farbe = new String[]{"green", "blue", "yellow", "doubleYellow", "[SC]", "red", "end"};

    public LightPanel(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {


        return false;
    }

    @Override
    public boolean down(String type) {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
