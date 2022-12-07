package pgdp.security;

public class Track {

    private SignalPost[] posts;

    public Track(int newTrack) {
        this.posts = new SignalPost[newTrack];

        for (int i = 0; i < posts.length; i++) {
            if (i == posts.length - 1) {
                this.posts[i] = new FinishPost(i);
            }
            else if (i % 3 == 0) {
                this.posts[i] = new LightPanel(i);
            }
            else {
                this.posts[i] = new FlagPost(i);
            }
        }
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

    public SignalPost[] getPosts() {
        return posts;
    }

    public void setPosts(SignalPost[] posts) {
        this.posts = posts;
    }
}
