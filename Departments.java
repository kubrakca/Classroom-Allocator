import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Departments implements UniversityCampus { // Composite
    public List<UniversityCampus> departmentElements = new ArrayList<>();
    private String departmentName;
    public Departments(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void add(UniversityCampus universityCampus) {
        departmentElements.add(universityCampus);
    }

    @Override
    public void remove(UniversityCampus universityCampus) {
        departmentElements.remove(universityCampus);
    }

    @Override
    public void Display(int indent) {
        for (int i = 1; i <= indent; i++) System.out.print("-");
        System.out.println("+ " + getName());

        // Display each child element on this node
        for (int i = 0; i < departmentElements.size(); i++) {
            departmentElements.get(i).Display(indent + 2);
        }
    }


    @Override
    public String getName() {
        return departmentName;
    }



    @Override
    public UniversityCampusIterator createIterator() {
        return new CompositeIterator(departmentElements.iterator());
    }

}

class ResourceAllocationDepartment extends Departments{

    public ResourceAllocationDepartment(String departmentName) {
        super(departmentName);
    }
    List<Classroom> classrooms = new ArrayList<>();
    public int getAvailableClassroomCount(int beginTime, int endTime) {
        int count = 0;

        Iterator<Classroom> iterator = classrooms.iterator();
        while (iterator.hasNext()) {
            Classroom classroom = iterator.next();
            if (classroom.isAvailable(beginTime, endTime)) {
                count++;
            }
        }
        return count;
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }








}
