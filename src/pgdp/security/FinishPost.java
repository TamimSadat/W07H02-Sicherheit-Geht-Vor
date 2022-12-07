package pgdp.security;


public class FinishPost extends FlagPost {

    public FinishPost(int postNumber) {
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


