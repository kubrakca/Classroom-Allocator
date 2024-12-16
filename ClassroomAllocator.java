import java.util.ArrayList;
import java.util.Scanner;

public class ClassroomAllocator {
    private UniversityCampus campus;
    Departments department2 ;
    Buildings building1;
    private String name;


    public ClassroomAllocator() {
        department2= new Departments("SE");

        Classroom classroom1 = new Classroom("M203", 34);
        Classroom classroom2 = new Classroom("M204", 35);



        department2.add(classroom1);
        department2.add(classroom2);

        building1= new Buildings("M Block");
        building1.add(department2);

        this.campus = new Buildings("Izmir Economy University");
        this.campus.add(building1);
        this.name=name;
    }

    public String allocateClassroom() {
        //Certain days are used for giving general tests such as history, Turkish or foreign languages.
        // For those tests you mark every classroom as not available

        Classroom classroom = null;

        UniversityCampusIterator campusIterator = campus.createIterator();
        System.out.println("You can see the Campus structure.");
        while (campusIterator.hasNext()) {
            UniversityCampus element = campusIterator.next();
            element.Display(1);
        }
        System.out.println("");


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter department name");


        for (int k=0;k<building1.buildingHouseElements.size();k++){

            String depName=scanner.nextLine();


            if (depName.equals(department2.getName())) {
                for (int i = 0; i < department2.departmentElements.size(); i++) {
                    System.out.println(department2.departmentElements.get(i).getName());

                }
                System.out.println("Which class and when you rez");
                String classNamee = scanner.nextLine();
                System.out.println("Enter the beginning time: ");
                int beginT = scanner.nextInt();
                System.out.println("Enter the end time: ");
                int endT = scanner.nextInt();
                for (int i = 0; i < department2.departmentElements.size(); i++) {
                    if (department2.departmentElements.get(i).getName().equals(classNamee)) {
                        classroom = (Classroom) department2.departmentElements.get(i);
                        classroom.registerObserver(classroom);
                        if (classroom.isAvailable(beginT, endT)) {
                            classroom.Reservation(beginT, endT);
                        }
                    }
                }
                if (classroom == null) {
                    System.out.println("No matching classroom found");
                    return null;
                }

            }
        }

        System.out.println(classroom.getName());
        return classroom.getName();
    }
}


