/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Controller;

import ResController.API_QLCNT;
import ResController.API_QLNT;
import com.sun.security.auth.NTSid;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Models.ChuNhaTro;
import Service.*;
import Models.Phong;
import Models.Tang;
import Models.User;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Daokh
 */
public class QuanLyNhaTro extends javax.swing.JFrame{

    API_QLCNT api;
    API_QLNT api_nt;
    public QuanLyNhaTro() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            ChucNang.getDBConnection();
//            FillToList();
            api = new API_QLCNT(btnCapNhat, btnDangxuat, btnDoiMK, btnDong, btnEdit, lblChuNT, lblDienThoai, lblEmail, lblTenCNT, txtChuNT, txtDienThoai, txtEmail, txtTenCNT);
            api.fillToCNT();
            api_nt = new API_QLNT(btnSua, btnThem, btnXoa, cboChonTang, cboTang, jLabel1, jLabel2, jPanel1, jPanel2, jPanel3, jPanel4, jPanel5, jPanel6, jScrollPane1, jScrollPane2, jTabbedPane1, lblAddress, lblAddress1, lblAnh, lblChuNT, lblDienThoai, lblDientich, lblEmail, lblGiaphong, lblImage, lblMota, lblName, lblSonguoio, lblTang, lblTenPhong, lblTotalPerson, lblTotalPerson2, tblNT, txtDienThoai, txtDienTich, txtEmail, txtGiaPhong, txtMoTa, txtSoNguoiO, txtTenPhong);
            api_nt.FillTang();
            setIconForm();
//            jTabbedPane1.setBackground(Color.red);
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Thread t=new Thread(this);
//         t.start();
    }
    public boolean checkValidate() {
        if (txtChuNT.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng không bỏ trống ");
            txtChuNT.setBackground(Color.yellow);
            return false;
        } else if (txtTenCNT.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng không bỏ trống ");
            txtTenCNT.setBackground(Color.yellow);
            return false;
        } else if (txtDienThoai.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng không bỏ trống ");
            txtDienThoai.setBackground(Color.yellow);
            return false;
        } else if (txtEmail.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng không bỏ trống ");
            txtEmail.setBackground(Color.yellow);
            return false;

        }
        return true;
    }
    public boolean checkValidateForm(String nhatro, int index) {
        if (index == 1) {
            if (txtTenPhong.getText().trim().equals("")) {
                txtTenPhong.setBackground(Color.yellow);
                lblTenPhong.setText("Chưa nhập Tên Phòng");
                return false;
            } else {
                lblTenPhong.setText("");
                txtTenPhong.setBackground(Color.white);
                return true;
            }
        }
        if (index == 2) {
            if (txtGiaPhong.getText().trim().equals("")) {
                txtGiaPhong.setBackground(Color.yellow);
                lblGiaphong.setText("Chưa nhập Giá Phòng");
                return false;

            } else {
                lblGiaphong.setText("");
                txtGiaPhong.setBackground(Color.white);
                return true;
            }
        }
        if (index == 3) {
            if (txtDienTich.getText().trim().equals("")) {
                txtDienTich.setBackground(Color.yellow);
                lblDientich.setText("Chưa nhập Diện tích");
                return false;
            } else {
                lblDientich.setText("");
                txtDienTich.setBackground(Color.white);
                return true;
            }
        }
        if (index == 4) {
            if (txtSoNguoiO.getText().trim().equals("")) {
                txtSoNguoiO.setBackground(Color.yellow);
                lblSonguoio.setText("Chưa nhập Số lượng người");
                return false;
            } else {
                lblSonguoio.setText("");
                txtSoNguoiO.setBackground(Color.white);
                return true;
            }
        }
        if (index == 5) {
            if (txtMoTa.getText().trim().equals("")) {
                txtMoTa.setBackground(Color.yellow);
                lblMota.setText("Chưa nhập Mô Tả");
                return false;
            } else {
                lblMota.setText("");
                txtMoTa.setBackground(Color.white);
                return true;
            }
        }

        return true;
    }

    public void setIconForm() {
        String path = "src/image/";
        lblChuNT.setIcon(new ImageIcon(path + "MaCNT.png"));
        lblTenCNT.setIcon(new ImageIcon("src/image/TenCNT.png"));
        lblDienThoai.setIcon(new ImageIcon("src/image/DienThoai.png"));
        lblEmail.setIcon(new ImageIcon("src/image/Email.png"));
        btnEdit.setIcon(new ImageIcon("src/image/Edit.png"));
        btnDong.setIcon(new ImageIcon("src/image/Cancel.png"));
        btnCapNhat.setIcon(new ImageIcon("src/image/Update.png"));
        btnDangxuat.setIcon(new ImageIcon(path + "LogOut.png"));
        lblName.setIcon(new ImageIcon(path + "TenPhong.png"));
        lblAddress.setIcon(new ImageIcon(path + "GiaPhong.png"));
        lblTotalPerson.setIcon(new ImageIcon(path + "DienTich.png"));
        lblTang.setIcon(new ImageIcon(""));
        lblAddress1.setIcon(new ImageIcon(path + "SoNguoiO.png"));
        lblTotalPerson2.setIcon(new ImageIcon(path + "MoTa.png"));
        btnThem.setIcon(new ImageIcon(path + "ADD.png"));
        btnXoa.setIcon(new ImageIcon(path + "Delete.png"));
        btnSua.setIcon(new ImageIcon(path + "Update.png"));
        lblImage.setIcon(new ImageIcon(path + "NoImg.jpg"));
        lblTang.setIcon(new ImageIcon(path + "tang.jpg"));
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblChuNT = new javax.swing.JLabel();
        lblTenCNT = new javax.swing.JLabel();
        lblDienThoai = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtChuNT = new javax.swing.JTextField();
        txtTenCNT = new javax.swing.JTextField();
        txtDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JToggleButton();
        btnDong = new javax.swing.JToggleButton();
        btnCapNhat = new javax.swing.JToggleButton();
        btnDoiMK = new javax.swing.JButton();
        btnDangxuat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtDienTich = new javax.swing.JTextField();
        lblTotalPerson = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNT = new javax.swing.JTable();
        lblImage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtSoNguoiO = new javax.swing.JTextField();
        lblAddress1 = new javax.swing.JLabel();
        lblTotalPerson2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        txtGiaPhong = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnChonANh = new javax.swing.JButton();
        lblTenPhong = new javax.swing.JLabel();
        lblGiaphong = new javax.swing.JLabel();
        lblDientich = new javax.swing.JLabel();
        lblMota = new javax.swing.JLabel();
        lblSonguoio = new javax.swing.JLabel();
        lblTang = new javax.swing.JLabel();
        cboTang = new javax.swing.JComboBox<>();
        lblAnh = new javax.swing.JLabel();
        cboChonTang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(25, 149, 242));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setForeground(new java.awt.Color(25, 149, 242));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 24), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.setToolTipText("");

        lblChuNT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblChuNT.setForeground(new java.awt.Color(25, 149, 242));
        lblChuNT.setText("Mã Chủ Nhà Trọ:");

        lblTenCNT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenCNT.setForeground(new java.awt.Color(25, 149, 242));
        lblTenCNT.setText("Tên Chủ Nhà Trọ:");

        lblDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDienThoai.setForeground(new java.awt.Color(25, 149, 242));
        lblDienThoai.setText("Điện Thoại: ");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(25, 149, 242));
        lblEmail.setText("Email:");

        txtChuNT.setEditable(false);
        txtChuNT.setForeground(new java.awt.Color(25, 149, 242));
        txtChuNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChuNTActionPerformed(evt);
            }
        });

        txtTenCNT.setEditable(false);
        txtTenCNT.setForeground(new java.awt.Color(25, 149, 242));

        txtDienThoai.setEditable(false);
        txtDienThoai.setForeground(new java.awt.Color(25, 149, 242));
        txtDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienThoaiActionPerformed(evt);
            }
        });

        txtEmail.setEditable(false);
        txtEmail.setForeground(new java.awt.Color(25, 149, 242));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenCNT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChuNT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtChuNT, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenCNT, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChuNT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChuNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenCNT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenCNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnEdit.setBackground(new java.awt.Color(25, 149, 242));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Sửa");
        btnEdit.setBorder(null);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel6.add(btnEdit);

        btnDong.setBackground(new java.awt.Color(25, 149, 242));
        btnDong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDong.setForeground(new java.awt.Color(255, 255, 255));
        btnDong.setText("Đóng");
        btnDong.setBorder(null);
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });
        jPanel6.add(btnDong);

        btnCapNhat.setBackground(new java.awt.Color(25, 149, 242));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setBorder(null);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel6.add(btnCapNhat);

        btnDoiMK.setBackground(new java.awt.Color(25, 149, 242));
        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiMK.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.setBorder(null);
        btnDoiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMKMouseClicked(evt);
            }
        });
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });
        jPanel6.add(btnDoiMK);

        btnDangxuat.setBackground(new java.awt.Color(25, 149, 242));
        btnDangxuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangxuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangxuat.setText("Đăng xuất");
        btnDangxuat.setBorder(null);
        btnDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangxuatActionPerformed(evt);
            }
        });
        jPanel6.add(btnDangxuat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(630, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("THÔNG TIN CÁ NHÂN CHỦ SỞ HỮU", jPanel3);

        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        lblName.setText("Tên phòng");

        txtTenPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtTenPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTenPhongMousePressed(evt);
            }
        });
        txtTenPhong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenPhongKeyReleased(evt);
            }
        });

        lblAddress.setText("Giá phòng");

        txtDienTich.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDienTich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDienTichMousePressed(evt);
            }
        });
        txtDienTich.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDienTichKeyReleased(evt);
            }
        });

        lblTotalPerson.setText("Diện tích");

        tblNT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Phòng", "Giá phòng", "Số lượng ở tối đa", "Số lượng đang ở", "Chi tiết khách hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNT.setGridColor(new java.awt.Color(25, 149, 242));
        tblNT.setRowHeight(30);
        tblNT.setShowGrid(true);
        tblNT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNT);
        if (tblNT.getColumnModel().getColumnCount() > 0) {
            tblNT.getColumnModel().getColumn(0).setMinWidth(20);
            tblNT.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblImage.setMaximumSize(new java.awt.Dimension(330, 200));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel5.add(btnThem);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel5.add(btnXoa);

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel5.add(btnSua);

        txtSoNguoiO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtSoNguoiO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtSoNguoiOMousePressed(evt);
            }
        });
        txtSoNguoiO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNguoiOActionPerformed(evt);
            }
        });
        txtSoNguoiO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoNguoiOKeyReleased(evt);
            }
        });

        lblAddress1.setBackground(new java.awt.Color(204, 204, 204));
        lblAddress1.setText("Số người ở");

        lblTotalPerson2.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        txtMoTa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMoTaMousePressed(evt);
            }
        });
        txtMoTa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoTaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtMoTa);

        txtGiaPhong.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        txtGiaPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtGiaPhongMousePressed(evt);
            }
        });
        txtGiaPhong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaPhongKeyReleased(evt);
            }
        });

        jLabel1.setText("m2");

        jLabel2.setText("VNĐ");

        btnChonANh.setText("Chọn ảnh");
        btnChonANh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonANhActionPerformed(evt);
            }
        });

        lblTang.setText("Tầng");

        lblAnh.setForeground(new java.awt.Color(255, 0, 51));

        cboChonTang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboChonTangItemStateChanged(evt);
            }
        });
        cboChonTang.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                cboChonTangHierarchyChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnChonANh)
                                .addGap(27, 27, 27)
                                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboChonTang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                        .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTotalPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblTotalPerson2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMota, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(lblTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblGiaphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDientich, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboTang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSoNguoiO, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSonguoio, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(57, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(lblGiaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(lblDientich, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalPerson, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress1)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSonguoio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoNguoiO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTang)
                                    .addComponent(cboTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addComponent(lblMota, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblTotalPerson2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))))))
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChonANh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(cboChonTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("QUẢN LÍ NHÀ TRỌ", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1158, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        //        index =-1;
        //        tblNT.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        index = tblNT.getSelectedRow();
        if (index != -1) {
            index = -1;
            tblNT.clearSelection();
            api_nt.Clear();
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void cboChonTangHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_cboChonTangHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChonTangHierarchyChanged

    private void cboChonTangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboChonTangItemStateChanged
        // TODO add your handling code here:
        api_nt.ChonTang();
        
    }//GEN-LAST:event_cboChonTangItemStateChanged

    private void btnChonANhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonANhActionPerformed
        // TODO add your handling code here:
        api_nt.ChonAnh();
    }//GEN-LAST:event_btnChonANhActionPerformed

    private void txtGiaPhongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaPhongKeyReleased
        checkValidateForm(txtGiaPhong.getText(), 2);
    }//GEN-LAST:event_txtGiaPhongKeyReleased

    private void txtGiaPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGiaPhongMousePressed
        checkValidateForm(txtGiaPhong.getText(), 2);
    }//GEN-LAST:event_txtGiaPhongMousePressed

    private void txtMoTaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoTaKeyReleased
        checkValidateForm(txtMoTa.getText(), 5);
    }//GEN-LAST:event_txtMoTaKeyReleased

    private void txtMoTaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMoTaMousePressed
        checkValidateForm(txtMoTa.getText(), 5);
    }//GEN-LAST:event_txtMoTaMousePressed

    private void txtSoNguoiOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNguoiOKeyReleased
        checkValidateForm(txtSoNguoiO.getText(), 4);
    }//GEN-LAST:event_txtSoNguoiOKeyReleased

    private void txtSoNguoiOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNguoiOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiOActionPerformed

    private void txtSoNguoiOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoNguoiOMousePressed
        checkValidateForm(txtSoNguoiO.getText(), 4);
    }//GEN-LAST:event_txtSoNguoiOMousePressed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        api_nt.Sua();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        api_nt.Xoa();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkValidateForm(txtTenPhong.getText(), 1) == false) {
            txtTenPhong.requestFocus();
            return;
        }
        if (checkValidateForm(txtGiaPhong.getText(), 2) == false) {
            txtGiaPhong.requestFocus();
            return;
        }
        if (checkValidateForm(txtDienTich.getText(), 3) == false) {
            txtDienTich.requestFocus();
            return;
        }
        if (checkValidateForm(txtSoNguoiO.getText(), 4) == false) {
            txtSoNguoiO.requestFocus();
            return;
        }
        if (checkValidateForm(txtMoTa.getText(), 5) == false) {
            txtMoTa.requestFocus();
            return;
        }
        if (name.equalsIgnoreCase("")) {
            lblAnh.setText("Chưa chọn ảnh");
            return;
        }
        //        System.out.println(new ImageIcon(lblImage.getIcon()).toString());
        api_nt.Them();
        //        FillToList();

    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNTMouseClicked

        index = tblNT.getSelectedRow();
        api_nt.mouseClick(index);
    }//GEN-LAST:event_tblNTMouseClicked

    private void txtDienTichKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDienTichKeyReleased
        checkValidateForm(txtDienTich.getText(), 3);
    }//GEN-LAST:event_txtDienTichKeyReleased

    private void txtDienTichMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDienTichMousePressed
        checkValidateForm(txtDienTich.getText(), 3);
    }//GEN-LAST:event_txtDienTichMousePressed

    private void txtTenPhongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenPhongKeyReleased
        checkValidateForm(txtTenPhong.getText(), 1);
    }//GEN-LAST:event_txtTenPhongKeyReleased

    private void txtTenPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenPhongMousePressed
        checkValidateForm(txtTenPhong.getText(), 1);
    }//GEN-LAST:event_txtTenPhongMousePressed

    private void btnDangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangxuatActionPerformed
        //        try {
            //            list2 = (List<User>) ChucNang.readObj("x.txt");
            //            for (User x : list2) {
                //                if (x.getUser().equalsIgnoreCase(cnt.getUsernameChu())) {
                    //                    if (!x.isRemember()) {
                        //                        list2.remove(x);
                        //                        break;
                        //                    } else {
                        //                        x.setIsLogin(false);
                        //                    }
                    //                }
                //            }
            //            ChucNang.writeObj("x.txt", list2);
            //        } catch (IOException ex) {
            //            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
            //        } catch (ClassNotFoundException ex) {
            //            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
            //        }
        api.DX();
        this.setVisible(false);
        new SignIn().setVisible(true);
    }//GEN-LAST:event_btnDangxuatActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void btnDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMKMouseClicked

        api.DoiMK();
    }//GEN-LAST:event_btnDoiMKMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        api.CapNhat();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        api.Dong();
        //     System.exit(0);
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        //        JOptionPane.showConfirmDialog(this,"Chỉnh sửa thành  công");
        api.Sua();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDienThoaiActionPerformed

    private void txtChuNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChuNTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChuNTActionPerformed
    public static String name = "";int index = -1;    

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhaTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhaTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhaTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhaTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhaTro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCapNhat;
    private javax.swing.JButton btnChonANh;
    private javax.swing.JButton btnDangxuat;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JToggleButton btnDong;
    private javax.swing.JToggleButton btnEdit;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboChonTang;
    private javax.swing.JComboBox<String> cboTang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddress1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblChuNT;
    private javax.swing.JLabel lblDienThoai;
    private javax.swing.JLabel lblDientich;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGiaphong;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblMota;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSonguoio;
    private javax.swing.JLabel lblTang;
    private javax.swing.JLabel lblTenCNT;
    private javax.swing.JLabel lblTenPhong;
    private javax.swing.JLabel lblTotalPerson;
    private javax.swing.JLabel lblTotalPerson2;
    private javax.swing.JTable tblNT;
    private javax.swing.JTextField txtChuNT;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtDienTich;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtGiaPhong;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoNguoiO;
    private javax.swing.JTextField txtTenCNT;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables
}
