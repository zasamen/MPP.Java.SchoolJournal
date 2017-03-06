package school.journal.entity;

public class Clazz {
    private int classId;
    private int number;
    private String letterMark;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLetterMark() {
        return letterMark;
    }

    public void setLetterMark(String letterMark) {
        this.letterMark = letterMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clazz clazz = (Clazz) o;

        if (classId != clazz.classId) return false;
        if (number != clazz.number) return false;
        if (letterMark != null ? !letterMark.equals(clazz.letterMark) : clazz.letterMark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId;
        result = 31 * result + number;
        result = 31 * result + (letterMark != null ? letterMark.hashCode() : 0);
        return result;
    }
}
