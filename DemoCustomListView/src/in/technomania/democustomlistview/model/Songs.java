package in.technomania.democustomlistview.model;

public class Songs {
	public Songs(int image, String name, String detail) {
		this.image = image;
		this.name = name;
		this.detail = detail;
	}
	private int image;
	private String name;
	private String detail;
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
