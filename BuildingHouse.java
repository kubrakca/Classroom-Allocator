import java.util.ArrayList;

public class BuildingHouse implements UniversityCampus{ //composite


    Departments departments;//later
    Classrooms classrooms;//later

    private ArrayList<UniversityCampus> buildingHouseElements=new ArrayList<>();

    private String buildingHouseName;

    public BuildingHouse(String buildingHouseName) {
        this.buildingHouseName = buildingHouseName;
    }

    @Override
    public void Add(UniversityCampus universityCampus) {
        buildingHouseElements.add(universityCampus);
    }

    @Override
    public void Remove(UniversityCampus universityCampus) {
        for (int i=0; i<buildingHouseElements.size();i++){
            if (buildingHouseElements.get(i).getName()==universityCampus.getName()){
                buildingHouseElements.remove(i);
                return;
            }
        }
    }

    @Override
    public void Display(int idx) {

    }

    @Override
    public String getName() {
        return buildingHouseName;
    }
}
