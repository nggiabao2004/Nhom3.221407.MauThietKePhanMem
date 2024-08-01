package MVC.Model;

import java.util.Date;

public class GiaoDichNha extends GiaoDich {
    private String loai;
    private String diaChi;

    public GiaoDichNha(String maGiaoDich, Date ngayGiaoDich, double donGia, double dienTich, String loai, String diaChi) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loai = loai;
        this.diaChi = diaChi;
    }

    public String getLoai() {
        return loai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    @Override
    protected int getThang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getThang'");
    }
}
