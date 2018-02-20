package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Videogame {

	private String name;
	private String recommendedAge;
	private Date releaseDate;
	private int companyId;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecommendedAge() {
		return recommendedAge;
	}
	public void setRecommendedAge(String recommendedAge) {
		this.recommendedAge = recommendedAge;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
}