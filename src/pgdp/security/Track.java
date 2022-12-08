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
        if (start < end) {
            for (int i = 0; i < posts.length; i++) {
                if (i >= start && i <= end) {
                    posts[i].down("danger");
                }
            }
        }
        else if (end < start) {
            for (int i = 0; i < posts.length; i++) {
                if (i <= end) {
                    posts[i].down("danger");

                }
                else if (i >= start) {
                    posts[i].down("danger");
                }
                else {
                    //whatever
                }
            }
        }
        else {
            posts[start].down("danger");
        }
    }

    public void createLappedCarAt(int post) {
        int differenz = posts.length - post;
       if (post < posts.length - 3) {
           for (int i = 0; i < posts.length; i++) {
               if (i == post || i == post + 1 || i == post + 2 || i == post + 3) {
                   posts[i].up("blue");
               }
           }
       }
       else if (differenz == 3) {
           for (int i = 0; i < posts.length; i++) {
               if (i == post || i == post + 1 || i == post + 2) {
                   posts[i].up("blue");
               }
           }
           posts[0].up("blue");
       }
       else if (differenz == 2) {
           for (int i = 0; i < posts.length; i++) {
               if (i == post || i == post + 1) {
                   posts[i].up("blue");
               }
           }
           posts[0].up("blue");
           posts[1].up("blue");
       }
       else if (differenz == 1) {
           for (int i = 0; i < posts.length; i++) {
               if (i == post) {
                   posts[i].up("blue");
               }
           }
           posts[0].up("blue");
           posts[1].up("blue");
           posts[2].up("blue");
       }
       else{
           //whatever
       }
    }

    public void removeLappedCarAt(int post) {
        int differenz = posts.length - post;
        if (post < posts.length - 3) {
            for (int i = 0; i < posts.length; i++) {
                if (i == post || i == post + 1 || i == post + 2 || i == post + 3) {
                    posts[i].down("blue");
                }
            }
        }
        else if (differenz == 3) {
            for (int i = 0; i < posts.length; i++) {
                if (i == post || i == post + 1 || i == post + 2) {
                    posts[i].down("blue");
                }
            }
            posts[0].down("blue");
        }
        else if (differenz == 2) {
            for (int i = 0; i < posts.length; i++) {
                if (i == post || i == post + 1) {
                    posts[i].down("blue");
                }
            }
            posts[0].down("blue");
            posts[1].down("blue");
        }
        else if (differenz == 1) {
            for (int i = 0; i < posts.length; i++) {
                if (i == post) {
                    posts[i].down("blue");
                }
            }
            posts[0].down("blue");
            posts[1].down("blue");
            posts[2].down("blue");
        }
        else{
            //whatever
        }
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
