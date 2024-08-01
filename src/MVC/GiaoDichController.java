package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import MVC.Model.GiaoDich;
import MVC.Model.GiaoDichDat;
import MVC.Model.GiaoDichNha;

public class GiaoDichController {
    private GiaoDichDAO dao;
    private GiaoDichView view;

    public GiaoDichController(GiaoDichDAO dao, GiaoDichView view) {
        this.dao = dao;
        this.view = view;

        view.getThemButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themGiaoDich();
            }
        });

        view.getXoaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaGiaoDich();
            }
        });

        view.getSuaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaGiaoDich();
            }
        });

        view.getTimKiemButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiemGiaoDich();
            }
        });

        view.getXuatButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuatGiaoDichTheoThang();
            }
        });
    }

    protected void xuatGiaoDichTheoThang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xuatGiaoDichTheoThang'");
    }

    private void themGiaoDich() {
        try {
            String maGiaoDich = view.getMaGiaoDichField().getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayGiaoDich = sdf.parse(view.getNgayGiaoDichField().getText());
            double donGia = Double.parseDouble(view.getDonGiaField().getText());
            double dienTich = Double.parseDouble(view.getDienTichField().getText());
            String loai = view.getLoaiField().getText();
    
            if ("A".equals(loai) || "B".equals(loai) || "C".equals(loai)) {
                GiaoDichDat giaoDichDat = new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, loai);
                dao.themGiaoDich(giaoDichDat);
                view.getKetQuaArea().append("Thêm giao dịch đất thành công\n");
            } else if ("cao cấp".equals(loai) || "thường".equals(loai)) {
                String diaChi = view.getDiaChiField().getText();
                GiaoDichNha giaoDichNha = new GiaoDichNha(maGiaoDich, ngayGiaoDich, donGia, dienTich, loai, diaChi);
                dao.themGiaoDich(giaoDichNha);
                view.getKetQuaArea().append("Thêm giao dịch nhà thành công\n");
            } else {
                view.getKetQuaArea().append("Loại giao dịch không hợp lệ\n");
            }
    
            // Hiển thị danh sách giao dịch sau khi thêm
            view.hienThiDanhSachGiaoDich(dao.xuatGiaoDichTheoThang(-1, -1)); // Hiển thị tất cả giao dịch
        } catch (ParseException e) {
            view.getKetQuaArea().append("Lỗi ngày giao dịch: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            view.getKetQuaArea().append("Lỗi định dạng số: " + e.getMessage() + "\n");
        }
    }
    
    private void xoaGiaoDich() {
        String maGiaoDich = view.getMaGiaoDichField().getText();
        dao.xoaGiaoDich(maGiaoDich);
        view.getKetQuaArea().append("Xóa giao dịch thành công\n");
    
        // Hiển thị danh sách giao dịch sau khi xóa
        view.hienThiDanhSachGiaoDich(dao.xuatGiaoDichTheoThang(-1, -1)); // Hiển thị tất cả giao dịch
    }
    
    private void suaGiaoDich() {
        try {
            String maGiaoDich = view.getMaGiaoDichField().getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayGiaoDich = sdf.parse(view.getNgayGiaoDichField().getText());
            double donGia = Double.parseDouble(view.getDonGiaField().getText());
            double dienTich = Double.parseDouble(view.getDienTichField().getText());
            String loai = view.getLoaiField().getText();
    
            if ("A".equals(loai) || "B".equals(loai) || "C".equals(loai)) {
                GiaoDichDat giaoDichDat = new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, loai);
                dao.suaGiaoDich(giaoDichDat);
                view.getKetQuaArea().append("Sửa giao dịch đất thành công\n");
            } else if ("cao cấp".equals(loai) || "thường".equals(loai)) {
                String diaChi = view.getDiaChiField().getText();
                GiaoDichNha giaoDichNha = new GiaoDichNha(maGiaoDich, ngayGiaoDich, donGia, dienTich, loai, diaChi);
                dao.suaGiaoDich(giaoDichNha);
                view.getKetQuaArea().append("Sửa giao dịch nhà thành công\n");
            } else {
                view.getKetQuaArea().append("Loại giao dịch không hợp lệ\n");
            }
    
            // Hiển thị danh sách giao dịch sau khi sửa
            view.hienThiDanhSachGiaoDich(dao.xuatGiaoDichTheoThang(-1, -1)); // Hiển thị tất cả giao dịch
        } catch (ParseException e) {
            view.getKetQuaArea().append("Lỗi ngày giao dịch: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            view.getKetQuaArea().append("Lỗi định dạng số: " + e.getMessage() + "\n");
        }
    }
    
    private void timKiemGiaoDich() {
        String maGiaoDich = view.getMaGiaoDichField().getText();
        GiaoDich giaoDich = dao.timKiemGiaoDich(maGiaoDich);
        if (giaoDich != null) {
            List<GiaoDich> danhSach = new ArrayList<>();
            danhSach.add(giaoDich);
            view.hienThiDanhSachGiaoDich(danhSach);
        } else {
            view.getKetQuaArea().append("Không tìm thấy giao dịch\n");
        }
    }
    
    private void xuatGiaoDich() {
        try {
            int thang = Integer.parseInt(view.getThangField().getText());
            int nam = Integer.parseInt(view.getNamField().getText());
            List<GiaoDich> danhSach = dao.xuatGiaoDichTheoThang(thang, nam);
            view.hienThiDanhSachGiaoDich(danhSach);
        } catch (NumberFormatException e) {
            view.getKetQuaArea().append("Lỗi định dạng số: " + e.getMessage() + "\n");
        }
    }
}
