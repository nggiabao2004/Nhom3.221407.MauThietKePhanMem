package MVC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import MVC.Model.GiaoDich;
import MVC.Model.GiaoDichDat;
import MVC.Model.GiaoDichNha;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class GiaoDichView extends JFrame {
    private JTextField maGiaoDichField, ngayGiaoDichField, donGiaField, dienTichField, loaiField, diaChiField;
    private JTextArea ketQuaArea;
    private JButton themButton, xoaButton, suaButton, timKiemButton, xuatButton;
    private JTable table;
    private DefaultTableModel tableModel;

    public GiaoDichView() {
        setTitle("Quản lý giao dịch nhà đất");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(10, 2));

        panel.add(new JLabel("Mã giao dịch:"));
        maGiaoDichField = new JTextField();
        panel.add(maGiaoDichField);

        panel.add(new JLabel("Ngày giao dịch (dd/MM/yyyy):"));
        ngayGiaoDichField = new JTextField();
        panel.add(ngayGiaoDichField);

        panel.add(new JLabel("Đơn giá:"));
        donGiaField = new JTextField();
        panel.add(donGiaField);

        panel.add(new JLabel("Diện tích:"));
        dienTichField = new JTextField();
        panel.add(dienTichField);

        panel.add(new JLabel("Loại (A/B/C hoặc cao cấp/thường):"));
        loaiField = new JTextField();
        panel.add(loaiField);

        panel.add(new JLabel("Địa chỉ (chỉ cho giao dịch nhà):"));
        diaChiField = new JTextField();
        panel.add(diaChiField);

        themButton = new JButton("Thêm");
        panel.add(themButton);

        xoaButton = new JButton("Xóa");
        panel.add(xoaButton);

        suaButton = new JButton("Sửa");
        panel.add(suaButton);

        timKiemButton = new JButton("Tìm kiếm");
        panel.add(timKiemButton);

        xuatButton = new JButton("Xuất theo tháng/năm");
        panel.add(xuatButton);

        ketQuaArea = new JTextArea(10, 30);
        ketQuaArea.setEditable(false);

        tableModel = new DefaultTableModel(new Object[]{"Mã", "Ngày", "Đơn giá", "Diện tích", "Loại", "Địa chỉ"}, 0);
        table = new JTable(tableModel);

        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(ketQuaArea), BorderLayout.CENTER);
        getContentPane().add(new JScrollPane(table), BorderLayout.SOUTH);
    }

    public JTextField getMaGiaoDichField() {
        return maGiaoDichField;
    }

    public JTextField getNgayGiaoDichField() {
        return ngayGiaoDichField;
    }

    public JTextField getDonGiaField() {
        return donGiaField;
    }

    public JTextField getDienTichField() {
        return dienTichField;
    }

    public JTextField getLoaiField() {
        return loaiField;
    }

    public JTextField getDiaChiField() {
        return diaChiField;
    }

    public JTextArea getKetQuaArea() {
        return ketQuaArea;
    }

    public JButton getThemButton() {
        return themButton;
    }

    public JButton getXoaButton() {
        return xoaButton;
    }

    public JButton getSuaButton() {
        return suaButton;
    }

    public JButton getTimKiemButton() {
        return timKiemButton;
    }

    public JButton getXuatButton() {
        return xuatButton;
    }

    public void hienThiDanhSachGiaoDich(List<GiaoDich> danhSach) {
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (GiaoDich giaoDich : danhSach) {
            if (giaoDich instanceof GiaoDichDat) {
                GiaoDichDat dat = (GiaoDichDat) giaoDich;
                tableModel.addRow(new Object[]{dat.getMaGiaoDich(), sdf.format(dat.getNgayGiaoDich()), dat.getDonGia(), dat.getDienTich(), dat.getLoai(), ""});
            } else if (giaoDich instanceof GiaoDichNha) {
                GiaoDichNha nha = (GiaoDichNha) giaoDich;
                tableModel.addRow(new Object[]{nha.getMaGiaoDich(), sdf.format(nha.getNgayGiaoDich()), nha.getDonGia(), nha.getDienTich(), nha.getLoai(), nha.getDiaChi()});
            }
        }
    }

    public AbstractButton getThangField() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getThangField'");
    }

    public AbstractButton getNamField() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNamField'");
    }
}
