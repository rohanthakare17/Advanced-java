package example.entity;
import java.time.LocalDate;
public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private String cuisine;
	private int branchCount;
	private LocalDate establishmentDate;
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int restaurantId, String restaurantName, String cuisine, int branchCount,
			LocalDate establishmentDate) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.cuisine = cuisine;
		this.branchCount = branchCount;
		this.establishmentDate = establishmentDate;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getBranchCount() {
		return branchCount;
	}
	public void setBranchCount(int branchCount) {
		this.branchCount = branchCount;
	}
	public LocalDate getEstablishmentDate() {
		return establishmentDate;
	}
	public void setEstablishmentDate(LocalDate establishmentDate) {
		this.establishmentDate = establishmentDate;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", cuisine="
				+ cuisine + ", branchCount=" + branchCount + ", establishmentDate=" + establishmentDate + "]";
	}
}
