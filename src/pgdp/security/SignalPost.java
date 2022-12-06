package pgdp.security;

public abstract class SignalPost {

	/**
	 * Diese Klasse ist nur da, damit keine Buildfails entstehen. Allerdings ist sie
	 * bei Weitem noch nicht vollständig.
	 * 
	 */
	private int postNumber;
	private String depiction;//Darstellung des SignalPosts speichert
	private int level;

	public SignalPost(int postNumber) {
		this.postNumber = postNumber;
		this.level = 0;
		this.depiction = "";
	}

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	public String getDepiction() {
		return depiction;
	}

	public void setDepiction(String depiction) {
		this.depiction = depiction;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
