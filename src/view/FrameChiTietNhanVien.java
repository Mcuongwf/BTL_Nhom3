package view;


import controller.QuanLyNhanVien;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import model.NhanVien;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class FrameChiTietNhanVien extends javax.swing.JFrame {

    int type;
    int index;
    QuanLyNhanVien qlNhanVien;

    /**
     * Creates new form FrameThemNhanVien
     */
    public FrameChiTietNhanVien() {
        initComponents();
        this.setTitle("Nhân Viên");
        setLocationRelativeTo(null);
        qlNhanVien = new QuanLyNhanVien();
    }

    public FrameChiTietNhanVien(int type, int index, QuanLyNhanVien qlNhanVien) {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Nhân Viên");
        this.type = type;
        this.index = index;
        this.qlNhanVien = qlNhanVien;
        if (this.type == 1) {
            setTitle("THÊM NHÂN VIÊN");
            lblNhanVien.setText("Thêm Nhân Viên");
        } else {
            setTitle("CẬP NHẬT THÔNG TIN");
            lblNhanVien.setText("Cập Nhật Nhân Viên");
            NhanVien nv = qlNhanVien.getDS_NhanVien().get(index);
            tfTenNhanVien.setText(nv.getTenNhanVien());
            tfMaNhanVien.setText(nv.getMaNhanVien());
            tfMaNhanVien.setEditable(false);
            if (nv.getGioiTinh().equalsIgnoreCase("Nam")) {
                btgrGioiTinh.setSelected(rdNam.getModel(), true);
                rdNu.setVisible(false);
            } else {
                btgrGioiTinh.setSelected(rdNu.getModel(), true);
                rdNam.setVisible(false);
            }
            tfSoDienThoai.setText(nv.getSoDienThoai());
            tfEmail.setText(nv.getEmail());
        
        
            tfTenTaiKhoan.setText(nv.getTenDangNhap());
            tfTenTaiKhoan.setEditable(false);
            tfMatKhau.setText(nv.getMatKhau());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btgrGioiTinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        tfTenNhanVien = new javax.swing.JTextField();
        lblGioiTinh = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        lblSoDienThoai = new javax.swing.JLabel();
        tfSoDienThoai = new javax.swing.JTextField();
        lblEmailNhanVien = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lblMaNhanVien = new javax.swing.JLabel();
        tfMaNhanVien = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblTenTaiKhoan = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        tfTenTaiKhoan = new javax.swing.JTextField();
        tfMatKhau = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nhanvien.png"))); 

        lblNhanVien.setFont(new java.awt.Font("Tahoma", 1, 30)); 
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhanVien.setText("Thêm Nhân Viên");

        lblTenNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblTenNhanVien.setText("Tên Nhân Viên:");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblGioiTinh.setText("Giới Tính:");

        btgrGioiTinh.add(rdNam);
        rdNam.setText("Nam");

        btgrGioiTinh.add(rdNu);
        rdNu.setText("Nữ");

        lblSoDienThoai.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblSoDienThoai.setText("Số Điện Thoại:");

        lblEmailNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblEmailNhanVien.setText("Email:");

        lblMaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblMaNhanVien.setText("Mã Nhân Viên:");

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tài Khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(102, 102, 102))); 

        lblTenTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblTenTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); 
        lblTenTaiKhoan.setText("Tên Tài Khoản:");

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        lblMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/key.png"))); 
        lblMatKhau.setText("Mật Khẩu:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(tfMatKhau))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btOK.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ok.png")));
        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btHuy.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        btHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove-button.png"))); 
        btHuy.setText("Hủy");
        btHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyActionPerformed(evt);
            }
        });
        
        textField = new JTextField();
        textField.setBackground(Color.WHITE);
        
        lblDiaChi_1 = new JLabel();
        lblDiaChi_1.setText("Địa Chỉ:");
        lblDiaChi_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(11)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addComponent(btOK, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(btHuy, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(lblTenNhanVien, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(tfTenNhanVien, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(lblMaNhanVien, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        									.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        									.addGroup(jPanel1Layout.createSequentialGroup()
        										.addComponent(rdNam, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(rdNu, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
        									.addComponent(tfMaNhanVien, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
        							.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        									.addComponent(lblDiaChi_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        									.addComponent(lblEmailNhanVien, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        									.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))))))
        				.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(lblSoDienThoai, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(tfSoDienThoai, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNhanVien)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTenNhanVien, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tfTenNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblMaNhanVien, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tfMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(rdNam)
        				.addComponent(rdNu))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblSoDienThoai, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tfSoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEmailNhanVien, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(15)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDiaChi_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        			.addGap(78)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btOK, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btHuy, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {lblTenNhanVien, lblGioiTinh, lblSoDienThoai, lblEmailNhanVien, lblMaNhanVien});
        jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblTenNhanVien, lblGioiTinh, lblSoDienThoai, lblEmailNhanVien, lblMaNhanVien});
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btHuyActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {
        String thongBao = "";
        if (tfMaNhanVien.getText().trim().length() == 0) {
            thongBao += "Chưa Điền mã nhân viên";
        }
        if (tfTenNhanVien.getText().trim().length() == 0) {
            thongBao += "\nChưa Điền tên nhân viên";
        }
       
        if (tfEmail.getText().trim().length() == 0) {
            thongBao += "\nChưa điên email";
        }
        if (tfSoDienThoai.getText().trim().length() == 0) {
            thongBao += "\nChưa điên số điện thoại";
        }
       
        if (thongBao.length() != 0) {
            JOptionPane.showMessageDialog(null, thongBao, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String maNhanVien = tfMaNhanVien.getText();
            String tenNhanVien = tfTenNhanVien.getText();
            String email = tfEmail.getText();
            String soDienThoai = tfSoDienThoai.getText();
            String tenDangNhap = tfTenTaiKhoan.getText();
            String matKhau = tfMatKhau.getText();
            String gioiTinh;
            if (rdNam.isSelected()) {
                gioiTinh = "Nam";
            } else {
                gioiTinh = "Nữ";
            }
            if (this.type == 1) {
                NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, gioiTinh, email, soDienThoai, tenDangNhap, matKhau);
                qlNhanVien.themNhanVien(nv);
            } else {
                NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, gioiTinh, email, soDienThoai, tenDangNhap, matKhau);
                qlNhanVien.suaThongTinNhanVien(nv, index);
            }
            this.dispose();
        }
    }

    public static Date string_To_Date(String s) {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = dateformat.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(FrameChiTietNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    public static String date_To_String(java.util.Date date) {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        String s = dateformat.format(date);
        return s;
    }

    private javax.swing.JButton btHuy;
    private javax.swing.JButton btOK;
    private javax.swing.ButtonGroup btgrGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblEmailNhanVien;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTenTaiKhoan;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfMaNhanVien;
    private javax.swing.JTextField tfMatKhau;
    private javax.swing.JTextField tfSoDienThoai;
    private javax.swing.JTextField tfTenNhanVien;
    private javax.swing.JTextField tfTenTaiKhoan;
    private JTextField textField;
    private JLabel lblDiaChi_1;
}
