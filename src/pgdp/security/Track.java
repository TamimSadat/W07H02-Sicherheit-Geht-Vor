package pgdp.security;

public class Track {

    private SignalPost[] posts;

    public Track(int newTrack) {
        if (newTrack <= 0) {
            newTrack = 10;
        }

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
        if (up) {
            for (int i = 0; i < posts.length; i++) {
                posts[i].up(type);
            }
        }
        else {
            for (int i = 0; i < posts.length; i++) {
                posts[i].down(type);
            }
        }
    }
    public void setRange(String type, boolean up, int start, int end) {
       if (up) {
          if (start < end) {
              for (int i = 0; i < posts.length; i++) {
                  if (i >= start && i <= end) {
                      posts[i].up(type);
                  }
                  else {
                      posts[i].down(type);
                  }
              }
          }
          else if (end < start) {
              for (int i = 0; i < posts.length; i++) {
                  if (i <= end) {
                      posts[i].up(type);
                  }
                  else if (i >= start) {
                      posts[i].up(type);
                  }
                  else {
                      posts[i].down(type);
                  }
              }
          }
          else {
              posts[start].up(type);
          }
       }
       else {
           for (int i = 0; i < posts.length; i++) {
               posts[i].down(type);
           }
       }
    }

    public void createHazardAt(int start, int end) {
        if (start < end) {
            for (int i = 0; i < posts.length; i++) {
                if (i >= start && i < end) {
                    posts[i].up("yellow");
                }
                else if (i >= start && i == end) {
                    posts[i].up("green");
                }
            }
        }
        else if (end < start) {
            for (int i = 0; i < posts.length; i++) {
                if (i <= end) {
                    if (i == end) {
                        posts[i].up("green");
                    }
                    else {
                        posts[i].up("yellow");
                    }
                }
                else if (i >= start) {
                    posts[i].up("yellow");
                }
                else {
                    //whatever
                }
            }
        }
        else {
            posts[start].up("green");
        }
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
