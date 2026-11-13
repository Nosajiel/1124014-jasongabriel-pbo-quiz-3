public class mahasiswadataview extends dataview<mahasiswa> {

    @Override
    protected String getPrimaryKeyValue(mahasiswa data) {
        return data.getNim();
    }

    @Override
    protected String[] getFields() {
        return new String[]{"nim", "nama", "email", "umur"};
    }

    @Override
    protected mahasiswa convertValuesToModel(String[] values) {
        return new mahasiswa(
                values[0],
                values[1],
                values[2],
                Integer.parseInt(values[3])
        );
    }

    @Override
    protected String[] convertModelToValues(mahasiswa data) {
        return new String[]{
                data.getNim(),
                data.getNama(),
                data.getEmail(),
                String.valueOf(data.getUmur())
        };
    }
}