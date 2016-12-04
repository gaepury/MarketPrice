package service1;

public class MartLoc {
	private String M_NAME;
	private double LAT;
	private double LNG;
	public MartLoc(String m_NAME, double LAT, double LNG) {
		this.M_NAME = m_NAME;
		this.LAT = LAT;
		this.LNG = LNG;
	}
	public String getM_NAME() {
		return M_NAME;
	}
	public void setM_NAME(String m_NAME) {
		this.M_NAME = M_NAME;
	}
	public double getLAT() {
		return LAT;
	}
	public void setLAT(double lAT) {
		this.LAT = LAT;
	}
	public double getLNG() {
		return LNG;
	}
	public void setLNG(double lNG) {
		this.LNG = LNG;
	}
}
