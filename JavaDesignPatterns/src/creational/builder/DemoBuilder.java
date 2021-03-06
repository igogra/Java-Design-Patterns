package creational.builder;

interface HousePlan {
	public void setBasement(String basement);

	public void setStructure(String structure);

	public void setRoof(String roof);
}

class House implements HousePlan {
	private String basement;
	private String structure;
	private String roof;

	@Override
	public void setBasement(String basement) {
		this.basement = basement;
	}

	@Override
	public void setStructure(String structure) {
		this.structure = structure;
	}

	@Override
	public void setRoof(String roof) {
		this.roof = roof;
	}

	@Override
	public String toString() {
		return "House [basement=" + basement + ", structure=" + structure
				+ ", roof=" + roof + "]";
	}
}

interface HouseBuilder {
	public void buildBasement();

	public void buildStructure();

	public void buildRoof();

	public House getHouse();
}

class IglooHouseBuilder implements HouseBuilder {
	private House house;

	public IglooHouseBuilder() {
		this.house = new House();
	}

	@Override
	public void buildBasement() {
		house.setBasement("Ice Bars");
	}

	@Override
	public void buildStructure() {
		house.setStructure("Ice Blocks");
	}

	@Override
	public void buildRoof() {
		house.setRoof("Ice Dome");
	}

	@Override
	public House getHouse() {
		return this.house;
	}
}

class TipiHouseBuilder implements HouseBuilder {
	private House house;

	public TipiHouseBuilder() {
		this.house = new House();
	}

	@Override
	public void buildBasement() {
		house.setBasement("Wooden Poles");
	}

	@Override
	public void buildStructure() {
		house.setStructure("Wood and Ice");
	}

	@Override
	public void buildRoof() {
		house.setRoof("Wood, caribou and seal skins");
	}

	@Override
	public House getHouse() {
		return this.house;
	}
}

class CivilEngineer {
	private HouseBuilder houseBuilder;

	public CivilEngineer(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	public House getHouse() {
		return this.houseBuilder.getHouse();
	}

	public void constructHouse() {
		this.houseBuilder.buildBasement();
		this.houseBuilder.buildStructure();
		this.houseBuilder.buildRoof();
	}
}

public class DemoBuilder {
	public static void main(String[] args) {
		HouseBuilder iglooBuilder = new IglooHouseBuilder();
		CivilEngineer engineer = new CivilEngineer(iglooBuilder);

		engineer.constructHouse();

		House house = engineer.getHouse();

		System.out.println("Builder constructed: " + house);
	}
}
