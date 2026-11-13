import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class dataview<T> {
    private List<T> records;
    protected static final Scanner scanner = new Scanner(System.in);

    public dataview() {
        this.records = new ArrayList<>();
    }

        public void printAll() {
        String[] fields = getFields();
        for (int i = 0; i < this.records.size(); i++) {
            T record = this.records.get(i);
            String[] values = this.convertModelToValues(record);
            System.out.println(i + ". ");
            for (int j = 0; j < fields.length; j++) {
                System.out.print(fields[j] + ": " + values[j] + " ");
            }
            System.out.println();
        }
    }

    public void printByPk(String primaryKey) {
        int index = findIndexByPk(primaryKey);
        T record = this.records.get(index);
        String[] fields = getFields();
        String[] values = this.convertModelToValues(record);
        System.out.println(index + ". ");
        for (int j = 0; j < fields.length; j++) {
            System.out.print(fields[j] + ": " + values[j] + " ");
        }
        System.out.println();
    }

    public void showInsertForm() {
        String[] fields = getFields();
        String[] values = new String[fields.length];
        for (int j = 0; j < fields.length; j++) {
            System.out.print(fields[j] + ": ");
            values[j] = scanner.nextLine();
        }
        T record = this.convertValuesToModel(values);
        this.records.add(record);
        System.out.println("Data berhasil ditambahkan.");
    }

    public void showUpdateForm() {
        System.out.print("Masukkan primary key data yang akan diubah: ");
        String primaryKey = scanner.nextLine();

        int index = findIndexByPk(primaryKey);

        String[] fields = getFields();
        String[] values = new String[fields.length];
        for (int j = 0; j < fields.length; j++) {
            System.out.print(fields[j] + ": ");
            values[j] = scanner.nextLine();
        }

        T updated = this.convertValuesToModel(values);
        this.records.set(index, updated);
        System.out.println("Data berhasil diubah.");
    }

    public void promptDelete() {
        System.out.print("Masukkan primary key data yang akan dihapus: ");
        String primaryKey = scanner.nextLine();

        int index = findIndexByPk(primaryKey);


        this.records.remove(index);
        System.out.println("Data berhasil dihapus.");
    }

    private int findIndexByPk(String primaryKey) {

    }

    

    protected abstract String getPrimaryKeyValue(T data);

    protected abstract String[] getFields();

    protected abstract T convertValuesToModel(String[] values);

    protected abstract String[] convertModelToValues(T data);
}