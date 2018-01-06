package sample.Data.DatabaseClasses;

public class Equipment {
    String name;
    int id;
    Section section;

    public Equipment() {
    }

    public Equipment(String name, int id, Section section) {
        this.name = name;
        this.id = id;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
