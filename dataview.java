import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class dataview<T> {
    private List<T> records;
    protected static final Scanner scanner = new Scanner(System.in);

    public dataview() {
        this.records = new ArrayList<>();
    }

    protected abstract String getPrimaryKeyValue(T data);

    protected abstract String[] getFields();

    protected abstract T convertValuesToModel(String[] values);

    protected abstract String[] convertModelToValues(T data);
}