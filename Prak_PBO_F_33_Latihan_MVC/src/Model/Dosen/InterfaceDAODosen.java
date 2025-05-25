package Model.Dosen;

import java.util.List;

public interface InterfaceDAODosen {
    // Method untuk memasukkan suatu data dosen
    public void insert(ModelDosen dosen);

    // Method untuk mengupdate (mengedit) suatu data dosen
    public void update(ModelDosen dosen);

    // Method untuk menghapus suatu data dosen
    public void delete(String id);

    // Method untuk mengambil semua data dosen
    public List<ModelDosen> getAll();

    // Method untuk mengambil data dosen berdasarkan ID
    public List<ModelDosen> getByNip(String id);
}