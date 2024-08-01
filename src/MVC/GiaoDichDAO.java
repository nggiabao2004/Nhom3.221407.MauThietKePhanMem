package MVC;

import java.util.ArrayList;
import java.util.List;

import MVC.Model.GiaoDich;

public class GiaoDichDAO {
    private List<GiaoDich> danhSachGiaoDich;

    public GiaoDichDAO() {
        this.danhSachGiaoDich = new ArrayList<>();
    }

    public void themGiaoDich(GiaoDich giaoDich) {
        danhSachGiaoDich.add(giaoDich);
    }

    public void xoaGiaoDich(String maGiaoDich) {
        danhSachGiaoDich.removeIf(giaoDich -> giaoDich.getMaGiaoDich().equals(maGiaoDich));
    }

    public void suaGiaoDich(GiaoDich giaoDich) {
        for (int i = 0; i < danhSachGiaoDich.size(); i++) {
            if (danhSachGiaoDich.get(i).getMaGiaoDich().equals(giaoDich.getMaGiaoDich())) {
                danhSachGiaoDich.set(i, giaoDich);
                return;
            }
        }
    }

    public GiaoDich timKiemGiaoDich(String maGiaoDich) {
        for (GiaoDich giaoDich : danhSachGiaoDich) {
            if (giaoDich.getMaGiaoDich().equals(maGiaoDich)) {
                return giaoDich;
            }
        }
        return null;
    }

    public List<GiaoDich> xuatGiaoDichTheoThang(int thang, int nam) {
        // Return all transactions as placeholder, actual implementation needed
        return new ArrayList<>(danhSachGiaoDich);
    }
}
