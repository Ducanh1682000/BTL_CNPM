/*
 Navicat Premium Data Transfer

 Source Server         : Test
 Source Server Type    : MySQL
 Source Server Version : 100414
 Source Host           : localhost:3306
 Source Schema         : quan_ly_nhan_khau

 Target Server Type    : MySQL
 Target Server Version : 100414
 File Encoding         : 65001

 Date: 12/12/2020 14:30:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chung_minh_thu
-- ----------------------------
DROP TABLE IF EXISTS `chung_minh_thu`;
CREATE TABLE `chung_minh_thu`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` int(11) NULL DEFAULT NULL,
  `soCMT` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngayCap` date NULL DEFAULT NULL,
  `noiCap` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idNhanKhau`(`idNhanKhau`) USING BTREE,
  FULLTEXT INDEX `soCMT`(`soCMT`),
  CONSTRAINT `chung_minh_thu_ibfk_1` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chung_minh_thu
-- ----------------------------
INSERT INTO `chung_minh_thu` VALUES (13, 26, '000000000001', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (14, 27, '000000000002', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (15, 28, '000000000003', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (16, 29, '000000000004', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (17, 30, '000000000005', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (18, 31, '000000000006', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (19, 32, '000000000007', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (20, 33, '000000000008', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (21, 34, '000000000009', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (22, 35, '100000000001', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (23, 36, '100000000002', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (24, 37, '000000000010', NULL, NULL);
INSERT INTO `chung_minh_thu` VALUES (25, 38, '000000000011', NULL, NULL);

-- ----------------------------
-- Table structure for dinh_chinh
-- ----------------------------
DROP TABLE IF EXISTS `dinh_chinh`;
CREATE TABLE `dinh_chinh`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idHoKhau` int(11) NULL DEFAULT NULL,
  `thongTinThayDoi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `thayDoiTu` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `thayDoiThanh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ngayThayDoi` date NULL DEFAULT NULL,
  `nguoiThayDoi` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idHoKhau`(`idHoKhau`) USING BTREE,
  INDEX `nguoiThayDoi`(`nguoiThayDoi`) USING BTREE,
  CONSTRAINT `dinh_chinh_ibfk_1` FOREIGN KEY (`idHoKhau`) REFERENCES `ho_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dinh_chinh_ibfk_2` FOREIGN KEY (`nguoiThayDoi`) REFERENCES `users` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gia_dinh
-- ----------------------------
DROP TABLE IF EXISTS `gia_dinh`;
CREATE TABLE `gia_dinh`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` int(11) NULL DEFAULT NULL,
  `hoTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `namSinh` date NULL DEFAULT NULL,
  `gioiTinh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `quanHeVoiNhanKhau` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ngheNghiep` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `diaChiHienTai` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idNhanKhau`(`idNhanKhau`) USING BTREE,
  CONSTRAINT `gia_dinh_ibfk_1` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gia_dinh
-- ----------------------------
INSERT INTO `gia_dinh` VALUES (2, 27, 'Nguyễn Minh Quân', '1995-05-31', 'Nam', 'Chồng', 'Kỹ sư', 'Số 2 Tạ Quang Bửu, Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (3, 28, 'Trần Thanh Duyên', '1997-12-23', 'Nữ', 'Vợ', 'Nhân viên văn phòng', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (4, 29, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Vợ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (5, 29, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Con trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (6, 29, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Con gái', 'Luật sư', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (7, 30, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Chồng', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (8, 30, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Con trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (9, 30, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Con Gái', 'Luật sư', '');
INSERT INTO `gia_dinh` VALUES (10, 31, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Bố', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (11, 31, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Mẹ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (12, 31, 'Nguyễn Trà My', '1997-12-12', 'Nữ', 'Em gái', 'Luật sư', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (13, 32, 'Nguyễn Tiến Dũng', '1964-06-03', 'Nam', 'Bố', 'Phó giám đốc', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (14, 32, 'Vũ Mỹ Linh', '1965-12-06', 'Nữ', 'Mẹ', 'Nội trợ', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (15, 32, 'Nguyễn Tiến Đạt', '1990-09-09', 'Nam', 'Anh trai', 'Kỹ sư điện', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (16, 33, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ', 'Vợ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (17, 33, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Con trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (18, 33, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Con gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (19, 34, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Con trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (20, 34, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Con gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (21, 34, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Chồng', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (22, 35, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Bố', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (23, 35, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ', 'Mẹ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (24, 35, 'Trần Thúy Ngọc', '2013-01-15', 'Nữ', 'Em gái', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (25, 36, 'Trần Văn Nam', '1980-07-09', 'Nam', 'Bố', 'Giảng viên đại học', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (26, 36, 'Nguyễn Minh Tuyết', '1985-09-02', 'Nữ ', 'Mẹ', 'Bác sĩ', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (27, 36, 'Trần Trung Kiên', '2008-12-25', 'Nam', 'Anh trai', 'Học sinh', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (28, 37, 'Bùi Thị Hà', '1948-02-03', 'Nữ', 'Vợ', 'Nội trợ', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (29, 37, 'Lý Thành Nam', '1968-06-12', 'Nam', 'Con Trai', 'Công nhân', 'Số 89, ngõ 98 Trường Chinh, Hà Nội');
INSERT INTO `gia_dinh` VALUES (30, 37, 'Lý Thu Thủy', '1971-03-05', 'Nữ', 'Con Gái', 'Nhân viên văn phòng', 'Số 3, ngõ 568 Đường Láng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (31, 38, 'Lý Văn Công', '1945-06-04', 'Nam', 'Chồng', 'Bộ đội về hưu', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội');
INSERT INTO `gia_dinh` VALUES (32, 38, 'Lý Thành Nam', '1968-06-12', 'Nam', 'Con trai', 'Công nhân', 'Số 89, ngõ 98 Trường Chinh, Hà Nội');
INSERT INTO `gia_dinh` VALUES (33, 38, 'Lý Thu Thủy', '1971-03-05', 'Nữ', 'Con gái', 'Nhân viên văn phòng', 'Số 3, ngõ 568 Đường Láng, Hà Nội');

-- ----------------------------
-- Table structure for ho_khau
-- ----------------------------
DROP TABLE IF EXISTS `ho_khau`;
CREATE TABLE `ho_khau`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `maHoKhau` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `idChuHo` int(11) NULL DEFAULT NULL,
  `maKhuVuc` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ngayLap` date NULL DEFAULT NULL,
  `ngayChuyenDi` date NULL DEFAULT NULL,
  `lyDoChuyen` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  `nguoiThucHien` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idChuHo`(`idChuHo`) USING BTREE,
  FULLTEXT INDEX `maHoKhau`(`maHoKhau`),
  CONSTRAINT `ho_khau_ibfk_1` FOREIGN KEY (`idChuHo`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ho_khau
-- ----------------------------
INSERT INTO `ho_khau` VALUES (13, 'TQB002', 28, 'HN03', 'Số 2 Tạ Quang Bửu, quần Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL);
INSERT INTO `ho_khau` VALUES (14, 'TQB001', 26, 'HN03', 'Số 1 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL);
INSERT INTO `ho_khau` VALUES (15, 'TQB003', 29, 'HN03', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL);
INSERT INTO `ho_khau` VALUES (16, 'TQB004', 33, 'HN03', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for khai_tu
-- ----------------------------
DROP TABLE IF EXISTS `khai_tu`;
CREATE TABLE `khai_tu`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `soGiayKhaiTu` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `idNguoiKhai` int(11) NULL DEFAULT NULL,
  `idNguoiChet` int(11) NULL DEFAULT NULL,
  `ngayKhai` date NULL DEFAULT NULL,
  `ngayChet` date NULL DEFAULT NULL,
  `lyDoChet` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idNguoiKhai`(`idNguoiKhai`) USING BTREE,
  INDEX `idNguoiChet`(`idNguoiChet`) USING BTREE,
  CONSTRAINT `khai_tu_ibfk_1` FOREIGN KEY (`idNguoiKhai`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `khai_tu_ibfk_2` FOREIGN KEY (`idNguoiChet`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for nhan_khau
-- ----------------------------
DROP TABLE IF EXISTS `nhan_khau`;
CREATE TABLE `nhan_khau`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `maNhanKhau` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `hoTen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `bietDanh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `namSinh` date NULL DEFAULT NULL,
  `gioiTinh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `noiSinh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `nguyenQuan` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `danToc` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `tonGiao` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `quocTich` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `soHoChieu` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `noiThuongTru` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `diaChiHienNay` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `trinhDoHocVan` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `TrinhDoChuyenMon` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `bietTiengDanToc` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `trinhDoNgoaiNgu` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ngheNghiep` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `noiLamViec` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `tienAn` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ngayChuyenDen` date NULL DEFAULT NULL,
  `lyDoChuyenDen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ngayChuyenDi` date NULL DEFAULT NULL,
  `lyDoChuyenDi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `diaChiMoi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ngayTao` date NULL DEFAULT NULL,
  `idNguoiTao` int(11) NULL DEFAULT NULL,
  `ngayXoa` date NULL DEFAULT NULL,
  `idNguoiXoa` int(11) NULL DEFAULT NULL,
  `lyDoXoa` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ghiChu` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idNguoiTao`(`idNguoiTao`) USING BTREE,
  INDEX `idNguoiXoa`(`idNguoiXoa`) USING BTREE,
  FULLTEXT INDEX `hoTen`(`hoTen`, `bietDanh`),
  CONSTRAINT `nhan_khau_ibfk_1` FOREIGN KEY (`idNguoiTao`) REFERENCES `users` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `nhan_khau_ibfk_2` FOREIGN KEY (`idNguoiXoa`) REFERENCES `users` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nhan_khau
-- ----------------------------
INSERT INTO `nhan_khau` VALUES (26, NULL, 'Trinh Văn An', '', '1990-12-07', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', 'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình đọ B', 'Giáo Viên', 'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (27, NULL, 'Trần Thanh Duyên', '', '1997-12-23', 'Nữ', NULL, 'Hải Phòng', 'Kinh', 'Không', 'Việt Nam', '', 'Số 3, đường Đình Đông, phường Đình Đông, quận Ngô Quyền, Hải Phòng', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Nhân viên văn phòng', 'Công ty ABC', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (28, NULL, 'Nguyễn Minh Quân', '', '1995-05-31', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Kỹ sư', 'Viettel', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (29, NULL, 'Nguyễn Tiến Dũng', '', '1964-06-03', 'Nam', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Kỹ sư', 'Không', 'Không', 'Phó giám đốc', 'Công ty EXE', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (30, NULL, 'Vũ Mỹ Linh', '', '1965-12-06', 'Nữ', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12', 'Cử Nhân', 'Không', 'Không', 'Nội trợ', 'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (31, NULL, 'Nguyễn Tiến Đạt', '', '1990-09-09', 'Nam', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Kỹ sư', 'không', 'Anh trình độ C', 'Kỹ sư điện', 'Công ty điện EVN', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (32, NULL, 'Nguyễn Trà My', '', '1997-12-12', 'Nữ', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'không', 'Anh trình đố D', 'Luật sư', 'Văn phòng luật sư 123', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (33, NULL, 'Trần Văn Nam', '', '1980-07-09', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Tiến sĩ', 'Không', 'Anh trình độ D', 'Giảng viên đại học', 'Đại học Bách khoa Hà Nội', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (34, NULL, 'Nguyễn Minh Tuyết', '', '1985-09-02', 'Nữ', NULL, 'Nam Định', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Bác sĩ', 'Bệnh viện quốc tế HJK', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (35, NULL, 'Trần Trung Kiên', '', '2008-12-25', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '6/12 chính quy', 'Không', 'Không', 'Không', 'Học sinh', 'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (36, NULL, 'Trần Thúy Ngọc', '', '2013-01-15', 'Nữ', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '1/12 chính quy', 'Không', 'Không', 'Không', 'Học sinh', 'Trường tiểu học Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (37, NULL, 'Lý Văn Công', '', '1945-06-04', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '10/12 chính quy', 'Không', 'Không', 'Không', 'Về hưu', 'Không', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);
INSERT INTO `nhan_khau` VALUES (38, NULL, 'Bùi Thị Hà', '', '1948-02-03', 'Nữ', NULL, 'Hải Phòng', 'Kinh', 'Không', 'Việt Nam', '', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '10/12', 'Không', 'Không', 'Không', 'Nội trợ', 'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for phi_dong_gop
-- ----------------------------
DROP TABLE IF EXISTS `phi_dong_gop`;
CREATE TABLE `phi_dong_gop`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `IdHoKhau` int(100) NOT NULL,
  `dotDongGop` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `thoiGian` date NULL DEFAULT NULL,
  `soTien` int(100) NULL DEFAULT NULL,
  `ghiChu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phi_dong_gop
-- ----------------------------
INSERT INTO `phi_dong_gop` VALUES (1, 13, 'Trợ giúp đồng bào miền Trung lũ lụt', '2020-12-01', 100000, NULL);
INSERT INTO `phi_dong_gop` VALUES (2, 13, 'Ủng hộ quỹ vì người nghèo', '2020-11-11', 50000, NULL);
INSERT INTO `phi_dong_gop` VALUES (3, 14, 'Trợ giúp đồng bào miền Trung lũ lụt', '2020-11-20', 200000, NULL);
INSERT INTO `phi_dong_gop` VALUES (4, 15, 'Ủng hộ ngày tết thiếu nhi', '2020-06-01', 50000, NULL);
INSERT INTO `phi_dong_gop` VALUES (5, 13, 'Ủng hộ ngày tết thiếu nhi', '2020-06-01', 300000, NULL);
INSERT INTO `phi_dong_gop` VALUES (6, 16, 'Ủng hộ trẻ em khuyết tật', '2020-10-10', 150000, NULL);
INSERT INTO `phi_dong_gop` VALUES (7, 14, 'Ủng hộ ngày thương binh liệt sĩ 27/07', '2020-07-20', 1000000, NULL);
INSERT INTO `phi_dong_gop` VALUES (8, 13, 'Ủng hộ trẻ em khuyết tật', '2020-05-05', 30000, NULL);
INSERT INTO `phi_dong_gop` VALUES (9, 15, 'Ủng hộ công tác phòng chống dịch COVID-19', '2020-01-01', 250000, NULL);
INSERT INTO `phi_dong_gop` VALUES (10, 14, 'Ủng hộ công tác phòng chống dịch COVID-19', '2020-01-02', 100000, NULL);
INSERT INTO `phi_dong_gop` VALUES (11, 16, 'Trợ giúp đồng bào miền Trung lũ lụt', '2020-10-05', 150000, NULL);

-- ----------------------------
-- Table structure for tam_tru
-- ----------------------------
DROP TABLE IF EXISTS `tam_tru`;
CREATE TABLE `tam_tru`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` int(11) NULL DEFAULT NULL,
  `maGiayTamtru` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `soDienThoaiNguoiDangKy` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `tuNgay` date NOT NULL,
  `denNgay` date NOT NULL,
  `lyDo` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idNhanKhau`(`idNhanKhau`) USING BTREE,
  CONSTRAINT `tam_tru_ibfk_1` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tam_vang
-- ----------------------------
DROP TABLE IF EXISTS `tam_vang`;
CREATE TABLE `tam_vang`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` int(11) NULL DEFAULT NULL,
  `maGiayTamVang` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `noiTamtru` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `tuNgay` date NULL DEFAULT NULL,
  `denNgay` date NULL DEFAULT NULL,
  `lyDo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idNhanKhau`(`idNhanKhau`) USING BTREE,
  CONSTRAINT `tam_vang_ibfk_1` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thanh_vien_cua_ho
-- ----------------------------
DROP TABLE IF EXISTS `thanh_vien_cua_ho`;
CREATE TABLE `thanh_vien_cua_ho`  (
  `idNhanKhau` int(11) NOT NULL,
  `idHoKhau` int(11) NOT NULL,
  `quanHeVoiChuHo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`idNhanKhau`, `idHoKhau`) USING BTREE,
  INDEX `idHoKhau`(`idHoKhau`) USING BTREE,
  CONSTRAINT `thanh_vien_cua_ho_ibfk_1` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `thanh_vien_cua_ho_ibfk_2` FOREIGN KEY (`idHoKhau`) REFERENCES `ho_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thanh_vien_cua_ho
-- ----------------------------
INSERT INTO `thanh_vien_cua_ho` VALUES (26, 14, 'Chủ hộ');
INSERT INTO `thanh_vien_cua_ho` VALUES (27, 13, 'Vợ');
INSERT INTO `thanh_vien_cua_ho` VALUES (29, 15, 'Chủ hộ');
INSERT INTO `thanh_vien_cua_ho` VALUES (30, 15, 'Vợ');
INSERT INTO `thanh_vien_cua_ho` VALUES (31, 15, 'Con trai');
INSERT INTO `thanh_vien_cua_ho` VALUES (32, 15, 'Con gái');
INSERT INTO `thanh_vien_cua_ho` VALUES (33, 16, 'Chủ hộ');
INSERT INTO `thanh_vien_cua_ho` VALUES (34, 16, 'Vợ');
INSERT INTO `thanh_vien_cua_ho` VALUES (35, 16, 'Con trai');
INSERT INTO `thanh_vien_cua_ho` VALUES (36, 16, 'Con gái');

-- ----------------------------
-- Table structure for thu_phi
-- ----------------------------
DROP TABLE IF EXISTS `thu_phi`;
CREATE TABLE `thu_phi`  (
  `idHoKhau` int(11) NOT NULL,
  `soTien` int(255) NULL DEFAULT NULL,
  `thoiGian` date NULL DEFAULT NULL,
  `trangThai` bit(1) NULL DEFAULT NULL,
  `ghiChu` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`idHoKhau`) USING BTREE,
  CONSTRAINT `thu_phi_fk_thanh_vien_cua_ho` FOREIGN KEY (`idHoKhau`) REFERENCES `thanh_vien_cua_ho` (`idHoKhau`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thu_phi
-- ----------------------------
INSERT INTO `thu_phi` VALUES (13, NULL, NULL, NULL, NULL);
INSERT INTO `thu_phi` VALUES (14, NULL, NULL, NULL, NULL);
INSERT INTO `thu_phi` VALUES (15, NULL, NULL, NULL, NULL);
INSERT INTO `thu_phi` VALUES (16, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tieu_su
-- ----------------------------
DROP TABLE IF EXISTS `tieu_su`;
CREATE TABLE `tieu_su`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idNhanKhau` int(11) NULL DEFAULT NULL,
  `tuNgay` date NULL DEFAULT NULL,
  `denNgay` date NULL DEFAULT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ngheNghiep` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `noiLamViec` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `idNhanKhau`(`idNhanKhau`) USING BTREE,
  CONSTRAINT `tieu_su_ibfk_1` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tieu_su
-- ----------------------------
INSERT INTO `tieu_su` VALUES (2, 27, '2015-09-05', '2015-09-05', 'Số 45, ngõ 56, Nguyễn Khang, Cầu Giấy, Hà Nội', 'Sinh Viên', 'Đại học Thương mại');
INSERT INTO `tieu_su` VALUES (3, 28, '2012-09-05', '2017-09-05', '556 La Thành, Hà Nội', 'Sinh Viên', 'Đại học Bách khoa Hà Nội');
INSERT INTO `tieu_su` VALUES (4, 29, '1989-05-10', '2000-08-25', 'Số 5 Nguyễn Khuyến, Hà Nội', 'Quản lý nhận sự', 'Công ty BCC');
INSERT INTO `tieu_su` VALUES (5, 30, '1987-05-23', '1997-03-01', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Nhân viên văn phòng', 'Công ty Zezs');
INSERT INTO `tieu_su` VALUES (6, 31, '2008-09-05', '2013-09-05', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Sinh viên', 'Đại học Bách khoa Hà Nội');
INSERT INTO `tieu_su` VALUES (7, 32, '2015-09-05', '2019-09-05', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Sinh viên', 'Đại học Luật Hà Nội');
INSERT INTO `tieu_su` VALUES (8, 33, '1998-09-05', '2003-09-05', 'Số 66, ngõ 445 Nguyễn Khang, Cầu Giấy, Hà Nội', 'Sinh Vvên', 'Đại học Bách khoa Hà Nội');
INSERT INTO `tieu_su` VALUES (9, 33, '2003-10-03', '2018-08-06', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Giảng viên', 'Đại học Công ngiệp Hà Nội');
INSERT INTO `tieu_su` VALUES (10, 34, '2003-09-05', '2011-09-05', 'Số 8 Tôn Thất Tùng, Hà Nội', 'Sinh viên', 'Đại học Y Hà Nội');
INSERT INTO `tieu_su` VALUES (11, 34, '2011-10-03', '2015-08-09', 'Số 8 Tôn Thất Tùng, Hà Nội', 'Bác sĩ nội trú', 'Bệnh viện Bạch Mai');
INSERT INTO `tieu_su` VALUES (12, 37, '1961-01-01', '1963-01-01', 'Không rõ', 'Bộ đội', 'Hà Nội');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `passwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '1');
INSERT INTO `users` VALUES (3, 'admin1', '123456');

SET FOREIGN_KEY_CHECKS = 1;
