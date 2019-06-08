package entities;

public class Company extends TaxPayer{
	private Integer numberOfEmployers;
	
	public Company() {
	}
	
	public Company(String name, Double anualIncome, Integer numberOfEmployers) {
		super(name, anualIncome);
		this.numberOfEmployers = numberOfEmployers;
	}

	public Integer getNumberOfEmployers() {
		return numberOfEmployers;
	}

	public void setNumberOfEmployers(Integer numberOfEmployers) {
		this.numberOfEmployers = numberOfEmployers;
	}

	@Override
	public Double taxIncome() {
		if (numberOfEmployers > 10) {
			return getAnualIncome() * 0.14;
		} else {
			return getAnualIncome() * 0.16;
		}
	}

}
