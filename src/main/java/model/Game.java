package model;


public class Game {

	// id will be used for primary key in MongoDB
	// We could use ObjectId, but I am keeping it
	// independent of MongoDB API classes
	private String _id;

	private String Rank;

	private String Name;

	private String Platform;

	private Integer Year;

	private String Genre;

	private String Publisher;

	private Double NA_Sales;

	private Double EU_Sales;

	private Double JP_Sales;

	private Double Other_Sales;

	private Double Global_Sales;

	public Game(){

	}

	public Game(String _id, String Rank, String Name, String Platform, Integer Year, String Genre, String Publisher, Double NA_Sales, Double EU_Sales, Double JP_Sales, Double Other_Sales, Double Global_Sales ){

		this._id = _id;
		this.Rank = Rank;
		this.Name = Name;
		this.Platform = Platform;
		this.Year = Year;
		this.Genre = Genre;
		this.Publisher = Publisher;
		this.NA_Sales = NA_Sales;
		this.EU_Sales = EU_Sales;
		this.JP_Sales = JP_Sales;
		this.Other_Sales = Other_Sales;
		this.Global_Sales = Global_Sales;
	}


	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		Rank = rank;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPlatform() {
		return Platform;
	}

	public void setPlatform(String platform) {
		Platform = platform;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public Double getNA_Sales() {
		return NA_Sales;
	}

	public void setNA_Sales(Double na_sales) {
		this.NA_Sales = na_sales;
	}

	public Double getEU_Sales() {
		return EU_Sales;
	}

	public void setEU_Sales(Double eu_sales) {
		this.EU_Sales = eu_sales;
	}

	public Double getJP_Sales() {
		return JP_Sales;
	}

	public void setJP_Sales(Double jp_sales) {
		this.JP_Sales = jp_sales;
	}

	public Double getOther_Sales() {
		return Other_Sales;
	}

	public void setOther_Sales(Double other_sales) {
		Other_Sales = other_sales;
	}

	public Double getGlobal_Sales() {
		return Global_Sales;
	}

	public void setGlobal_Sales(Double global_sales) { Global_Sales = global_sales;
	}
}
