package view;

import controller.QuanLyBanHang;
import controller.QuanLyDangNhap;
import controller.QuanLyNhanVien;
import controller.QuanLySanPham;
import controller.QuanLyThuChi;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DiaNhac;
import model.DiaPhim;
import model.HoaDon;
import model.NhanVien;
import model.Sach;
import model.SanPham;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FrameNhanVien extends javax.swing.JFrame {

    QuanLySanPham qlSanPham;
    QuanLyNhanVien qlNhanVien;
    QuanLyBanHang qlBanHang;
    QuanLyDangNhap qlDangNhap;
    QuanLyThuChi qlThuChi;
    ArrayList<NhanVien> ds_NhanVien;
    private ArrayList<Sach> ds_Sach;
    private ArrayList<DiaNhac> ds_DiaNhac;
    private ArrayList<DiaPhim> ds_DiaPhim;
    private ArrayList<HoaDon> ds_HoaDon;
    String user;
    NhanVien nv;

    /**
     * Creates new form FrameNhanVien
     */
    public FrameNhanVien(String user) {
        this.user = user;
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("PHẦN MỀM QUẢN LÝ BÁN HÀNG");
        reset();
        qlThuChi = new QuanLyThuChi();
        qlDangNhap = new QuanLyDangNhap();
        tfTongTien.setEditable(false);
        qlBanHang = new QuanLyBanHang();
        ds_HoaDon = qlBanHang.getDsHoaDon();
        lbNgayThangNam.setText(getDate(lbNgayThangNam));
        qlNhanVien = new QuanLyNhanVien();
        ds_NhanVien = qlNhanVien.getDS_NhanVien();
        for (int i = 0; i < ds_NhanVien.size(); i++) {
            if (ds_NhanVien.get(i).getTenDangNhap().equals(user)) {
                lbchao.setText(ds_NhanVien.get(i).getTenNhanVien());
                nv = ds_NhanVien.get(i);
                break;
            }
        }
        qlSanPham = new QuanLySanPham(tableSanPham);
        qlSanPham.load_SanPham();
        ds_Sach = qlSanPham.getDS_Sach();
        ds_DiaNhac = qlSanPham.getDS_DiaNhac();
        ds_DiaPhim = qlSanPham.getDS_DiaPhim();
        ArrayList ds = qlSanPham.thongKe();
        showThongKeSP(ds);
    }

    public static void showThongKeSP(ArrayList ds) {
    }

    @SuppressWarnings("unchecked")
  
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lblMaSanPham2 = new javax.swing.JLabel();
        lblNhaCungCap2 = new javax.swing.JLabel();
        lblLoaiSanPham2 = new javax.swing.JLabel();
        lblTenSanPham2 = new javax.swing.JLabel();
        lblGiaMua2 = new javax.swing.JLabel();
        lblGiaBan2 = new javax.swing.JLabel();
        tfTenSanPham = new javax.swing.JTextField();
        tfMaSanPham = new javax.swing.JTextField();
        tfNhaCungCap = new javax.swing.JTextField();
        cbLoaiSanPham = new javax.swing.JComboBox<>();
        btCapNhatSanPham = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        tfGiaMua = new javax.swing.JTextField();
        tfGiaBan = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lbthem2 = new javax.swing.JLabel();
        tfThem2 = new javax.swing.JTextField();
        lbthem1 = new javax.swing.JLabel();
        tfThem1 = new javax.swing.JTextField();
        btThemSanPham = new javax.swing.JButton();
        btXoaSanPham = new javax.swing.JButton();
        lbthem3 = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        pnKhachHang6 = new javax.swing.JPanel();
        pnChiTietBanHang7 = new javax.swing.JPanel();
        btnXacNhan7 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableBanHang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfTongTien = new javax.swing.JTextField();
        pnThongTinSPBanHang = new javax.swing.JPanel();
        btThemVaoGioHang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfThemMaSanPham = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbThemVaoHoaDonLoaiSanPham = new javax.swing.JComboBox<>();
        tfThemSoLuong = new javax.swing.JTextField();
        lbNgayThangNam = new javax.swing.JLabel();
        lbchao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PHẦN MỀM QUẢN LÝ BÁN HÀNG");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Sản Phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); 

        lblMaSanPham2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblMaSanPham2.setText("Mã Sản Phẩm:");

        lblNhaCungCap2.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblNhaCungCap2.setText("Nhà Cung Cấp:");

        lblLoaiSanPham2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblLoaiSanPham2.setText("Loại Sản Phẩm:");

        lblTenSanPham2.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblTenSanPham2.setText("Tên Sản Phẩm:");

        lblGiaMua2.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblGiaMua2.setText("Giá Mua:");

        lblGiaBan2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblGiaBan2.setText("Giá Bán:");

        cbLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Đĩa Nhạc", "Đĩa Phim" }));

        btCapNhatSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btCapNhatSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/repair.png"))); 
        btCapNhatSanPham.setText("Cập Nhật");
        btCapNhatSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatSanPhamActionPerformed(evt);
            }
        });

        btThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); 
        btThoat.setText(" Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 2, 14)); 
        jLabel46.setForeground(new java.awt.Color(0, 204, 0));
        jLabel46.setText("VND");

        jLabel47.setFont(new java.awt.Font("Tahoma", 2, 14)); 
        jLabel47.setForeground(new java.awt.Color(0, 204, 0));
        jLabel47.setText("VND");

        lbthem2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lbthem2.setText("jLabel7");

        lbthem1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lbthem1.setText("jLabel34");

        btThemSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addproduct.png"))); 
        btThemSanPham.setText("Thêm Mới");
        btThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemSanPhamActionPerformed(evt);
            }
        });

        btXoaSanPham.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btXoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/removeproduct.png"))); 
        btXoaSanPham.setText("Xóa");
        btXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaSanPhamActionPerformed(evt);
            }
        });

        lbthem3.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lbthem3.setText("Số Lượng");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbthem3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNhaCungCap2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoaiSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbthem1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGiaMua2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGiaBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbthem2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfThem1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfGiaMua, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(688, 688, 688))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(btCapNhatSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblLoaiSanPham2, lblMaSanPham2, lblNhaCungCap2, lblTenSanPham2, lbthem3});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbLoaiSanPham, tfMaSanPham, tfNhaCungCap, tfSoLuong, tfTenSanPham});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblGiaBan2, lblGiaMua2, lbthem1, lbthem2});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLoaiSanPham2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addComponent(lblGiaMua2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tfGiaMua, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaSanPham2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGiaBan2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addComponent(tfMaSanPham)
                        .addComponent(tfGiaBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblTenSanPham2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lbthem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNhaCungCap2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbthem3)
                                    .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btCapNhatSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbthem2)
                                    .addComponent(tfThem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(tfThem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblLoaiSanPham2, lblMaSanPham2, lblNhaCungCap2, lblTenSanPham2, lbthem3});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbLoaiSanPham, tfNhaCungCap, tfSoLuong});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblGiaBan2, lbthem1, lbthem2});

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfThem1, tfThem2});

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); 

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Loại Sản Phẩm", "Giá Mua", "Giá Bán", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableSanPham);
        if (tableSanPham.getColumnModel().getColumnCount() > 0) {
            tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(70);
            tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        jScrollPane3.setViewportView(jScrollPane5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        				.addComponent(jPanel15, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jTabbedPane1.addTab("Sản Phẩm", new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-cart.png")), jPanel2); 

        pnChiTietBanHang7.setBackground(new java.awt.Color(204, 204, 255));
        pnChiTietBanHang7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Mục Sản Phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); 

        btnXacNhan7.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        btnXacNhan7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ok.png"))); 
        btnXacNhan7.setText("Xác Nhận");
        btnXacNhan7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });

        tableBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tableBanHang);
        if (tableBanHang.getColumnModel().getColumnCount() > 0) {
            tableBanHang.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableBanHang.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableBanHang.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableBanHang.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableBanHang.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jLabel2.setText("Tổng Số Tiền:");

        javax.swing.GroupLayout pnChiTietBanHang7Layout = new javax.swing.GroupLayout(pnChiTietBanHang7);
        pnChiTietBanHang7.setLayout(pnChiTietBanHang7Layout);
        pnChiTietBanHang7Layout.setHorizontalGroup(
            pnChiTietBanHang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChiTietBanHang7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXacNhan7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChiTietBanHang7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        pnChiTietBanHang7Layout.setVerticalGroup(
            pnChiTietBanHang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChiTietBanHang7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChiTietBanHang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChiTietBanHang7Layout.createSequentialGroup()
                        .addGroup(pnChiTietBanHang7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnXacNhan7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfTongTien))
                .addContainerGap())
        );

        pnChiTietBanHang7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnXacNhan7, jLabel2});

        pnThongTinSPBanHang.setBackground(new java.awt.Color(204, 204, 255));
        pnThongTinSPBanHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 51, 51))); 

        btThemVaoGioHang.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        btThemVaoGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addproduct.png"))); 
        btThemVaoGioHang.setText("Thêm vào giỏ hàng");
        btThemVaoGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemVaoGioHangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); 
        jLabel3.setText("SỐ LƯỢNG");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 12)); 
        jLabel5.setText("NHẬP MÃ SẢN PHẨM:");

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); 
        jLabel1.setText("LOẠI SẢN PHẨM");

        cbThemVaoHoaDonLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Đĩa Nhạc", "Đĩa Phim" }));
        cbThemVaoHoaDonLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThemVaoHoaDonLoaiSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThongTinSPBanHangLayout = new javax.swing.GroupLayout(pnThongTinSPBanHang);
        pnThongTinSPBanHang.setLayout(pnThongTinSPBanHangLayout);
        pnThongTinSPBanHangLayout.setHorizontalGroup(
            pnThongTinSPBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinSPBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbThemVaoHoaDonLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfThemMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tfThemSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btThemVaoGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnThongTinSPBanHangLayout.setVerticalGroup(
            pnThongTinSPBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinSPBanHangLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(pnThongTinSPBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinSPBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfThemMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(btThemVaoGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfThemSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinSPBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbThemVaoHoaDonLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        pnThongTinSPBanHangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbThemVaoHoaDonLoaiSanPham, jLabel1, jLabel3, jLabel5});

        pnThongTinSPBanHangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfThemMaSanPham, tfThemSoLuong});

        lbNgayThangNam.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        lbNgayThangNam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNgayThangNam.setText("Thứ ..... Ngày ..... Tháng ..... Năm .....");

        javax.swing.GroupLayout pnKhachHang6Layout = new javax.swing.GroupLayout(pnKhachHang6);
        pnKhachHang6.setLayout(pnKhachHang6Layout);
        pnKhachHang6Layout.setHorizontalGroup(
            pnKhachHang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHang6Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbNgayThangNam, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnKhachHang6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnKhachHang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnThongTinSPBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnChiTietBanHang7, javax.swing.GroupLayout.PREFERRED_SIZE, 883, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnKhachHang6Layout.setVerticalGroup(
            pnKhachHang6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhachHang6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbNgayThangNam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongTinSPBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnChiTietBanHang7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnKhachHang6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnKhachHang6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bán Hàng", new javax.swing.ImageIcon(getClass().getResource("/icon/money.png")), jPanel1); 

        lbchao.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        lbchao.setForeground(new java.awt.Color(102, 102, 0));
        lbchao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbchao.setText("Tên nhân Viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel4.setForeground(new java.awt.Color(102, 102, 0));
        jLabel4.setText("Xin Chào :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbchao, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(lbchao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {
        int i = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            qlSanPham.writeSanPhamToFile();
            qlNhanVien.writeNhanVienToFile();
            qlThuChi.writeThuChiToFile();
            System.exit(0);
        }
    }

    private void btThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {
        qlSanPham.themSanPham();
        reset();
    }

    private void btCapNhatSanPhamActionPerformed(java.awt.event.ActionEvent evt) {
        reset();
        int i = tableSanPham.getSelectedRow();
        try {
            qlSanPham.suaThongTin(i);
        } catch (Exception e) {
        }
    }

    private void btXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {
        int i = tableSanPham.getSelectedRow();
        if (i != -1) {
            int j = JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Chắn Muốn Loại Bỏ Sản Phẩm Này", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (j == JOptionPane.YES_OPTION) {
                qlSanPham.xoaSanPham(i);
            }
        }
        reset();
    }

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {
        int i = tableSanPham.getSelectedRow();
        int sizeSach = ds_Sach.size();
        int sizeDiaNhac = ds_DiaNhac.size();
        int sizeDiaPhim = ds_DiaPhim.size();
        if (i < sizeSach && i != -1) {
            //Sach
            cbLoaiSanPham.setSelectedIndex(0);
            lbthem1.setText("Tác Giả");
            lbthem1.setVisible(true);
            tfThem1.setVisible(true);
            lbthem2.setText("Nhà Xuất Bản");
            lbthem2.setVisible(true);
            tfThem2.setVisible(true);
            tfMaSanPham.setText(ds_Sach.get(i).getMaSanPham());
            tfTenSanPham.setText(ds_Sach.get(i).getTenSanPham());
            tfNhaCungCap.setText(ds_Sach.get(i).getNhaCungCap());
            tfSoLuong.setText(ds_Sach.get(i).getSoLuong() + "");
            tfGiaMua.setText(ds_Sach.get(i).getGiaMua() + "");
            tfGiaBan.setText(ds_Sach.get(i).getGiaBan() + "");
            tfThem1.setText(ds_Sach.get(i).getTacGia());
            tfThem2.setText(ds_Sach.get(i).getNhaXuatBan());
        } else if ((i < sizeSach + sizeDiaNhac) && i != -1) {
            //Dia NHac
            cbLoaiSanPham.setSelectedIndex(1);
            lbthem1.setText("Tên Ca Sỹ");
            lbthem1.setVisible(true);
            tfThem1.setVisible(true);
            lbthem2.setText("Thể Loại");
            lbthem2.setVisible(true);
            tfThem2.setVisible(true);
            tfMaSanPham.setText(ds_DiaNhac.get(i - sizeSach).getMaSanPham());
            tfTenSanPham.setText(ds_DiaNhac.get(i - sizeSach).getTenSanPham());
            tfNhaCungCap.setText(ds_DiaNhac.get(i - sizeSach).getNhaCungCap());
            tfSoLuong.setText(ds_DiaNhac.get(i - sizeSach).getSoLuong() + "");
            tfGiaMua.setText(ds_DiaNhac.get(i - sizeSach).getGiaMua() + "");
            tfGiaBan.setText(ds_DiaNhac.get(i - sizeSach).getGiaBan() + "");
            tfThem1.setText(ds_DiaNhac.get(i - sizeSach).getTenCaSy());
            tfThem2.setText(ds_DiaNhac.get(i - sizeSach).getTheLoai());
        } else if ((i < sizeSach + sizeDiaNhac + sizeDiaPhim) && i != -1) {
            //Dia Phim
            cbLoaiSanPham.setSelectedIndex(2);
            lbthem1.setText("Tên Đạo Diễn");
            lbthem1.setVisible(true);
            tfThem1.setVisible(true);
            lbthem2.setText("Tên Diễn Viên");
            lbthem2.setVisible(true);
            tfThem2.setVisible(true);
            tfMaSanPham.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getMaSanPham());
            tfTenSanPham.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getTenSanPham());
            tfNhaCungCap.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getNhaCungCap());
            tfSoLuong.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getSoLuong() + "");
            tfGiaMua.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getGiaMua() + "");
            tfGiaBan.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getGiaBan() + "");
            tfThem1.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getTenDaoDien());
            tfThem2.setText(ds_DiaPhim.get(i - sizeSach - sizeDiaNhac).getTenDienVien());
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        int i = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            qlSanPham.writeSanPhamToFile();
            qlNhanVien.writeNhanVienToFile();
            qlThuChi.writeThuChiToFile();
            System.exit(0);
        }
    }

    private void btThemVaoGioHangActionPerformed(java.awt.event.ActionEvent evt) {
        String thongBao = "";
        if (tfThemMaSanPham.getText().trim().length() == 0) {
            thongBao += "Chưa Điền mã sản phẩm";
        }
        if (tfThemSoLuong.getText().trim().length() == 0 || tfThemSoLuong.getText().trim().equals("0")) {
            thongBao += "\nChưa Điền số lượng";
        }
        if (thongBao.length() != 0) {
            JOptionPane.showMessageDialog(null, thongBao, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            SanPham sp;
            int giaBan = 0;
            String tenSanPham = null;
            String maSanPham = tfThemMaSanPham.getText().trim();
            int soLuong = Integer.parseInt(tfThemSoLuong.getText().trim());
            int soLuongCon = -1;
            switch (cbThemVaoHoaDonLoaiSanPham.getSelectedIndex()) {
                case 0:
                    for (int i = 0; i < ds_Sach.size(); i++) {
                        if (maSanPham.equalsIgnoreCase(ds_Sach.get(i).getMaSanPham())) {
                            giaBan = ds_Sach.get(i).getGiaBan();
                            tenSanPham = ds_Sach.get(i).getTenSanPham();
                            soLuongCon = ds_Sach.get(i).getSoLuong() - soLuong;
                            int giaMua = ds_Sach.get(i).getGiaMua();
                            String nhaCungCap = ds_Sach.get(i).getNhaCungCap();
                            String tacGia = ds_Sach.get(i).getTacGia();
                            String nhaXuatBan = ds_Sach.get(i).getNhaXuatBan();
                            int index = i;
                            Sach s = new Sach(maSanPham, tenSanPham, giaMua, giaBan, nhaCungCap, soLuongCon, tacGia, nhaXuatBan);
                            if (soLuongCon > 0) {
                                qlSanPham.suaThongTin(s, index);
                            } else if (soLuongCon == 0) {
                                qlSanPham.xoaSanPham(index);
                            } else {
                                JOptionPane.showMessageDialog(null, "Không Đủ Hàng", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < ds_DiaNhac.size(); i++) {
                        if (maSanPham.equalsIgnoreCase(ds_DiaNhac.get(i).getMaSanPham())) {
                            giaBan = ds_DiaNhac.get(i).getGiaBan();
                            tenSanPham = ds_DiaNhac.get(i).getTenSanPham();
                            soLuongCon = ds_DiaNhac.get(i).getSoLuong() - soLuong;
                            int giaMua = ds_DiaNhac.get(i).getGiaMua();
                            String nhaCungCap = ds_DiaNhac.get(i).getNhaCungCap();
                            String tenCaSy = ds_DiaNhac.get(i).getTenCaSy();
                            String theLoai = ds_DiaNhac.get(i).getTheLoai();
                            int index = i;
                            DiaNhac dn = new DiaNhac(maSanPham, tenSanPham, giaMua, giaBan, nhaCungCap, soLuongCon, tenCaSy, theLoai);
                            if (soLuongCon >= 0) {
                                qlSanPham.suaThongTin(dn, index);
                            } else if (soLuongCon == 0) {
                                qlSanPham.xoaSanPham(index);
                            } else {
                                JOptionPane.showMessageDialog(null, "Không Đủ Hàng", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        }
                    }
                    break;
                default:
                    for (int i = 0; i < ds_DiaPhim.size(); i++) {
                        if (maSanPham.equalsIgnoreCase(ds_DiaPhim.get(i).getMaSanPham())) {
                            giaBan = ds_DiaPhim.get(i).getGiaBan();
                            tenSanPham = ds_DiaPhim.get(i).getTenSanPham();
                            soLuongCon = ds_DiaPhim.get(i).getSoLuong() - soLuong;
                            int giaMua = ds_DiaPhim.get(i).getGiaMua();
                            String nhaCungCap = ds_DiaPhim.get(i).getNhaCungCap();
                            String tenDaoDien = ds_DiaPhim.get(i).getTenDaoDien();
                            String theDienVien = ds_DiaPhim.get(i).getTenDienVien();
                            int index = i;
                            DiaPhim dp = new DiaPhim(maSanPham, tenSanPham, giaMua, giaBan, nhaCungCap, soLuongCon, tenDaoDien, theDienVien);
                            if (soLuongCon >= 0) {
                                qlSanPham.suaThongTin(dp, index);
                            } else if (soLuongCon == 0) {
                                qlSanPham.xoaSanPham(index);
                            } else {
                                JOptionPane.showMessageDialog(null, "Không Đủ Hàng", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        }
                    }
            }
            if (soLuongCon >= 0) {
                boolean checkTrungMaSP = false;
                sp = new SanPham(maSanPham, tenSanPham, giaBan, soLuong);
                DefaultTableModel model = (DefaultTableModel) tableBanHang.getModel();
                for (int i = 0;i<tableBanHang.getRowCount();i++){
                    if (sp.getMaSanPham().equalsIgnoreCase(tableBanHang.getValueAt(i, 0).toString())) {
                        int sl = Integer.parseInt(tableBanHang.getValueAt(i, 2).toString()) + soLuong;
                        tableBanHang.setValueAt(sl+"", i, 2);
                        tableBanHang.setValueAt(sl*sp.getGiaBan()+"", i, 4);
                        checkTrungMaSP = true;
                        break;
                    }
                }
                if (!checkTrungMaSP){
                    model.addRow(new Object[]{
                        sp.getMaSanPham(),
                        sp.getTenSanPham(),
                        sp.getSoLuong(),
                        sp.getGiaBan(),
                        sp.getGiaBan() * sp.getSoLuong()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sai Mã Hàng", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        tfThemMaSanPham.setText("");
        tfThemSoLuong.setText("");
    }

    private void cbThemVaoHoaDonLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void reset() {
        lbthem1.setVisible(false);
        lbthem2.setVisible(false);
        tfThem1.setVisible(false);
        tfThem2.setVisible(false);
        tfMaSanPham.setEditable(false);
        tfMaSanPham.setText("");
        tfTenSanPham.setEditable(false);
        tfTenSanPham.setText("");
        tfNhaCungCap.setEditable(false);
        tfNhaCungCap.setText("");
        tfGiaBan.setEditable(false);
        tfGiaBan.setText("");
        tfGiaMua.setEditable(false);
        tfGiaMua.setText("");
        tfSoLuong.setEditable(false);
        tfSoLuong.setText("");
        cbLoaiSanPham.setEnabled(false);
        tfThem1.setEditable(false);
        tfThem2.setEditable(false);
    }

    public String getDate(JLabel label) {
        Calendar date = new GregorianCalendar();
        String dateShow = String.valueOf(date.get(Calendar.DATE)) + " Tháng " + String.valueOf(date.get(Calendar.MONTH) + 1) + " Năm " + String.valueOf(date.get(Calendar.YEAR));
        switch (date.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                dateShow = "Chủ Nhật Ngày " + dateShow;
                break;
            case 2:
                dateShow = "Thứ Hai Ngày " + dateShow;
                break;
            case 3:
                dateShow = "Thứ Ba Ngày " + dateShow;
                break;
            case 4:
                dateShow = "Thứ Tư Ngày " + dateShow;
                break;
            case 5:
                dateShow = "Thứ Năm Ngày " + dateShow;
                break;
            case 6:
                dateShow = "Thứ Sáu Ngày " + dateShow;
                break;
            case 7:
                dateShow = "Thứ Bảy Ngày " + dateShow;
                break;
            default:
                break;
        }
        return dateShow;
    }

    private ArrayList<SanPham> getListSPTrongHD() {
        ArrayList<SanPham> listSP = new ArrayList<>();
        int cs = tableBanHang.getColumnCount();
        int rs = tableBanHang.getRowCount();
        for (int i = 0; i < rs; i++) {
            String maSP = tableBanHang.getValueAt(i, 0).toString();
            String tenSP = tableBanHang.getValueAt(i, 1).toString();
            int soLuong = Integer.parseInt(tableBanHang.getValueAt(i, 2).toString());
            int donGia = Integer.parseInt(tableBanHang.getValueAt(i, 3).toString());
            SanPham sp = new SanPham(maSP, tenSP, soLuong, donGia);
            listSP.add(sp);
        }
        return listSP;
    }

    private String setMaHoaDon() {
        int i = ds_HoaDon.size() + 1;
        return "HD " + getCureentTime();
    }

   

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dates = new Date();
        return dateFormat.format(dates);
    }

    private String getCureentTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date dates = new Date();
        return dateFormat.format(dates);
    } 
    private javax.swing.JButton btCapNhatSanPham;
    private javax.swing.JButton btThemSanPham;
    private javax.swing.JButton btThemVaoGioHang;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btXoaSanPham;
    private javax.swing.JButton btnXacNhan7;
    private javax.swing.JComboBox<String> cbLoaiSanPham;
    private javax.swing.JComboBox<String> cbThemVaoHoaDonLoaiSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbNgayThangNam;
    private javax.swing.JLabel lbchao;
    private javax.swing.JLabel lblGiaBan2;
    private javax.swing.JLabel lblGiaMua2;
    private javax.swing.JLabel lblLoaiSanPham2;
    private javax.swing.JLabel lblMaSanPham2;
    private javax.swing.JLabel lblNhaCungCap2;
    private javax.swing.JLabel lblTenSanPham2;
    private javax.swing.JLabel lbthem1;
    private javax.swing.JLabel lbthem2;
    private javax.swing.JLabel lbthem3;
    private javax.swing.JPanel pnChiTietBanHang7;
    private javax.swing.JPanel pnKhachHang6;
    private javax.swing.JPanel pnThongTinSPBanHang;
    private javax.swing.JTable tableBanHang;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField tfGiaBan;
    private javax.swing.JTextField tfGiaMua;
    private javax.swing.JTextField tfMaSanPham;
    private javax.swing.JTextField tfNhaCungCap;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenSanPham;
    private javax.swing.JTextField tfThem1;
    private javax.swing.JTextField tfThem2;
    private javax.swing.JTextField tfThemMaSanPham;
    private javax.swing.JTextField tfThemSoLuong;
    private javax.swing.JTextField tfTongTien;

}
