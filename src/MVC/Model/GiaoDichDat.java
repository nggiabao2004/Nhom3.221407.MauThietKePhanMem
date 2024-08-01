package MVC.Model;

import java.util.Date;

public class GiaoDichDat extends GiaoDich {
    private String loai;

    public GiaoDichDat(String maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich, String loai) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loai = loai;
    }

    public String getLoai() {
        return loai;
    }

    @Override
    protected int getThang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getThang'");
    }
}
