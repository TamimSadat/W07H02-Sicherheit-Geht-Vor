package pgdp.security;

public class Track {

    SignalPost[] posts;

    public Track(int newTrack) {
        posts = new SignalPost[newTrack];
    }

    public void setAll(String type, boolean up) {

    }

    public void setRange(String type, boolean up, int start, int end) {

    }

    public void createHazardAt(int start, int end) {

    }

    public void removeHazardAt(int start, int end) {

    }

    public void createLappedCarAt(int post) {

    }

    public void removeLappedCarAt(int post) {

    }

    public void printStatus() {

    }

}
